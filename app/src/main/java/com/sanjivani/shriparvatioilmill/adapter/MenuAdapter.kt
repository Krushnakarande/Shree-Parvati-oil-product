package com.sanjivani.shriparvatioilmill.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanjivani.shriparvatioilmill.DetailsActivity
import com.sanjivani.shriparvatioilmill.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItemsName: List<String>,
    private val menuItemPrice: List<String>,
    private val menuImages: List<Int>,
    private val requireContext: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition // Use adapterPosition for compatibility
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(requireContext, DetailsActivity::class.java)
                    intent.putExtra("MenuItemName", menuItemsName[position])
                    intent.putExtra("MenuItemImage", menuImages[position])
                    requireContext.startActivity(intent)
                }
            }
        }

        fun bind(position: Int) {
            binding.apply {
                foodNamePopular.text = menuItemsName[position]
                PricePopolar.text = menuItemPrice[position]
                imageView5.setImageResource(menuImages[position])
            }
        }
    }
}


