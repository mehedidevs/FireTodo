package com.es.k_e_cart_maad.ui.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.es.k_e_cart_maad.data.offline.db.CartDatabase
import com.es.k_e_cart_maad.data.offline.repo.CartRepositories
import com.es.k_e_cart_maad.entity.ProductCart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application) :
    AndroidViewModel(application) {
    private val repo: CartRepositories


    init {
        val db = CartDatabase.getDatabase(application.applicationContext)
        repo = CartRepositories(db)
    }

    fun insertCart(cart: ProductCart) = CoroutineScope(Dispatchers.IO)
        .launch {
            repo.insertCart(cart)
        }

    fun updateCart(cart: ProductCart) = CoroutineScope(Dispatchers.IO)
        .launch {
            repo.updateCart(cart)
        }

    fun deleteCart(cart: ProductCart) = CoroutineScope(Dispatchers.IO)
        .launch {
            repo.deleteCart(cart)
        }

    fun getAllCart() = repo.getAllCart()

}