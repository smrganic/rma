package com.example.lv5_task_2.ui

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Context
import android.location.*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.lv5_task_2.R
import com.example.lv5_task_2.databinding.ActivityMapsBinding
import com.example.lv5_task_2.sounds.AudioPlayer
import com.example.lv5_task_2.utils.Constants
import com.example.lv5_task_2.utils.Permissions
import com.example.lv5_task_2.utils.ScreenCapture
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.vmadalin.easypermissions.annotations.AfterPermissionGranted
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MapsActivity : AppCompatActivity(), LocationListener {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager: LocationManager
    private val audioPlayer by inject<AudioPlayer>()
    private var currentLocation: LatLng? = null
    private val mapsViewModel by viewModel<MapsViewModel>()

    private fun updateViews(position: LatLng) {
        currentLocation = position
        val geoCoder = Geocoder(this)
        val address = geoCoder.getFromLocation(position.latitude, position.longitude, 1)[0]
        val locationData = LocationData(
            position.latitude.toString(),
            position.longitude.toString(),
            address.getAddressLine(0),
            address.countryName,
            address.locality
        )
        mapsViewModel.updatePosition(locationData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup binding
        binding = ActivityMapsBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_maps)
        binding.mapsViewModel = mapsViewModel
        binding.lifecycleOwner = this

        binding.mapView.getMapAsync {
            map = it
            map.setOnMapLongClickListener { onMapLongClick(it) }
            trackCurrentLocation()
        }

        binding.mapView.onCreate(savedInstanceState)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        binding.btnTakePhoto.setOnClickListener {
            currentLocation?.let {
                val imageName = String.format("%.4f, %.4f", it.latitude, it.longitude);
                val callback = SnapshotReadyCallback { bitmap ->
                    ScreenCapture.screenShot(
                        contentResolver,
                        bitmap!!,
                        imageName,
                        getString(R.string.imageDesc)
                    )
                }
                map.snapshot(callback)
                Toast.makeText(this, getString(R.string.imageSaved), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onMapLongClick(position: LatLng) {
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
    @AfterPermissionGranted(Constants.REQUEST_CODE_LOCATION_PERMISSION)
    private fun trackCurrentLocation() {
        if (Permissions.hasPermission(this, ACCESS_FINE_LOCATION)) {

            val criteria = Criteria()
            criteria.accuracy = Criteria.ACCURACY_FINE

            val provider = locationManager.getBestProvider(criteria, true)
            val minTime = 1000L
            val minDistance = 10.0f

            // this refers to onLocationChanged
            locationManager.requestLocationUpdates(
                provider!!,
                minTime,
                minDistance,
                this
            )

        } else {
            // Do not have permissions, request them now
            Permissions.requestPermission(
                this,
                getString(R.string.locationRationale),
                Constants.REQUEST_CODE_LOCATION_PERMISSION,
                ACCESS_FINE_LOCATION
            )
        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }
}