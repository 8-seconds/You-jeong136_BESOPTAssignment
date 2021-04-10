package org.sopt.androidseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidseminar.databinding.ActivityUserInfoBinding

class userInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val followingFragment = FollowingFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.following_fragment, followingFragment)
        transaction.commit()

    }


}