package com.jeanandroid.kotlinbasico

import android.app.IntentService
import android.content.Intent
import android.net.Uri

class exemploService : IntentService("SALAAULA") {

    private var count: Int = 0
    private val MAX = 5

    override fun onHandleIntent(intent: Intent?) {

        val uris = Uri.parse("http://google.com")
        val intents = Intent(Intent.ACTION_VIEW, uris)
        startActivity(intents)

//        while (count < MAX) {
//            // Simula algum processamento
//            Thread.sleep(10000)
//            count++
//            Log.d("DENTRO_LACO", "Iteração de n° $count")
//        }
//        Log.d("FORA_LACO", "saiu do laço")
//        val it = Intent(this, MainActivity::class.java)
//        NotificacaoUtil.create(this, 1, it, "Fim Servico", "Fim do serviço.")
    }
}