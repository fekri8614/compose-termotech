package info.fekri8614.thermocall.ui.features.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.fekri8614.thermocall.model.repository.ThermoRepository
import info.fekri8614.thermocall.util.coroutineExceptionHandler
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val thermoRepository: ThermoRepository
) : ViewModel() {
    val dataTemperature = mutableStateOf("")
    val showProgress = mutableStateOf(false)

    init {
        getDataFromNet()
    }

    private fun getDataFromNet() {
        viewModelScope.launch(coroutineExceptionHandler) {
            showProgress.value = true

            val tempData = thermoRepository.getTemperature()

            dataTemperature.value = tempData.temperature.toString()

            showProgress.value = false
        }
    }

}