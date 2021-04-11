package com.neppplus.daily10minutesapplication_20210411.utils

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class ServerUtil {


    companion object {

        val HOST_URL = "http://15.164.153.174"

        fun postRequestLogin(email : String, pw : String) {

            val urlString = "${HOST_URL}/user"

            val formData = FormBody.Builder()
                .add("email", email)
                .add("password", pw)
                .build()

            val request = Request.Builder()
                .url(urlString) // 어디로 가는지?
                .post(formData) // POST방식 - 필요데이터(formData) 들고 가도록
                .build()

            val client = OkHttpClient()

            client.newCall(request)


        }


    }

}