package info.fekri8614.thermocall.util

import info.fekri8614.thermocall.model.data.ThermoItem

// keys
const val KEY_THERMO_ITEM = "key_thermo_item"

const val KEY_TEMPERATURE = "key_temperature"

// api
const val BASE_URL = "http://127.0.0.1:1880"

val thermoItemList = listOf<ThermoItem>(
    ThermoItem(title = "SomeTitle", kind = "Dry Alert", time = "3 hours ago", temperature = 0.0),
    ThermoItem(title = "SomeTitle", kind = "Dry Alert", time = "5 hours ago", temperature = 0.0),
    ThermoItem(title = "SomeTitle", kind = "Dry Alert", time = "1 minutes ago", temperature = 0.0),
    ThermoItem(title = "SomeTitle", kind = "Dry Alert", time = "3 minutes ago", temperature = 0.0),
    ThermoItem(title = "SomeTitle", kind = "Dry Alert", time = "3 minutes ago", temperature = 0.0),
    ThermoItem(title = "SomeTitle", kind = "Dry Alert", time = "8 hours ago", temperature = 0.0),
    ThermoItem(title = "SomeTitle", kind = "Dry Alert", time = "52 minutes ago", temperature = 0.0),
    ThermoItem(title = "SomeTitle", kind = "Dry Alert", time = "32 hours ago", temperature = 0.0),
)
