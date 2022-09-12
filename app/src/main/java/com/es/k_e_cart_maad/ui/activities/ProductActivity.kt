package com.es.k_e_cart_maad.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.es.k_e_cart_maad.R
import com.es.k_e_cart_maad.data.online.retrofit.MyRetrofit
import com.es.k_e_cart_maad.databinding.ActivityProductBinding
import com.es.k_e_cart_maad.entity.ProductCart
import com.es.k_e_cart_maad.ui.adapter.ProductAdapter
import com.es.k_e_cart_maad.ui.my_listener.CartAddListener
import com.es.k_e_cart_maad.ui.view_models.CartViewModel
import com.es.k_web_api.ProductsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity(), CartAddListener {


    var ctgName: String? = null
    lateinit var productsItem: List<ProductsItem>

    lateinit var viewModel: CartViewModel


    lateinit var binding: ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ctgName = intent.getStringExtra("name")
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        viewModel = ViewModelProvider(this)[CartViewModel::class.java]


        val ctgNameTV = findViewById<TextView>(R.id.appName)
        ctgNameTV.text = ctgName
        setSupportActionBar(toolbar)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)






        productsItem = ArrayList<ProductsItem>()

        getAllProductFromServer(ctgName!!);


        Log.i("TAG", "Ctg Name : $ctgName")


    }


    private fun getAllProductFromServer(ctg: String) {

        val getItems: Call<List<ProductsItem>> = MyRetrofit.getRetrofit().getAllProductByCtg(ctg)


        getItems.enqueue(object : Callback<List<ProductsItem>> {
            override fun onResponse(
                call: Call<List<ProductsItem>>,
                response: Response<List<ProductsItem>>
            ) {

                productsItem = response.body()!!

                setupRecyclerView()


                Log.i("TAG", "onResponse: ${productsItem[0]} ")


            }

            override fun onFailure(call: Call<List<ProductsItem>>, t: Throwable) {
                Log.i("TAG", "onFailure: ${t.localizedMessage}")
            }


        })


    }

    private fun setupRecyclerView() {

        val adapter: ProductAdapter = ProductAdapter(productsItem, baseContext, this)
        binding.productRecycler.adapter = adapter


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true

        }
        return super.onOptionsItemSelected(item)
    }

    override fun cartAdd(cart: ProductCart) {

        viewModel.insertCart(cart)
        Toast.makeText(this, "Cart Added", Toast.LENGTH_LONG).show()


    }
}