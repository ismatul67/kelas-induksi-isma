import java.util.ArrayList;

public class KelasInduksi {
    public static void main(String[] args) {

        Toko toko = new Toko(new Jeruk());

        BuahInterface jeruk = new Jeruk();
        System.out.println(jeruk.getName());
        System.out.println(jeruk.getTotalPrice());

        toko.tambahBuah(new Apel());

        toko.lihatSemuaBuah();
    }

}


class Toko{
    protected Buah buah;
    protected ArrayList<Buah> keranjangBuah;

    public Toko(Buah buah) {
        this.buah = buah;
        this.keranjangBuah = new ArrayList<>();
        if (buah!=null){
            this.keranjangBuah.add(buah);
        }
    }

    public void tambahBuah(Buah buah){
        this.buah= buah;
        keranjangBuah.add(buah);
        System.out.println(this.buah);
    }
    public void jual(Buah buah, Integer jumlah){
        System.out.println("Kamu telah membeli " + jumlah + " " + buah.nama + " dengan harga " + (buah.price * jumlah));
    }
    public void lihatSemuaBuah(){
        System.out.println(keranjangBuah);
    }
}

class Buah{
    protected String nama;
    protected Integer price;
    protected Integer quantity;

    public Buah() {
    }

    public Buah(String nama, Integer price, Integer quantity) {
        this.nama = nama;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Buah{" +
                "nama='" + nama + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

interface BuahInterface {

    public String getName();
    public float getTotalPrice();
}

class Jeruk extends Buah implements BuahInterface {

    public Jeruk() {
        this.nama= "jeruk";
        this.price = 5000;
        this.quantity= 8;
    }

    @Override
    public String getName() {
        return this.nama;
    }

    @Override
    public float getTotalPrice() {
        return this.price * this. quantity;
    }
}

class Apel extends Buah implements BuahInterface {

    public Apel() {
        this.nama= "Apel";
        this.price = 7000;
        this.quantity= 5;
    }

    @Override
    public String getName() {
        return this.nama;
    }

    @Override
    public float getTotalPrice() {
        return (this.price/(2/100)) * this. quantity;
    }
}
