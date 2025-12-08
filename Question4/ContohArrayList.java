package Question4;

import java.util.ArrayList;

public class ContohArrayList {
    public static void main(String[] args) {
        // Membuat ArrayList
        ArrayList<String> daftarBuah = new ArrayList<>();

        // Menambahkan elemen
        daftarBuah.add("Apel");
        daftarBuah.add("Pisang");
        daftarBuah.add("Jeruk");
        System.out.println("Daftar buah awal: " + daftarBuah);

        // Menghapus elemen
        daftarBuah.remove("Pisang"); // menghapus berdasarkan nilai
        System.out.println("Daftar buah setelah dihapus Pisang: " + daftarBuah);

        // Menghapus elemen berdasarkan indeks
        daftarBuah.remove(0); // menghapus elemen pertama
        System.out.println("Daftar buah setelah menghapus indeks 0: " + daftarBuah);
    }
}
