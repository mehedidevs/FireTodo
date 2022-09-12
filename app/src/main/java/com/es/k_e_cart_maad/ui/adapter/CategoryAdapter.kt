package com.es.k_e_cart_maad.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.es.k_e_cart_maad.R
import com.es.k_e_cart_maad.entity.Category
import com.es.k_e_cart_maad.ui.my_listener.CtgListener

import com.es.k_e_cart_maad.ui.viewholders.CategoryViewHolder

class CategoryAdapter(

    val listener: CtgListener,
    private val categories: List<Category>,
    private val context: Context
) :

    RecyclerView.Adapter<CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_ctg, parent, false)
        return CategoryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val ctg: Category = categories[position]

        holder.ctgName.text = ctg.name
        Glide.with(context).load(ctg.imageUrl).into(holder.ctgImage)


        holder.itemView.setOnClickListener {

            listener.CtgClickListener(ctg)
        }

    }

    override fun getItemCount(): Int {
        return categories.size
    }

}