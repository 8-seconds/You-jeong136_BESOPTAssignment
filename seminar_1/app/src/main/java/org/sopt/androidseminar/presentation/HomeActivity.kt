package org.sopt.androidseminar.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.androidseminar.data.LocalRepositoryDataSource
import org.sopt.androidseminar.data.RepositoryDataSource
import org.sopt.androidseminar.data.SoptUserAuthStorage
import org.sopt.androidseminar.databinding.ActivityHomeBinding
import org.sopt.androidseminar.presentation.model.RepositoryInfo


class HomeActivity : AppCompatActivity() {
    private val TAG:String= "HomeActivity";

    private lateinit var binding: ActivityHomeBinding
    private lateinit var repoDataSource : RepositoryDataSource
    private lateinit var repositoryListAdapter: RepositoryListAdapter

    private var isGrid:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userid: String? = intent.getStringExtra("userId")
        val username : String? = intent.getStringExtra("userName")
        binding.tvGithubId.text = userid
        binding.tvName.text = username

        repositoryListAdapter = RepositoryListAdapter()
        repoDataSource = LocalRepositoryDataSource()
        val repoList = repoDataSource.fetchRepoData()

        binding.rvRepoList.adapter = repositoryListAdapter

        repositoryListAdapter.replaceList(repoList)


        initButtonClickEvent()
        Log.d(TAG, "onCreate")
    }

    private fun initButtonClickEvent(){
        //userInfoActivity (followingFragment가 있는) 띄워주기
        binding.btnMore.setOnClickListener{
            val userInfoIntent = Intent(this@HomeActivity, userInfoActivity::class.java)
            startActivity(userInfoIntent)
        }

        //grid <-> linear 보기 방식 바꾸기
        binding.btnChange.setOnClickListener{
            if(isGrid)
                binding.rvRepoList.layoutManager = LinearLayoutManager(this)
            else
                binding.rvRepoList.layoutManager = GridLayoutManager(this, 2)
            isGrid = !isGrid
        }

        binding.tvLogout.setOnClickListener{
            SoptUserAuthStorage.clearAuthStorage(this)
            val loginIntent = Intent(this@HomeActivity, SignInActivity::class.java)
            startActivity(loginIntent)
            finish()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

}