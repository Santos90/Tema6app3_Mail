package com.example.tema6app3mail.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema6app3mail.R
import com.example.tema6app3mail.databinding.ActivityMainBinding
import com.example.tema6app3mail.adapters.OnClickListener
import com.example.tema6app3mail.fragments.DetailFragment
import com.example.tema6app3mail.fragments.ListFragment
import com.example.tema6app3mail.pojos.Correo

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frgListado = supportFragmentManager.findFragmentById(binding.frgListado.id) as ListFragment

        frgListado.setFragmentListener(this)
    }

    override fun onClick(correo : Correo) {

        var hayDetalle = binding.frgDetalle?.let {
            supportFragmentManager.findFragmentById(it.id)
        } != null

        //var hayDetalle2 = supportFragmentManager.findFragmentById(R.id.frgDetalle) != null

        if (hayDetalle){//Si existe frgDetalle, se muestra el contenido en la misma Activity

/*
            val detailFragment = DetailFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frgDetalle, detailFragment)
                .commitNow()

*/

            val detailFragment = supportFragmentManager.findFragmentById(R.id.frgDetalle) as DetailFragment


            detailFragment.mostrarDetalle(correo.getTexto())

        }else {
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("TextoDetalle", correo.getTexto())
            startActivity(i)
        }

    }
}