package com.example.aplikasicrud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasicrud.db.DBSource;
import com.example.aplikasicrud.model.Barang;

public class TambahActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit, btnTotal;

    TextView edTotal;

    EditText edNamaBarang, edMerk, edHarga, edJumlah;

    DBSource dbSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        btnSubmit = findViewById(R.id.btn_submit);
        edNamaBarang = findViewById(R.id.ed_nama_barang);
        edMerk = findViewById(R.id.ed_merk);
        edHarga = findViewById(R.id.ed_harga);
        edJumlah = findViewById(R.id.ed_jumlah);
        edTotal = findViewById(R.id.ed_total);
        btnTotal = findViewById(R.id.btn_total);

        btnSubmit.setOnClickListener(this);
        btnTotal.setOnClickListener(this);

        dbSource = new DBSource(this);

        dbSource.open();

    }

    @Override
    public void onClick(View view) {
        String nama_barang = null;
        String merk = null;
        String harga = null;

        Barang barang = null;

        if (edNamaBarang.getText() != null && edMerk.getText() != null && edHarga.getText() != null && edJumlah.getText() != null) {
            nama_barang = edNamaBarang.getText().toString();
            merk = edMerk.getText().toString();
            harga = edHarga.getText().toString();
        }

        switch (view.getId()) {
            case R.id.btn_submit:
                barang = dbSource.createBarang(nama_barang, merk, harga);

                Toast.makeText(this, "masuk Barang\n" +
                        "nama : " + barang.getNama_barang() +
                        " merk : " + barang.getMerk() +
                        " harga : " + barang.getHarga(), Toast.LENGTH_LONG).show();
                finish();
                break;

            case R.id.btn_total:
                int harga1 = Integer.parseInt(edHarga.getText().toString());
                int jumlah1 = Integer.parseInt(edJumlah.getText().toString());
                int total = harga1 * jumlah1;
                edTotal.setText(total + "z");
                break;
        }

    }

    @Override
    protected void onStop() {
        dbSource.close();
        super.onStop();

    }


}
