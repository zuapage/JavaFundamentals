package Question2;

public class ContohMetode {

    // Metode statis
    public static void cetakStatic() {
        System.out.println("Ini metode STATIC (milik class)");
    }

    // Metode non-statis
    public void cetakNonStatic() {
        System.out.println("Ini metode NON-STATIC (milik objek)");
    }

    // main() harus statis sebagai entry point
    public static void main(String[] args) {
        // Memanggil metode statis langsung
        cetakStatic();

        // Membuat objek untuk memanggil metode non-statis
        ContohMetode obj = new ContohMetode();
        obj.cetakNonStatic();
    }
}
