package com.example.multipleactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.DatePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class halaman1 extends AppCompatActivity {

    CheckBox cb_bakso, cb_nasi, cb_mi;
    EditText edt_keyword;
    ToggleButton tb_makan;
    Switch s_jomblo;
    Spinner sp_ngoding;
    TimePicker tp;
    DatePicker dp;
    Button my_button;
    TextView tv_jawaban;
    StringBuilder pilihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman1);  // Jangan lupa panggil setContentView untuk menghubungkan layout

        // Inisialisasi UI elements
        cb_bakso = findViewById(R.id.cb_bakso);
        cb_mi = findViewById(R.id.cb_mi);
        cb_nasi = findViewById(R.id.cb_nasi);
        edt_keyword = findViewById(R.id.edt_keyword);
        tb_makan = findViewById(R.id.tb_makan);
        s_jomblo = findViewById(R.id.s_jomblo);
        sp_ngoding = findViewById(R.id.sp_ngoding);
        tp = findViewById(R.id.tp);
        dp = findViewById(R.id.dp);
        my_button = findViewById(R.id.my_button);
        tv_jawaban = findViewById(R.id.tv_jawaban);

        // Mengonfigurasi Spinner dengan data
        String[] ngodingOptions = {"Pilih opsi", "Java", "Kotlin", "Python", "JavaScript"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ngodingOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_ngoding.setAdapter(adapter);

        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Debugging log
                    Log.d("Halaman1", "Button Pressed");

                    // Membuat StringBuilder untuk menampung semua hasil inputan
                    pilihan = new StringBuilder();

                    // Mengecek nilai dari CheckBox
                    if (cb_bakso.isChecked()) {
                        pilihan.append("Bakso\n");
                    }
                    if (cb_mi.isChecked()) {
                        pilihan.append("Mie Ayam\n");
                    }
                    if (cb_nasi.isChecked()) {
                        pilihan.append("Nasi Goreng\n");
                    }

                    // Mengambil nilai dari EditText
                    String keyword = edt_keyword.getText().toString();
                    if (!keyword.isEmpty()) {
                        pilihan.append("Keyword: ").append(keyword).append("\n");
                    }

                    // Mengecek nilai dari ToggleButton
                    boolean isMakanChecked = tb_makan.isChecked();
                    pilihan.append("Makan: ").append(isMakanChecked ? "Sudah" : "Belum").append("\n");

                    // Mengecek nilai dari Switch
                    boolean isJombloChecked = s_jomblo.isChecked();
                    pilihan.append("Jomblo: ").append(isJombloChecked ? "wkwkw iya" : "alhamdulillah tidak").append("\n");

                    // Mengambil nilai dari Spinner dengan pengecekan null
                    String ngodingChoice = "Pilih opsi"; // Default value jika tidak ada pilihan
                    if (sp_ngoding.getSelectedItem() != null) {
                        ngodingChoice = sp_ngoding.getSelectedItem().toString();
                    }
                    pilihan.append("doyan Ngoding: ").append(ngodingChoice).append("\n");

                    // Mengambil nilai dari TimePicker
                    int hour = tp.getHour();
                    int minute = tp.getMinute();
                    pilihan.append("Pilihan Jam : ").append(hour).append(":").append(minute).append("\n");

                    // Mengambil nilai dari DatePicker
                    int day = dp.getDayOfMonth();
                    int month = dp.getMonth() + 1; // Month is 0-based, so add 1
                    int year = dp.getYear();
                    pilihan.append("Pilihan Tanggal: ").append(day).append("/").append(month).append("/").append(year).append("\n");

                    // Menampilkan hasil di TextView
                    tv_jawaban.setText(pilihan.toString());

                } catch (Exception e) {
                    Log.e("Halaman1", "Error occurred", e);
                    Toast.makeText(halaman1.this, "Terjadi kesalahan!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
