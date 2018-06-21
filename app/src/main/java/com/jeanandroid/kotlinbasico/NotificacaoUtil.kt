package com.jeanandroid.kotlinbasico

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat

object NotificacaoUtil {

    fun create(context: Context, id: Int, intent: Intent, title: String, msg: String) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, MainActivity::class.java)
        val p = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val jean = NotificationCompat.Builder(context, "1")
                .setContentIntent(p)
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(R.mipmap.ic_launcher)
                //a linha abaixo faz com que a notificação seja automaticamente cancelada quando o usuário clicar nela.
                .setAutoCancel(true)
        val n = jean.build()

        manager.notify(id, n)
    }
}