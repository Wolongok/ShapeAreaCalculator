package com.example.shapecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.Locale;

public class RumusPage extends AppCompatActivity {

    TextView tvNamaBangun;
    ImageView ivGambarBangun;


    EditText persegi;

    EditText lingkaran;

    ConstraintLayout segitiga;

    ConstraintLayout persegiPanjang;

    EditText kubus;

    ConstraintLayout kerucut;

    ConstraintLayout tabung;

    EditText bola;

    EditText segitigaTinggi;
    EditText segitiaAlas;

    EditText persegiPanjangTinggi;
    EditText persegiPanjangAlas;

    EditText kerucutTinggi;
    EditText kerucutJariJari;

    EditText tabungTinggi;
    EditText tabungJariJari;

    TextView hasil;
    Button btnKalkulai;

    String angka1Str;
    String angka2Str;
    String angkaStr;
    double angka1;
    double angka2;
    double angka;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumus_page);

        tvNamaBangun = findViewById(R.id.tvNamaBangun);
        ivGambarBangun = findViewById(R.id.ivGambarBangun);

        persegi = findViewById(R.id.persegi);

        lingkaran = findViewById(R.id.lingkaran);

        segitiga = findViewById(R.id.segitiga);
        segitigaTinggi = findViewById(R.id.tinggiSegitiga);
        segitiaAlas = findViewById(R.id.alasSegitiga);

        persegiPanjang = findViewById(R.id.persegiPanjang);
        persegiPanjangAlas = findViewById(R.id.panjangPeregi);
        persegiPanjangTinggi = findViewById(R.id.tinggiPersegi);





        kubus = findViewById(R.id.kubus);


        kerucut = findViewById(R.id.kerucut);
        kerucutTinggi = findViewById(R.id.tinggiKerucut);
        kerucutJariJari = findViewById(R.id.jariJariKerucut);

        tabung = findViewById(R.id.tabung);
        tabungTinggi = findViewById(R.id.tinggiTabung);
        tabungJariJari = findViewById(R.id.jariJariTabung);

        bola = findViewById(R.id.bola);


        hasil = findViewById(R.id.hasil);
        btnKalkulai = findViewById(R.id.btnKalkulasi);


        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");

        tvNamaBangun.setText(nama);


        Perhitungan rumus = new Perhitungan();


        switch (nama) {
            case "Persegi":
                Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Regular_quadrilateral.svg/250px-Regular_quadrilateral.svg.png").into(ivGambarBangun);
                persegi.setVisibility(View.VISIBLE);
                lingkaran.setVisibility(View.GONE);
                segitiga.setVisibility(View.GONE);
                persegiPanjang.setVisibility(View.GONE);

                kubus.setVisibility(View.GONE);
                kerucut.setVisibility(View.GONE);
                tabung.setVisibility(View.GONE);
                bola.setVisibility(View.GONE);


                btnKalkulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        angkaStr = persegi.getText().toString();

                        if(angkaStr.isEmpty()){
                            Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        angka = Double.parseDouble(angkaStr);
                        double result = rumus.rumusPersegi(angka);
                        String formattedResult = String.format(Locale.US, "%.2f", result);
                        hasil.setText("Hasil : " + formattedResult);

                    }
                });

                break;
            case "Lingkaran":
                Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Circle-withsegments.svg/768px-Circle-withsegments.svg.png").into(ivGambarBangun);
                persegi.setVisibility(View.GONE);
                lingkaran.setVisibility(View.VISIBLE);
                segitiga.setVisibility(View.GONE);
                persegiPanjang.setVisibility(View.GONE);

                kubus.setVisibility(View.GONE);
                kerucut.setVisibility(View.GONE);
                tabung.setVisibility(View.GONE);
                bola.setVisibility(View.GONE);

                btnKalkulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        angkaStr = lingkaran.getText().toString();

                        if(angkaStr.isEmpty()){
                            Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        angka = Double.parseDouble(angkaStr);
                        double result = rumus.rumusLingkaran(angka);
                        String formattedResult = String.format(Locale.US, "%.2f", result);
                        hasil.setText("Hasil : " + formattedResult);

                    }
                });
                break;
            case "Segitiga":
                Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/3/35/Enneagram_triangle.png").into(ivGambarBangun);
                persegi.setVisibility(View.GONE);
                lingkaran.setVisibility(View.GONE);
                segitiga.setVisibility(View.VISIBLE);
                persegiPanjang.setVisibility(View.GONE);

                kubus.setVisibility(View.GONE);
                kerucut.setVisibility(View.GONE);
                tabung.setVisibility(View.GONE);
                bola.setVisibility(View.GONE);
                btnKalkulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        angka1Str = segitiaAlas.getText().toString();
                        angka2Str = segitigaTinggi.getText().toString();

                        if(angka1Str.isEmpty() || angka2Str.isEmpty()){
                            Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        angka1 = Double.parseDouble(angka1Str);
                        angka2 = Double.parseDouble(angka2Str);

                        double result = rumus.rumusSegitiga(angka1, angka2);
                        String formattedResult = String.format(Locale.US, "%.2f", result);
                        hasil.setText("Hasil : " + formattedResult);

                    }
                });
                break;
            case "Persegi Panjang":
                Glide.with(this).load("https://drive.usercontent.google.com/u/0/uc?id=1Zv4WHbeYFF-vc2RXa7SXVtt_xOSjtUT2&export=download").into(ivGambarBangun);
                persegi.setVisibility(View.GONE);
                lingkaran.setVisibility(View.GONE);
                segitiga.setVisibility(View.GONE);
                persegiPanjang.setVisibility(View.VISIBLE);

                kubus.setVisibility(View.GONE);
                kerucut.setVisibility(View.GONE);
                tabung.setVisibility(View.GONE);
                bola.setVisibility(View.GONE);

                btnKalkulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        angka1Str = persegiPanjangAlas.getText().toString();
                        angka2Str = persegiPanjangTinggi.getText().toString();

                        if(angka1Str.isEmpty() || angka2Str.isEmpty()){
                            Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        angka1 = Double.parseDouble(angka1Str);
                        angka2 = Double.parseDouble(angka2Str);

                        double result = rumus.rumusPersegiPanjang(angka1, angka2);
                        String formattedResult = String.format(Locale.US, "%.2f", result);
                        hasil.setText("Hasil : " + formattedResult);

                    }
                });
                break;
            case "Kubus":
                Glide.with(this).load("https://drive.google.com/uc?export=download&id=10Ddz_4-ioTbq_Tcr5g_mofxa8LCZtreO").into(ivGambarBangun);
                persegi.setVisibility(View.GONE);
                lingkaran.setVisibility(View.GONE);
                segitiga.setVisibility(View.GONE);
                persegiPanjang.setVisibility(View.GONE);

                kubus.setVisibility(View.VISIBLE);
                kerucut.setVisibility(View.GONE);
                tabung.setVisibility(View.GONE);
                bola.setVisibility(View.GONE);

                btnKalkulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        angkaStr = kubus.getText().toString();

                        if(angkaStr.isEmpty()){
                            Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        angka = Double.parseDouble(angkaStr);
                        double result = rumus.rumusKubus(angka);
                        String formattedResult = String.format(Locale.US, "%.2f", result);
                        hasil.setText("Hasil : " + formattedResult);

                    }
                });
                break;
            case "Kerucut":
                Glide.with(this).load("https://cdn.pixabay.com/photo/2013/07/12/14/13/cone-148003_1280.png").into(ivGambarBangun);
                persegi.setVisibility(View.GONE);
                lingkaran.setVisibility(View.GONE);
                segitiga.setVisibility(View.GONE);
                persegiPanjang.setVisibility(View.GONE);

                kubus.setVisibility(View.GONE);
                kerucut.setVisibility(View.VISIBLE);
                tabung.setVisibility(View.GONE);
                bola.setVisibility(View.GONE);

                btnKalkulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        angka1Str = kerucutJariJari.getText().toString();
                        angka2Str = kerucutTinggi.getText().toString();

                        if(angka1Str.isEmpty() || angka2Str.isEmpty()){
                            Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        angka1 = Double.parseDouble(angka1Str);
                        angka2 = Double.parseDouble(angka2Str);

                        double result = rumus.rumusKerucut(angka1, angka2);
                        String formattedResult = String.format(Locale.US, "%.2f", result);
                        hasil.setText("Hasil : " + formattedResult);

                    }
                });
                break;
            case "Tabung":
                Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Zylinder-1-tab.svg/232px-Zylinder-1-tab.svg.png").into(ivGambarBangun);
                persegi.setVisibility(View.GONE);
                lingkaran.setVisibility(View.GONE);
                segitiga.setVisibility(View.GONE);
                persegiPanjang.setVisibility(View.GONE);

                kubus.setVisibility(View.GONE);
                kerucut.setVisibility(View.GONE);
                tabung.setVisibility(View.VISIBLE);
                bola.setVisibility(View.GONE);
                btnKalkulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        angka1Str = tabungJariJari.getText().toString();
                        angka2Str = tabungTinggi.getText().toString();

                        if(angka1Str.isEmpty() || angka2Str.isEmpty()){
                            Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        angka1 = Double.parseDouble(angka1Str);
                        angka2 = Double.parseDouble(angka2Str);

                        double result = rumus.rumusTabung(angka1, angka2);
                        String formattedResult = String.format(Locale.US, "%.2f", result);
                        hasil.setText("Hasil : " + formattedResult);

                    }
                });
                break;
            case "Bola":
                Glide.with(this).load("https://drive.google.com/uc?export=download&id=1GvJNTZC8sYJj8mkq8skQPNTdhQ_RiNkh").into(ivGambarBangun);
                persegi.setVisibility(View.GONE);
                lingkaran.setVisibility(View.GONE);
                segitiga.setVisibility(View.GONE);
                persegiPanjang.setVisibility(View.GONE);

                kubus.setVisibility(View.GONE);
                kerucut.setVisibility(View.GONE);
                tabung.setVisibility(View.GONE);
                bola.setVisibility(View.VISIBLE);
                btnKalkulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        angkaStr = bola.getText().toString();

                        if(angkaStr.isEmpty()){
                            Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        angka = Double.parseDouble(angkaStr);
                        double result = rumus.rumusBola(angka);
                        String formattedResult = String.format(Locale.US, "%.2f", result);
                        hasil.setText("Hasil : " + formattedResult);

                    }
                });
                break;

        }


    }
}