package com.app.viewpagertwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.viewpagertwo.data.UserItem
import com.app.viewpagertwo.databinding.ActivityMainBinding
import com.app.viewpagertwo.network.ApiConfig
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    protected var _binding: ActivityMainBinding? = null
    protected val binding get() = _binding as ActivityMainBinding

    protected lateinit var pageAdapter : PageAdapter
    protected val adapterUser = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pageAdapter = PageAdapter(supportFragmentManager, lifecycle)

        with(binding){
            vpWa.adapter = pageAdapter

            TabLayoutMediator(tabWa, vpWa) {tab, position ->
                when(position){
                    0 -> tab.text = "Chat"
                    1 -> tab.text = "Status"
                    2 -> tab.text = "Call"
                }
            }.attach()
        }
        getDataApi()
    }

    fun setData(data: ArrayList<UserItem>){
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterUser
            adapterUser.setUser(data)
        }
    }

    protected fun getDataApi() {
        ApiConfig.getApiService().getListUser().enqueue(object : Callback<ArrayList<UserItem>>{
            override fun onResponse(
                call: Call<ArrayList<UserItem>>,
                response: Response<ArrayList<UserItem>>
            ) {
                response.body()?.let {
                    setData(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<UserItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}