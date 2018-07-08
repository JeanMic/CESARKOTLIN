package com.jeanandroid.kotlinbasico

import android.app.IntentService
import android.content.Intent
import android.net.Uri

class exemploService : IntentService("SALAAULA") {

    override fun onHandleIntent(intent: Intent?) {
        val uris = Uri.parse("https://permita.me/?q=Android+Intent+Service")
        val intents = Intent(Intent.ACTION_VIEW, uris)
        startActivity(intents)
    }
}