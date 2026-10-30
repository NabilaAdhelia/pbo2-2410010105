\# Praktikum PBO 2 - Pertemuan 7: Tabel, Menu, dan Mini Proyek GUI



\## Identitas



| | |

|---|---|

| Nama | Nabila Adhelia |

| NPM | 2410010105 |

| Kelas | 5C Teknik Informatika |

| Mata Kuliah | Pemrograman Berbasis Objek 2 (TIF1508) |

| Proyek | p07-tabel-dan-menu (Aplikasi Daftar Kontak) |



\## Deskripsi



Aplikasi Daftar Kontak dengan JTable (AbstractTableModel), JMenuBar, dan JDialog modal. Kontak dapat ditambah, diubah, dihapus, dicari, dan diurutkan.



\## Jawaban Eksperimen Praktikum 5



\### Eksperimen 1: fireTableRowsInserted dijadikan komentar



Setelah baris `fireTableRowsInserted(baris, baris);` dijadikan komentar, tabel tidak langsung berubah saat kontak baru disimpan. Baris baru baru muncul setelah jendela diubah ukurannya. Data sebenarnya sudah masuk ke daftar di model, tetapi JTable tidak diberi tahu sehingga tidak menggambar ulang. Jadi setiap data di model berubah, method `fire...` wajib dipanggil agar tabel ikut diperbarui.



\### Eksperimen 2: barisTerpilih tanpa convertRowIndexToModel



Setelah `barisTerpilih()` diganti menjadi `return kontakTable.getSelectedRow();`, saya mencari kata "ah", memilih Ahmad Fauzi, lalu klik Hapus. Dialog konfirmasi menampilkan nama Budi Santoso, bukan Ahmad Fauzi. Ini terjadi karena tabel sedang disaring sehingga nomor baris tampilan berbeda dengan nomor baris di model. Ahmad Fauzi ada di baris tampilan 1 tetapi baris model 2, sedangkan baris model 1 adalah Budi Santoso. Karena itu nomor baris tampilan harus diubah dengan `convertRowIndexToModel` sebelum dipakai mengambil atau menghapus data.



\### Eksperimen 3: Dialog tidak modal



Setelah `super(pemilik, judul, true)` diubah menjadi `false`, jendela utama tetap bisa diklik saat dialog terbuka, dan kontak yang diisi tidak masuk ke tabel setelah Simpan. Dialog tidak lagi modal, sehingga `setVisible(true)` tidak menunggu dialog ditutup. Method `tampilkan()` langsung mengembalikan `hasil` yang masih `null`, jadi `tambah()` tidak menambahkan apa pun. Dialog tambah dan ubah dibuat modal supaya program menunggu pengguna selesai mengisi, baru hasilnya dibaca.



\### Eksperimen 4: Ctrl+E dan Ctrl+D tanpa baris terpilih



Saat tidak ada baris yang dipilih, Ctrl+E dan Ctrl+D tidak bekerja, dan item Ubah dan Hapus di menu Kontak tampil abu-abu. Setelah satu baris dipilih, keduanya bekerja. Method `perbaruiTombol()` menonaktifkan `ubahItem` dan `hapusItem` selama tidak ada baris terpilih, dan item menu yang nonaktif tidak merespons pintasan. Dengan begitu pengguna tidak bisa mengubah atau menghapus data yang belum dipilih.



\### Eksperimen 5: Accelerator hapusItem menjadi Delete



Pada baris `hapusItem.setAccelerator(...)` di `initComponents()`, `VK\_D` berubah menjadi `VK\_DELETE` dan bagian `CTRL\_DOWN\_MASK` hilang (diganti `0`). NetBeans menulis ulang kode di `initComponents()` secara otomatis dari pengaturan di tab Design, jadi kita tidak perlu mengetik kodenya sendiri.



\### Eksperimen 6: Atribut model dibuat setelah initComponents()



Setelah atribut `model` diubah menjadi `private KontakTableModel model;` dan `model = new KontakTableModel();` dipindah ke setelah `initComponents()`, aplikasi gagal dibuka. Di Output muncul `IllegalArgumentException: Cannot set a null TableModel` pada `JTable.setModel`, dipanggil dari `initComponents()`. Ini terjadi karena `initComponents()` dipanggil di awal konstruktor dan langsung memasang `model` ke `kontakTable`, padahal `model` belum dibuat sehingga masih `null`. Karena itu atribut `model` harus sudah dibuat saat dideklarasikan, sebelum `initComponents()` berjalan.

