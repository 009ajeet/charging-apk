package com.example.chargingvolume

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chargingvolume.services.BatteryService
import com.example.chargingvolume.services.VolumeService

class MainActivity : AppCompatActivity() {

    private lateinit var chargingSpeedTextView: TextView
    private lateinit var volumeService: VolumeService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chargingSpeedTextView = findViewById(R.id.chargingSpeedTextView)
        volumeService = VolumeService(this)

        startBatteryService()
        setupVolumeControls()
    }

    private fun startBatteryService() {
        val batteryServiceIntent = Intent(this, BatteryService::class.java)
        startService(batteryServiceIntent)
    }

    private fun setupVolumeControls() {
        val increaseVolumeButton: Button = findViewById(R.id.increaseVolumeButton)
        val decreaseVolumeButton: Button = findViewById(R.id.decreaseVolumeButton)

        increaseVolumeButton.setOnClickListener {
            volumeService.increaseVolume()
        }

        decreaseVolumeButton.setOnClickListener {
            volumeService.decreaseVolume()
        }
    }

    fun updateChargingSpeed(speed: String) {
        chargingSpeedTextView.text = speed
    }
}