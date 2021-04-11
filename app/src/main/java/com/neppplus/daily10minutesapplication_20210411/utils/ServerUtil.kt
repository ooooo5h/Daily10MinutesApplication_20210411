package com.neppplus.daily10minutesapplication_20210411.utils

import android.util.Log
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

    interface JsonResponseHandler {
        fun onResponse(jsonObj : JSONObject)
    }

    companion object {

        val HOST_URL = "http://15.164.153.174"

        fun postRequestLogin(email : String, pw : String, handler : JsonResponseHandler?) {

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

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {

                    val bodyString = response.body!!.string()

                    val jsonObj = JSONObject(bodyString)

                    Log.d("서버응답", jsonObj.toString())

                    handler?.onResponse(jsonObj)

                }

            })

        }

        fun putRequestSingUp(email : String, pw : String, nickname : String, handler: JsonResponseHandler?) {

            val urlString = "${HOST_URL}/user"

            val formData = FormBody.Builder()
                .add("email", email)
                .add("password", pw)
                .add("nick_name", nickname)
                .build()

            val request = Request.Builder()
                .url(urlString)
                .put(formData)
                .build()

            val client = OkHttpClient()

            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    val bodyString = response.body!!.string()
                    val jsonObj = JSONObject(bodyString)
                    Log.d("서버응답", jsonObj.toString())
                    handler?.onResponse(jsonObj)


                }


            })

        }

        fun getRequestEmailCheck(email : String, handler: JsonResponseHandler?) {

            val urlBuilder = "${HOST_URL}/email_check".toHttpUrlOrNull()!!.newBuilder()

            urlBuilder.addEncodedQueryParameter("email", email)

            val urlString = urlBuilder.build().toString()

            Log.d("가공된url", urlString )

        }

    }

}