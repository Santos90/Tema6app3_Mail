package com.example.tema6app3mail.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tema6app3mail.R
import com.example.tema6app3mail.databinding.ActivityMainBinding
import com.example.tema6app3mail.adapters.OnClickListener
import com.example.tema6app3mail.fragments.DetailFragment
import com.example.tema6app3mail.fragments.ListFragment
import com.example.tema6app3mail.pojos.Correo
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), OnClickListener , NavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frgListado = supportFragmentManager.findFragmentById(binding.frgListado.id) as ListFragment
        drawerLayout = findViewById<ConstraintLayout>(binding.root!!.id)
        frgListado.setFragmentListener(this)
    }

    override fun onClick(correo : Correo) {

        var hayDetalle = binding.frgDetalle?.let {
            supportFragmentManager.findFragmentById(it.id)
        } != null

        //var hayDetalle2 = supportFragmentManager.findFragmentById(R.id.frgDetalle) != null

        if (hayDetalle){//Si existe frgDetalle, se muestra el contenido en la misma Activity

            val detailFragment = supportFragmentManager.findFragmentById(R.id.frgDetalle) as DetailFragment
            detailFragment.mostrarDetalle(correo.getTexto())

        }else {
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("TextoDetalle", correo.getTexto())
            startActivity(i)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_exit -> {
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        drawerLayout.close(GravityCompat.START)
        return true
    }
}