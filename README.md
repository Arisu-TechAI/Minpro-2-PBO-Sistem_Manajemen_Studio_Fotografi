# Mini Project 2 PBO - Sistem Manajemen Studio Fotografi

Oleh :  

Nama    : Arizky Saputra   
NIM     : 2509116088  
Prodi   : Sistem Informasi  
Kelas   : C 2025

Program ini dibuat untuk memenuhi tugas Mini Project 2 mata kuliah Pemrograman Berbasis Objek (PBO) program studi S1 Sistem Informasi. 
Program ini mengimplementasikan konsep *Object-Oriented Programming* (OOP) menggunakan bahasa Java dan dikembangkan menggunakan aplikasi Apache NetBeans.  

# 1. Deskripsi Singkat Program  
<b>Sistem Manajemen Studio Fotografi</b> adalah aplikasi berbasis Console/Command Line Interface (CLI) berorientasi objek (Object-Oriented Programming) yang dikembangkan menggunakan bahasa pemrograman Java. 
Program ini dirancang untuk memodelkan dan mengelola proses bisnis transaksi dan reservasi jasa fotografi pada sebuah studio foto secara terstruktur.  

Pada pengembangan Mini Project 2 ini, program mengalami peningkatan arsitektur yang signifikan dari versi sebelumnya. Program kini mengadopsi pola arsitektur Model-View-Controller (MVC) dengan pembagian package yang jelas, pemisahan peran class, serta penerapan pilar OOP yang lebih kuat seperti 
<b>Inheritance, Polymorphism, Encapsulation,</b> dan penanganan validasi data secara <b>real-time</b>  

## Penyesuaian dan Penyederhanaan Scope Program Minpro-1 ke Minpro-2  
Dalam proses pembuatan dan perancangan program ini, dibuatlah beberapa penyesuaian dan penyederhanaan untuk meningkatkan efisiensi dan kebersihan kode dari rancangan awal yaitu :  
- **Pembuatan Package baru**  
  Package yang dibuat meliputi Package **main, controller, model,** dan **view**  
- **Restrukturisasi ke** **Pattern MVC**  
  Menghilangkan pemrosesan terpusat yang sebelumnya hanya berada pada satu package saja (**main**). Program yang menjalankan logika bisnis dipindahkan ke **Package Controller**, kemudian data-data entitas disimpan ke **Package Model**, sedangkan program yang menangani interaksi pengguna dipindah ke **Package View**.
- **Perbaikan penggunaan konsep INHERITANCE**  
  Memperbaiki klasifikasi jenis paket jasa Foto dari sebelumnya yang berupa atribut mentah menjadi **Super-Class** sehingga class lainnya dapat mewarisi sifat, data, dan method dari Super-Class ini.
- **Pembuatan konsep Otomatisasi ID**  
  Program disesuaikan agar tidak lagi membutuhkan input ID manual oleh pengguna ketika sistem sedang digunakan untuk melakukan pembuatan transaksi dan invoice untuk menghindari bentrokan data. Seluruh ID tersebut akan di-*generate* secara otomatis oleh sistem.  

### Latar Belakang Tujuan Pembuatan Program  
**1. Masalah Operasional Industri Studio Fotografi**
Usaha jasa studio fotografi modern terus berkembang seiring meningkatnya kebutuhan masyarakat akan dokumentasi momen penting (wisuda, *portrait*, hingga *wedding*). Namun, sebagian besar manajemen studio skala kecil hingga menengah masih mengandalkan pencatatan pesanan secara manual. Hal ini menimbulkan beberapa masalah operasional:
- **Risiko Duplikasi & Kesalahan Data:** Pencatatan manual rentan terhadap kesalahan penulisan ID pesanan, nomor telepon klien, atau jadwal sesi yang bentrok antar-pelanggan.
- **Kurangnya Transparansi Detail Paket:** Klien sering kali kesulitan membedakan spesifikasi antar-paket (misalnya beda durasi sesi untuk paket studio reguler vs jumlah kru untuk paket *event outdoor*).
- **Kesulitan Memantau Status Pembayaran:** Pihak studio sering kesulitan memisahkan transaksi mana yang masih berstatus *DP/Belum Lunas* dan mana yang sudah *Lunas*, yang berdampak pada ketidakpastian arus kas.

**Oleh karena itu**, program ini dibangun sebagai **solusi digitalisasi sistem reservasi** yang memungut data pemesanan secara otomatis, tervalidasi, dan terstruktur.  

**2. Tantangan Pengembangan Perangkat Lunak**  
Dari sisi akademis dan rekayasa perangkat lunak, pembuatan program ini menjadi sarana untuk menyelesaikan beberapa tantangan pengembangan aplikasi CLI:

- **Penerapan Arsitektur Bersih (MVC):** Mencegah penumpukan kode pada satu class utama (*spaghetti code*) dengan memisahkan *Model* (penyimpanan data), *View* (antarmuka input/output), dan *Controller* (logika bisnis).
- **Integritas Data melalui Validasi Input:** Menghindari *program crash* atau penyimpanan data yang asal-asalan saat pengguna salah memasukkan format teks, nomor telepon, atau opsi menu.
- **Kebutuhan Keamanan Data (Encapsulation):** Memastikan seluruh data sensitif milik klien dan nilai transaksi terproteksi dari akses luar yang tidak sah (*direct variable access*).
- **Skalabilitas Fitur (Inheritance & Polymorphism):** Memudahkan penambahan jenis layanan foto baru di masa depan tanpa harus merombak struktur kode yang sudah ada.

