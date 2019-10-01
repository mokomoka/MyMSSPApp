package io.github.mokomoka.mssprandomapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class Interface {
    interface NicoApiService {
        @GET("api/v2/video/contents/search")
        fun getNicoData(
            @Query("q") query : String,
            @Query("targets") targets : String,
            @Query("fields") fields : String,
            @Query("_sort") sort : String,
            @Query("_offset") offset : Int,
            @Query("_limit") limit : Int,
            @Query("_context") context : String
        ) : Call<NicoResponse>
    }

//    interface TubeApiService {
//        @GET("v3/search")
//        fun getTubeData(
//            @Query("part") part : String,
//            @Query("channelId") channelId : String,
//            @Query("order") order : String,
//            @Query("q") query : String,
//            @Query("type") type : String,
//            @Query("key") key : String
//        ) : Call<TubeResponse>
//    }
}
