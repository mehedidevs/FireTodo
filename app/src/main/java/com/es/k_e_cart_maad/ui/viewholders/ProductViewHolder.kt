package com.es.k_e_cart_maad.ui.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.es.k_e_cart_maad.R
import com.google.android.material.imageview.ShapeableImageView

public  class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
    val favoriteImageView: AppCompatButton = itemView.findViewById(R.id.favoriteImageView)
    val addToCartButton: AppCompatButton = itemView.findViewById(R.id.addToCartButton)
    val productTitleTextView: TextView = itemView.findViewById(R.id.productTitleTextView)
    val productCategoryTextView: TextView = itemView.findViewById(R.id.productCategoryTextView)
    val productPriceTextView: TextView = itemView.findViewById(R.id.productPriceTextView)


}