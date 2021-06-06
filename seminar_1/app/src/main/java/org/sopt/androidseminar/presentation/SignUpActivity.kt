package org.sopt.androidseminar.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.sopt.androidseminar.api.ServiceCreator
import org.sopt.androidseminar.data.request.RequestLoginData
import org.sopt.androidseminar.data.request.RequestSignupData
import org.sopt.androidseminar.data.response.ErrorResponse
import org.sopt.androidseminar.data.response.ResponseLoginData
import org.sopt.androidseminar.data.response.ResponseSignupData
import org.sopt.androidseminar.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            val birth: String = binding.etRegiBirth.text.toString()
            val phone: String = binding.etRegiPhone.text.toString()
            val sex: String = if(binding.r1Male.isChecked){ "0" }
                                else { "1" }

            if (userName.isNullOrBlank() || userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(
                    this@SignUpActivity,
                    "빈 칸이 있는지 확인해주세요", Toast.LENGTH_LONG
                ).show()
            } else {
                callSignUpService(userId, userPw, userName, birth, phone, sex)
            }
        }
    }

    private fun callSignUpService(userId: String, userPw: String, userName: String, birth:String, phone:String, sex: String) {
        val requestSignupData = RequestSignupData(
                id = userId, password = userPw, birth = birth, phone = phone, sex = sex, nickname = userName
        )

        val call: Call<ResponseSignupData> = ServiceCreator.soptService.postSignup(requestSignupData)

        call.enqueue(object : Callback<ResponseSignupData>{
            override fun onResponse(call: Call<ResponseSignupData>, response: Response<ResponseSignupData>) {
                if(response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@SignUpActivity,
                            "회원가입 성공!", Toast.LENGTH_LONG ).show()

                    val result = Intent()
                    result.putExtra("regiName", data?.nickname)
                            .putExtra("regiId", userId)
                            .putExtra("regiPw", userPw)

                    setResult(Activity.RESULT_OK, result)
                    finish()
                } else {
                    val gson = Gson()
                    val type = object : TypeToken<ErrorResponse>() {}.type
                    var errorResponse: ErrorResponse = gson.fromJson(response.errorBody()!!.charStream(), type)

                    Toast.makeText(this@SignUpActivity,
                            errorResponse.message, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseSignupData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })



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