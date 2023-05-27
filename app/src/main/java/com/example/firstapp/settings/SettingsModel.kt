package com.example.firstapp.settings

data class SettingsModel(
    var volume: Int,
    var darkMode: Boolean,
    var bluetooth: Boolean,
    var vibration: Boolean
)