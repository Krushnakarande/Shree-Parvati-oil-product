package com.sanjivani.shriparvatioilmill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.sanjivani.shriparvatioilmill.adapter.MenuAdapter
import com.sanjivani.shriparvatioilmill.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val menuItemName = listOf("Coconut oil","Groundnut oil","Sunflower oil ","Flaxseed oil ","item")
        val menuItemPrice = listOf("₹150","₹65","₹130","₹250","₹78")
        val menuImage = listOf(
            R.drawable.o1,R.drawable.o2,R.drawable.o3,R.drawable.o4,R.drawable.o5
        )
        val adapter = MenuAdapter(ArrayList(menuItemName),ArrayList(menuItemPrice),ArrayList(menuImage),requireContext())


        val layoutManager = GridLayoutManager(requireContext(), 2) // 2 for 2 columns

        binding.menuRecyclerView.layoutManager = layoutManager
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {



    }
}