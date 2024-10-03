package com.example.aidl.server

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.util.Log

class AIDLColorService : Service() {
    val TAG = "AIDLColorService"

    override fun onBind(intent: Intent): IBinder {
        return iBinder;
    }

    private val iBinder = object : IAIDLColorInterface.Stub() {
        override fun getColor(): Int {
            // generate a random color using Color.argb() method
            val color = Color.argb(255, (0..255).random(), (0..255).random(), (0..255).random())
            Log.d(TAG, "Generated color: $color")
            return color
        }
    }
}