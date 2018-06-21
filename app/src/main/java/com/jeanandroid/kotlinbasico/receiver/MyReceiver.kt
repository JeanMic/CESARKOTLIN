package com.jeanandroid.kotlinbasico.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.jeanandroid.kotlinbasico.MainActivity
import com.jeanandroid.kotlinbasico.NotificacaoUtil

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val intent = Intent(context, MainActivity::class.java)

        Log.d("RECIVER", "entrou  no reciver")
        NotificacaoUtil.create(context, 2, intent,"Broadcast Botao", "Notificação do Botão")

    }
}
