import java.util.Scanner;

/*
     Robot yang akan bertarung. Robot punya senjata, perisai dan skor kesehatan.
 */
public class Robot {
    Senjata oSenjata;
    Perisai oPerisai;

    Senjata inventSenjata[] = new Senjata[5];
    Perisai inventPerisai[] = new Perisai[5];
    Senjata tampungSenjata = new Senjata();
    Perisai tampungPerisai = new Perisai();
    Scanner input = new Scanner(System.in);
    int kesehatan,i=0,j=0,c,choice;
    int count =1;
    String nama = "";


    //isi senjata milik robot


    public void tambahSenjatakeInve(Senjata s){ // menambahkan senjata ke inventori
        inventSenjata[i] =s;
        i++;
    }
    public void tambahPerisaikeInve(Perisai p){ // menambahkan perisai ke inventori
        inventPerisai[j] =p;
        j++;
    }

    public void  tambahSenjata(Senjata s) {
        oSenjata = s;
    }

    public void tambahPerisai(Perisai p){
        oPerisai = p;
    }

    public void printSenjata(){
        System.out.println("Pilih Senjata");
        System.out.println("Nama-Kekuatan");
        count =1;
        for(c=0;c<i;c++){
            tampungSenjata = inventSenjata[c];
            System.out.println(count+tampungSenjata.nama+"-"+tampungSenjata.kekuatan);
            count++;
        }
        System.out.println("Pilih Senjata: ");
        choice = input.nextInt();
        oSenjata = inventSenjata[choice-1];
    }

    public void printPerisai(){
        System.out.println("Pilih Perisai");
        System.out.println("Nama-Kekuatan");
        count =1;
        for(c=0;c<j;c++){
            tampungPerisai = inventPerisai[c];
            System.out.println(count+tampungPerisai.nama+"-"+tampungPerisai.kekuatan);
            count++;
        }
        System.out.println("Pilih Perisai: ");
        choice = input.nextInt();
        oPerisai = inventPerisai[choice-1];
    }

    //print kesehatan dsb
    public void printStatistik() {
        System.out.println("Nama Robot: "+nama);
        System.out.println("Kesehatan:"+kesehatan);


        /*for(c=0;c<i;c++){
            tampungSenjata = inventSenjata[c];
            System.out.println(tampungSenjata.nama);
            System.out.println(tampungSenjata.kekuatan);
        } */

    //komen diatas menampilkan senjata yang ada di inventori
    }

    //constructor
    public Robot(String vNama) {
        nama = vNama;
        kesehatan = 100; //default
    }

    /* menyerang robot lain, skor kesehatan robot lain akan berkurang
    */
    public void serang(Robot rLawan) {
       //skor kesehatan robot lawan akan dikurangi
       rLawan.kesehatan =  rLawan.kesehatan - (oSenjata.kekuatan - rLawan.oPerisai.kekuatan);
       if (rLawan.kesehatan <= 0){
           rLawan.kesehatan = 0;
       }
    }
}
