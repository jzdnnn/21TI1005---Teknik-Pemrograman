import java.util.Scanner;

class DVD {
    protected String judul;
    protected String publisher;
    protected int stok;

    public DVD(String judul, String publisher, int stok) {
        this.judul = judul;
        this.publisher = publisher;
        this.stok = stok;
    }

    public void tampilkanInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("Publisher: " + publisher);
        System.out.println("Stok: " + stok);
    }
}

class DVDFilm extends DVD {
    private String[] pemeran;
    private String sutradara;
    private String kategoriFilm;

    public DVDFilm(String judul, String[] pemeran, String sutradara, String publisher, String kategoriFilm, int stok) {
        super(judul, publisher, stok);
        this.pemeran = pemeran;
        this.sutradara = sutradara;
        this.kategoriFilm = kategoriFilm;
    }

    public void tampilkanInformasiKhusus() {
        tampilkanInformasi();
        System.out.println("Pemeran: " + String.join(", ", pemeran));
        System.out.println("Sutradara: " + sutradara);
        System.out.println("Kategori: " + kategoriFilm);
    }
}

class DVDMusik extends DVD {
    private String penyanyi;
    private String produser;
    private String[] topHits;
    private String kategoriMusik;

    public DVDMusik(String judul, String penyanyi, String produser, String publisher, String[] topHits, String kategoriMusik, int stok) {
        super(judul, publisher, stok);
        this.penyanyi = penyanyi;
        this.produser = produser;
        this.topHits = topHits;
        this.kategoriMusik = kategoriMusik;
    }

    public void tampilkanInformasiKhusus() {
        tampilkanInformasi();
        System.out.println("Penyanyi: " + penyanyi);
        System.out.println("Produser: " + produser);
        System.out.println("Top Hits: " + String.join(", ", topHits));
        System.out.println("Kategori: " + kategoriMusik);
    }
}

public class DVDMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input Informasi DVDFilm
        System.out.println("Masukkan informasi untuk DVDFilm");
        System.out.println("Judul : ");
        String judulFilm = scanner.nextLine();
        System.out.println("Pemeran : ");
        String[] pemeranFilm = scanner.nextLine().split(", ");
        System.out.println("Sutradara : ");
        String sutradaraFilm = scanner.nextLine();
        System.out.println("Publisher : ");
        String publisherFilm = scanner.nextLine();
        System.out.println("Kategori : ");
        String kategoriFilm = scanner.nextLine();
        System.out.println("Stok : ");
        int stokFilm = scanner.nextInt();

        DVDFilm dvdFilm = new DVDFilm(judulFilm, pemeranFilm, sutradaraFilm, publisherFilm, kategoriFilm, stokFilm);

        // Input Informasi DVDMusik
        scanner.nextLine(); // Consume the newline character
        System.out.println("Masukkan informasi untuk DVDMusik");
        System.out.println("Judul : ");
        String judulMusik = scanner.nextLine();
        System.out.println("Penyanyi : ");
        String penyanyiMusik = scanner.nextLine();
        System.out.println("Produser : ");
        String produserMusik = scanner.nextLine();
        System.out.println("Publisher : ");
        String publisherMusik = scanner.nextLine();
        System.out.println("Top Hits (comma-separated) : ");
        String[] topHitsMusik = scanner.nextLine().split(", ");
        System.out.println("Kategori : ");
        String kategoriMusik = scanner.nextLine();
        System.out.println("Stok : ");
        int stokMusik = scanner.nextInt();

        DVDMusik dvdMusik = new DVDMusik(judulMusik, penyanyiMusik, produserMusik, publisherMusik, topHitsMusik, kategoriMusik, stokMusik);

        System.out.println();
        System.out.println("INFORMASI DVD FILM");
        dvdFilm.tampilkanInformasiKhusus();

        System.out.println();
        System.out.println("INFORMASI DVD MUSIK");
        dvdMusik.tampilkanInformasiKhusus();
    }
}
