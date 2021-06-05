package com.mrizkimn.utspraktik_if1_10118012_mochrizkimaulanan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Cek_Kembali_Main extends AppCompatActivity {

    TextView tvNik, tvNama, tvTanggal, tvJk, tvHubungan ;
    Button btnUbah, btnSimpan;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_kembali_main);

        Intent intent = getIntent();
        String nik = intent.getStringExtra("dataNik");
        String nama = intent.getStringExtra("dataNama");
        String tanggal = intent.getStringExtra("dataTanggal");
        String jk = intent.getStringExtra("dataJk");
        String hubungan = intent.getStringExtra("dataHubungan");

        tvNik = findViewById(R.id.tv_ckd_nik);
        tvNik.setText(nik);
        tvNama = findViewById(R.id.tv_ckd_nama);
        tvNama.setText(nama);
        tvTanggal = findViewById(R.id.tv_ckd_tanggal);
        tvTanggal.setText(tanggal);
        tvJk = findViewById(R.id.tv_ckd_jk);
        tvJk.setText(jk);
        tvHubungan = findViewById(R.id.tv_ckd_hubungan);
        tvHubungan.setText(hubungan);

    }

}