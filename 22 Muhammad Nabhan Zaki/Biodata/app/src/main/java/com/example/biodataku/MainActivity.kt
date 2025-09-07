package com.example.biodataku

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hubungkan komponen dengan id di XML
        val etNama = findViewById<EditText>(R.id.etNama)
        val etAlamat = findViewById<EditText>(R.id.etAlamat)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)
        val spinnerAgama: Spinner = findViewById(R.id.spAgama)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)
        ArrayAdapter.createFromResource(
            this,
            R.array.agama_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerAgama.adapter = adapter
        }

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val alamat = etAlamat.text.toString()
            val tanggal = "${datePicker.dayOfMonth}/${datePicker.month + 1}/${datePicker.year}"

            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Belum dipilih"
            }

            val agama = spinnerAgama.selectedItem.toString()

            tvOutput.text = """
        Nama: $nama
        Alamat: $alamat
        Tanggal Lahir: $tanggal
        Jenis Kelamin: $gender
        Agama: $agama
    """.trimIndent()
        }
    }
}
