package com.example.biodata

import android.app.AlertDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etAlamat = findViewById<EditText>(R.id.etAlamat)
        val etTanggal = findViewById<EditText>(R.id.etTanggal)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val spinnerAgama = findViewById<Spinner>(R.id.spinnerAgama)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        ArrayAdapter.createFromResource(this, R.array.agama_array, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerAgama.adapter = adapter
        }

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val alamat = etAlamat.text.toString()
            val tanggal = etTanggal.text.toString()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val agama = spinnerAgama.selectedItem.toString()

            if (nama.isEmpty() || alamat.isEmpty() || tanggal.isEmpty() || selectedGenderId == -1) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()
            val biodata = "Nama: $nama\nAlamat: $alamat\nTanggal Lahir: $tanggal\nJenis Kelamin: $gender\nAgama: $agama"

            AlertDialog.Builder(this)
                .setTitle("Biodata")
                .setMessage(biodata)
                .setPositiveButton("OK", null)
                .show()
        }
    }
}