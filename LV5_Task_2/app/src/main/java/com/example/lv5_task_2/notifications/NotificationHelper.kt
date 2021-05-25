package com.example.lv5_task_2.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.lv5_task_2.R

val CHANNEL_ID = "Maps Notifications"
var notificationID = 0
fun createNotificationChannel(context: Context) {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "test name"
        val descriptionText = "test notif"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        // Register the channel with the system
        val notificationManager: NotificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

fun triggerNotification(context: Context){
    val intent = Intent()
    intent.action = Intent.ACTION_VIEW
    intent.type = "image/*"
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    // Create an explicit intent for an Activity in your app
    val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

    val builder = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(context.getString(R.string.photo_notification_title))
        .setContentText(context.getString(R.string.photo_notification_desc))
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        // Set the intent that will fire when the user taps the notification
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    with(NotificationManagerCompat.from(context)) {
        // notificationId is a unique int for each notification that you must define
        notify(notificationID++, builder.build())
    }
}
