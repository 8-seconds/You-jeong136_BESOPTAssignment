package org.sopt.androidseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidseminar.databinding.ActivityUserinfoBinding

class userInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserinfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val followingFragment = FollowingFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.followingFragment, followingFragment)
        transaction.commit()

    }


}