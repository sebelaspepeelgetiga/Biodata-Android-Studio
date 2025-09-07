package com.example.biodata_pbm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.widget.*
import android.content.Intent
import android.app.DatePickerDialog

class MainActivity : AppCompatActivity() {
    private lateinit var etNama: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etTanggalLahir: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var spAgama: Spinner
    private lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        etNama = findViewById(R.id.etNama)
        etAlamat = findViewById(R.id.etAlamat)
        etTanggalLahir = findViewById(R.id.etTanggalLahir)
        rgGender = findViewById(R.id.rgGender)
        spAgama = findViewById(R.id.spAgama)
        btnSimpan = findViewById(R.id.btnSimpan)

        //variabel buat spinner Agamanya ada apa saja
        val agamaList = arrayOf("Islam", "Kristen", "Katolik", "Hindu", "Budha", "Konghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, agamaList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAgama.adapter = adapter

        // DatePicker untuk Tanggal Lahir
        etTanggalLahir.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, y, m, d ->
                etTanggalLahir.setText("$d/${m + 1}/$y")
            }, year, month, day)

            datePicker.show()
        }
        // Tombol Simpan
        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val alamat = etAlamat.text.toString()
            val tanggal = etTanggalLahir.text.toString()
            val genderId = rgGender.checkedRadioButtonId
            val agama = spAgama.selectedItem.toString()

            if (nama.isEmpty() || alamat.isEmpty() || tanggal.isEmpty() || genderId == -1) {
                Toast.makeText(this, "Semuanya harus diisi yawh!", Toast.LENGTH_SHORT).show()
            } else {
                val gender = findViewById<RadioButton>(genderId).text.toString()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("NAMA", nama)
                intent.putExtra("ALAMAT", alamat)
                intent.putExtra("TANGGAL", tanggal)
                intent.putExtra("GENDER", gender)
                intent.putExtra("AGAMA", agama)
                startActivity(intent)
            }
        }
    }
}