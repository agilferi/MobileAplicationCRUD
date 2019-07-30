package com.example.aplikasicrud.model;

public class Barang {
    private long id;
    private String nama_barang;
    private String merk;
    private String harga;
    private String total;

    public Barang() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Barang " +
                "nama_barang = '" + nama_barang +
                ", merk = '" + merk +
                ", harga = '" + harga +
                ", total = '" + total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
