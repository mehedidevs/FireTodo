package com.es.k_e_cart_maad.ui.fragments

import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.es.k_e_cart_maad.databinding.FragmentHomeBinding
import com.es.k_e_cart_maad.entity.Category
import com.es.k_e_cart_maad.entity.SliderItem
import com.es.k_e_cart_maad.ui.activities.ProductActivity
import com.es.k_e_cart_maad.ui.adapter.CategoryAdapter
import com.es.k_e_cart_maad.ui.adapter.SliderAdapter
import com.es.k_e_cart_maad.ui.my_listener.CtgListener
import com.es.k_e_cart_maad.utlis.Common


class HomeFragment : Fragment(), CtgListener {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        val view = binding.root


        val adapter: CategoryAdapter = CategoryAdapter(this, Common.getCategory, requireActivity())

        binding.ctgRecyclerview.adapter = adapter

        setupSlider();





        return view
    }

    private fun setupSlider() {
        val sliderList = listOf<SliderItem>(
            SliderItem(
                "publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without",
                "https://i.pinimg.com/originals/c7/28/58/c72858992482c70d5ec3a585eec352ed.png"
            ),
            SliderItem(
                "publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without",
                "https://i.pinimg.com/originals/88/e1/f9/88e1f93024ce28f5e66f279ddeb0c6ce.png"
            ),
            SliderItem(
                "publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without",
                "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/7bad8c93546277.5f48a570f12f8.jpg"
            ),
            SliderItem(
                "publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without",
                "https://slidebazaar.com/wp-content/uploads/2021/09/product-banner.jpg"
            ),
        )


        val adapter: SliderAdapter = SliderAdapter(requireActivity(), sliderList)
        binding.banner.setSliderAdapter(adapter)


    }

    override fun CtgClickListener(category: Category) {


        val intent: Intent = Intent(requireActivity(), ProductActivity::class.java)

        intent.putExtra("name", category.name)

        startActivity(intent)


    }


}