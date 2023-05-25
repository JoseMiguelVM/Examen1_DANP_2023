package com.omen.examen1_danp_2023.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.omen.examen1_danp_2023.R
import com.omen.examen1_danp_2023.Clases.Destinos
import com.omen.examen1_danp_2023.Composables.FondoCircular
import com.omen.examen1_danp_2023.Composables.FormRegistroReporte
import com.omen.examen1_danp_2023.Composables.ListaReportes
import com.omen.examen1_danp_2023.ui.theme.PrimaryColor
import com.omen.examen1_danp_2023.ui.theme.SecondaryColor

@Composable
fun InicioScreen(navController: NavHostController) {

    val reportsList = MutableList(10) { it }
    var showDialog by rememberSaveable { mutableStateOf(false) }

    FondoCircular()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(24.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 20.dp)
                .fillMaxWidth(),
        ) {
            Text(
                fontSize = 24.sp,
                color = SecondaryColor,
                text = "Bienvenido Usuario",
                modifier = Modifier.weight(1f)
            )

            Icon(
                Icons.Default.ExitToApp,
                contentDescription = "Logout",
                tint = SecondaryColor,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate(Destinos.Login.route) }
            )
        }

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .fillMaxSize()
                .background(SecondaryColor)
                .padding(8.dp, 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pollution Reports",
                color = PrimaryColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (reportsList.isEmpty()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.vacio),
                        contentDescription = "Empty",
                        modifier = Modifier.size(300.dp)
                    )

                    Text(text = "No existe reportes registrados", color = PrimaryColor, fontSize = 18.sp)
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(all = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(reportsList) {
                    ListaReportes(navController = navController, reportId = it)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            containerColor = PrimaryColor,
            contentColor = SecondaryColor,
            onClick = { showDialog = true },
            shape = RoundedCornerShape(50.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }

    FormRegistroReporte(showDialog = showDialog, { showDialog = false }, {
        // Save in DataBase
        showDialog = false
    })
}