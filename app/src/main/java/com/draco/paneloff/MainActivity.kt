package com.draco.paneloff

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class MainActivity: Activity() {
    private fun isRooted(): Boolean {
        val rootCheckProcess = ProcessBuilder("which", "su").start()
        rootCheckProcess.waitFor()
        return rootCheckProcess.exitValue() == 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()

        if (isRooted()) {
            if (panelOff() != 0)
                Toast.makeText(this, "Root permissions denied. Exiting.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Device not rooted. Exiting.", Toast.LENGTH_SHORT).show()
        }
    }
}