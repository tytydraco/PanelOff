package com.draco.paneloff

fun panelOff(): Int {
     val screenOffProcess = ProcessBuilder(
            "su", "-c",
            "echo 0 > /sys/class/backlight/panel0-backlight/brightness"
        ).start()

    screenOffProcess.waitFor()

    return screenOffProcess.exitValue()
}