package com.example.proyectopractica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopractica.ui.theme.ProyectoPracticaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoPracticaTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    presentacion()
                }
            }
        }
    }
}

@Composable
fun presentacion() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center, // Cambiado a Center
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Parte superior: imagen, nombre, título
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.email_icono),
                contentDescription = "Profile Image",
                modifier = Modifier.size(100.dp)
            )
            Text(text = stringResource(R.string.daniel_ariel_tovar_canturin), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = stringResource(R.string.contactos), fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(32.dp)) // Espacio fijo en lugar de weight

        // Parte inferior: información de contacto
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            filaContactos(iconId = R.drawable.email_icono, text = stringResource(R.string._51_987_763_803))
            filaContactos(iconId = R.drawable.email_icono, text = stringResource(R.string.universitario))
            filaContactos(iconId = R.drawable.email_icono, text = stringResource(R.string.daniel_tovar_unmsm_edu_pe))
        }
    }
}

@Composable
fun filaContactos(iconId: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ProyectoPracticaPreview() {
    ProyectoPracticaTheme {
        presentacion()
    }
}
