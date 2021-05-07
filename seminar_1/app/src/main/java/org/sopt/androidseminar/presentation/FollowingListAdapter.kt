package org.sopt.androidseminar.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.databinding.ItemFollowUserBinding
import org.sopt.androidseminar.presentation.model.FollowingUserInfo

class FollowingListAdapter: RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>(){

    private var followList = mutableListOf<FollowingUserInfo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowingUserViewHolder {
        val binding = ItemFollowUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FollowingUserViewHolder(binding)
    }

    override fun onBindViewHolder(
            holder: FollowingUserViewHolder,
            position: Int
    ) {
       holder.onBind(followList[position])
    }

    override fun getItemCount(): Int = followList.size

    fun replaceList(newList: List<FollowingUserInfo>){
        followList = newList.toMutableList()
        notifyDataSetChanged()
    }

    //dataBinding
    class FollowingUserViewHolder(
            private val binding: ItemFollowUserBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun onBind(followingUserInfo: FollowingUserInfo){
            binding.followUserInfo = followingUserInfo
        }
    }

    /*  //viewBinding
    class FollowingUserViewHolder(
        private val binding: ItemFollowUserBinding
    ):RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingUserInfo: FollowingUserInfo){
            binding.followUserName.text = followingUserInfo.userName
        }
    }
    */
}