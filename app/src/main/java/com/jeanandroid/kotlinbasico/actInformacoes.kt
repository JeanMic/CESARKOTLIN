package com.jeanandroid.kotlinbasico

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_act_informacoes.*

class actInformacoes : AppCompatActivity(), View.OnClickListener {

    val ID_CHANEL = "1"

    private val helloReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.d("livroandroid", "HelloReceiver Dinamico!!!")
            textodinamico.setText("Mensagem recebida pelo HelloReceiver Dinamico!!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_informacoes)

        notif?.setOnClickListener(this)
        broadcast?.setOnClickListener(this)
        mensagem?.setOnClickListener(this)
//        servico?.setOnClickListener(this)
        registerReceiver(helloReceiver, IntentFilter("BINGO"))
    }

    override fun onClick(view: View?) {
        when (view) {
            notif -> {
                val intent = Intent(this, MainActivity::class.java)
                NotificacaoUtil.create(this, 1, intent, "Notif Botao", "Notificação botao")
            }
            broadcast -> {
                sendBroadcast(Intent("ACAO_TESTE"))
            }
            mensagem -> {
                sendBroadcast(Intent("BINGO"))
                Toast.makeText(this, "Intent enviada!", Toast.LENGTH_SHORT).show()
            }
//            servico -> {
////                startService(Intent(this, exemploService::class.java))
//            }

        }//fim when
    }//fim metodo

    override fun onDestroy() {
        super.onDestroy()
        // Cancela o receiver
        unregisterReceiver(helloReceiver)
    }
}
