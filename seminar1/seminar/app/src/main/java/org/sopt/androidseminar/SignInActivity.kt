package org.sopt.androidseminar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import org.sopt.androidseminar.databinding.ActivitySigninBinding
import androidx.activity.result.contract.ActivityResultContracts.*

class SignInActivity : AppCompatActivity() {
    private val TAG:String= "SignInActivity";
    private lateinit var binding:ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()

    }

    private fun initButtonClickEvent() {
        binding.btnLogin.setOnClickListener {

            val userId:String = binding.etID.text.toString()
            val userPw:String = binding.etPassword.text.toString()

            if(userId.isNullOrBlank() || userPw.isNullOrBlank()){
                Toast.makeText(this@SignInActivity,
                    "id/pw를 확인해주세요!", Toast.LENGTH_LONG).show()
            } else {
                val intent1 = Intent(this@SignInActivity, HomeActivity::class.java)
                startActivity(intent1)
                Toast.makeText(this@SignInActivity,
                        "로그인 성공", Toast.LENGTH_LONG).show()
            }
        }

        val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
                StartActivityForResult() // ◀ StartActivityForResult 처리를 담당
        ) { activityResult ->
            // action to do something
            binding.etID.setText(activityResult.data!!.getStringExtra("regiId").toString());
            binding.etPassword.setText(activityResult.data!!.getStringExtra("regiPw").toString());
        }

        binding.tvRegister.setOnClickListener {
            val intent2 = Intent(this@SignInActivity, SignUpActivity::class.java)
            requestActivity.launch(intent2)
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