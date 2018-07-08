package com.jeanandroid.kotlinbasico.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.jeanandroid.kotlinbasico.MainActivity
import com.jeanandroid.kotlinbasico.NotificacaoUtil

class MyReceiver : BroadcastReceiver() {

    companion object {
        var TITULO = "TITLE"
        var DESCRICAO = "DESC"
    }

    override fun onReceive(context: Context, intent: Intent) {
        var teste = intent.extras
        Log.d("CESAR_NOTIFICACAO", "${teste.getString(TITULO)} //  ${teste.getString(DESCRICAO)}")
        var intent = Intent(context, MainActivity::class.java)
        NotificacaoUtil.create(context, 2, intent, teste.getString(TITULO), teste.getString(DESCRICAO))

    }
}
