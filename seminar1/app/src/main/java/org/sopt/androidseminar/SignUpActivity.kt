package org.sopt.androidseminar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidseminar.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private val TAG:String= "SignUpActivity";
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()

    }

    private fun initButtonClickEvent() {
        binding.btnSignUp.setOnClickListener {

            val userName: String = binding.etRegisterName.text.toString()
            val userId: String = binding.etRegisterId.text.toString()
            val userPw: String = binding.etRegisterPw.text.toString()

            if (userName.isNullOrBlank() || userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(
                    this@SignUpActivity,
                    "빈 칸이 있는지 확인해주세요", Toast.LENGTH_LONG
                ).show()
            } else {
                val result = Intent()
                result.putExtra("regiName", userName)
                result.putExtra("regiId", userId)
                result.putExtra("regiPw", userPw)

                setResult(Activity.RESULT_OK, result)
                finish()

            }
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