package com.es.k_e_cart_maad.data.offline.repo

import com.es.k_e_cart_maad.data.offline.db.CartDatabase
import com.es.k_e_cart_maad.entity.ProductCart

class CartRepositories(private val db: CartDatabase) {

    suspend fun insertCart(cart: ProductCart) = db.getCartDao().insert(cart)
    suspend fun updateCart(cart: ProductCart) = db.getCartDao().update(cart)
    suspend fun deleteCart(cart: ProductCart) = db.getCartDao().delete(cart)

    fun getAllCart() = db.getCartDao().getAllCart()
}