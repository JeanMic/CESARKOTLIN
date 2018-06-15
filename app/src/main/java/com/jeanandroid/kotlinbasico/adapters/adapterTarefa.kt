package com.jeanandroid.kotlinbasico.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jeanandroid.kotlinbasico.R
import com.jeanandroid.kotlinbasico.tarefas.TarefaTrabalho

//class adapterTarefa(private val tarefas: MutableList<Array<TarefaTrabalho>>, private val acttivity: Activity) : BaseAdapter() {
class adapterTarefa(private val tarefas: Array<TarefaTrabalho>, private val acttivity: Activity) : BaseAdapter() {

    override fun getCount(): Int {
        return tarefas.size
    }

    override fun getItem(position: Int): Any {
        return tarefas[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = acttivity.layoutInflater.inflate(R.layout.adapterlayout, parent, false)
//        val tarefas = this.tarefas[position]

        //não consegui tirar o find view by id, pelo q pesquisei se essa classe fosse uma activity ou fragment eu conseguiria
        (view.findViewById(R.id.imagem_lista) as ImageView).setImageResource(TarefaTrabalho.trabalhos[position].imagemId)
        (view.findViewById(R.id.titulo_lista) as TextView).setText(TarefaTrabalho.trabalhos[position].nome)
        return view
    }
}