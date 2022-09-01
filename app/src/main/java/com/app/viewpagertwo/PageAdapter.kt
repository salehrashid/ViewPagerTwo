package com.app.viewpagertwo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.viewpagertwo.data.UserItem
import com.app.viewpagertwo.databinding.RowItemUserBinding
import com.app.viewpagertwo.page.CallFragment
import com.app.viewpagertwo.page.ChatFragment
import com.app.viewpagertwo.page.StatusFragment
import com.bumptech.glide.Glide

class PageAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when (position) {
            0 -> fragment = ChatFragment()
            1 -> fragment = StatusFragment()
            2 -> fragment = CallFragment()
        }
        return fragment
    }
}

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    protected val listUser = ArrayList<UserItem>()

    inner class UserViewHolder(val itemUser: RowItemUserBinding) :
        RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        RowItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemUser.apply {
            with(listUser[position]){
                tvUser.text = login
                Glide.with(imageView.context).load(avatarUrl).into(imageView)
            }
        }
    }

    override fun getItemCount() = listUser.size

    fun setUser(user: ArrayList<UserItem>){
        this.listUser.clear()
        this.listUser.addAll(user)
    }
}