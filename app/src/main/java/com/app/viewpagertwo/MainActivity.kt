package com.app.viewpagertwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.app.viewpagertwo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    protected var _binding: ActivityMainBinding? = null
    protected val binding get() = _binding as ActivityMainBinding

    protected lateinit var pageAdapter : PageAdapter

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
    }
}