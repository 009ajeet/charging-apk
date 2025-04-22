package com.example.chargingvolume.services

import android.content.Context
import android.media.AudioManager

class VolumeService(private val context: Context) {

    private val audioManager: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    fun increaseVolume() {
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING)
        audioManager.setStreamVolume(AudioManager.STREAM_RING, currentVolume + 1, 0)
    }

    fun decreaseVolume() {
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING)
        audioManager.setStreamVolume(AudioManager.STREAM_RING, currentVolume - 1, 0)
    }

    fun setVolume(level: Int) {
        audioManager.setStreamVolume(AudioManager.STREAM_RING, level, 0)
    }

    fun getCurrentVolume(): Int {
        return audioManager.getStreamVolume(AudioManager.STREAM_RING)
    }
}