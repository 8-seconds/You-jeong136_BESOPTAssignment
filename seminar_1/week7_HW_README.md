* sopt android week7 HW

* level1 -1 Activity 처리과정

  * SigninActivity _ 처음 들어왔을 때 sharedPreference에 id/pw가 있을 경우

    * onCreate에서 searchUserAuthStorage() 를 통해 확인. 

      ```kotlin
      private fun searchUserAuthStorage(){
          if(hasUserAuthData()){
              callLoginService(
                  SoptUserAuthStorage.getUserId(this),
                  SoptUserAuthStorage.getUserPw(this)
      
              )
          }
      }
      
      private fun hasUserAuthData() = SoptUserAuthStorage.getUserId(this).isNotEmpty()
              && SoptUserAuthStorage.getUserPw(this).isNotEmpty()
      ```

  * SigninActivity _ 로그인 할 때 성공 시 sharedPreference 집어 넣기

    * ```kotlin
      val call: Call<ResponseLoginData> = ServiceCreator.soptService.postLogin(requestLoginData)
      
              call.enqueue(object : Callback<ResponseLoginData> {
                  override fun onResponse(call: Call<ResponseLoginData>, response: Response<ResponseLoginData>) {
                      if(response.isSuccessful){
                          val data = response.body()?.data
                          val nickname = data?.user_nickname
      //로그인 성공 시 정보 넣는 부분
                          if(!hasUserAuthData()){
                              with(binding){
                                  SoptUserAuthStorage.saveUserId(this@SignInActivity, etID.text.toString())
                                  SoptUserAuthStorage.saveUserPw(this@SignInActivity, etPassword.text.toString())
                              }
                          }
      
      //                    Toast.makeText(this@SignInActivity,
      //                            "로그인 성공 $nickname", Toast.LENGTH_LONG).show()
                           showToast( "로그인 성공 $nickname")
      
                          val homeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
                          homeIntent.putExtra("userId", userId);
                          homeIntent.putExtra("userName",  nickname)
                          startActivity(homeIntent)
                          finish()
                      }
                      else {
                          val gson = Gson()
                          val type = object : TypeToken<ErrorResponse>() {}.type
                          var errorResponse: ErrorResponse = gson.fromJson(response.errorBody()!!.charStream(), type)
      
      //                    Toast.makeText(this@SignInActivity,
      //                            errorResponse.message, Toast.LENGTH_LONG).show()
                          showToast(errorResponse.message)
                      }
                 }
      ```

  * HomeActivity _ 로그아웃할 경우 sharedPreference  clear

    * ```kotlin
      binding.tvLogout.setOnClickListener{
          SoptUserAuthStorage.clearAuthStorage(this)
          val loginIntent = Intent(this@HomeActivity, SignInActivity::class.java)
          startActivity(loginIntent)
          finish()
      }
      ```

* level1 - 2  구현한 SharedPreference 코드

  * ```kotlin
    package org.sopt.androidseminar.data
    
    import android.content.Context
    import android.content.SharedPreferences
    
    object SoptUserAuthStorage {
        private const val  STORAGE_KEY = "user_auth"
        private const val USER_ID = "user_id"
        private const val USER_PW = "user_pw"
    
    
        private lateinit var prefs : SharedPreferences
    
        fun initPreferences(context: Context) {
            prefs = context.getSharedPreferences(
                    "${context.packageName}.$STORAGE_KEY", Context.MODE_PRIVATE)
        }
        
    //    SharedPreferences를 얻어오는 부분을 함수로 뺀 경우.
    //    private fun getPreferences(context: Context): SharedPreferences {
    //        return context.getSharedPreferences(
    //                "${context.packageName}.$STORAGE_KEY", Context.MODE_PRIVATE)
    //    }
    
        fun saveUserId(context: Context, id: String){
            //val prefs = getPreferences(context)
            prefs.edit()
                    .putString(USER_ID, id)
                    .apply()
        }
    
        fun saveUserPw(context: Context, pw : String){
           // val prefs = getPreferences(context)
            prefs.edit()
                    .putString(USER_PW, pw)
                    .apply()
        }
    
        fun getUserId(context: Context) : String {
           // val prefs = getPreferences(context)
            return prefs.getString(USER_ID, "") ?: ""
        }
    
        fun getUserPw(context: Context) : String {
           // val prefs = getPreferences(context)
            return prefs.getString(USER_PW, "") ?: ""
        }
    
        fun removeUserId(context: Context) {
           // val prefs = getPreferences(context)
            prefs.edit()
                    .remove(USER_ID)
                    .apply()
        }
    
        fun removeUserPw(context: Context) {
           // val prefs = getPreferences(context)
            prefs.edit()
                    .remove(USER_PW)
                    .apply()
        }
    
        fun clearAuthStorage(context: Context) {
           // val prefs = getPreferences(context)
            prefs.edit()
                    .clear()
                    .apply()
        }
    
    }
    ```

    추가) initPreferences 호출 부분.

    ```kotlin
    package org.sopt.androidseminar
    
    import android.app.Application
    import org.sopt.androidseminar.data.SoptUserAuthStorage.initPreferences
    
    class ApplicationController : Application() {
    
        override fun onCreate() {
            super.onCreate()
            initPreferences(this)
        }
    }
    ```



* week7 과제를 통해 배운 내용 :
  * 영속성 데이터, sharedPreference를 사용하는 방법에 대해서 배울 수 있었다.
  * 또한 사실 민감한 데이터인 id와 pw를 이렇게 따로 저장하는 방법은 보안성이 나쁠 수 있는데, 이와 관련하여 세미나 자료에서 AccessToken 이라는 것과 그 흐름에 대해 예시를 들어주어, 관련 내용을 검색해보는 시간을 가질 수 있었다. (시험기간이라, 짧게 검색만 해보았지만 이후 관련해서 더 알아보는 시간을 가지면 좋을 듯...)