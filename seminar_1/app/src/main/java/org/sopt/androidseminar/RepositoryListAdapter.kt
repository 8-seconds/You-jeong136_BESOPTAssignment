package org.sopt.androidseminar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.databinding.ItemRepositoryBinding

class RepositoryListAdapter: RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    val repoList = mutableListOf<RepositoryInfo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryViewHolder {
        val binding = ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    override fun getItemCount(): Int = repoList.size

    class RepositoryViewHolder(
        private val binding: ItemRepositoryBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun onBind(repositoryInfo: RepositoryInfo){
            binding.tvRepoName.text = repositoryInfo.repoName
            binding.tvRepoDesc.text = repositoryInfo.repoDesc
            binding.tvRepoLang.text = repositoryInfo.repoLang
        }
    }
}
