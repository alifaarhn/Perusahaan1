// Kelas Perusahaan merepresentasikan entitas perusahaan
class Perusahaan {
    // Atribut final untuk menyimpan nama perusahaan (tidak bisa diubah setelah diinisialisasi)
    private final String namaPerusahaan;

    // Konstruktor untuk menginisialisasi objek Perusahaan dengan nama tertentu
    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    // Metode getter untuk mendapatkan nama perusahaan
    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
}

// Kelas Karyawan merepresentasikan seorang karyawan dalam perusahaan
class Karyawan {
    // Atribut private untuk menjaga enkapsulasi
    private String nama;         
    private double gajiPokok;    
    private Perusahaan perusahaan; 

    // Konstruktor untuk menginisialisasi objek Karyawan dengan data yang diberikan
    public Karyawan(String nama, double gajiPokok, Perusahaan perusahaan) {
        setNama(nama); // Menggunakan metode setNama agar validasi nama diterapkan
        this.gajiPokok = gajiPokok;
        this.perusahaan = perusahaan; // Menghubungkan karyawan dengan perusahaan tertentu
    }

    // Setter untuk atribut nama dengan validasi minimal 4 karakter
    public void setNama(String nama) {
        if (nama.length() < 4) {  // Mengecek apakah panjang nama kurang dari 4 karakter
            System.out.println("Nama harus minimal 4 karakter!"); // Pesan error jika tidak valid
        } else { 
            this.nama = nama; // Jika valid, nama disimpan dalam atribut
        }
    }

    // Getter untuk mendapatkan nama karyawan
    public String getNama() {
        return nama;
    }

    // Getter untuk mendapatkan gaji pokok karyawan
    public double getGajiPokok() {
        return gajiPokok;
    }

    // Getter untuk mendapatkan perusahaan tempat karyawan bekerja
    public Perusahaan getPerusahaan() {
        return perusahaan;
    }

    // Metode untuk menampilkan informasi lengkap tentang karyawan
    public void info() {
        System.out.println("Nama Karyawan  : " + nama);  // Menampilkan nama karyawan
        System.out.println("Gaji Pokok     : Rp" + gajiPokok);  // Menampilkan gaji pokok
        System.out.println("Perusahaan     : " + perusahaan.getNamaPerusahaan()); // Menampilkan nama perusahaan
        System.out.println("--------------------------"); // Garis pemisah untuk tampilan lebih rapi
    }
}

public class Tahap1 {
    public static void main(String[] args) {
        // Membuat objek Perusahaan dengan nama "PT. Alifah Sukses"
        Perusahaan ptAlifahSukses = new Perusahaan("PT. Alifah Sukses");

        // Membuat beberapa objek Karyawan yang bekerja di PT. Alifah Sukses
        Karyawan karyawan1 = new Karyawan("Andi", 5000000, ptAlifahSukses); 
        Karyawan karyawan2 = new Karyawan("Budi", 6000000, ptAlifahSukses); 
        Karyawan karyawan3 = new Karyawan("Ana", 5500000, ptAlifahSukses); 

        // Menampilkan informasi setiap karyawan
        karyawan1.info();
        karyawan2.info();
        karyawan3.info();
    }
}
