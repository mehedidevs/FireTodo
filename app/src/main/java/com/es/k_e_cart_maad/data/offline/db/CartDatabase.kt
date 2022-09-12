package com.es.k_e_cart_maad.data.offline.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.es.k_e_cart_maad.data.offline.daos.CartDao
import com.es.k_e_cart_maad.entity.ProductCart

@Database(
    entities = [ProductCart::class],
    version = 1,
)
abstract class CartDatabase : RoomDatabase() {

    abstract fun getCartDao(): CartDao


    companion object {

        fun getDatabase(context: Context): CartDatabase {

            var instance: CartDatabase? = null
            return if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    CartDatabase::class.java,
                    "Cart_DB"
                ).build()
                instance

            } else {
                return instance
            }


        }


    }


}