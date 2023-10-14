package com.veysel;

import com.veysel.controller.AracController;
import com.veysel.controller.KiralamaController;
import com.veysel.controller.KisiController;
import com.veysel.repository.AracRepository;
import com.veysel.repository.KiralamaRepository;
import com.veysel.repository.KisiRepository;
import com.veysel.repository.entity.Arac;
import com.veysel.repository.entity.Kiralama;
import com.veysel.repository.entity.Kisi;
import com.veysel.utility.UtilityClass;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Main main = new Main();


        Kisi kisi=Kisi.builder()
                .name("A")
                .username("b")
                .password("123")
                .build();




        Arac arac=Arac.builder()
                .marka("Audi")
                .model("a6")
                .durum(true)
                .build();

        Arac arac2=Arac.builder()
                .marka("Audi")
                .model("a7")
                .durum(true)
                .build();

        Kiralama kiralama= Kiralama.builder()
                .arac(arac)
                .kisi(kisi)
                .baslangicTarihi(LocalDate.now())
                .build();

        Kiralama kiralama1= Kiralama.builder()
                .arac(arac)
                .kisi(kisi)
                .baslangicTarihi(LocalDate.now())
                .build();

        new KisiRepository().save(kisi);
        new AracRepository().save(arac);
        new KiralamaRepository().save(kiralama1);
        new KiralamaRepository().save(kiralama);

    }

    public static Long userId;

    private void login() {
        boolean close = false;
        System.out.print("Kullan�c� Ad�n�z� giriniz : ");
        String userName = new Scanner(System.in).nextLine();
        System.out.print("Kullan�c� Sifrenizi Giriniz : ");
        String sifre = new Scanner(System.in).nextLine();

        try {
            userId = new KisiRepository().findByColumnNameAndValue("username", userName).get(0).getId();
            Long passwordId = new KisiRepository().findByColumnNameAndValue("password", sifre).get(0).getId();

            if (userId.equals(passwordId)) {
                System.out.println("Sisteme Giri� Ba�ar�l�");

            } else {
                System.out.println("Kullan�c� Ad� veya Sifre Hatal�");
                login();
            }
        } catch (Exception e) {
            System.out.println("Kullan�c� Ad� veya Sifre Hatal�");
            login();
        }
    }

    private void aracKiralamaIntro(){
        System.out.println("*************************************");
        System.out.println("********* G�R��  �SLEMLER�  *********");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("1- �ye Ol");
        System.out.println("2- Giri� Yap");
        System.out.println("0- Cikis Yap");
    }


        public int afterLogin () {
            System.out.print("1-Raporlama Menusu");
            System.out.print("2-Musteriye Gore Kiralad�g� Araclar");
            System.out.print("3-Bosta Olan Araclar");
            System.out.print("4-Kirada Olan Araclar");
            System.out.print("5-Kiralama Yap");
            System.out.print("6-Arac Ara");
            System.out.print("7-Kisi Ekle");
            System.out.print("8-Arac Ekle");
            System.out.print("0-C�k�s");
            System.out.print("Secim Yap�n�z :");
            int secim=new Scanner(System.in).nextInt();

            return secim;

        }


        public void cases(){
        boolean status=true;
        do{
            switch (afterLogin()){
                case 1:raporlamaMenusu();
                case 2:musteriyeGoreKiraladagiAraclar();break;
                case 3:bostaOlanAraclar();break;
                case 4:kiradaOlanAraclar();break;
                case 5:kiralamaYap();break;
                case 6:aracAra();break;
                case 7:kisiEkle();break;
                case 8:aracEkle();break;
                case 0:status=false;break;

            }
        }while (status);
        }

        UtilityClass utilityClass=new UtilityClass();
    private Arac aracEkle() {

        String marka=utilityClass.stringDeger("Arac Marka :");
        String model=utilityClass.stringDeger("Arac Model :");
        String plaka=utilityClass.stringDeger("Plaka Giriniz :");

        Arac arac= Arac.builder()
                .marka(marka)
                .model(model)
                .durum(true)
                .build();

        new AracController().save(arac);
        return arac;

    }

    private Kisi kisiEkle(){

        String ad=utilityClass.stringDeger("Ad :");
        String username=utilityClass.stringDeger("Username :");
        String password=utilityClass.stringDeger("Password :");

        Kisi kisi=Kisi.builder()
                .name(ad)
                .username(username)
                .password(password)
                .build();

        return new KisiController().save(kisi);
    }

    private Optional<Arac> aracAra(){
      String plaka= utilityClass.stringDeger("Aramak Istedi�iniz Arac�n Plakas�n� Giriniz");
      Long aracId = new AracRepository().findByColumnNameAndValue("plaka", plaka).get(0).getId();
      return new AracController().findById(aracId);
    }


    public void kiralamaYap(){


        new AracController().aracList().stream().filter(arac -> arac.getDurum()==true)
                .collect(Collectors.toList()).forEach(System.out::println);


        int g�n=utilityClass.intDeger("Arac Kiralama G�n�n� Giriniz");
        int ay=utilityClass.intDeger("Arac Kiralama Ay�n� Giriniz");
        int y�l= utilityClass.intDeger("Arac Kiralama Y�l�n� Giriniz");


        Long aracId=utilityClass.longDeger("Arac Idsini Giriniz");

        new KisiController().findAll().forEach(System.out::println);
        Long id=utilityClass.longDeger("Musteri idsini Giriniz");

        int g�n1=utilityClass.intDeger("Arac �ade G�n�n� Giriniz");
        int ay1=utilityClass.intDeger("Arac �ade Ay�n� Giriniz");
        int y�l1= utilityClass.intDeger("Arac �ade Y�l�n� Giriniz");
        Kiralama kiralama= Kiralama.builder()
                .baslangicTarihi(LocalDate.of(y�l,g�n,ay))
                .kisi(new KisiController().kisiBul(id).get())
                .arac(new AracController().findById(aracId).get())
                .bitisTarihi(LocalDate.of(y�l1,ay1,g�n1))
                .build();


        new AracController().findById(aracId).get().setDurum(false);

        new AracController().save(new AracController().findById(aracId).get());



        if(kiralama.getArac().getDurum()==false ){
            System.out.println("Arac Doludur Ge�erli Arac Seciniz");
            kiralamaYap();
        }else{
            new KiralamaController().kiralamaYap(kiralama);
        }
    }


    public void kiradaOlanAraclar(){
        new AracController().aracList().stream().filter(arac -> arac.getDurum()==false)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public void bostaOlanAraclar(){
        new AracController().aracList().stream().filter(arac -> arac.getDurum()==true)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public void musteriyeGoreKiraladagiAraclar(){
        new KisiController().findAll().forEach(System.out::println);
        Long id=utilityClass.longDeger("Musteri idsini G�riniz");
       new KiralamaController().kiralad�g�mAraclar().stream().filter(kiralama ->
               kiralama.getKisi().equals(new KisiController().kisiBul(id)));
    }

    public void raporlamaMenusu(){

    }

}
