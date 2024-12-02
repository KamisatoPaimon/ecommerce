package com.example.ecommerce.Ui.Fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.Adapter.ProductAdapter
import com.example.ecommerce.Data.Api.ProductService
import com.example.ecommerce.Data.Api.RetrofitClient
import com.example.ecommerce.Data.Model.Product
import com.example.ecommerce.R
import com.example.ecommerce.Ui.Activity.BarcodeScannerActivity
import retrofit2.*


class HomeFragment : Fragment() {
    private val REQUEST_CODE_BARCODE = 1001
    private lateinit var listProduct: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var imgBtnCamera:ImageButton
    private var productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)
        init(view)
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_BARCODE && resultCode == RESULT_OK) {
            val barcode = data?.getStringExtra("barcode")
            if (!barcode.isNullOrEmpty()) {
                // Hiển thị mã vạch hoặc xử lý logic khác
                Toast.makeText(requireContext(), "Mã vạch: $barcode", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun init(view: View) {
        imgBtnCamera = view.findViewById(R.id.img_btn_camera)
        imgBtnCamera.setOnClickListener(View.OnClickListener {
            startActivityForResult(Intent(requireContext(), BarcodeScannerActivity::class.java), REQUEST_CODE_BARCODE )
        })
        listProduct = view.findViewById(R.id.list_product)
        listProduct.layoutManager = GridLayoutManager(requireContext(),2)
        fetchProduct()
    }

    fun fetchProduct() {
        val retrofitClient = RetrofitClient().getClient().create(ProductService::class.java)
        val productService = retrofitClient.getAllProducts()
        productService.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                val products = response.body()
                products?.let {
                    productList.clear()  // Clear previous list if any
                    productList.addAll(it)  // Add the new products
                    productAdapter = ProductAdapter(requireContext(),productList)
                    listProduct.adapter = productAdapter
                }


            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.e("Product", "Error fetching products: ${t.message}")
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}