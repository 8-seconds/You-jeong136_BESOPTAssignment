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