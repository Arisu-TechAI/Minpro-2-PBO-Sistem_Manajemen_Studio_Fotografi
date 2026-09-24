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

# 2. Penjelasan Struktur Package  
Pada pengerjaan Mini Project 2 ini, kode-kode program tidak lagi ditumpuk pada satu package atau class, melainkan dipisahkan menjadi 4 **Package** utama yang disesuaikan berdasarkan tugas dan fungsinya. Adapun Package dan Class yang dibuat adalah sebagai berikut :  
- **Package _Main_**  
  Package ini berisi sebuah class yaitu **main.java** yang berisi method *main(string[] args)*. Tugas class ini hanya menginstansiasi sebuah class lain yaitu class **Menu** dan berfungsi untuk menjalankan antarmuka aplikasi, sehingga file utama dalam program dibuat bersih dari sistem logika bisnis.
  
- **Package _model_**  
  Package ini digunakan untuk menyimpan seluruh struktur data dari entitas, model objek dunia nyata, dan aturan bisnis yang ada. Fungsinya adalah mendefinisikan atribut-atribut data yang ada di dalam class nya dan menyimpan data tersebut dengan menerapkan konsep *Encapsulation*. Adapun class-class yang terdapat pada package ini yaitu :
  - **LayananFotografi.java (Super-class)** : Class ini digunakan sebagai *Parent* dari seluruh class yang memiliki atribut terkait tipe layanan jasa fotografi.  
  -  **PaketReguler.java (Sub-class)** : Class ini berfungsi untuk menyimpan atribut spesifik terkait jenis paket jasa fotografi di *Indoor/Studio*.
  -  **Paket Event.java (Sub-class)** : Class ini digunakan untuk menyimpan atribut spesifik terkait jenis paket jasa fotografi di *Outdoor*.
  -  **Client.java** : Class yang digunakan untuk menyimpan informasi data pelanggan, seperti ID, nama, dan nomor telepon.
  -  **Transaksi.java** : Class yang berfungsi sebagai lembar kuitansi/nota pesanan utuh. Class ini menggabungkan data pelanggan dari class Client dengan paket foto dari class LayananFotografi, lalu menambahkan informasi tanggal sesi foto serta status pembayaran (Belum Lunas/Lunas).
 
- **Package _controller_**
  Package ini bertindak sebagai **Otak** dari sistem yang ada dalam program Studio Fotografi ini. Fungsinya adalah mengelola keperluan operasional program yang ada pada class dibawahnya. Package ini memiliki sebuah class yaitu :
  - **Transaksi_Controller** : Fungsi class ini adalah mengelola lemari penyimpanan berkas digital (ArrayList). Tugas-tugas tersebut meliputi :  
      - Membuatkan nomor ID otomatis  
      - Menyiapkan data sampel awal  
      - Mencari data pesanan di dalam lemari berkas, menambahkan pesanan baru, serta mengubah status pembayaran pelanggan dari belum lunas menjadi lunas  
