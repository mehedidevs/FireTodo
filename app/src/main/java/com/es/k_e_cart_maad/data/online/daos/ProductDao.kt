package com.es.k_e_cart_maad.data.online.daos

import com.es.k_web_api.ProductsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDao {

    @GET("/products")
    fun getAllProduct(): Call<List<ProductsItem>>


    @GET("/products/category/{ctg}")
    fun getAllProductByCtg(@Path("ctg") id: String): Call<List<ProductsItem>>

    //https://fakestoreapi.com/products/category/jewelery


}