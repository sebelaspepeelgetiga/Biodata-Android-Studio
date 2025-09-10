import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNama, editTextAlamat, editTextTanggal;
    RadioGroup radioGroupGender;
    Spinner spinnerAgama;
    Button buttonSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hubungkan variabel dengan komponen di layout
        editTextNama = findViewById(R.id.editTextNama);
        editTextAlamat = findViewById(R.id.editTextAlamat);
        editTextTanggal = findViewById(R.id.editTextTanggal);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerAgama = findViewById(R.id.spinnerAgama);
        buttonSimpan = findViewById(R.id.buttonSimpan);

        // === INI BAGIAN PENTINGNYA ===
        // Buat list agama yang akan ditampilkan
        String[] agamaList = {
                "Pilih Agama",  // Ini placeholder biar user pilih dulu
                "Islam",
                "Kristen",
                "Katolik",
                "Hindu",
                "Buddha",
                "Konghucu"
        };

        // Buat adapter untuk spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,                       // Context
                android.R.layout.simple_spinner_item,  // Tampilan biasa
                agamaList                   // Data yang akan ditampilkan);

        // Atur tampilan dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Hubungkan adapter dengan spinner
        spinnerAgama.setAdapter(adapter);
        // === SAMPAI SINI ===

        // Tombol simpan diklik
        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanData();
            }
        });
    }

    private void simpanData() {
        // Ambil data dari form
        String nama = editTextNama.getText().toString();
        String alamat = editTextAlamat.getText().toString();
        String tanggal = editTextTanggal.getText().toString();

        // Ambil gender yang dipilih
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        String gender = "";
        if (selectedGenderId != -1) {
            RadioButton radioButton = findViewById(selectedGenderId);
            gender = radioButton.getText().toString();
        }

        // Ambil agama yang dipilih
        String agama = spinnerAgama.getSelectedItem().toString();

        // Cek apakah agama sudah dipilih (bukan placeholder)
        if (agama.equals("Pilih Agama")) {
            Toast.makeText(this, "Pilih agama", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tampilkan data
        String message = "Nama: " + nama +
                "\nAlamat: " + alamat +
                "\nTanggal: " + tanggal +
                "\nGender: " + gender +
                "\nAgama: " + agama;

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}