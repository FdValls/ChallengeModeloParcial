package com.example.challengemodeloparcial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductListAdapter(
    private var productList: MutableList<Product>,
    val onItemClick: (Int) -> Boolean
) : RecyclerView.Adapter<ProductHolder>() {

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return (ProductHolder(view))
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {

        holder.setName(productList[position].nombre)
        holder.setCatergoria(productList[position].categoria)
        holder.setImg(productList[position])

        holder.getCardLayout().setOnClickListener {
            onItemClick(position)
        }

    }

    fun setData(newData: ArrayList<Product>) {
        this.productList = newData
        this.notifyDataSetChanged()
    }


}