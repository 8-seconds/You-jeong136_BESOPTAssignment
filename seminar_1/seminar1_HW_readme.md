#Android seminar 1주차 과제 readme

* 필수 (level 1)

  * 화면 전환 후 데이터를 가져온 로직 정리

    * signin <-> home :  

    * SignInActivity 	

      * ```kotlin
         val intent1 = Intent(this@SignInActivity, HomeActivity::class.java)
                        intent1.putExtra("userId", userId);
                        startActivity(intent1)
        ```

    * HomeActivity

      * ```kotlin
        val userid: String? = intent.getStringExtra("userId")
        tvGithubId.text = userid
        ```

    * signin <-> signup : 

    * signInActivity

      * ```kotlin
        val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
                StartActivityForResult()
        ) { activityResult ->
            binding.etID.setText(activityResult.data!!.getStringExtra("regiId").toString());
            binding.etPassword.setText(activityResult.data!!.getStringExtra("regiPw").toString());
        }
        
        binding.tvRegister.setOnClickListener {
            val intent2 = Intent(this@SignInActivity, SignUpActivity::class.java)
            requestActivity.launch(intent2)
        }
        ```

    * signUpActivity

    * ```kotlin
      val result = Intent()
      result.putExtra("regiName", userName)
      result.putExtra("regiId", userId)
      result.putExtra("regiPw", userPw)
      
      setResult(Activity.RESULT_OK, result)
      finish()
      ```

  * 생명주기 호출 _ 로그 캡처

    * ![](C:\Users\user\Desktop\lifecycle_log.PNG)

  * 배운 내용

    * startActivityForResult 대신 registerActivityForResult를 이용 _ 사용방법을 익힘.
      전에는 startActivityForResult()를 이용 intent를 넘기고, 이때 이용한 request code 등을 사용하여 이후 다시 onActivityResult()에서 넘어온 데이터를 처리하였으나, 이번 과제에서는 registerForAcitivityResult()에 앞에서 사용한 onActivityResult()에 해당하는 부분을 함께 정의해주고, 이를 뒤에  intent를 넘길때 앞에서 정의한 변수를 사용 .launch()하여 실행시킴 

* 선택 (level2)

  - [ ] 변수이름 체크
  - [ ] constraintLayout _ chain, guideLine 이용 뷰
  - [x] 자기 소개 부분  _ scrollView로 만들기. 