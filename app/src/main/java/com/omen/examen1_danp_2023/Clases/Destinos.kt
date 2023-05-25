package com.omen.examen1_danp_2023.Clases

// [NAV02] Class Destination with App routes
sealed class Destinos(val route: String) {
    object Home : Destinos("home")
    object Login : Destinos("login")
    object Register : Destinos("register")
    object Details : Destinos("details/{reportId}") {
        fun createRoute(reportId: Int) = "details/$reportId"
    }
}