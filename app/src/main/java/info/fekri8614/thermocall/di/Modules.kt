package info.fekri8614.thermocall.di

import info.fekri8614.thermocall.ui.features.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {
    viewModel { DashboardViewModel() }
}