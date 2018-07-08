package com.jeanandroid.kotlinbasico.fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.jeanandroid.kotlinbasico.R
import com.jeanandroid.kotlinbasico.tarefas.TarefaTrabalho
import com.jeanandroid.kotlinbasico.tarefas.TarefasCasa
import kotlinx.android.synthetic.main.fragment_detalhe_tarefa.*

class DetalheTarefaFragment : android.app.Fragment(), View.OnClickListener {

    private var valRefInter: FragInterface? = null
    var Posicao: Int = 0
    var tipoTarefa = "casa"

    internal interface FragInterface {
        fun confirAgenda(titulo: String, descricao: String)
    };

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_detalhe_tarefa, container, false)
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var res1 = activity.findViewById(R.id.botaoAgendar) as Button
        res1.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        val view = view
        if (view != null) {
            if (tipoTarefa == "casa") {
                titulo_detalhe.setText(TarefasCasa.tarefas[Posicao].nome)
                descricao_detalhe.setText(TarefasCasa.tarefas[Posicao].descricao)
                imagem_grande.setImageResource(TarefasCasa.tarefas[Posicao].imagemIdGrande)
                Log.d("CESAR_ONSTART", "$Posicao // $tipoTarefa")
            } else {
                titulo_detalhe.setText(TarefaTrabalho.trabalhos[Posicao].nome)
                Log.d("CESAR_ONSTART", "$Posicao // $tipoTarefa")
                descricao_detalhe.setText(TarefaTrabalho.trabalhos[Posicao].descricao)
                imagem_grande.setImageResource(TarefaTrabalho.trabalhos[Posicao].imagemIdGrande)
            }

        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        this.valRefInter = activity as FragInterface
    }

    override fun onClick(v: View?) {
        Log.d("CESAR_ONCLICK", "$Posicao // $tipoTarefa")
        if (tipoTarefa == "casa") {
            valRefInter?.confirAgenda(TarefasCasa.tarefas[Posicao].nome, TarefasCasa.tarefas[Posicao].descricao)
        } else {
            valRefInter?.confirAgenda(TarefaTrabalho.trabalhos[Posicao].nome, TarefaTrabalho.trabalhos[Posicao].descricao)
        }

    }

}