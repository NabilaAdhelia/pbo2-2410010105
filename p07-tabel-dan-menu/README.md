\# P07 - Tabel, Menu, dan Dialog (Daftar Kontak)



Aplikasi Daftar Kontak dengan JTable, JMenuBar, dan JDialog modal.



\## Jawaban Eksperimen Praktikum 5



\### Eksperimen 1: fireTableRowsInserted dijadikan komentar

Setelah baris `fireTableRowsInserted(baris, baris);` dijadikan komentar, tabel tidak langsung berubah saat kontak baru disimpan. Baris baru baru muncul setelah jendela diubah ukurannya. Data sudah masuk ke daftar di model, tetapi JTable tidak diberi tahu sehingga tidak menggambar ulang. Jadi setiap data di model berubah, method `fire...` wajib dipanggil.



\### Eksperimen 2: barisTerpilih tanpa convertRowIndexToModel

Setelah `barisTerpilih()` diganti menjadi `return kontakTable.getSelectedRow();`, saya mencari "ah", memilih Ahmad Fauzi, lalu klik Hapus. Dialog konfirmasi menampilkan nama Budi Santoso. Ini karena tabel sedang disaring sehingga nomor baris tampilan berbeda dengan baris model: Ahmad Fauzi di baris tampilan 1 tetapi baris model 2, sedangkan baris model 1 adalah Budi Santoso.



\### Eksperimen 3: Dialog tidak modal

Setelah `super(pemilik, judul, true)` diubah menjadi `false`, jendela utama tetap bisa diklik saat dialog terbuka dan kontak yang diisi tidak masuk ke tabel. Dialog tidak lagi modal, sehingga `setVisible(true)` tidak menunggu dialog ditutup. Method `tampilkan()` langsung mengembalikan `hasil` yang masih `null`.



\### Eksperimen 4: Ctrl+E dan Ctrl+D tanpa baris terpilih

Saat tidak ada baris dipilih, Ctrl+E dan Ctrl+D tidak bekerja dan item Ubah dan Hapus di menu tampil abu-abu. Setelah baris dipilih, keduanya bekerja. Method `perbaruiTombol()` menonaktifkan `ubahItem` dan `hapusItem` saat tidak ada pilihan, dan item menu yang nonaktif tidak merespons pintasan.



\### Eksperimen 5: Accelerator hapusItem menjadi Delete

Pada baris `hapusItem.setAccelerator(...)` di `initComponents()`, `VK\_D` berubah menjadi `VK\_DELETE` dan bagian `CTRL\_DOWN\_MASK` hilang (diganti `0`). NetBeans menulis ulang kode di `initComponents()` otomatis dari pengaturan di tab Design.



\### Eksperimen 6: Atribut model dibuat setelah initComponents()

Aplikasi gagal dibuka dengan `IllegalArgumentException: Cannot set a null TableModel` pada `JTable.setModel`, dipanggil dari `initComponents()`. `initComponents()` dipanggil di awal konstruktor dan langsung memasang `model` ke tabel, padahal `model` belum dibuat (masih `null`). Karena itu atribut `model` harus dibuat saat dideklarasikan.

