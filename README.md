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
