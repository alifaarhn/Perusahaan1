class Perusahaan {
    private final String namaPerusahaan;

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
}

class Karyawan {
    private String nama;
    private double gajiPokok;
    private Perusahaan perusahaan;

    public Karyawan(String nama, double gajiPokok, Perusahaan perusahaan) {
        setNama(nama);
        this.gajiPokok = gajiPokok;
        this.perusahaan = perusahaan;
    }

    public void setNama(String nama) {
        if (nama.length() < 4) {
            System.out.println("Nama harus minimal 4 karakter!");
        } else {
            this.nama = nama;
        }
    }

    public String getNama() {
        return nama;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public Perusahaan getPerusahaan() {
        return perusahaan;
    }

    // Metode untuk menghitung gaji (akan di-override di subclass)
    public double hitungGaji() {
        return gajiPokok; // Default, hanya gaji pokok
    }

    public void infoGaji() {
        System.out.println("Nama Karyawan  : " + nama);
        System.out.println("Total Gaji     : Rp" + hitungGaji());
        System.out.println("Perusahaan     : " + perusahaan.getNamaPerusahaan());
        System.out.println("--------------------------");
    }
}

class Programmer extends Karyawan {
    private double bonus;

    public Programmer(String nama, double gajiPokok, double bonus, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.bonus = bonus;
    }

    // Override metode hitungGaji untuk menambahkan bonus
    @Override
    public double hitungGaji() {
        return getGajiPokok() + bonus;
    }
}

// Subclass Manager yang memiliki tambahan insentif
class Manager extends Karyawan {
    private double insentif;

    public Manager(String nama, double gajiPokok, double insentif, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.insentif = insentif;
    }

    // Override metode hitungGaji untuk menambahkan insentif
    @Override
    public double hitungGaji() {
        return getGajiPokok() + insentif;
    }
}

public class Tahap2 {
    public static void main(String[] args) {
        // Membuat objek Perusahaan
        Perusahaan ptAlifahSukses = new Perusahaan("PT. Alifah Sukses");

        // Membuat objek Karyawan, Programmer, dan Manager
        Karyawan karyawan1 = new Karyawan("Andi", 5000000, ptAlifahSukses);
        Programmer programmer1 = new Programmer("Budi", 6000000, 1000000, ptAlifahSukses);
        Manager manager1 = new Manager("Ana", 8000000, 2000000, ptAlifahSukses);

        // Menampilkan informasi dan perhitungan gaji
        karyawan1.infoGaji();
        programmer1.infoGaji();
        manager1.infoGaji();
    }
}
