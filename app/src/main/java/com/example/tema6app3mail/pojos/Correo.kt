package com.example.tema6app3mail.pojos

class Correo (private var de: String,
              private var asunto: String,
              private var texto: String,
                val spam : Boolean) {

    fun getDe(): String {
        return de
    }

    fun getAsunto(): String {
        return asunto
    }

    fun getTexto(): String {
        return texto
    }


    class CorreoDatos{
        companion object{
            val CORREOS = arrayListOf<Correo>(
                Correo("Persona 1", "Ganador de premio!!", "Texto del correo 1\n Oferta!!", true),
                Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2", false ),
                Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3", false ),
                Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4", false ),
                Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5", false ),
                Correo("Persona 6", "Oferta!", "Texto del correo 6\n" +
                        "Ofertón de ultima hora", true )
            )
        }
    }


}