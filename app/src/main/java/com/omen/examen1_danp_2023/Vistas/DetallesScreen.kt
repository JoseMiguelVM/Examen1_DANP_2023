package com.omen.examen1_danp_2023.Vistas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.omen.examen1_danp_2023.Composables.FondoCircular

@Composable
fun DetallesScreen(navController: NavHostController, reportId: Int) {
    FondoCircular()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Detalles de Reporte de denuncias #$reportId")
        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Back")
        }
        // Edit and Delete Button
    }
}