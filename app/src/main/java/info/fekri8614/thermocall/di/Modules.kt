package info.fekri8614.thermocall.di

import android.content.Context
import info.fekri8614.thermocall.model.net.createApiService
import info.fekri8614.thermocall.model.repository.ThermoRepository
import info.fekri8614.thermocall.model.repository.ThermoRepositoryImpl
import info.fekri8614.thermocall.ui.features.dashboard.DashboardViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {

    single { androidContext().getSharedPreferences("data_temperature", Context.MODE_PRIVATE) }
    single { createApiService() }

    single<ThermoRepository> { ThermoRepositoryImpl(get(), get()) }

    viewModel { DashboardViewModel(get()) }

}