# Praktikum PBO 2 - Pertemuan 7

- Nama: Nabila Adhelia
- NPM: 2410010105
- Kelas: 5C Teknik Informatika
- Mata Kuliah: Pemrograman Berbasis Objek 2 (TIF1508)
- Proyek: p07-tabel-dan-menu (Aplikasi Daftar Kontak)

## Jawaban Eksperimen Praktikum 5

### Eksperimen 1

Tabel tidak langsung berubah setelah `fireTableRowsInserted` dijadikan komentar. Baris baru baru muncul setelah jendela diubah ukurannya, karena JTable tidak diberi tahu bahwa data di model bertambah.

### Eksperimen 2

Setelah `barisTerpilih()` diganti menjadi `return kontakTable.getSelectedRow();`, saya mencari "ah", memilih Ahmad Fauzi, lalu klik Hapus. Dialog konfirmasi menampilkan nama Budi Santoso. Ini karena tabel sedang disaring, sehingga nomor baris tampilan berbeda dengan nomor baris model. Ahmad Fauzi ada di baris tampilan 1 tetapi baris model 2, sedangkan baris model 1 adalah Budi Santoso. Karena itu harus memakai `convertRowIndexToModel`.

### Eksperimen 3

Setelah `super(pemilik, judul, true)` diubah menjadi `false`, jendela utama tetap bisa diklik saat dialog terbuka, dan kontak yang diisi tidak masuk ke tabel. Dialog tidak lagi modal, sehingga `setVisible(true)` tidak menunggu dialog ditutup dan `tampilkan()` langsung mengembalikan `hasil` yang masih `null`.
