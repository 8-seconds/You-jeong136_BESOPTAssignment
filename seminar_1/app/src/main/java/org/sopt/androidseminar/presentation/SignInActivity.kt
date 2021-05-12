package org.sopt.androidseminar.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import org.sopt.androidseminar.databinding.ActivitySigninBinding
import androidx.activity.result.contract.ActivityResultContracts.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.sopt.androidseminar.api.ServiceCreator
import org.sopt.androidseminar.data.request.RequestLoginData
import org.sopt.androidseminar.data.response.ErrorResponse
import org.sopt.androidseminar.data.response.ResponseLoginData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        //로그인 버튼 클릭 시
        binding.btnLogin.setOnClickListener {

            val userId:String = binding.etID.text.toString()
            val userPw:String = binding.etPassword.text.toString()

            if(isLoginInputNullorBlank(userId, userPw)){
                Toast.makeText(this@SignInActivity,
                    "id/pw를 확인해주세요!", Toast.LENGTH_LONG).show()
            } else {
                callLoginService(userId, userPw)
//                val homeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
//                homeIntent.putExtra("userId", userId);
//                startActivity(homeIntent)
//                Toast.makeText(this@SignInActivity,
//                        "로그인 성공", Toast.LENGTH_LONG).show()
            }
        }

        //회원가입 클릭 시
        val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
                StartActivityForResult()
        ) { activityResult ->
            //돌아온 후 데이터 처리
            binding.etID.setText(activityResult.data?.getStringExtra("regiId").toString());
            binding.etPassword.setText(activityResult.data?.getStringExtra("regiPw").toString());
        }

        binding.tvRegister.setOnClickListener {
            val signUpIntent = Intent(this@SignInActivity, SignUpActivity::class.java)
            requestActivity.launch(signUpIntent)
        }


    }

    private fun callLoginService(userId: String, userPw: String) {
        val requestLoginData = RequestLoginData(
                id = userId, password = userPw
        )

        val call: Call<ResponseLoginData> = ServiceCreator.soptService.postLogin(requestLoginData)

        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(call: Call<ResponseLoginData>, response: Response<ResponseLoginData>) {
                if(response.isSuccessful){
                    val data = response.body()?.data

                    Toast.makeText(this@SignInActivity,
                            "로그인 성공 " + data?.user_nickname, Toast.LENGTH_LONG).show()

                    val homeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
                    homeIntent.putExtra("userId", userId);
                    startActivity(homeIntent)

                }
                else {
                    val gson = Gson()
                    val type = object : TypeToken<ErrorResponse>() {}.type
                    var errorResponse: ErrorResponse = gson.fromJson(response.errorBody()!!.charStream(), type)

                    Toast.makeText(this@SignInActivity,
                            errorResponse.message, Toast.LENGTH_LONG).show()
                }
           }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })


    }

    private fun isLoginInputNullorBlank(id: String, password: String) = id.isNullOrBlank() || password.isNullOrBlank();

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