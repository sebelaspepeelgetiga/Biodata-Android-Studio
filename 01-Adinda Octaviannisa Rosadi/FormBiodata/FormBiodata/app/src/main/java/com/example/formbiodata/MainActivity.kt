package com.example.formbiodata

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.editTextNama)
        val etAlamat = findViewById<EditText>(R.id.editTextAlamat)
        val etTanggal = findViewById<EditText>(R.id.editTextTanggal)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val spAgama = findViewById<Spinner>(R.id.spinnerAgama)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.agama_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAgama.adapter = adapter

        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val alamat = etAlamat.text.toString()
            val tanggal = etTanggal.text.toString()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val agama = spAgama.selectedItem.toString()

            if (nama.isEmpty() || alamat.isEmpty() || tanggal.isEmpty() || selectedGenderId == -1) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                val gender = findViewById<RadioButton>(selectedGenderId).text.toString()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("nama", nama)
                intent.putExtra("alamat", alamat)
                intent.putExtra("tanggal", tanggal)
                intent.putExtra("gender", gender)
                intent.putExtra("agama", agama)
                startActivity(intent)
            }
        }
    }
}