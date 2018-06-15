package com.jeanandroid.kotlinbasico.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jeanandroid.kotlinbasico.R
import com.jeanandroid.kotlinbasico.tarefas.TarefasCasa

class adapterTarefaCasa(private var tarefas: Array<TarefasCasa>, private var acttivity: Activity) : BaseAdapter() {

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
        var tarefas = this.tarefas[position]

        (view.findViewById(R.id.imagem_lista) as ImageView).setImageResource(TarefasCasa.tarefas[position].imagemId)
        (view.findViewById(R.id.titulo_lista) as TextView).setText(TarefasCasa.tarefas[position].nome)
        return view
    }
}