package com.es.k_e_cart_maad.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.es.k_e_cart_maad.R
import com.es.k_e_cart_maad.entity.Category
import com.es.k_e_cart_maad.entity.ProductCart
import com.es.k_e_cart_maad.ui.my_listener.CartAddListener
import com.es.k_e_cart_maad.ui.my_listener.CtgListener

import com.es.k_e_cart_maad.ui.viewholders.CategoryViewHolder
import com.es.k_e_cart_maad.ui.viewholders.ProductViewHolder
import com.es.k_web_api.ProductsItem

class ProductAdapter(


    private val products: List<ProductsItem>,
    private val context: Context,
    private val cartAddListener: CartAddListener

) :

    RecyclerView.Adapter<ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productsItem: ProductsItem = products[position]

        holder.productTitleTextView.text = productsItem.title
        holder.productCategoryTextView.text = productsItem.category
        holder.productPriceTextView.text = " $ " + productsItem.price

        Glide.with(context).load(productsItem.image).into(holder.productImageView)


        holder.addToCartButton.setOnClickListener {
            val cart: ProductCart = ProductCart(
                productsItem.category,
                productsItem.description,
                productsItem.id,
                productsItem.image,
                productsItem.price,
                productsItem.title,
                1
            )




            cartAddListener.cartAdd(cart)


        }



        holder.itemView.setOnClickListener {


        }

    }

    override fun getItemCount(): Int {
        return products.size
    }

}