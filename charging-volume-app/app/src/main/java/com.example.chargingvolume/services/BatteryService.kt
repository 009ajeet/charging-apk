package com.example.chargingvolume.services

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.IBinder
import android.os.Build
import androidx.annotation.RequiresApi

class BatteryService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { intentFilter ->
            registerReceiver(null, intentFilter)
        }

        val level: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1
        val voltage: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1) ?: -1

        val chargingSpeed = calculateChargingSpeed(level, scale, voltage)

        // Update UI or notify the user with the charging speed
        // This can be done using a BroadcastReceiver or a local notification

        return START_STICKY
    }

    private fun calculateChargingSpeed(level: Int, scale: Int, voltage: Int): Float {
        // Placeholder for actual charging speed calculation logic
        // This is a simplified example and may not reflect true charging speed
        return (level.toFloat() / scale * voltage) // mAh
    }
}