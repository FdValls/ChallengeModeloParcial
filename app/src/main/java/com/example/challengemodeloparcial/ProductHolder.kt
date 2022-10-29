package com.example.challengemodeloparcial

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.Serializable

class ProductHolder(v: View) : RecyclerView.ViewHolder(v), Serializable {

    private var view: View
    private lateinit var photo: ImageView

    init {
        this.view = v
    }

    fun setName(name: String) {
        val txt: TextView = view.findViewById(R.id.txt_name_product)
        txt.text = name
    }

    fun setCatergoria(cat: String) {
        val txt: TextView = view.findViewById(R.id.txt_cat_product)
        txt.text = cat
    }

    fun setImgaen(p: Product) {
        photo = view.findViewById(R.id.id_img_product)
        val img: ImageView = view.findViewById(R.id.id_img_product)
        Glide.with(photo.context).load(p.urlImage).into(photo)
    }

    fun getCardLayout(): CardView {
        return view.findViewById(R.id.card_package_item)
    }

}