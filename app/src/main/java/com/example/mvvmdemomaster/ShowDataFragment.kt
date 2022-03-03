package com.example.mvvmdemomaster

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemomaster.adapter.UserAdapter
import com.example.mvvmdemomaster.apiInstance.ApiInstance
import com.example.mvvmdemomaster.apiService.UserService
import com.example.mvvmdemomaster.databinding.FragmentShowDataBinding
import com.example.mvvmdemomaster.retroFit.UserItem
import kotlinx.coroutines.launch

class ShowDataFragment : Fragment() {

    private lateinit var mBinding: FragmentShowDataBinding

    val USER_KEY = "userKey"



    private val userItem: ArrayList<UserItem> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentShowDataBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return mBinding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UserAdapter(userItem, object {
            var fragment = ShowDataFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(USER_KEY, arguments)
                }
            }
        })

        mBinding.rvDashboard.layoutManager = LinearLayoutManager(requireContext())
        mBinding.rvDashboard.adapter = adapter
        val apiInterFace = ApiInstance.getApiData().create(UserService::class.java)

        lifecycleScope.launch {
            val result = apiInterFace.getData()
            if(result.body() != null){
                adapter.userItem.clear()
                adapter.userItem.addAll(result.body()!!)
                adapter.notifyDataSetChanged()
            }
        }

    }
}