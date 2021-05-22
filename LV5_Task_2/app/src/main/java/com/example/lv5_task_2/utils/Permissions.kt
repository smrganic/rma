package com.example.lv5_task_2.utils

import android.app.Activity
import android.content.Context
import com.vmadalin.easypermissions.EasyPermissions

object Permissions {
    fun hasPermission(context: Context, permission: String): Boolean {
        return EasyPermissions.hasPermissions(context, permission)
    }

    fun requestPermission(activity: Activity, permission: String) {
        EasyPermissions.requestPermissions(
            activity,
            "Storage permission is needed to take screenshot",
            Constants.REQUEST_CODE_READ_STORAGE_PERMISSION,
            permission
        )
    }
}