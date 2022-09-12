package com.es.k_e_cart_maad.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.es.k_e_cart_maad.R
import com.es.k_e_cart_maad.databinding.ItemCartBinding
import com.es.k_e_cart_maad.entity.ProductCart
import com.es.k_e_cart_maad.ui.my_listener.CartListener
import com.es.k_e_cart_maad.ui.viewholders.CartViewHolder

class CartAdapter(
    val context: Context,
    val productList: List<ProductCart>,
    val cartListener: CartListener
) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        // val view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false)
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = productList[position]
        holder.binding.cartItemName.text = cart.title
        holder.binding.cartItemPrice.text = cart.price.toString()
        holder.binding.cartItemQuantity.text = cart.quantity.toString()
        Glide.with(context).load(cart.image).into(holder.binding.cartItemImage)

        holder.binding.cartItemPlus.setOnClickListener {

            cartListener.cartAdd(cart)

        }

        holder.binding.cartItemMinus.setOnClickListener {

            cartListener.cartMinus(cart)

        }


        holder.binding.cartItemDelete.setOnClickListener {

            cartListener.cartDelete(cart)

        }


    }

    override fun getItemCount(): Int {
        return productList.size
    }


    class CartViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)
}