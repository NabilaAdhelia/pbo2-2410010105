/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07.mini.proyek;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BukuTableModel extends AbstractTableModel {
    // ===== BAGIAN 1: TEMPAT MENYIMPAN DATA =====

    private static final String[] KOLOM
            = // judul kolom di atas tabel
            {"Kode", "Judul", "Penulis", "Tahun Terbit", "Status"}; // ada 5 kolom, urutannya tetap
    private final List<Buku> daftar = new ArrayList<>(); // isi buku catatan: daftar Buku, awalnya kosong
// ===== BAGIAN 2: JAWABAN UNTUK 3 PERTANYAAN TABEL =====

    @Override
    public int getRowCount() { // tabel bertanya: "ada berapa baris?"
        return daftar.size(); // jawab: sebanyak jumlah buku di daftar
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Buku b = daftar.get(baris);
        return switch (kolom) {
            case 0 ->
                b.kode();
            case 1 ->
                b.judul();
            case 2 ->
                b.penulis();
            case 3 ->
                b.tahun();
            default ->
                b.status();
        };
    }
// ===== BAGIAN 3: MENGAMBIL SATU BUKU =====

    public Buku get(int baris) {
        return daftar.get(baris);
    }
// ===== BAGIAN 4: TAMBAH, UBAH, HAPUS =====
    // Pola selalu sama: (1) ubah daftar, (2) teriak ke tabel supaya gambar ulang

    public void tambah(Buku buku) {
        daftar.add(buku);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public void ubah(int baris, Buku buku) {
        daftar.set(baris, buku);
        fireTableRowsUpdated(baris, baris);
    }

    public void hapus(int baris) {
        daftar.remove(baris);
        fireTableRowsDeleted(baris, baris);
    }
// ===== BAGIAN 5: MENGHITUNG =====
    public int hitungTersedia() {   // hitung berapa buku yang tersedia
        int jumlah = 0; // penghitung mulai dari 0
        for (Buku b : daftar) {
            if (b.status() == StatusBuku.TERSEDIA) {
                jumlah++;
            }
        }
        return jumlah; //kembalikan
    }
}
