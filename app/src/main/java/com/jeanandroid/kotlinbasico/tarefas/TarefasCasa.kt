package com.jeanandroid.kotlinbasico.tarefas

import com.jeanandroid.kotlinbasico.R

class TarefasCasa ( var nome: String,
                    var descricao: String,
                    var imagemId: Int,
                    var imagemIdGrande: Int) {

    companion object {
        var tarefas = arrayOf<TarefasCasa>(
                TarefasCasa(" Arrumar o Quarto", " Varrer o chão, limpar a mesa e organizar livros", R.drawable.quarto, R.drawable.quartogrande),
                TarefasCasa(" Fazer Comida", " Fazer a comida e congelar o que sobrar", R.drawable.comida, R.drawable.comidagrande),
                TarefasCasa(" Lavar a Roupa", " Lavar todas as roupas sujas", R.drawable.roupa, R.drawable.roupagrande))
    }
}