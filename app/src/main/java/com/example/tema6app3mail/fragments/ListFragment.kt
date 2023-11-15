package com.example.tema6app3mail.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tema6app3mail.adapters.CorreoAdapter
import com.example.tema6app3mail.adapters.OnClickListener
import com.example.tema6app3mail.databinding.FragmentListBinding
import com.example.tema6app3mail.pojos.Correo

class ListFragment : Fragment() , OnClickListener {
    private lateinit var correoAdapter: CorreoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var binding: FragmentListBinding


    private lateinit var listenerCorreo: OnClickListener

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        correoAdapter = CorreoAdapter(Correo.CorreoDatos.CORREOS, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerIdList.apply{
            layoutManager = linearLayoutManager
            adapter = correoAdapter
            addItemDecoration(itemDecoration)
        }



        return binding.root
    }



    fun setFragmentListener(listenerCorreo: OnClickListener) {
        this.listenerCorreo = listenerCorreo

    }

    override fun onClick(correo: Correo) {
        Toast.makeText(context, "Seleccion: ${correo.getDe()}", Toast.LENGTH_LONG)

        if (listenerCorreo != null) listenerCorreo.onClick(correo)
    }

}