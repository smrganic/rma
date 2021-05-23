package com.example.lv5_task_2.utils

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.provider.MediaStore
import android.view.View

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
}