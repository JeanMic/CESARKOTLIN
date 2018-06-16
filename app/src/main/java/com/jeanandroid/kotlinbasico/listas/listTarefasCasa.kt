package com.jeanandroid.kotlinbasico.listas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import com.jeanandroid.kotlinbasico.R
import com.jeanandroid.kotlinbasico.adapters.adapterTarefaCasa
import com.jeanandroid.kotlinbasico.fragment.DetalheTarefaAct
import com.jeanandroid.kotlinbasico.tarefas.TarefasCasa
import kotlinx.android.synthetic.main.activity_list_tarefas_trabalho.*
import org.jetbrains.anko.startActivity

class listTarefasCasa : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_tarefas_casa)

        lista.adapter = adapterTarefaCasa(TarefasCasa.tarefas, this)

        val itemClickListener = AdapterView.OnItemClickListener { listView, v, position, id ->
            startActivity<DetalheTarefaAct>(DetalheTarefaAct.EXTRA_ID_TAREFA to position, DetalheTarefaAct.EXTRA_TIPO_TAREFA to "casa")
        }
        lista.onItemClickListener = itemClickListener
    }
}