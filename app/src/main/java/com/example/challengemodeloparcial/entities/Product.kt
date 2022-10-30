package com.example.challengemodeloparcial.entities

import java.io.Serializable

class Product(nombre: String, categoria: String, anio: Int, precio: Double, urlImage: String): Serializable{

    var nombre: String = ""

    var categoria: String = ""

    var anio: Int = 0

    var precio: Double = 0.0

    var urlImage: String = ""

    class Categorias {
        companion object {
            val accion = "Acciòn"
            val drama = "Drama"
            val suspenso = "Suspenso"
            val terror = "Terror"
            val comedia = "Comedia"
        }
    }

    init {
        this.nombre = nombre!!
        this.categoria = categoria!!
        this.anio = anio!!
        this.precio = precio!!
        this.urlImage = urlImage!!
    }


}