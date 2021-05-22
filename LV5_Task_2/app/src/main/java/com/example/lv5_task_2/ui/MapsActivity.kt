package com.example.lv5_task_2.ui

import android.Manifest.permission.*
import android.annotation.SuppressLint
import android.content.Context
import android.location.*
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.lv5_task_2.R
import com.example.lv5_task_2.databinding.ActivityMapsBinding
import com.example.lv5_task_2.sounds.AudioPlayer
import com.example.lv5_task_2.utils.Constants
import com.example.lv5_task_2.utils.ScreenCapture
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.annotations.AfterPermissionGranted
import org.koin.android.ext.android.inject


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapLongClickListener,
    LocationListener {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager: LocationManager
    private val audioPlayer by inject<AudioPlayer>()
    private var currentLocation: LatLng? = null

    private fun updateViews(position: LatLng) {
        currentLocation = position
        val geoCoder = Geocoder(this)
        val address = geoCoder.getFromLocation(position.latitude, position.longitude, 1)[0]
        binding.apply {
            latitude.text = position.latitude.toString()
            longitude.text = position.longitude.toString()
            this.address.text = address.getAddressLine(0)
            country.text = address.countryName
            city.text = address.locality
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup binding
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager


        binding.btnTakePhoto.setOnClickListener {
            val rootView = window.decorView.rootView
            if (currentLocation != null)
                ScreenCapture.screenShot(
                    contentResolver,
                    rootView,
                    currentLocation.toString(),
                    "Testing"
                )
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setOnMapLongClickListener(this)
        trackCurrentLocation()
    }

    override fun onMapLongClick(position: LatLng) {
        map.clear()
        map.addMarker(
            MarkerOptions().position(position).title("${position.latitude}, ${position.longitude}")
        )
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 12f))
        audioPlayer.playSound(R.raw.marker)
        updateViews(position)
    }

    override fun onLocationChanged(location: Location) {
        val position = LatLng(location.latitude, location.longitude)
        map.clear()
        map.addMarker(
            MarkerOptions().position(position).title("${position.latitude}, ${position.longitude}")
        )
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 12f))
        audioPlayer.playSound(R.raw.marker)
        updateViews(position)
    }

    @SuppressLint("MissingPermission")
    @AfterPermissionGranted(Constants.REQUEST_CODE_LOCATION_AND_STORAGE_PERMISSION)
    private fun trackCurrentLocation() {
        if (EasyPermissions.hasPermissions(this, ACCESS_FINE_LOCATION, CAMERA)) {

            val criteria = Criteria()
            criteria.accuracy = Criteria.ACCURACY_FINE

            val provider = locationManager.getBestProvider(criteria, true)
            val minTime = 1000L
            val minDistance = 10.0f

            locationManager.requestLocationUpdates(
                provider!!,
                minTime,
                minDistance,
                this
            )

        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(
                host = this,
                rationale = "This app need location and camera.",
                Constants.REQUEST_CODE_LOCATION_AND_STORAGE_PERMISSION,
                ACCESS_FINE_LOCATION, READ_EXTERNAL_STORAGE
            )
        }
    }
}