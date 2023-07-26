package com.example.uas2020003.app


import com.example.uas2020003.model.KopiModel
import com.example.uas2020003.model.ResponseModel


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("tblkopi/save")
    fun saveKopi(
        @Body data: KopiModel
    ): Call<ResponseModel>

    @GET("kopi")
    fun getKopi(): Call<ResponseModel>

//    @GET("sekolah")
//    fun getSekolah(): Call<ResponseModelSekolah>
}