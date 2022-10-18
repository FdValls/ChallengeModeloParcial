package com.example.challengemodeloparcial

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

class ListProductFragment : Fragment(), Serializable {

    lateinit var v: View
    lateinit var title: String
    lateinit var recProduct: RecyclerView
    var products: MutableList<Product> = ArrayList()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var productListAdapter: ProductListAdapter

    companion object {
        fun newInstance() = ListProductFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = ListProductFragmentArgs.fromBundle(requireArguments()).txtTitle
        activity?.title = title

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list_product, container, false)

        recProduct = v.findViewById(R.id.rec_list_product)

        return v
    }

    override fun onStart() {
        super.onStart()

        for (i in 1..5) {
            products.add(
                Product(
                    "Forest Gump",
                    Product.Categorias.drama,
                    1994,
                    1100.0,
                    "https://play-lh.googleusercontent.com/ToGy2Cue0epHBdeRkq3dntz8on4ogI1UlKLGqMvgCptTwmpMWVkIxojwVUuvIjrMIFz2UiNjW73xcuofHQ"
                )
            )
            products.add(
                Product(
                    "Matrix",
                    Product.Categorias.accion,
                    1999,
                    1100.0,
                    "https://cloudfront-us-east-1.images.arcpublishing.com/infobae/H64GZYVKAZFXFEMGWFFZRD4T3Q.jpg"
                )
            )
            products.add(
                Product(
                    "Gladiador",
                    Product.Categorias.drama,
                    2000,
                    1100.0,
                    "https://es.web.img3.acsta.net/medias/nmedia/18/70/92/02/20149073.jpg"
                )
            )
            products.add(
                Product(
                    "Interestelar",
                    Product.Categorias.drama,
                    2014,
                    1100.0,
                    "https://web9.unl.edu.ar/noticias/img/thumbs/news/37787/foto%20peli_vga.jpg"
                )
            )
            products.add(
                Product(
                    "El ilusionista",
                    Product.Categorias.drama,
                    2006,
                    1100.0,
                    "https://i0.wp.com/webadictos.com/media/2013/03/pelicula-el-ilusionista.jpg?resize=600%2C354"
                )
            )
            products.add(
                Product(
                    "Oblivion",
                    Product.Categorias.accion,
                    2013,
                    1100.0,
                    "https://hbomax-images.warnermediacdn.com/images/GYPH-TQRrvryIHAEAAABc/tileburnedin?size=1280x720&partner=hbomaxcom&v=77b541a0caed299814e71217a088b0ca&host=art-gallery.api.hbo.com&language=es-es&w=1280"
                )
            )
            products.add(
                Product(
                    "La llamada",
                    Product.Categorias.terror,
                    2007,
                    1100.0,
                    "https://www.tematika.com/media/catalog/Ilhsa/Imagenes/649124.jpg"
                )
            )
            products.add(
                Product(
                    "Parasite",
                    Product.Categorias.drama,
                    2019,
                    1100.0,
                    "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/parasite-explicacion-analisis-final-2-1572041599.jpg?crop=0.958xw:0.852xh;0.0228xw,0.0522xh&resize=1200:*"
                )
            )
            products.add(
                Product(
                    "Logan",
                    Product.Categorias.drama,
                    2017,
                    1100.0,
                    "https://es.web.img2.acsta.net/pictures/17/01/30/11/31/059557.jpg"
                )
            )
            products.add(
                Product(
                    "Deadpool",
                    Product.Categorias.comedia,
                    2016,
                    1100.0,
                    "https://lumiere-a.akamaihd.net/v1/images/au_movie_disney_plus_star_deadpool_poster_bd8b72b7.jpeg?region=0,0,540,810"
                )
            )
        }

        recProduct.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)

        recProduct.layoutManager = linearLayoutManager

        productListAdapter = ProductListAdapter(products) { x ->
            onItemClick(x)
        }

        recProduct.adapter = productListAdapter

    }

    fun onItemClick(position: Int): Boolean {
        Snackbar.make(v, position.toString(), Snackbar.LENGTH_SHORT).show()
        Toast.makeText(activity, "Ir a detalles", Toast.LENGTH_SHORT)
            .show()
        val myProduct = products[position]
        var a = ListProductFragmentDirections.actionListProductFragmentToTerceraPantalla(title,myProduct)
        v.findNavController().navigate(a)

        return true
    }
}