package com.jeanandroid.kotlinbasico

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_act_informacoes.*

class actInformacoes : AppCompatActivity() , View.OnClickListener {

    val ID_CHANEL = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_informacoes)

        notif?.setOnClickListener(this)
        broadcast?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            notif -> {

                val intent = Intent(this, MainActivity::class.java)
                NotificacaoUtil.create(this, 1, intent,"Notif Botao", "Notificação botao")
//                val manager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//                val intent = Intent(this, MainActivity::class.java)
//                val p = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//                val jean = NotificationCompat.Builder(this, "1")
//                        .setContentIntent(p)
//                        .setContentTitle("Teste Jean")
//                        .setContentText("Teste da notificação de Jean")
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        //a linha abaixo faz com que a notificação seja automaticamente cancelada quando o usuário clicar nela.
//                        .setAutoCancel(true)
//                val n = jean.build()
//                manager.notify(1, n)

            }
            broadcast -> {
                sendBroadcast(Intent("ACAO_TESTE"))

                Toast.makeText(this, "Intent enviada!", Toast.LENGTH_SHORT).show()
            }
        }//fim when
    }//fim metodo
}
