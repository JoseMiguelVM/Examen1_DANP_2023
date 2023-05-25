package com.omen.examen1_danp_2023.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.omen.examen1_danp_2023.R
import com.omen.examen1_danp_2023.ui.theme.BlackColor

@Composable
fun ListaReportes(navController: NavHostController, reportId: Int) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color(245, 245, 245))
            .padding(12.dp, 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
//            .shadow(1.dp),

    ) {
        Image(
            painter = painterResource(id = R.drawable.denuncia),
            contentDescription = "Trash",
            modifier = Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Titulo de Reporte", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "Esta es una descripcion simple de la denuncia", fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.fillMaxHeight()) {
            Icon(
                Icons.Default.Edit,
                contentDescription = "Add",
                modifier = Modifier.size(24.dp),
                tint = BlackColor
            )
        }

    }
}