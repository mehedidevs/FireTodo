package com.es.k_e_cart_maad.ui.fragments

import android.content.DialogInterface
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.es.k_e_cart_maad.R
import com.es.k_e_cart_maad.databinding.FragmentCartBinding
import com.es.k_e_cart_maad.entity.ProductCart
import com.es.k_e_cart_maad.ui.adapter.CartAdapter
import com.es.k_e_cart_maad.ui.my_listener.CartListener
import com.es.k_e_cart_maad.ui.view_models.CartViewModel


class CartFragment : Fragment(), CartListener {


    lateinit var binding: FragmentCartBinding

    lateinit var cartViewModel: CartViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCartBinding.inflate(inflater, container, false)

        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]

        cartViewModel.getAllCart().observe(viewLifecycleOwner) {
            val adapter = CartAdapter(requireActivity(), it, this)
            binding.cartRcyclerView.adapter = adapter
            binding.amountToPay.text = "Amount to Pay : ${getTotalAmount(it)}"

        }



        return binding.root
    }

    private fun getTotalAmount(it: List<ProductCart>?): Double {
        var mAmount: Double = 0.0
        it!!.forEach {
            mAmount += (it.price * it.quantity)


        }





        return mAmount


    }

    override fun cartAdd(cart: ProductCart) {
        var qty = cart.quantity + 1

        val mCart: ProductCart = ProductCart(
            cart.title, cart.description, cart.id, cart.image,
            cart.price, cart.title, qty
        )



        cartViewModel.updateCart(mCart)


    }

    override fun cartMinus(cart: ProductCart) {
        var qty = cart.quantity - 1

        val mCart: ProductCart = ProductCart(
            cart.title, cart.description, cart.id, cart.image,
            cart.price, cart.title, qty
        )

        if (qty >= 1) {

            cartViewModel.updateCart(mCart)

        } else {

            Toast.makeText(requireActivity(), " Qty cant be less then 1", Toast.LENGTH_LONG).show()
            showAlert("Are you Sure?", "Want To Delete this Cart", cart)
        }
    }

    override fun cartDelete(cart: ProductCart) {
        showAlert("Are you Sure?", "Want To Delete this Cart", cart)

    }


    fun showAlert(title: String, msg: String, cart: ProductCart) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(title)
        builder.setMessage(msg)
        builder.setCancelable(true)

        builder.setPositiveButton("Yes") { dialog, which ->

            cartViewModel.deleteCart(cart)
        }
        builder.setNegativeButton("No") { dialog, which ->

        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()


    }


}

