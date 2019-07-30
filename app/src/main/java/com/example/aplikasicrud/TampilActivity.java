package com.example.aplikasicrud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aplikasicrud.db.DBSource;
import com.example.aplikasicrud.model.Barang;

import java.util.ArrayList;

public class TampilActivity extends AppCompatActivity {

    ListView listView;

    DBSource dbSource;

    ArrayList<Barang> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        listView = findViewById(R.id.listview);

        dbSource = new DBSource(this);

        dbSource.open();

        //ambil semua data barang
        values = dbSource.getAllBarang();

        ArrayAdapter<Barang> adapter = new ArrayAdapter<Barang>(this,
                android.R.layout.simple_list_item_1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Barang b = (Barang) parent.getAdapter().getItem(position);

                Barang edit = dbSource.getBarang(b.getId());

                Intent intent = new Intent(TampilActivity.this, UbahActivity.class);
                Bundle bun = new Bundle();

                bun.putLong("id", edit.getId());
                bun.putString("nama_barang", edit.getNama_barang());
                bun.putString("harga", edit.getHarga());
                bun.putString("merk", edit.getMerk());
                intent.putExtras(bun);

                startActivity(intent);

                TampilActivity.this.finish();

            }
        });

    }
}
