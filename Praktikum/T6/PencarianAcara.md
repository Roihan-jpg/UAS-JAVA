import java.time.LocalDate;
// Import untuk menangani tanggal dalam format modern Java 8+

import java.time.format.DateTimeFormatter;
// Import untuk memformat tanggal dalam tampilan yang user-friendly

import java.util.Scanner;
// Import untuk membaca input dari user

class Acara {
    // Deklarasi class Acara untuk merepresentasikan data acara
    LocalDate tanggal;
    // Field untuk menyimpan tanggal acara menggunakan LocalDate
    
    String nama;
    // Field untuk menyimpan nama acara
    
    String lokasi;
    // Field untuk menyimpan lokasi acara
    
    String deskripsi;
    // Field untuk menyimpan deskripsi acara

    public Acara(LocalDate tanggal, String nama, String lokasi, String deskripsi) {
        // Constructor untuk membuat objek Acara dengan parameter yang diperlukan
        this.tanggal = tanggal;
        // Assign parameter tanggal ke field tanggal
        
        this.nama = nama;
        // Assign parameter nama ke field nama
        
        this.lokasi = lokasi;
        // Assign parameter lokasi ke field lokasi
        
        this.deskripsi = deskripsi;
        // Assign parameter deskripsi ke field deskripsi
    }

    @Override
    public String toString() {
        // Override method toString untuk memberikan representasi string dari objek Acara
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        // Membuat formatter untuk menampilkan tanggal dalam format "hari bulan tahun"
        
        return String.format("Tanggal: %s\nNama Acara: %s\nLokasi: %s\nDeskripsi: %s",
                            tanggal.format(formatter), nama, lokasi, deskripsi);
        // Mengembalikan string yang berisi informasi lengkap acara dengan format yang rapi
    }
}

public class PencarianAcara {
    // Deklarasi class utama PencarianAcara
    
    public static void main(String[] args) {
        // Method main sebagai entry point program
        
        // Data acara yang sudah diurutkan berdasarkan tanggal
        Acara[] jadwalAcara = {
            // Array berisi data acara yang sudah diurutkan berdasarkan tanggal (ascending)
            new Acara(LocalDate.of(2025, 5, 10), "Workshop Java", "Ruang Pelatihan A", "Workshop dasar pemrograman Java"),
            // Membuat objek Acara dengan tanggal 10 Mei 2025
            
            new Acara(LocalDate.of(2025, 5, 15), "Seminar AI", "Aula Utama", "Seminar tentang perkembangan Artificial Intelligence"),
            // Membuat objek Acara dengan tanggal 15 Mei 2025
            
            new Acara(LocalDate.of(2025, 5, 20), "Kompetisi Coding", "Lab Komputer", "Kompetisi coding untuk mahasiswa"),
            // Membuat objek Acara dengan tanggal 20 Mei 2025
            
            new Acara(LocalDate.of(2025, 5, 25), "Tech Talk", "Auditorium", "Diskusi tentang teknologi terbaru"),
            // Membuat objek Acara dengan tanggal 25 Mei 2025
            
            new Acara(LocalDate.of(2025, 6, 1), "Career Fair", "Gedung Serbaguna", "Pameran karir bidang IT"),
            // Membuat objek Acara dengan tanggal 1 Juni 2025
            
            new Acara(LocalDate.of(2025, 6, 5), "Webinar Cloud Computing", "Online", "Webinar tentang teknologi cloud"),
            // Membuat objek Acara dengan tanggal 5 Juni 2025
            
            new Acara(LocalDate.of(2025, 6, 10), "Hackathon", "Co-Working Space", "Hackathon 24 jam"),
            // Membuat objek Acara dengan tanggal 10 Juni 2025
            
            new Acara(LocalDate.of(2025, 6, 15), "Workshop Database", "Ruang Pelatihan B", "Workshop database SQL dan NoSQL"),
            // Membuat objek Acara dengan tanggal 15 Juni 2025
            
            new Acara(LocalDate.of(2025, 6, 20), "Game Development Talk", "Ruang Multimedia", "Diskusi tentang pengembangan game")
            // Membuat objek Acara dengan tanggal 20 Juni 2025
        };

        Scanner scanner = new Scanner(System.in);
        // Membuat objek Scanner untuk membaca input dari user

        System.out.println("=== SISTEM PENCARIAN ACARA ===");
        // Menampilkan header sistem
        
        System.out.println("Format tanggal: yyyy-MM-dd (contoh: 2025-05-20)");
        // Memberikan instruksi format tanggal kepada user
        
        System.out.print("Masukkan tanggal yang ingin dicari: ");
        // Meminta input tanggal dari user
        
        String tanggalInput = scanner.nextLine();
        // Membaca input tanggal sebagai string

        try {
            // Memulai blok try-catch untuk menangani exception parsing tanggal
            
            // Parse input tanggal
            LocalDate tanggalCari = LocalDate.parse(tanggalInput);
            // Mengconvert string input menjadi objek LocalDate

            // Lakukan pencarian binary search
            int index = cariAcaraByTanggal(jadwalAcara, tanggalCari);
            // Memanggil method binary search untuk mencari acara berdasarkan tanggal

            System.out.println("\nHASIL PENCARIAN:");
            // Menampilkan header hasil pencarian
            
            if (index != -1) {
                // Jika acara ditemukan (index bukan -1)
                System.out.println("Acara ditemukan pada tanggal " + tanggalInput + "!");
                // Menampilkan pesan bahwa acara ditemukan
                
                System.out.println(jadwalAcara[index]);
                // Menampilkan detail acara yang ditemukan
            } else {
                // Jika acara tidak ditemukan
                System.out.println("Tidak ada acara yang terjadwal pada tanggal " + tanggalInput + ".");
                // Menampilkan pesan bahwa acara tidak ditemukan
            }
        } catch (Exception e) {
            // Menangkap exception jika format tanggal tidak valid
            System.out.println("Format tanggal tidak valid. Gunakan format yyyy-MM-dd.");
            // Menampilkan pesan error format tanggal
        }

        scanner.close();
        // Menutup scanner untuk mencegah memory leak
    }

    public static int cariAcaraByTanggal(Acara[] jadwalAcara, LocalDate tanggal) {
        // Method untuk melakukan binary search berdasarkan tanggal
        
        int low = 0;
        // Inisialisasi pointer bawah pada index 0
        
        int high = jadwalAcara.length - 1;
        // Inisialisasi pointer atas pada index terakhir array

        while (low <= high) {
            // Loop selama pointer bawah masih kurang dari atau sama dengan pointer atas
            
            int mid = low + (high - low) / 2;
            // Menghitung index tengah dengan cara yang aman dari integer overflow

            // Bandingkan tanggal
            if (jadwalAcara[mid].tanggal.isEqual(tanggal)) {
                // Jika tanggal di index tengah sama dengan tanggal yang dicari
                return mid;
                // Kembalikan index tempat acara ditemukan
            }

            // Jika tanggal yang dicari lebih awal, cari di setengah kiri
            if (jadwalAcara[mid].tanggal.isAfter(tanggal)) {
                // Jika tanggal di index tengah lebih besar dari tanggal yang dicari
                high = mid - 1;
                // Pindahkan pointer atas ke kiri dari tengah
            }
            // Jika tanggal yang dicari lebih akhir, cari di setengah kanan
            else {
                // Jika tanggal di index tengah lebih kecil dari tanggal yang dicari
                low = mid + 1;
                // Pindahkan pointer bawah ke kanan dari tengah
            }
        }

        // Jika acara tidak ditemukan
        return -1;
        // Kembalikan -1 sebagai indikator bahwa acara tidak ditemukan
    }
}