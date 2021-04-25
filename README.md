#Android seminar 2주차 과제 readme

* 필수 (level 1)

  * 구현 방법

    * 구현 내용 : 

      * HomeActivity _ 유저 정보 옆에 more 버튼 추가 _ userInfoActivity 띄우기

        *  activity_home.xml에 btnMore 추가 후 homeActivity에서 initMoreButtonClickEvent() 정의 _ userInfoIntent를 실행함.

        * ```kotlin
          private fun initMoreButtonClickEvent(){
              binding.btnMore.setOnClickListener{
                  val userInfoIntent = Intent(this@HomeActivity, userInfoActivity::class.java)
                  startActivity(userInfoIntent)
              }
          }
          ```

    * HomeActivity _ 하단에 recycle view를 추가, repository 정보를 담을 list 띄우기 

      * 먼저 repository의 정보를 담을 item data class 생성

      * ```kotlin
        data class RepositoryInfo(
            val repoName: String,
            val repoDesc: String,
            val repoLang: String,
        )
        ```

      * item을 담을 viewHolder와 해당 viewHolder를 담아 뷰에서 보여줄 adapter를 정의 

      * recylcerView에 adapter를 연결하여 데이터를 갱신해, item을 보여준다. 

      * // 구성 요건 : 레포지터리의 이름이나 설명이 너무 길어질 경우 ... 이용해서 나타내기

        * ```kotlin
          android:ellipsize="end"
          android:maxLines="1"
          ```

          * 여기서 ellipsize는 ...을 나타낼 위치를 가리키기도 함. end면 문장의 끝에 ...을 표시, start면 맨앞에, middle은 중간에 ... 을 표시함. (그 외에는 marquee도 존재 )

* 선택 (level 2) _ 시험 끝나면 추가예정....
  - [x] gridLayoutManager 사용해보기 
  - [ ] 여러 viewHolder를 만들어 recyclerView 안에 2가지 이상의 뷰를 보여주기
  - [x] recyclerView Item 기능 구현하기 _ change 버튼 추가 클릭 시 grid <-> linear layoutManager 

* 선택 (level3) _ 시험 끝나면 추가예정...
