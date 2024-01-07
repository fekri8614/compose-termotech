package info.fekri8614.thermocall.model.data

import com.google.gson.annotations.SerializedName

data class ThermoNetwork(
    @SerializedName("Temp") val temperature: Double
)
