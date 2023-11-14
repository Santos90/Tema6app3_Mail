package com.example.tema6app3mail.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema6app3mail.R
import com.example.tema6app3mail.databinding.ActivityMainBinding
import com.example.tema6app3mail.fragments.CorreosListener
import com.example.tema6app3mail.fragments.DetailFragment
import com.example.tema6app3mail.fragments.ListFragment
import com.example.tema6app3mail.pojos.Correo

class MainActivity : AppCompatActivity(), CorreosListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frgListado = supportFragmentManager.findFragmentById(binding.frgListado.id) as ListFragment

        frgListado.setCorreosListener(this)
    }


    override fun onCorreoSeleccionado(correo : Correo) {
        if (correo != null) {

            var hayDetalle = binding.frgDetalle?.let {
                supportFragmentManager.findFragmentById(it.id)
            } != null

            var hayDetalle2 = supportFragmentManager.findFragmentById(R.id.frgDetalle) != null



            if(hayDetalle){//Se muestra el contenido en la misma Activity

                val detailFragment = DetailFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction
                    .replace(R.id.frgDetalle, detailFragment)
                    .commitNow()
                detailFragment.mostrarDetalle(correo.getTexto())

            }else{
                val i = Intent(this, DetailActivity::class.java)
                i.putExtra("TextoDetalle", correo.getTexto())
                startActivity(i)
            }
        }

    }
}