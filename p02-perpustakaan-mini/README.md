P02 – Perpustakaan Mini



Jawaban Praktikum



1\. Compilation Error pada Kelas Abstrak



Terjadi compilation error karena Koleksi merupakan abstract class, sehingga tidak dapat dibuat objek secara langsung menggunakan new Koleksi(...). Class abstract harus diturunkan terlebih dahulu oleh subclass yang dapat diinstansiasi.



2\. Penggunaan Anotasi @Override



Jika anotasi @Override ada, compiler memberikan error karena method hitungDenda tidak melakukan override terhadap method dari interface BisaDipinjam. Jika @Override dihapus, program tetap error karena kelas Buku masih wajib mengimplementasikan method hitungDenda(int) dari interface BisaDipinjam.



3\. Validasi Judul Kosong



Program menghasilkan IllegalArgumentException dengan pesan “Judul tidak boleh kosong” karena constructor Koleksi memeriksa judul dan menolak jika judul berupa string kosong.



4\. Pelanggaran Enkapsulasi



Aturan enkapsulasi dilanggar karena atribut status yang seharusnya bersifat private dapat diakses dan diubah langsung dari luar class Koleksi. Akibatnya, status koleksi dapat diubah sembarangan dan menyebabkan buku yang masih dipinjam dapat dipinjam kembali.





\## Dokumentasi Screenshot



\### Hasil Praktikum P02

!\[Screenshot Praktikum P02](./Screenshot%20(326).png)

