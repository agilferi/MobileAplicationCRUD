package com.example.aplikasicrud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aplikasicrud.db.DBSource;
import com.example.aplikasicrud.model.Barang;

public class UbahActivity extends AppCompatActivity {

    EditText edNama_barang, edMerk, edHarga;

    Button btnSubmit, btnDelete;

    DBSource dbSource;

    Barang barang;

    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        edNama_barang = findViewById(R.id.ed_nama_barang);
        edMerk = findViewById(R.id.ed_merk);
        edHarga = findViewById(R.id.ed_harga);

        btnSubmit = findViewById(R.id.btn_submit);
        btnDelete = findViewById(R.id.btn_delete);

        Bundle bun = this.getIntent().getExtras();
        id = bun.getLong("id");
        String harga = bun.getString("harga");
        String merk = bun.getString("merk");
        String nama_barang = bun.getString("nama_barang");

        edNama_barang.setText(nama_barang);
        edMerk.setText(merk);
        edHarga.setText(harga);

        dbSource = new DBSource(this);
        dbSource.open();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });

    }

    private void updateData() {
        Barang barang = new Barang();
        barang.setNama_barang(edNama_barang.getText().toString().trim());
        barang.setMerk(edMerk.getText().toString().trim());
        barang.setHarga(edHarga.getText().toString().trim());
        barang.setId(id);
        dbSource.updateBarang(barang);

        this.finish();

        dbSource.close();

        Intent i = new Intent(UbahActivity.this, TampilActivity.class);

        startActivity(i);

        UbahActivity.this.finish();
    }

    private void deleteData() {
        dbSource.deleteBarang(id);
        this.finish();
        dbSource.close();

        Intent i = new Intent(UbahActivity.this, TampilActivity.class);
        startActivity(i);
        UbahActivity.this.finish();

    }
}
