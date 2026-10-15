P03-Komponen GUI dengan Swing dan FlatLaf



Nama: Nabila Adhelia

NPM: 2410010105

Kelas: 5C Teknik Informatika





JAWABAN PERTANYAAN REFLEKSI

Pertemuan 3: Komponen GUI dengan Swing dan FlatLaf



1\. Perbedaan top-level container, intermediate container, dan atomic component.

Top-level container adalah jendela utama yang memiliki bingkai dan judul, contohnya JFrame. Intermediate container adalah wadah untuk mengelompokkan komponen, contohnya JPanel. Atomic component adalah komponen yang berinteraksi langsung dengan pengguna, contohnya JButton.



2\. Mengapa kedua JRadioButton perlu properti buttonGroup yang sama?

ButtonGroup membuat radio button dalam satu grup saling eksklusif, sehingga hanya satu yang bisa terpilih. Tanpa grup yang sama, setiap radio button berdiri sendiri dan keduanya bisa terpilih bersamaan. Hal ini terbukti saat eksperimen, baris jenisKelaminGroup.add(perempuanRadio); hilang dari initComponents() dan kedua pilihan bisa aktif sekaligus.



3\. Kapan memilih JComboBox dibandingkan JRadioButton?

JComboBox dipilih saat pilihannya banyak, misalnya daftar kota tujuan, karena daftarnya ringkas dan tidak memenuhi form. JRadioButton dipilih saat pilihannya sedikit dan sebaiknya langsung terlihat semua, misalnya jenis kelamin atau kelas tiket.



4\. Mengapa kode di initComponents() tidak boleh diedit langsung, dan di mana kode tambahan ditulis?

Isi initComponents() dibuat dan diperbarui otomatis oleh NetBeans berdasarkan rancangan di tab Design (file .form). Perubahan manual akan hilang atau menimbulkan konflik saat NetBeans membuat ulang kodenya. Kode tambahan ditulis di luar blok abu-abu, yaitu di konstruktor setelah initComponents(), di dalam event handler, di method bantu, dan di method main.



5\. Mengapa FlatLightLaf.setup() harus dipanggil sebelum form dibuat?

Tampilan (look and feel) dipasang pada komponen saat komponen itu dibuat. Jika setup() dipanggil setelah form dibuat, komponen sudah memakai tampilan bawaan (Metal) dan tidak otomatis berubah, kecuali dipaksa lewat FlatLaf.updateUI(). Karena itu setup() dipanggil lebih dulu di method main, sebelum new FormTiketTravel().




## Dokumentasi Screenshot

### 1. Rancangan Form di NetBeans Design

![Rancangan Form](./Screenshot%20(373).png)

### 2. Hasil Program - Light Mode

![Hasil Program Light Mode](./Screenshot%20(374).png)

### 3. Hasil Program - Dark Mode

![Hasil Program Dark Mode](./Screenshot%20(375).png)












