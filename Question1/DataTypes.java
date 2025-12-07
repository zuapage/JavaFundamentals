package Question1;
public class DataTypes {
    
    public static void main(String[] args) {
        
        System.out.println("=== TIPE DATA PRIMITIF ===\n");
        demonstratePrimitiveTypes();
        
        System.out.println("\n=== TIPE DATA NON-PRIMITIF ===\n");
        demonstrateNonPrimitiveTypes();
        
        System.out.println("\n=== PERBANDINGAN MEMORY ===\n");
        compareMemoryUsage();
    }
    
    public static void demonstratePrimitiveTypes() {
        // byte: 8-bit signed integer (-128 sampai 127)
        byte umur = 25;
        System.out.println("byte umur: " + umur);
        
        // short: 16-bit signed integer (-32768 sampai 32767)
        short jumlahPekerja = 150;
        System.out.println("short jumlahPekerja: " + jumlahPekerja);
        
        // int: 32-bit signed integer (paling sering digunakan)
        int populasi = 270000000;
        System.out.println("int populasi: " + populasi);
        
        // long: 64-bit signed integer (untuk angka yang sangat besar)
        long jarak = 150000000000L;
        System.out.println("long jarak: " + jarak);
        
        // float: 32-bit floating point (untuk desimal)
        float tinggi = 175.5f;
        System.out.println("float tinggi: " + tinggi);
        
        // double: 64-bit floating point (presisi lebih tinggi)
        double berat = 70.5;
        System.out.println("double berat: " + berat);
        
        // boolean: true atau false
        boolean isActive = true;
        System.out.println("boolean isActive: " + isActive);
        
        // char: single character
        char grade = 'A';
        System.out.println("char grade: " + grade);
    }
    
    public static void demonstrateNonPrimitiveTypes() {
        // String: teks/kalimat
        String nama = "Budi Santoso";
        System.out.println("String nama: " + nama);
        
        // Array: kumpulan elemen dengan tipe sama
        int[] nomorAbsen = {1, 2, 3, 4, 5};
        System.out.println("Array nomorAbsen: ");
        for (int nomor : nomorAbsen) {
            System.out.print(nomor + " ");
        }
        System.out.println();
        
        // Array 2 dimensi
        int[][] matrikNilai = {
            {85, 90, 88},
            {92, 87, 91}
        };
        System.out.println("Array 2D matrikNilai[0][1]: " + matrikNilai[0][1]);
        
        // Class: object dengan atribut dan method
        Karyawan karyawan1 = new Karyawan("Ahmad", 5000000);
        System.out.println("Object Karyawan - Nama: " + karyawan1.getNama() + 
                         ", Gaji: " + karyawan1.getGaji());
        
        // Interface implementation
        Kendaraan mobil = new Mobil("Toyota", 2020);
        System.out.println("Interface Kendaraan - " + mobil.info());
        
        // ArrayList: dynamic array
        java.util.ArrayList<String> daftarKota = new java.util.ArrayList<>();
        daftarKota.add("Jakarta");
        daftarKota.add("Surabaya");
        daftarKota.add("Medan");
        System.out.println("ArrayList daftarKota: " + daftarKota);
    }
    
    public static void compareMemoryUsage() {
        System.out.println("Tipe Data Primitif - Menyimpan nilai langsung:");
        int nilai1 = 100;
        int nilai2 = nilai1;
        nilai2 = 200;
        System.out.println("nilai1: " + nilai1 + ", nilai2: " + nilai2);
        System.out.println("Perubahan nilai2 tidak mempengaruhi nilai1\n");
        
        System.out.println("Tipe Data Non-Primitif - Menyimpan reference:");
        Karyawan karyawan2 = new Karyawan("Siti", 6000000);
        Karyawan karyawan3 = karyawan2;
        karyawan3.setNama("Sitir");
        System.out.println("karyawan2 nama: " + karyawan2.getNama());
        System.out.println("karyawan3 nama: " + karyawan3.getNama());
        System.out.println("Kedua variable menunjuk ke object yang sama");
    }
}

class Karyawan {
    private String nama;
    private int gaji;
    
    public Karyawan(String nama, int gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public int getGaji() {
        return gaji;
    }
}

interface Kendaraan {
    String info();
}

class Mobil implements Kendaraan {
    private String merek;
    private int tahun;
    
    public Mobil(String merek, int tahun) {
        this.merek = merek;
        this.tahun = tahun;
    }
    
    @Override
    public String info() {
        return "Mobil " + merek + " tahun " + tahun;
    }
}