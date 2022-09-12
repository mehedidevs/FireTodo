package com.es.k_e_cart_maad.ui.my_listener

import com.es.k_e_cart_maad.entity.ProductCart

interface CartListener {

    fun cartAdd(cart: ProductCart)
    fun cartMinus(cart: ProductCart)
    fun cartDelete(cart: ProductCart)

}