package com.example.tema6app3mail.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tema6app3mail.R
import com.example.tema6app3mail.databinding.ListItemCorreoBinding
import com.example.tema6app3mail.pojos.Correo


class CorreoAdapter (private val correos: List<Correo>, private val listener: CorreosListener): RecyclerView.Adapter<CorreoAdapter.ViewHolder>(){

    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ListItemCorreoBinding.bind(view)

        fun setListener(correo: Correo){
            binding.root.setOnClickListener {
                listener.onClick(correo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_correo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = correos.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val correo = correos.get(position)
        with(holder){
            setListener(correo)
            binding.tvDe.text = correo.getDe()
            binding.tvAsunto.text = correo.getAsunto()
        }
    }



}

