package com.es.k_e_cart_maad.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class ProductCart(
    @ColumnInfo
    val category: String,
    @ColumnInfo
    val description: String,

    val id: Int,
    @ColumnInfo
    val image: String,
    @ColumnInfo
    val price: Double,
    @ColumnInfo
    val title: String,

    @ColumnInfo
    val quantity: Int
) {
    @PrimaryKey(autoGenerate = false)
    var pId = id

}