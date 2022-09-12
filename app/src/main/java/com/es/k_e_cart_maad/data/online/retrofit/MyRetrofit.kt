package com.es.k_e_cart_maad.data.online.retrofit

import com.es.k_e_cart_maad.data.online.daos.ProductDao
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {

    companion object {
        private var productDao: ProductDao? = null

        fun getRetrofit(): ProductDao {
            val url = "https://fakestoreapi.com"

            if (productDao == null) {
                val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                productDao = retrofit.create(ProductDao::class.java)
                return productDao as ProductDao

            }


            return productDao as ProductDao


        }


    }
}