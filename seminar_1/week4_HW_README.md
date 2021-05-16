sopt android week4 HW

level 1 : 로그인 / 회원가입 통신 구현하기!

- postMan 테스트 사진
  - 회원가입의 경우
    [postman signup](https://user-images.githubusercontent.com/59916029/118387405-681ce200-b659-11eb-85a3-6d013596d94c.PNG)
  - 로그인의 경우
    [postman signin](https://user-images.githubusercontent.com/59916029/118387403-66ebb500-b659-11eb-8119-15575749553f.PNG)
- 구현 완료 gif 
    [avd gif](https://user-images.githubusercontent.com/59916029/118387396-56d3d580-b659-11eb-83f5-de25bb8d574a.gif)

* retrofit interface와 구현체 코드 

  * ```kotlin
    interface SoptService {
        @POST("/login/signin")
        fun postLogin(
            @Body body: RequestLoginData
        ) : Call<ResponseLoginData>
    
        @POST("login/signup")
        fun postSignup(
                @Body body: RequestSignupData
        ) : Call<ResponseSignupData>
    }
    ```

    ```kotlin
    object ServiceCreator {
        private const val BASE_URL = "http://cherishserver.com" //domain name
    
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //retrofit에서 json을 dataClass로 바꿔줄 gson 연결
            .build()
        val soptService: SoptService = retrofit.create(SoptService::class.java)
    }
    ```

  * callback 연결부분

    * sign in 

    * ```kotlin
       private fun callLoginService(userId: String, userPw: String) {
              val requestLoginData = RequestLoginData(
                      id = userId, password = userPw
              )
           val call: Call<ResponseLoginData> = ServiceCreator.soptService.postLogin(requestLoginData)
        
           call.enqueue(object : Callback<ResponseLoginData> {
               override fun onResponse(call: Call<ResponseLoginData>, response: Response<ResponseLoginData>) {
                   if(response.isSuccessful){
                       val data = response.body()?.data
                       val nickname = data?.user_nickname
                       Toast.makeText(this@SignInActivity,
                                      "로그인 성공 $nickname", Toast.LENGTH_LONG).show()
        
                       val homeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
                       homeIntent.putExtra("userId", userId);
                       homeIntent.putExtra("userName",  nickname)
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
      ```

    * sign up 

    * ```kotlin
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
      ```

* 과제를 통해 배운 내용 : 

  * week4 세미나 과제를 통해 평소 자신이 없던 서버 통신에 대해서 연습할 수 있는 기회를 가졌다.

  *  postman과 retrofit의 사용법을 배우고, retrofit interface와 구현체, callback 함수를 등록하는 과정을 통해 retrofit을 통한 서버통신 방법을 익힐 수 있었다. 

  * +) 여태까지는 get,post를 통해 자원을 요청하였었는데, 해당 세미나에서 put과  https://reqres.in/ 라는 더미데이터 서버와 put과 delete도 알게 되어, 이를 연습하는 기회가 됨.   

    
