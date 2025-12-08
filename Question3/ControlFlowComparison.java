package Question3;

public class ControlFlowComparison {
    public static void main(String[] args) {
        System.out.println("=== PERBANDINGAN IF-ELSE vs SWITCH-CASE ===\n");
        
        demonstrateIfElse();
        System.out.println();
        demonstrateSwitchCase();
        System.out.println();
        analyzePerformance();
        System.out.println();
        demonstrateComplexScenario();
    }
    
    private static void demonstrateIfElse() {
        System.out.println("--- PENDEKATAN IF-ELSE ---");
        
        String[] vehicleData = {"motor", "mobil", "truk", "Motor", "MOBIL", "bus"};
        
        for (String vehicle : vehicleData) {
            String result = determineVehicleTypeIfElse(vehicle);
            System.out.println("Input: '" + vehicle + "' -> " + result);
        }
    }
    
    private static String determineVehicleTypeIfElse(String vehicle) {
        if (vehicle == null || vehicle.isEmpty()) {
            return "Input tidak valid";
        } else if (vehicle.equalsIgnoreCase("motor")) {
            return "Kendaraan roda dua dengan kapasitas 1 penumpang";
        } else if (vehicle.equalsIgnoreCase("mobil")) {
            return "Kendaraan roda empat dengan kapasitas 5 penumpang";
        } else if (vehicle.equalsIgnoreCase("truk")) {
            return "Kendaraan berat untuk pengangkutan barang";
        } else {
            return "Tipe kendaraan tidak diketahui";
        }
    }
    
    private static void demonstrateSwitchCase() {
        System.out.println("--- PENDEKATAN SWITCH-CASE ---");
        
        String[] vehicleData = {"motor", "mobil", "truk", "Motor", "MOBIL", "bus"};
        
        for (String vehicle : vehicleData) {
            String result = determineVehicleTypeSwitchCase(vehicle);
            System.out.println("Input: '" + vehicle + "' -> " + result);
        }
    }
    
    private static String determineVehicleTypeSwitchCase(String vehicle) {
        String normalize = vehicle != null ? vehicle.toLowerCase() : "";
        
        switch (normalize) {
            case "motor":
                return "Kendaraan roda dua dengan kapasitas 1 penumpang";
            case "mobil":
                return "Kendaraan roda empat dengan kapasitas 5 penumpang";
            case "truk":
                return "Kendaraan berat untuk pengangkutan barang";
            default:
                return "Tipe kendaraan tidak diketahui";
        }
    }
    
    private static void analyzePerformance() {
        System.out.println("--- PERFORMA & KARAKTERISTIK ---");
        
        System.out.println("IF-ELSE:");
        System.out.println("  Evaluasi: Sekuensial dari atas ke bawah");
        System.out.println("  Logika: Boolean kompleks (a > 5 && b < 10)");
        System.out.println("  Performa: O(n) - lebih lambat banyak kondisi");
        System.out.println("  Fleksibilitas: Tinggi, bisa range checking");
        System.out.println("  Use case: Kondisi bertingkat, range, logika kompleks");
        
        System.out.println("\nSWITCH-CASE:");
        System.out.println("  Evaluasi: Hash table/jump table pada bytecode");
        System.out.println("  Logika: Exact value matching");
        System.out.println("  Performa: O(1) - optimal banyak nilai");
        System.out.println("  Fleksibilitas: Terbatas pada tipe primitif & String");
        System.out.println("  Use case: Kategori diskrit, enumeration, fixed values");
    }
    
    private static void demonstrateComplexScenario() {
        System.out.println("--- SKENARIO KOMPLEKS: KLASIFIKASI KENDARAAN ---\n");
        
        classifyVehicle("motor", 125);
        classifyVehicle("motor", 300);
        classifyVehicle("mobil", 1500);
        classifyVehicle("mobil", 2200);
        classifyVehicle("truk", 5000);
    }
    
    private static void classifyVehicle(String type, int cc) {
        System.out.println("Kendaraan: " + type + " (" + cc + "cc)");
        
        String classification = switch (type.toLowerCase()) {
            case "motor" -> classifyMotorcycle(cc);
            case "mobil" -> classifyAutomobile(cc);
            case "truk" -> "Kendaraan Komersial Berat";
            default -> "Tidak Diketahui";
        };
        
        System.out.println("Klasifikasi: " + classification);
        System.out.println();
    }
    
    private static String classifyMotorcycle(int cc) {
        if (cc <= 125) {
            return "Motor Kecil (Underbone)";
        } else if (cc <= 250) {
            return "Motor Menengah (Sport)";
        } else if (cc <= 500) {
            return "Motor Besar (Cruiser)";
        } else {
            return "Motor Super (Performance)";
        }
    }
    
    private static String classifyAutomobile(int cc) {
        if (cc <= 1200) {
            return "Mobil Kompak (Ekonomi)";
        } else if (cc <= 1800) {
            return "Mobil Standar (Sedan)";
        } else if (cc <= 2500) {
            return "SUV (Premium)";
        } else {
            return "Kendaraan Mewah";
        }
    }
}