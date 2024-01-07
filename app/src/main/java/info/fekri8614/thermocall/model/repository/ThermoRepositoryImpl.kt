package info.fekri8614.thermocall.model.repository

import android.content.SharedPreferences
import info.fekri8614.thermocall.model.data.ThermoNetwork
import info.fekri8614.thermocall.model.net.ApiService
import info.fekri8614.thermocall.util.KEY_TEMPERATURE

class ThermoRepositoryImpl(
    private val sharedPreferences: SharedPreferences,
    private val apiService: ApiService
): ThermoRepository {
    override suspend fun getTemperature(): ThermoNetwork{
        val dataTemp = apiService.getTemperature()
        saveTemperature(dataTemp.temperature.toString())
        return dataTemp
    }

    override fun saveTemperature(temp: String) {
        sharedPreferences.edit().apply {
            putString(KEY_TEMPERATURE, temp)
        }.apply()
    }

    override fun getSavedTemperature(): String {
        return sharedPreferences.getString(KEY_TEMPERATURE, "No-data")!!
    }
}