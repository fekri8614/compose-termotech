package info.fekri8614.thermocall.model.net

import info.fekri8614.thermocall.model.data.ThermoItem
import info.fekri8614.thermocall.model.data.ThermoNetwork
import info.fekri8614.thermocall.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/* write your http(s) requests here */
interface ApiService {

    // http://127.0.0.1:1880/data

    @GET("data")
    suspend fun getTemperature(): ThermoNetwork
}

fun createApiService(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}