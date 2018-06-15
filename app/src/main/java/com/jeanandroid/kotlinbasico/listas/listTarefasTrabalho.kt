package com.jeanandroid.kotlinbasico.listas

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import com.jeanandroid.kotlinbasico.R
import com.jeanandroid.kotlinbasico.adapters.adapterTarefa
import com.jeanandroid.kotlinbasico.fragment.DetalheTarefaAct
import com.jeanandroid.kotlinbasico.tarefas.TarefaTrabalho
import kotlinx.android.synthetic.main.activity_list_tarefas_trabalho.*

class listTarefasTrabalho : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_tarefas_trabalho)

        lista.adapter = adapterTarefa(TarefaTrabalho.trabalhos, this)

        var itemClickListener = AdapterView.OnItemClickListener { listView, v, position, id ->
            var intent = Intent(this@listTarefasTrabalho, DetalheTarefaAct::class.java)
            intent.putExtra(DetalheTarefaAct.EXTRA_ID_TAREFA, position)
            intent.putExtra(DetalheTarefaAct.EXTRA_TIPO_TAREFA, "trabalho")
            startActivity(intent)
        }
        lista.onItemClickListener = itemClickListener
    }
}
