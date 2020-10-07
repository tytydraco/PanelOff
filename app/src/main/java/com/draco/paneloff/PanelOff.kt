package com.draco.paneloff

fun panelOff(): Int {
     val screenOffProcess = ProcessBuilder(
            "su", "-c",
            "for i in /sys/class/backlight/*/brightness; do echo 0 > \"\$i\"; done"
        ).start()

    screenOffProcess.waitFor()

    return screenOffProcess.exitValue()
}