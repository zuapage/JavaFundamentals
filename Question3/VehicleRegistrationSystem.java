package Question3;

public class VehicleRegistrationSystem {
    
    enum VehicleType {
        MOTOR(5, "Roda Dua", "Kendaraan bermotor roda dua"),
        AUTOMOBILE(15, "Roda Empat", "Kendaraan bermotor roda empat"),
        TRUCK(25, "Komersial", "Kendaraan komersial pengangkut barang"),
        BUS(20, "Transportasi", "Kendaraan transportasi penumpang massal"),
        OTHER(0, "Lainnya", "Tipe kendaraan lainnya");
        
        final int taxRate;
        final String category;
        final String description;
        
        VehicleType(int taxRate, String category, String description) {
            this.taxRate = taxRate;
            this.category = category;
            this.description = description;
        }
    }
    
    static class VehicleInfo {
        String type;
        int taxRate;
        String category;
        String description;
        
        VehicleInfo(String type, int taxRate, String category, String description) {
            this.type = type;
            this.taxRate = taxRate;
            this.category = category;
            this.description = description;
        }
        
        void display() {
            System.out.println("Jenis: " + type);
            System.out.println("Tarif Pajak: " + taxRate + "%");
            System.out.println("Kategori: " + category);
            System.out.println("Deskripsi: " + description);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== SISTEM REGISTRASI KENDARAAN ===\n");
        
        processRegistration("motor");
        processRegistration("mobil");
        processRegistration("truk");
        processRegistration("bus");
        processRegistration("sepeda");
    }
    
    private static void processRegistration(String input) {
        System.out.println("Input: " + input);
        VehicleInfo info = getVehicleInfo(input);
        info.display();
        System.out.println();
    }
    
    private static VehicleInfo getVehicleInfo(String input) {
        String normalize = input != null ? input.toLowerCase() : "";
        
        return switch (normalize) {
            case "motor" -> new VehicleInfo(
                "Motor",
                VehicleType.MOTOR.taxRate,
                VehicleType.MOTOR.category,
                VehicleType.MOTOR.description
            );
            case "mobil" -> new VehicleInfo(
                "Mobil",
                VehicleType.AUTOMOBILE.taxRate,
                VehicleType.AUTOMOBILE.category,
                VehicleType.AUTOMOBILE.description
            );
            case "truk" -> new VehicleInfo(
                "Truk",
                VehicleType.TRUCK.taxRate,
                VehicleType.TRUCK.category,
                VehicleType.TRUCK.description
            );
            case "bus" -> new VehicleInfo(
                "Bus",
                VehicleType.BUS.taxRate,
                VehicleType.BUS.category,
                VehicleType.BUS.description
            );
            default -> new VehicleInfo(
                "Tidak Diketahui",
                VehicleType.OTHER.taxRate,
                VehicleType.OTHER.category,
                VehicleType.OTHER.description
            );
        };
    }
}