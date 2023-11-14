package com.example.tema6app3mail.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema6app3mail.R
import com.example.tema6app3mail.fragments.DetailFragment

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailFragment = supportFragmentManager.findFragmentById(R.id.frgDetalle) as DetailFragment

        detailFragment.mostrarDetalle(  intent.getStringExtra("TextoDetalle")  )


    }
}