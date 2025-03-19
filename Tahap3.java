import java.text.NumberFormat;
import java.util.Locale;

class Util {
    public static String formatRupiah(double amount) {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return formatRupiah.format(amount);
    }
}

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
    protected String nama;
    protected double gajiPokok;
    protected Perusahaan perusahaan;

    public Karyawan(String nama, double gajiPokok, Perusahaan perusahaan) {
        this.nama = nama;
        this.gajiPokok = gajiPokok;
        this.perusahaan = perusahaan;
    }

    public double hitungGaji() {
        return gajiPokok;
    }

    public void info() {
        System.out.println("Nama: " + nama);
        System.out.println("Gaji: " + Util.formatRupiah(hitungGaji()));
        System.out.println("Perusahaan: " + perusahaan.getNamaPerusahaan());
        System.out.println("----------------------------");
    }
}

class Programmer extends Karyawan {
    private double bonus;

    public Programmer(String nama, double gajiPokok, double bonus, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.bonus = bonus;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + bonus;
    }
}

class Manager extends Karyawan {
    private double insentif;

    public Manager(String nama, double gajiPokok, double insentif, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.insentif = insentif;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + insentif;
    }
}

public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan("Tech Corp");

        Karyawan k1 = new Karyawan("Alifah", 5000000, perusahaan);
        Programmer p1 = new Programmer("Budi", 7000000, 2000000, perusahaan);
        Manager m1 = new Manager("Citra", 10000000, 3000000, perusahaan);

        k1.info();
        p1.info();
        m1.info();
    }
}
