package com.es.k_e_cart_maad.ui.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.es.k_e_cart_maad.R

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ctgImage: ImageView = itemView.findViewById(R.id.ctg_image)
    val ctgName: TextView = itemView.findViewById(R.id.ctgName)


}