package com.example.lv5_task_2.utils

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.view.Window
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

object ScreenCapture {

    fun takeScreenShot(activity: Activity, view: View) {
        if (Permissions.hasPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            val bitmap = getScreenShot(view)
            val root = Environment.getExternalStorageDirectory().toString()
            val myDir = File("$root/saved_images")
            myDir.mkdirs()

            val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val fname = "Shutta_$timeStamp.jpg"

            val file = File(myDir, fname)
            if (file.exists()) file.delete()
            try {
                val out: FileOutputStream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
                Toast.makeText(activity, "THIS was a success... yea right.", Toast.LENGTH_SHORT).show()
                out.flush()
                out.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else Permissions.requestPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    fun getScreenShot(view: View): Bitmap {
        val screenView: View = view.getRootView()
        screenView.setDrawingCacheEnabled(true)
        val bitmap: Bitmap = Bitmap.createBitmap(screenView.getDrawingCache())
        screenView.setDrawingCacheEnabled(false)
        return bitmap
    }

    private fun getBitMap(window: Window): Bitmap {
        val screen = window.decorView.rootView
        val returnedBitmap =
            Bitmap.createBitmap(screen.width, screen.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = screen.background
        if (bgDrawable != null) bgDrawable.draw(canvas)
        else canvas.drawColor(Color.WHITE)
        screen.draw(canvas)
        return returnedBitmap
    }

    @Throws(IOException::class)
    private fun saveBitmap(
        context: Context, bitmap: Bitmap, format: Bitmap.CompressFormat,
        mimeType: String, displayName: String
    ): Uri {

        val values = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, displayName)
            put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DCIM)
        }

        var uri: Uri? = null

        return runCatching {
            with(context.contentResolver) {
                insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)?.also {
                    uri = it // Keep uri reference so it can be removed on failure

                    openOutputStream(it)?.use { stream ->
                        if (!bitmap.compress(format, 95, stream))
                            throw IOException("Failed to save bitmap.")
                    } ?: throw IOException("Failed to open output stream.")

                } ?: throw IOException("Failed to create new MediaStore record.")
            }
        }.getOrElse {
            uri?.let { orphanUri ->
                // Don't leave an orphan entry in the MediaStore
                context.contentResolver.delete(orphanUri, null, null)
            }

            throw it
        }
    }
}