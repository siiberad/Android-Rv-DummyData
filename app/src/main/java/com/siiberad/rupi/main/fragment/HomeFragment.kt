package com.siiberad.rupi.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.siiberad.rupi.R
import com.siiberad.rupi.main.adapter.HomeRvAdapter
import com.siiberad.rupi.main.model.RvDataModel
import com.siiberad.rupi.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var vm: MainViewModel
    companion object {
        fun getInstance() = HomeFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (activity != null) {
            vm = ViewModelProvider(activity!!).get(MainViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.getData().observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })
    }

    private fun setAdapter(data: List<RvDataModel>?) {
        val homeRvAdapter = HomeRvAdapter(data!!)
        rv_home.apply {
            layoutManager = LinearLayoutManager(context)
            homeRvAdapter.notifyDataSetChanged()
            adapter = homeRvAdapter
        }
    }
}