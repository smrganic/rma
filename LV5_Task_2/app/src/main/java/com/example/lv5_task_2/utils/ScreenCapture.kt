package com.example.lv5_task_2.utils

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult

object ScreenCapture {

    private fun getBitmap(view: View): Bitmap {
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) bgDrawable.draw(canvas)
        else canvas.drawColor(Color.WHITE)
        view.draw(canvas)
        return returnedBitmap
    }

    fun screenShot(contentResolver: ContentResolver, rootView: View, name: String, desc: String) {
        MediaStore.Images.Media.insertImage(
            contentResolver,
            getBitmap(rootView),
            name,
            desc
        )
    }

    fun saveBitmap(contentResolver: ContentResolver, bitmap: Bitmap, name: String, desc: String) {
        MediaStore.Images.Media.insertImage(
            contentResolver,
            bitmap,
            name,
            desc
        )
    }

    fun dispatchTakePictureIntent(context: Context) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(context as Activity, takePictureIntent, Constants.REQUEST_IMAGE_CAPTURE, null)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Failed to save the photo", Toast.LENGTH_SHORT).show()
        }
    }
}