package info.fekri8614.thermocall.model.repository

import info.fekri8614.thermocall.model.data.ThermoNetwork

interface ThermoRepository {
    suspend fun getTemperature(): ThermoNetwork
    fun saveTemperature(temp: String)
    fun getSavedTemperature(): String
}