package com.jeanandroid.kotlinbasico.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeanandroid.kotlinbasico.R
import com.jeanandroid.kotlinbasico.tarefas.TarefaTrabalho
import com.jeanandroid.kotlinbasico.tarefas.TarefasCasa
import kotlinx.android.synthetic.main.fragment_detalhe_tarefa.*

class DetalheTarefaFragment : android.app.Fragment() {

    var Posicao: Int = 0
    var tipoTarefa = "casa"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detalhe_tarefa, container, false)
    }

    override fun onStart() {
        super.onStart()
        val view = view
        if (view != null) {
            if (tipoTarefa == "casa") {
                titulo_detalhe.setText(TarefasCasa.tarefas[Posicao].nome)
                descricao_detalhe.setText(TarefasCasa.tarefas[Posicao].descricao)
                imagem_grande.setImageResource(TarefasCasa.tarefas[Posicao].imagemIdGrande)
            } else {
                titulo_detalhe.setText(TarefaTrabalho.trabalhos[Posicao].nome)
                descricao_detalhe.setText(TarefaTrabalho.trabalhos[Posicao].descricao)
                imagem_grande.setImageResource(TarefaTrabalho.trabalhos[Posicao].imagemIdGrande)
            }

        }
    }
}