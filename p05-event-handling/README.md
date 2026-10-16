# P05 Event Handling

Nama: Nabila Adhelia
NPM: 2410010105

## Tabel Pengamatan Praktikum 2

| No | Tindakan | Event yang tercatat |
|----|----------|---------------------|
| 1 | Arahkan kursor ke tombol, lalu jauhkan | MouseEvent mouseEntered (kursor masuk ke tombol), MouseEvent mouseExited (kursor keluar dari tombol) |
| 2 | Klik tombol Klik saya | MouseEvent mouseEntered, ActionEvent actionPerformed (tombol diklik), MouseEvent mouseExited |
| 3 | Centang lalu hapus centang Aktifkan fitur | ItemEvent itemStateChanged (kotak dicentang), ItemEvent itemStateChanged (centang dihapus) |
| 4 | Ganti pilihan dari Pagi menjadi Malam | ItemEvent itemStateChanged (memilih Malam), hanya 1 baris |
| 5 | Klik isian, lalu ketik kata "abc" | FocusEvent focusGained (isian mendapat fokus), KeyEvent keyTyped 3 kali (huruf a, b, c) |
| 6 | Klik tombol setelah mengetik di isian | MouseEvent mouseEntered, FocusEvent focusLost (isian kehilangan fokus), ActionEvent actionPerformed (tombol diklik), MouseEvent mouseExited |

<img src="log-pengamat-event.png" alt="Log PengamatEvent" width="700">

## Jawaban Eksperimen Praktikum 3

1. Pesan "item berubah" tercetak 2 kali setiap pilihan diganti. `itemStateChanged` dipanggil sekali untuk pilihan lama (DESELECTED) dan sekali untuk pilihan baru (SELECTED). Karena itu aksi perlu diperiksa dengan `evt.getStateChange() == ItemEvent.SELECTED` agar hanya berjalan sekali.

2. Hasil terlambat satu karakter karena `keyPressed` dipanggil saat tombol baru ditekan, sebelum karakter masuk ke isian, sehingga `getText()` masih membaca isi sebelumnya. Pada `keyReleased`, karakter sudah masuk sehingga `getText()` membaca isi terbaru.

3. Di Output muncul `java.lang.NumberFormatException: For input string: "a"` beserta stack trace, karena `Double.parseDouble` tidak bisa mengubah huruf menjadi angka dan tidak ada `catch`. Aplikasi tetap berjalan tapi pengguna tidak mendapat umpan balik. `try` dan `catch` diperlukan untuk menampilkan "Masukkan angka yang valid".

## Jawaban Eksperimen Praktikum 4

1. Pesan "kali" tercetak 2 kali setiap tombol x diklik. `kaliButton` punya dua listener: satu dari event handler GUI Builder (dipasang NetBeans di `initComponents()`) dan satu dari lambda di konstruktor. Satu tombol sebaiknya hanya memakai satu cara agar aksinya tidak berjalan dua kali.

2. Tab Design: menambah Button `modButton` (text `%`) di `operatorPanel`, mengubah Columns GridLayout `operatorPanel` dari 4 menjadi 5, dan membuat event `actionPerformed` lewat Events. Tab Source: mengisi `modButtonActionPerformed` dengan `hitung('%');`, menambah `case '%' -> a % b;` pada `switch` di `hitung`, dan memperluas pemeriksaan pembagi nol menjadi `(operator == '/' || operator == '%') && b == 0`.

3. Kursor berada di isian pertama karena method `hapus` memanggil `angka1Field.requestFocusInWindow()`, yang mengembalikan fokus keyboard ke isian pertama setelah tombol Hapus diklik.