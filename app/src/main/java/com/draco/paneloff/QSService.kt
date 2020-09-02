package com.draco.paneloff

import android.service.quicksettings.TileService

class QSService : TileService() {
    override fun onClick() {
        super.onClick()
        panelOff()
    }
}