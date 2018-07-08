package com.jeanandroid.kotlinbasico.fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.jeanandroid.kotlinbasico.R
import com.jeanandroid.kotlinbasico.tarefas.TarefaTrabalho
import com.jeanandroid.kotlinbasico.tarefas.TarefasCasa
import kotlinx.android.synthetic.main.fragment_detalhe_tarefa.*



class DetalheTarefaFragment : android.app.Fragment(), View.OnClickListener {

    private var valRefInter: FragInterface? = null
    var Posicao: Int = 0
    var tipoTarefa = "casa"
    var campoHoras: EditText? = null

    internal interface FragInterface {
        fun confirAgenda(titulo: String, descricao: String, horas: String)
    };

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_detalhe_tarefa, container, false)
        campoHoras = (view.findViewById(R.id.imputhoras) as EditText)
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

        if (tipoTarefa == "casa" && !campoHoras?.text!!.isEmpty()) {
            Log.d("CESAR_ONCLICK", "ENTROU_IF")
            valRefInter?.confirAgenda(TarefasCasa.tarefas[Posicao].nome, TarefasCasa.tarefas[Posicao].descricao, campoHoras?.text.toString())
        } else if (!campoHoras?.text!!.isEmpty()) {
            Log.d("CESAR_ONCLICK", "ENTROU_IF")
            valRefInter?.confirAgenda(TarefaTrabalho.trabalhos[Posicao].nome, TarefaTrabalho.trabalhos[Posicao].descricao, campoHoras?.text.toString())
        } else {
            Toast.makeText(getActivity(),"Favor inserir em quantas horas deseja receber um aviso!",Toast.LENGTH_SHORT).show()
        }
    }
}
