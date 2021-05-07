package org.sopt.androidseminar.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.databinding.ItemRepositoryBinding
import org.sopt.androidseminar.presentation.model.RepositoryInfo

class RepositoryListAdapter: RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    private var repoList = mutableListOf<RepositoryInfo>()

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

    fun replaceList(newList : List<RepositoryInfo>){
        repoList = newList.toMutableList() //deep cloning 한 다음 넘겨줌. shallow(X)
        notifyDataSetChanged()
    }
    //dataBinding version
    class RepositoryViewHolder(
        private val binding : ItemRepositoryBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun onBind(repositoryInfo: RepositoryInfo){ binding.repositoryInfo = repositoryInfo}
    }

    /* //viewBinding version
    class RepositoryViewHolder(
    
        private val binding: ItemRepositoryBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun onBind(repositoryInfo: RepositoryInfo){
            binding.tvRepoName.text = repositoryInfo.repoName
            binding.tvRepoDesc.text = repositoryInfo.repoDesc
            binding.tvRepoLang.text = repositoryInfo.repoLang
        }
    }
    */
     
}
