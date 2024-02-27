import java.util.Scanner;

class Restaurant {
    private String[] nama;
    private double[] harga;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama = new String[30];
        harga = new double[30];
        stok = new int[30];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama[id] = nama;
        this.harga[id] = harga;
        this.stok[id] = stok;
        id++;
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(nama[i] + "[" + stok[i] + "]" + "\tRp. " + harga[i]);
            }
        }
    }

    public String getNamaMakanan(int id) {
        return nama[id];
    }

    public double getHarga(int id) {
        return harga[id];
    }

    public int getStock(int id) {
        return stok[id];
    }

    public void setStock(int stok, int id) {
        this.stok[id] = stok;
    }

    public byte getId() {
        return id;
    }

    public void takeOrder(String nama_makanan, int quantity) {
        for (int i = 0; i < id; i++) {
            if (nama_makanan.equalsIgnoreCase(this.nama[i]) && this.stok[i] >= quantity) {
                this.stok[i] -= quantity;
                System.out.println("Pesanan " + nama_makanan + " sebanyak " + quantity + " diterima");
                return;
            } else if (nama_makanan.equalsIgnoreCase(this.nama[i]) && this.stok[i] < quantity) {
                System.out.println("Stok " + this.nama[i] + " tidak mencukupi");
                return;
            }
        }
        System.out.println(nama_makanan + " tidak ditemukan");
    }

    public boolean isOutOfStock(int id) {
        return stok[id] == 0;
    }

    public static void nextId() {
        id++;
    }
}

class Produk {
    private String namaProduk;
    private double harga;
    private int qty;

    public Produk(String namaProduk, double harga, int qty) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.qty = qty;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public double getHarga() {
        return harga;
    }

    public int getQty() {
        return qty;
    }
}

class Penjualan {
    private String namaProduk;
    private int quantity;
    private double hargaPerItem;

    public Penjualan(String namaProduk, int quantity, double hargaPerItem) {
        this.namaProduk = namaProduk;
        this.quantity = quantity;
        this.hargaPerItem = hargaPerItem;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getHargaTotal() {
        return hargaPerItem * quantity;
    }
}

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        Scanner scanner = new Scanner(System.in);

        // Penambahan Menu Makanan
        menu.tambahMenuMakanan("Bala-bala", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Gehu", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tahu", 1_000, 0);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Molen", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Onde-Onde", 1_000, 25);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Roti", 3_000, 10);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Spaghetti", 5_000, 5);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Chicken Steak", 10_000, 0);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Kerupuk", 5_00, 30);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Mie Ayam", 7_000, 15);
        Restaurant.nextId();

        // Tampilan Menu Makanan
        System.out.println("--------------------------------------");
        System.out.println("             MENU MAKANAN             ");
        System.out.println("--------------------------------------");
        menu.tampilMenuMakanan();
        System.out.println("______________________________________");
        System.out.println();

        // Pemesanan
        System.out.println("Silakan pilih menu makanan:");
        String pesanan = scanner.nextLine();
        System.out.println("Masukkan jumlah yang ingin dipesan:");
        int jumlah = scanner.nextInt();

        // Proses pemesanan
        menu.takeOrder(pesanan, jumlah);
        double hargaPerItem = menu.getHarga(menu.getId() - 1);

        // Tampilan Invoice
        System.out.println("--------------------------------------");
        System.out.println("                INVOICE               ");
        System.out.println("--------------------------------------");
        System.out.println("Nama Produk\tQuantity\tHarga Total");
        Penjualan penjualan = new Penjualan(pesanan, jumlah, hargaPerItem);
        System.out.println(penjualan.getNamaProduk() + "\t\t" + penjualan.getQuantity() + "\t\tRp. " + penjualan.getHargaTotal());
        System.out.println("--------------------------------------");

        // Konfirmasi untuk memesan item makanan lain
        System.out.println("Apakah Anda ingin memesan item makanan lain? (ya/tidak)");
        String konfirmasi = scanner.next();
        
        if (konfirmasi.equalsIgnoreCase("ya")) {
            // Tambahkan logika untuk memesan item makanan lain
        } else {
            System.out.println("Terima kasih atas pesanan Anda!");
        }
    }
}
