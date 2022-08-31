package com.app.viewpagertwo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.viewpagertwo.page.CallFragment
import com.app.viewpagertwo.page.ChatFragment
import com.app.viewpagertwo.page.StatusFragment

class PageAdapter(fm: FragmentManager, lc: Lifecycle): FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0 -> fragment = ChatFragment()
            1 -> fragment = StatusFragment()
            2 -> fragment = CallFragment()
        }
        return fragment
    }
}