package com.jeanandroid.kotlinbasico

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jeanandroid.kotlinbasico.listas.listTarefasTrabalho
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImgTrab?.setOnClickListener(this)
        ImgCasa?.setOnClickListener(this)
        ImgConfig?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view) {

            ImgTrab -> {
                val intentTrabalho = Intent(this, listTarefasTrabalho::class.java)
                startActivity(intentTrabalho)
            }
//            R.id.ImgCasa -> {
//                val intentcasa = Intent(this, listTarefasCasa::class.java)
//                startActivity(intentcasa)
//            }
//            R.id.ImgConfig -> {
//            }
        }//                Intent CategoriasPesquisaProdutos = new Intent(getApplicationContext(), telaPesquisaCategoriasProduto.class);
        //                startActivity(CategoriasPesquisaProdutos);

    }
}
