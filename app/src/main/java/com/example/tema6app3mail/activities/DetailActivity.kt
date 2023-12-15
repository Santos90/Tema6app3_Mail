package com.example.tema6app3mail.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tema6app3mail.R
import com.example.tema6app3mail.fragments.DetailFragment

class DetailActivity : AppCompatActivity() {

    private lateinit var detailFragment: DetailFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        detailFragment = supportFragmentManager.findFragmentById(R.id.frgDetalle) as DetailFragment
    }

    override fun onResume() {
        super.onResume()

        detailFragment.mostrarDetalle(  intent.getStringExtra("TextoDetalle")  )
    }

    override fun onStart() {
        super.onStart()



    }
}