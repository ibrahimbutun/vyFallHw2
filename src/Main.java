import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//------------------------// a ŞIKKI------------------------------------------------------
//        LinkedList<Integer> linkedList = new LinkedList<>();
//
//        try {
//            // Source.txt dosyasını okuyalım
//            BufferedReader reader = new BufferedReader(new FileReader("source.txt"));
//            String line = reader.readLine(); // Tüm değerlerin bir satırda olduğunu varsayıyoruz
//            reader.close();
//
//            // Değerleri ayıralım
//            String[] values = line.split(",");
//            for (String value : values) {
//                int intValue = Integer.parseInt(value.trim());
//                //Trim ile gereksiz boşlukları kaldırıyoruz
//                // Eğer liste de yoksa sona ekle
//                if (!linkedList.search(intValue)) {
//                    linkedList.addToEnd(intValue);
//                }
//            }
//
//            // Listeyi gösterelim
//            System.out.println("LinkedList içeriği:");
//            linkedList.display();
//
//        } catch (IOException e) {
//            System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
//        }
//    }
// --------------------@@@@ b şıkkı @@@@-----------------------------------------------------------------------------
        LinkedList<Integer> linkedList = new LinkedList<>();
        int totalMemoryAccess = 0;
        //toplam bellek erişim sayısı
        int totalSearchValues = 0;
        //search.txt toplam değer sayısı

        try {
            BufferedReader sourceReader = new BufferedReader(new FileReader("source.txt"));
            String line = sourceReader.readLine();
            sourceReader.close(); //close ile kapatmamız gerekiyor.

            // Source.txt içindeki değerleri listeye ekle
            String[] values = line.split(",");
            for (String value : values) {
                int number = Integer.parseInt(value.trim());
                if (!linkedList.search(number)) { // Eğer listede yoksa ekle
                    linkedList.addToEnd(number);
                }
            }
        } catch (IOException e) {
            System.out.println("Source.txt dosyası okunamadı: " + e.getMessage());
            return;
        }

        // Search.txt dosyasındaki değerleri arıyoruz
        // ve bellek erişimlerini hesaplıyoruz
        try {
            BufferedReader searchReader = new BufferedReader(new FileReader("search.txt"));
            String line = searchReader.readLine();
            searchReader.close();

            // Search.txt içindeki değerleri sırayla arayıp bellek erişimlerini hesaplayalım
            String[] values = line.split(",");
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                int number = Integer.parseInt(value.trim());// bu method ile sayıları ayıralım
                totalSearchValues++; // total arama sayısını arttıralım

                // LinkedList ile searchWithMemoryAccess methodu ile arama yapalım
                int memoryAccess = linkedList.searchWithMemoryAccess(number);
                totalMemoryAccess += memoryAccess;
            }

            // Toplam ve ortalama bellek erişimlerini yazdıralım
            //double averageMemoryAccess = (double) totalMemoryAccess / totalSearchValues;
            int averageMemoryAccess = totalMemoryAccess / totalSearchValues;
            System.out.println("Toplam bellek erişim sayısı: " + totalMemoryAccess);
            System.out.println("Ortalama bellek erişim sayısı: " + averageMemoryAccess);

            //toplam bellek erişimi toplam erişilen node(düğüm) olarak tanımlauabiliriz.
            //ortalama değer için ise toplam bellek erişimini aranan değerlerin toplam sayısına bölüyoruz.

        } catch (IOException e) {
            System.out.println("Search.txt dosyası okunamadı: " + e.getMessage());
        }
//---------------------@@@@ c şıkkı @@@@-----------------------------------------------------------------------------}
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        int totalMemoryAccess = 0; // Toplam bellek erişim sayısı
//        int totalSearchValues = 0; // Search.txt'deki toplam değer sayısı
//
//        // Source.txt dosyasını okuyup listeyi oluşturuyoruz
//        try {
//            BufferedReader sourceReader = new BufferedReader(new FileReader("Source.txt"));
//            String line = sourceReader.readLine();
//            sourceReader.close();
//
//            // Source.txt içindeki değerleri listeye ekle
//            String[] values = line.split(",");
//            for (String value : values) {
//                int number = Integer.parseInt(value.trim());
//                if (!linkedList.search(number)) { // Eğer listede yoksa ekle
//                    linkedList.addToEnd(number);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Source.txt dosyası okunamadı: " + e.getMessage());
//            return;
//        }
//
//        // Search.txt dosyasındaki değerleri arıyoruz ve bellek erişimlerini hesaplıyoruz
//        try {
//            BufferedReader searchReader = new BufferedReader(new FileReader("Search.txt"));
//            String line = searchReader.readLine();
//            searchReader.close();
//
//            // Search.txt içindeki değerleri sırayla arayıp bellek erişimlerini hesapla
//            String[] values = line.split(",");
//            for (String value : values) {
//                int number = Integer.parseInt(value.trim());
//                totalSearchValues++; // Toplam arama sayısını bir artır
//
//                // LinkedList.searchAndMoveToFront ile arama yap ve listeyi değiştir
//                int memoryAccess = linkedList.searchAndAddToFront(number);
//                totalMemoryAccess += memoryAccess; // Bellek erişim sayısını ekle
//            }
//
//            // Toplam ve ortalama bellek erişimlerini yazdır
//            //double averageMemoryAccess = (double) totalMemoryAccess / totalSearchValues;
//            int averageMemoryAccess = totalMemoryAccess / totalSearchValues;
//            System.out.println("Toplam bellek erişim sayısı: " + totalMemoryAccess);
//            System.out.println("Ortalama bellek erişim sayısı: " + averageMemoryAccess);
//
//        } catch (IOException e) {
//            System.out.println("Search.txt dosyası okunamadı: " + e.getMessage());
//        }
    }
}
