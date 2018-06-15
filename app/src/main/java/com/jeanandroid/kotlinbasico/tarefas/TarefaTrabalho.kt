package com.jeanandroid.kotlinbasico.tarefas

import com.jeanandroid.kotlinbasico.R

class TarefaTrabalho (val nome: String,
                      val descricao: String,
                      val imagemId: Int,
                      val imagemIdGrande: Int){

    companion object {
    val trabalhos = arrayOf<TarefaTrabalho>(
            TarefaTrabalho("Enviar Email", "Responder emails atrasados", R.drawable.email, R.drawable.emailgrande),
            TarefaTrabalho("Corrigir bugs", "Corrigir bugs relatados pelo cliente", R.drawable.bug, R.drawable.buggrande),
            TarefaTrabalho("Reunião", "Realizar reunião de passagem de bola", R.drawable.reuniao, R.drawable.reuniaogrande))
    }
}