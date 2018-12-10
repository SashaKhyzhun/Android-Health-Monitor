package com.sashakhyzhun.healthmonitor.utils

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager


object CameraUtil {


    fun enable(context: Context) {
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager?

        try {
            val cameraId = cameraManager!!.cameraIdList[0]
            cameraManager.setTorchMode(cameraId, true)
        } catch (e: CameraAccessException) {
        }

    }

    fun disable(context: Context) {
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager?

        try {
            val cameraId = cameraManager!!.cameraIdList[0]
            cameraManager.setTorchMode(cameraId, false)
        } catch (e: CameraAccessException) {
        }

    }


}