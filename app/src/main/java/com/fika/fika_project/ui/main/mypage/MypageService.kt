package com.fika.fika_project.ui.main.mypage

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageService(val View : MypageView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun tryMypage(){
        View.onLoading()

        retrofit.Mypage().enqueue(object : Callback<MypageResponse> {
            override fun onResponse(call: Call<MypageResponse>, response: Response<MypageResponse>) {
                var result: MypageResponse? = response.body()
                val resp = response.body()

                Log.d("MYPAGE/API-RESPONSE", result.toString())

                when(resp?.code){
                    //성공
                    1000 -> {
                        View.onMypageSuccess(response.body() as MypageResponse)
                        Log.d("MYPAGE", resp.message)
                    }
                    4000 -> { Log.d("MYPAGE", "Access-Token이 존재하지 않는 경우") }
                    4001 -> { Log.d("MYPAGE", "유효하지 않은 AccessToken") }
                    4002 -> { Log.d("MYPAGE", "만료된 토큰") }
                    4020 -> { Log.d("MYPAGE", "필수값이 포함되지 않은 경우") }
                    else ->  {
                        Log.d("MYPAGE", "MYPAGE 실패 : 서버 연결 오류")
                    } }
            }

            override fun onFailure(call: Call<MypageResponse>, t: Throwable) {
                Log.d("MYPAGE-FAIL", "MYPAGE 실패 : 서버 오류 ${t.toString()}")
            }
        })}

    fun tryMyScrap(){
        retrofit.MyScrap().enqueue(object : Callback<MyScrapResponse> {
            override fun onResponse(call: Call<MyScrapResponse>, response: Response<MyScrapResponse>) {
                var result: MyScrapResponse? = response.body()
                val resp = response.body()

                Log.d("MYPAGE/API-RESPONSE", result.toString())

                when(resp?.code){
                    //성공
                    1000 -> {
                        Log.d("MYPAGE", resp.message)
                    }
                    4000 -> { Log.d("MYPAGE", "Access-Token이 존재하지 않는 경우") }
                    4001 -> { Log.d("MYPAGE", "유효하지 않은 AccessToken") }
                    4002 -> { Log.d("MYPAGE", "만료된 토큰") }
                    4020 -> { Log.d("MYPAGE", "필수값이 포함되지 않은 경우") }
                    else ->  {
                        Log.d("MYPAGE", "MYPAGE 실패 : 서버 연결 오류")
                    } }
            }

            override fun onFailure(call: Call<MyScrapResponse>, t: Throwable) {
                Log.d("MYPAGE-FAIL", "MYPAGE 실패 : 서버 오류 ${t.toString()}")
            }
        })}

}