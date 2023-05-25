package com.omen.examen1_danp_2023.Composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.omen.examen1_danp_2023.Clases.Destinos
import com.omen.examen1_danp_2023.Vistas.DetallesScreen
import com.omen.examen1_danp_2023.Vistas.InicioScreen
import com.omen.examen1_danp_2023.Vistas.LoginScreen
import com.omen.examen1_danp_2023.Vistas.RegisterScreen

// [NAV03] NavigationAppHost Composable to associate route and screen
@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable(Destinos.Login.route) { LoginScreen(navController = navController) }
        composable(Destinos.Register.route) { RegisterScreen(navController = navController) }
        composable(Destinos.Home.route) { InicioScreen(navController = navController) }
        composable(Destinos.Details.route) { navBackStackEntry ->
            val reportId = navBackStackEntry.arguments?.getString("reportId")

            if (reportId != null) {
                DetallesScreen(navController, reportId = reportId.toInt())
            }
        }
    }
}