import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--HOSGELDINIZ--");

        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<Integer> balances = new ArrayList<>();
        String adminUserName = "admin";
        String adminPassoword ="aDmiN123";
        while (true) {
            System.out.println("Giriş yapmak için 1 tuşuna basınız.");
            System.out.println("Hesap oluşturmak için 2 tuşuna basınız.");
            System.out.println("Cıkıs yapmak için 3 tuşuna basınız.");
            System.out.println("Sistemdeki kayıtlı kullanıcilari görmek icin 4 tuşuna basınız.");
            String ilkGiris = scanner.next();
            scanner.nextLine();
            String islemler = "Islem tipi seciniz: \n" +
                    "1- Para Çekme \n" +
                    "2- Para Yatırma \n" +
                    "3- Çıkış yapma";

            switch (ilkGiris) {
                case "1": {
                    System.out.println("Kullanıcı adınızı giriniz:");
                    String nick = scanner.nextLine();
                    System.out.println("Şifrenizi giriniz:");
                    String password = scanner.nextLine();

                    boolean girisYapildi = false;
                    for (int k = 0; k < users.size(); k++) {
                        if (nick.equals(users.get(k)) && password.equals(passwords.get(k))) {
                            System.out.println("Giriş yapıldı.");
                            girisYapildi = true;
                            int bakiye = balances.get(k);


                            System.out.println(islemler);
                            int tip = scanner.nextInt();
                            switch (tip) {
                                case 1: {
                                    System.out.println("Bakiyeniz:"+bakiye);
                                    System.out.println("Para çekme tutarı giriniz:");
                                    int tutar = scanner.nextInt();
                                    if (bakiye >= tutar) {
                                        System.out.println("Paranız veriliyor..");
                                        bakiye = bakiye - tutar;
                                        balances.set(k, bakiye);
                                        System.out.println("Kalan bakiye: " + bakiye);
                                        System.out.println();

                                    } else {
                                        System.out.println("Yetersiz bakiye!");
                                        System.out.println();
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("Yatırılacak tutar:");
                                    int yatir = scanner.nextInt();
                                    System.out.println("Para yatırılıyor..");
                                    bakiye = yatir + bakiye;
                                    balances.set(k, bakiye);
                                    System.out.println("Hesap bakiyesi:" + bakiye);
                                    System.out.println();
                                    break;
                                }
                                case 3: {
                                    System.out.println("Çıkış yapılıyor...");

                                    break;
                                }

                                default:
                                    System.out.println("Geçersiz işlem");
                                    System.out.println();
                                    break;
                            }

                        }
                    }
                    if (!girisYapildi) {
                        System.out.println("Kullanıcı adı veya şifre hatalı.");
                        System.out.println("Cikis yapiliyor..");
                        System.out.println();

                    }
                    break;
                }
                case "2": {
                    System.out.println("Yeni kullanıcı adı oluşturunuz:");
                    String nickNew = scanner.nextLine();
                    System.out.println("Yeni şifre oluşturunuz:");
                    String passwordNew = scanner.nextLine();
                    if (users.contains(nickNew)){
                        System.out.println("Bu kullanıcı adı daha önceden alınmıs!");
                    } else if (passwordNew.length()<4) {
                        System.out.println("Sifre en az 4 haneli olmadılıdır!");

                    } else{
                        System.out.println("!---Yeni kullanici olusturuldu---!");
                        System.out.println();
                        users.add(nickNew);
                        passwords.add(passwordNew);
                        balances.add(10000);
                        break;
                    }
                }
                case "3": {
                    System.out.println("Çıkış yapılıyor..");
                    System.out.println();
                    break;
                }
                case "4":{
                    System.out.println("Hoşgeldin Admin!");
                    System.out.println("Sistem bilgilerini görmek için kullanıcı adı ve şifre giriniz:");
                    System.out.print("Admin Adı:");
                    String adminKullanici = scanner.next();
                    System.out.print("Admin sifre:");
                    String adminSifre = scanner.next();
                    if (adminKullanici.equals(adminUserName)&&adminSifre.equals(adminPassoword)){
                        System.out.println("Giris Yapildi!");
                        for (int i=0;i<users.size();i++){
                            System.out.print((i+1)+". User Nickname: "+users.get(i)+" User Password: "+passwords.get(i)+" User Balance "+balances.get(i));
                            System.out.println();
                        }
                        break;

                    }else{
                        System.out.println("Admin password veya kullanıcı adı hatalı!");
                        System.out.println("Cikis yapiliyor..");
                        System.out.println();
                        break;
                    }
                }
                default:
                    System.out.println("Geçersiz işlem!");
                    break;
            }
        }
    }
}
