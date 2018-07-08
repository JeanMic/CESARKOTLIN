package com.jeanandroid.kotlinbasico.fragment

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import com.jeanandroid.kotlinbasico.R
import com.jeanandroid.kotlinbasico.receiver.MyReceiver

class DetalheTarefaAct : Activity(), DetalheTarefaFragment.FragInterface {

    override fun confirAgenda(titulo: String, descricao: String) {
        var intentTarefa = Intent(this, MyReceiver::class.java)
        intentTarefa.putExtra(MyReceiver.TITULO, titulo)
        intentTarefa.putExtra(MyReceiver.DESCRICAO, descricao)
        Log.d("CESAR_PUT_EXTRA_ALARME", "$titulo // $descricao")
        var p = PendingIntent.getBroadcast(this, requestCode++, intentTarefa, Intent.FILL_IN_DATA)
        var alarme = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarme.set(AlarmManager.RTC_WAKEUP, getTime(), p)
        Log.d("CESAR_AGENDAMENTO", "Alarme agendado")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_tarefa)

        val detalhe = fragmentManager.findFragmentById(R.id.detalhe_tarefa) as DetalheTarefaFragment
        detalhe.Posicao = (intent.extras!!.get(EXTRA_ID_TAREFA) as Int)
        detalhe.tipoTarefa = (intent.extras!!.getString(EXTRA_TIPO_TAREFA))
    }

    companion object {
        val EXTRA_ID_TAREFA = "id"
        val EXTRA_TIPO_TAREFA = "tarefa"
        var requestCode: Int = 0
    }

    fun getTime(): Long {
        val c = Calendar.getInstance()
        c.timeInMillis = System.currentTimeMillis()
        c.add(Calendar.SECOND, 10)
        return c.timeInMillis
    }

}