package com.jeanandroid.kotlinbasico

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jeanandroid.kotlinbasico.listas.listTarefasCasa
import com.jeanandroid.kotlinbasico.listas.listTarefasTrabalho
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

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
            ImgTrab -> {startActivity<listTarefasTrabalho>()}
            ImgCasa -> {startActivity<listTarefasCasa>()}
//            ImgConfig -> {startActivity<actInformacoes>()}
            ImgConfig -> {
                var uris = Uri.parse("http://google.com")
                var intents = Intent(Intent.ACTION_VIEW, uris)
                startActivity(intents)
            }
        }
    }
}
