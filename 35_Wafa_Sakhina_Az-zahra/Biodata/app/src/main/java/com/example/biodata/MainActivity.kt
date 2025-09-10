package com.example.biodata

import android.content.Intent
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
        val rgKelamin = findViewById<RadioGroup>(R.id.rgKelamin)
        val spAgama = findViewById<Spinner>(R.id.spAgama)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        // Isi data agama ke spinner
        val agamaList = arrayOf("Islam", "Kristen", "Katolik", "Hindu", "Buddha", "Konghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, agamaList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAgama.adapter = adapter

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val alamat = etAlamat.text.toString()
            val tanggal = etTanggal.text.toString()

            val selectedId = rgKelamin.checkedRadioButtonId
            val kelamin = if (selectedId != -1) {
                findViewById<RadioButton>(selectedId).text.toString()
            } else {
                ""
            }

            val agama = spAgama.selectedItem.toString()

            // Validasi
            if (nama.isEmpty() || alamat.isEmpty() || tanggal.isEmpty() || kelamin.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            } else {
                // Kirim data ke ResultActivity
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("nama", nama)
                intent.putExtra("alamat", alamat)
                intent.putExtra("tanggal", tanggal)
                intent.putExtra("kelamin", kelamin)
                intent.putExtra("agama", agama)
                startActivity(intent)
            }
        }
    }
}
