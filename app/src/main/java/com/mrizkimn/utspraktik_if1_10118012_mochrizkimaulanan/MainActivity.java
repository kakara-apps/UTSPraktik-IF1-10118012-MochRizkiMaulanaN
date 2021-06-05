package com.mrizkimn.utspraktik_if1_10118012_mochrizkimaulanan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    EditText edtTanggal;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat simpleDateFormat;

    RadioButton rbLaki, rbPerempuan, rbOrtu, rbSusi, rbAnak, rbKerabat;
    Button btnSelanjutnya;


    EditText edtNik, edtNama, edtJk, edtHubungan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Date Picker
        edtTanggal = findViewById(R.id.edt_main_tanggal);
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        edtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });


        btnSelanjutnya = findViewById(R.id.btn_main_selanjutnya);
        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });


    }

    public void sendMessage(){

        //Radio Button
        rbLaki = findViewById(R.id.rb_main_laki);
        rbPerempuan = findViewById(R.id.rb_main_perempuan);
        rbOrtu = findViewById(R.id.rb_main_ortu);
        rbSusi = findViewById(R.id.rb_main_susi);
        rbAnak = findViewById(R.id.rb_main_anak);
        rbKerabat = findViewById(R.id.rb_main_kerabatLainnya);

        Intent intent = new Intent(MainActivity.this, Cek_Kembali_Main.class );
        edtNik = findViewById(R.id.edt_main_nik);
        edtNama = findViewById(R.id.edt_main_nama);
        edtTanggal = findViewById(R.id.edt_main_tanggal);
        String jk = "";
        if (rbLaki.isChecked()){
            jk="Laki-Laki";
        }else if(rbPerempuan.isChecked()){
            jk="Perempuan";
        }

        String hubungan = "";
        if (rbOrtu.isChecked()){
            hubungan="Orangtua";
        }else if(rbSusi.isChecked()){
            hubungan="Suami/Istri";
        }else if(rbAnak.isChecked()) {
            hubungan = "Anak";
        }else if(rbKerabat.isChecked()) {
            hubungan = "Kerabat";
        }

        String nik = edtNik.getText().toString();
        String nama = edtNama.getText().toString();
        String tanggal = edtTanggal.getText().toString();
        intent.putExtra("dataNik", nik);
        intent.putExtra("dataNama", nama);
        intent.putExtra("dataTanggal", tanggal);
        intent.putExtra("dataJk", jk);
        intent.putExtra("dataHubungan", hubungan);
        startActivity(intent);
        finish();

    }

    private void showDateDialog() {

        Calendar kalender = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year,month,dayOfMonth);
                edtTanggal.setText(simpleDateFormat.format(newDate.getTime()));
            }
        },kalender.get(Calendar.YEAR), kalender.get(Calendar.MONTH), kalender.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

}