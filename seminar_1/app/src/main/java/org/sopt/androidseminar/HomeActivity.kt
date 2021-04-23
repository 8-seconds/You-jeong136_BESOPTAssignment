package org.sopt.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.androidseminar.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val TAG:String= "HomeActivity";
    private lateinit var binding: ActivityHomeBinding
    private lateinit var repositoryListAdapter: RepositoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userid: String? = intent.getStringExtra("userId")
        binding.tvGithubId.text = userid


        repositoryListAdapter = RepositoryListAdapter()
        binding.rvRepoList.adapter = repositoryListAdapter

        addAllRepoListItem()

        repositoryListAdapter.notifyDataSetChanged()

        initMoreButtonClickEvent()
        Log.d(TAG, "onCreate")
    }

    private fun addAllRepoListItem() {
        repositoryListAdapter.repoList.addAll(
            listOf<RepositoryInfo>(
                RepositoryInfo(
                    repoName = "레포지터리",
                    repoDesc = "레포지터리 설명",
                    repoLang = "언어"
                ),
                RepositoryInfo(
                    repoName = "말이 엄청 긴 레포지터리 이름 실험: ellipsize, maxLine 옛날옛날에 어는 마을에 마음이 착한 목화솜이 살았어요",
                    repoDesc = "마찬가지로 말이 엄청 긴 레포지터리 설명 실험: ellipsize, maxLinem 옛날옛날에 어느마을에 마음이 착한 목화솜이 살았어요",
                    repoLang = "한국어"
                ),
                RepositoryInfo(
                    repoName = "레포지터리",
                    repoDesc = "레포지터리 설명",
                    repoLang = "언어"
                ),
                RepositoryInfo(
                    repoName = "레포지터리",
                    repoDesc = "레포지터리 설명",
                    repoLang = "언어"
                ),
                RepositoryInfo(
                    repoName = "레포지터리",
                    repoDesc = "레포지터리 설명",
                    repoLang = "언어"
                ),
                RepositoryInfo(
                    repoName = "레포지터리",
                    repoDesc = "레포지터리 설명",
                    repoLang = "언어"
                ),
                RepositoryInfo(
                    repoName = "레포지터리",
                    repoDesc = "레포지터리 설명",
                    repoLang = "언어"
                )
            )
        )
    }

    private fun initMoreButtonClickEvent(){
        //userInfoActivity (followingFragment가 있는) 띄워주기
        binding.btnMore.setOnClickListener{
            val userInfoIntent = Intent(this@HomeActivity, userInfoActivity::class.java)
            startActivity(userInfoIntent)
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