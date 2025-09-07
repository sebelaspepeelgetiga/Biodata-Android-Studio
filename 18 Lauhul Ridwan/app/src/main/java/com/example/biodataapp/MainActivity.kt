package com.example.biodataapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.biodataapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupDatePicker()
        setupButton()
    }

    private fun setupSpinner() {
        val agamaList = listOf(
            "Pilih Agama",
            "Islam",
            "Kristen",
            "Katolik",
            "Hindu",
            "Buddha",
            "Konghucu"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, agamaList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spAgama.adapter = adapter
    }

    private fun setupDatePicker() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }

        binding.etTanggalLahir.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
        binding.etTanggalLahir.setText(sdf.format(calendar.time))
    }

    private fun setupButton() {
        binding.btnSimpan.setOnClickListener {
            if (validateForm()) {
                showBiodataDialog()
            }
        }
    }

    private fun validateForm(): Boolean {
        // Validasi Nama
        if (binding.etNama.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Nama lengkap harus diisi", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validasi Alamat
        if (binding.etAlamat.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Alamat harus diisi", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validasi Tanggal Lahir
        if (binding.etTanggalLahir.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Tanggal lahir harus diisi", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validasi Jenis Kelamin
        if (binding.rgJenisKelamin.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Jenis kelamin harus dipilih", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validasi Agama
        if (binding.spAgama.selectedItemPosition == 0) {
            Toast.makeText(this, "Agama harus dipilih", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun showBiodataDialog() {
        val nama = binding.etNama.text.toString()
        val alamat = binding.etAlamat.text.toString()
        val tanggalLahir = binding.etTanggalLahir.text.toString()

        val selectedRadioButtonId = binding.rgJenisKelamin.checkedRadioButtonId
        val jenisKelamin = findViewById<RadioButton>(selectedRadioButtonId).text.toString()

        val agama = binding.spAgama.selectedItem.toString()

        val message = """
            Nama: $nama
            Alamat: $alamat
            Tanggal Lahir: $tanggalLahir
            Jenis Kelamin: $jenisKelamin
            Agama: $agama
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Biodata Anda")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}