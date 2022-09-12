package com.es.k_e_cart_maad.data.offline.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.es.k_e_cart_maad.entity.ProductCart

@Dao
interface CartDao {


    @Insert
    suspend fun insert(cart: ProductCart)

    @Update
    suspend fun update(cart: ProductCart)

    @Delete
    suspend fun delete(cart: ProductCart)


    @Query("SELECT * FROM cart_items")
    fun getAllCart(): LiveData<List<ProductCart>>


}