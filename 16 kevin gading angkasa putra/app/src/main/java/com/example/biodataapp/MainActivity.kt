package com.example.biodataapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BiodataForm()
        }
    }
}

@Composable
fun BiodataForm() {
    // State untuk input
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var agama by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama Lengkap") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = tglLahir,
            onValueChange = { tglLahir = it },
            label = { Text("Tanggal Lahir") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Jenis Kelamin") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = agama,
            onValueChange = { agama = it },
            label = { Text("Agama") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                // Pindah ke ResultActivity
                val intent = Intent(context, ResultActivity::class.java).apply {
                    putExtra("nama", nama)
                    putExtra("alamat", alamat)
                    putExtra("tgl", tglLahir)
                    putExtra("gender", gender)
                    putExtra("agama", agama)
                }
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Simpan & Lihat Hasil")
        }
    }
}
