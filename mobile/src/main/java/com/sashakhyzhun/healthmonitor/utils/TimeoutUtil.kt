package com.sashakhyzhun.healthmonitor.utils

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

object TimeoutUtil {


    var cameraTimeoutMillis: Long = 10_000L

    /**
     * Coroutine score for timer
     */
    private var job: Job? = null


    /**
     * Function to start timeout Coroutine Context while the camera is working
     * @param action - lambda function we run after a timeout
     * @return Unit
     */
    fun startCameraTimeout(action: () -> Unit) {
        job = CoroutineScope(Dispatchers.Default).launch {
            delay(cameraTimeoutMillis)
            launch(UI) {
                action()
            }
        }
    }

    /**
     * Function to stop your Coroutine Context in case if the user closed the camera
     * or we found QR or BAR code faster than the timeout is gone.
     */
    fun stopCameraTimeout() {
        job?.cancel()
    }


}