package com.ahmetozaydin.ecommerceapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmetozaydin.ecommerceapp.databinding.EachCategoryBinding
import com.ahmetozaydin.ecommerceapp.model.Product
import com.ahmetozaydin.ecommerceapp.view.CategoryActivity

class CategoryAdapter(
    private val products: ArrayList<Product>,
    private val categories: ArrayList<String>,
    val context: Context
) : RecyclerView.Adapter<CategoryAdapter.PlaceHolder>() {//girdi olarak bir hat listesi alması gerekebilir.
//private var categories = ArrayList<String>()

    interface Listener {
        fun categoryButtonClicked(
            products: ArrayList<Product>,
            holder: PlaceHolder,
            position: Int
        )//service : Service de alabilir.
    }

    class PlaceHolder(val binding: EachCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaceHolder {// layout ile bağlama işlemi, view binding ile
        val binding =
            EachCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PlaceHolder,
        position: Int
    ) {
        holder.binding.buttonEachCategory.text = categories[position]

        holder.binding.buttonEachCategory.setOnClickListener {
            val intent = Intent(context, CategoryActivity::class.java)
            intent.putExtra("category_type", holder.binding.buttonEachCategory.text)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}