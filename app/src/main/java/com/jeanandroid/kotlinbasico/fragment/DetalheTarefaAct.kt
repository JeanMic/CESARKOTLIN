package com.jeanandroid.kotlinbasico.fragment

import android.app.Activity
import android.os.Bundle
import com.jeanandroid.kotlinbasico.R


class DetalheTarefaAct : Activity() {

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
    }
}