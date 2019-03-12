import java.util.Scanner;

public class ArenaInteraktif {
    private Robot robot1;
    private Robot robot2;
    int done=1;
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    public void tambahRobot(Robot r1,Robot r2) {
        robot1 = r1;
        robot2 = r2;
    }

    public void bertanding() {
        //UI sederhana untuk pertandingan

        //loop sampai salah satu robot habis skor kesehatannya
        boolean isSelesai = false;

        //LENGKAPI dengan NIM dan NAMA
        System.out.println("Saya berjanji tdk berbuat curang dan/atau membantu orang lain berbuat curang");
        System.out.println(" Quiz 1 27 Feb ");
        System.out.println(" NIM: 1608254");
        System.out.println(" Nama: Rivaldo");
        System.out.println("========================");

        Robot robotAktif = robot1;
        Robot robotPasif = robot2;
        while (done != 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(robot1.nama);
            System.out.println("Senjata:"+ robot1.oSenjata.nama);
            System.out.println("Perisai:"+ robot1.oPerisai.nama);

            System.out.println("========================");
            System.out.println(robot2.nama);
            System.out.println("Senjata:"+ robot2.oSenjata.nama);
            System.out.println("Perisai:"+ robot2.oPerisai.nama);
            System.out.println("========================");
            System.out.println("1. Battle ||2. Set Equip ||3. Exit");
            System.out.println("Pilih Aksi: ");

            switch(input.nextInt()){
                case 1: //Pertandingan mulai
                    System.out.print("Pertandingan dimulai =====\n");
                    //player
                    while (!isSelesai) {
                        System.out.println("");
                        System.out.println("Giliran robot:"+robotAktif.nama);
                        System.out.println("Robot menyerang dengan senjata" + robotAktif.oSenjata.nama);
                        robotAktif.serang(robotPasif);
                        //print kesehatan
                        robot1.printStatistik();
                        robot2.printStatistik();
                        //tukar peran
                        Robot temp = robotAktif; //supaya tdk tertimpa
                        robotAktif = robotPasif;
                        robotPasif = temp;

                        //stop jika salah satu robot skor kesehatanya nol
                        isSelesai = (robotAktif.kesehatan<=0 || robotPasif.kesehatan<=0);
                    }
                    System.out.println("Pertandingan Selesai");
                    //cek pemenang
                    //lengkapi
                    if (robotAktif.kesehatan <=0 && robotPasif.kesehatan<=0){
                        System.out.println("Draw");
                    }else if (robotAktif.kesehatan>0){
                        System.out.println("Pemenang : "+ robotAktif.nama);
                    }else System.out.println("Pemenang : "+ robotPasif.nama);
                    break;
                case 2: //Menu ganti peralatan
                    int ex=1;

                    while (ex !=0){
                        System.out.println("==============================================");
                        System.out.println("Set equip "+robot1.nama);
                        System.out.println("---------------------------------------");

                        System.out.println("1. Senjata ||2. Perisai ||3. Exit");
                            switch(input2.nextInt()){
                                case 1:
                                    robot1.printSenjata();
                                    break;
                                case 2:
                                    robot1.printPerisai();
                                    break;
                                case 3:
                                    ex =0;
                                    break;
                                    default:
                                        System.out.println("Maaf, pilihan tidak tersedia.");
                                        break;
                            }
                        }

                    ex=1;


                    while (ex !=0){
                        System.out.println("==============================================");

                        System.out.println("Set equip "+robot2.nama);
                        System.out.println("---------------------------------------");
                        System.out.println("1. Senjata ||2. Perisai ||3. Exit");
                        System.out.println("Pilih Aksi: ");

                        switch(input2.nextInt()){
                            case 1:
                                robot2.printSenjata();
                                break;
                            case 2:
                                robot2.printPerisai();
                                break;
                            case 3:
                                ex =0;
                                break;
                            default:
                                System.out.println("Maaf, pilihan tidak tersedia.");
                                break;
                        }
                    }
                    break;
                case 3:
                   done = 0;
                    break;
                default:
                    System.out.println("Maaf, pilihan tidak tersedia.");
                    break;
            }


        }


    }



    public static void main(String [] args) {
        //buat arena
        ArenaInteraktif oArena = new ArenaInteraktif();

        //siapkan robot
        Robot robot1 = new Robot("Robot pertama");
        Robot robot2 = new Robot("Robot kedua");

        //Set default Equipment
        Senjata oSenjataPukulan1 = new SenjataKilat();
        Perisai oPerisai1 = new PerisaiKecil();
        robot1.tambahSenjata(oSenjataPukulan1);
        robot1.tambahPerisai(oPerisai1);

        Senjata oSenjataPukulan2 = new SenjataPukulan();
        Perisai oPerisai2 = new PerisaiBesar();
        robot2.tambahSenjata(oSenjataPukulan2);
        robot2.tambahPerisai(oPerisai2);


        //tambahkan senjata ke Inventori
        Senjata oSen = new SenjataPanah();
        robot1.tambahSenjatakeInve(oSenjataPukulan1);
        robot1.tambahSenjatakeInve(oSenjataPukulan2); //inisialisasiPeralatan yg dimiliki robot 1 *Bonus
        robot1.tambahSenjatakeInve(oSen);
        robot1.tambahPerisaikeInve(oPerisai1);
        robot1.tambahPerisaikeInve(oPerisai2);

        robot2.tambahSenjatakeInve(oSen);
        robot2.tambahSenjatakeInve(oSenjataPukulan2); //inisialisasi Peraltan yg dimiliki robot 2 *Bonus
        robot2.tambahPerisaikeInve(oPerisai1);
        robot2.tambahPerisaikeInve(oPerisai2);
// =====================================

        //tambahkan robot ke arena
        oArena.tambahRobot(robot1,robot2);

        //mainkan
        oArena.bertanding();

    }
}
