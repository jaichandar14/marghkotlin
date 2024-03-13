package com.zuper.marghkoltin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zuper.marghkoltin.databinding.FragmentHomeBinding
import com.zuper.marghkoltin.ui.adapter.MemeListAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MemeListAdapter
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mIntitalizeRecylerView()
        var dataset=ArrayList<String>()
        dataset.add("jai")
        dataset.add("jai1")
        dataset.add("jai2")
        dataset.add("jai3")

        adapter.refreshItems(dataset)
    }
    private  fun mIntitalizeRecylerView(){
        recyclerView = binding.recyclerView
        adapter = MemeListAdapter(requireActivity().applicationContext)
        recyclerView.layoutManager =
            LinearLayoutManager(requireActivity().applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}