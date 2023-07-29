import entity.Bancomat;
import entity.Card;
import entity.History;
import entity.User;
import sun.util.calendar.LocalGregorianCalendar;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    User[] users = new User[100];
    Card[] cards = new Card[100];
    History[] histories = new History[100];
    boolean bool = false;
    boolean bool1 = false;
    Bancomat bancomat = new Bancomat(BigDecimal.valueOf(0));
    Integer n = 0;
    Integer k = 0;
    Integer h = 0;
    Integer f = 0;
    Integer d=0;
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";

    public void enterMenu() {
        System.out.println("1.Kirish");
        System.out.println("2.Ro'yxatdan o'tish");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 2) {
            signUpMenu();
        } else {
            signIn();
        }
    }

    public void signIn() {
        Scanner signIn = new Scanner(System.in);
        System.out.println("Username ni kiriting: ");
        String username = signIn.nextLine();
        System.out.println("Parol ni kiriting: ");
        String password = signIn.nextLine();
        signIn = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                mainMenu(users[i].getId());
                f++;
                System.out.println("1.Bosh Menu        2.Dasturdan Chiqish");
                if (signIn.nextInt() == 1) {
                    enterMenu();
                } else {
                    System.out.println("Etiboringiz uchun Raxmat.");

                }

            }
        }
        if (f == 0) {
            System.out.println(RED + "Error" + ANSI_RESET);
            signIn();
        }


    }

    public void signUpMenu() {
        User user = new User();
        Scanner sign = new Scanner(System.in);
        System.out.println("Ismingiz: ");
        user.setFirstName(sign.nextLine());
        System.out.println("Familya:");
        user.setLastName(sign.nextLine());
        System.out.println("Username: ");
        user.setUsername(sign.nextLine());
        for (int i = 0; i < n; i++) {
            if (user.getUsername().equals(users[i].getUsername())) {
                System.out.println("Ro'yxatdan o'tilgan akkaunt!!!");
                signUpMenu();
            }
        }

        System.out.println("Password: ");
        String d = sign.nextLine();
        if (d.length() >= 4) {
            user.setPassword(d);
            sign = new Scanner(System.in);
            user.setId(n);
            if (n == 0) {
                user.setOwner_role(true);
                user.setAdmin_role(false);
            } else {
                user.setOwner_role(false);
                user.setAdmin_role(false);
            }
            users[n] = user;
            System.out.println("Siz Ro'yxatdan O'tdingiz.");
            n++;

            System.out.println("1.Bosh Menu        2.Dasturdan Chiqish");
            if (sign.nextInt() == 1) {
                enterMenu();
            } else {
                System.out.println("Etiboringiz uchun Raxmat.");
            }
        } else {
            System.out.println("Password kamida 4ta simboldan iborat bo'lishi zarur!");
            enterMenu();
        }
    }


    public void mainMenu(Integer user_id) {
        Scanner mainscanner = new Scanner(System.in);
        if (users[user_id].isOwner_role()) {
            System.out.println("1.Foydalanuvchilar ro'yxati : ");
            System.out.println("2.Adminlar ro'yxati : ");
            System.out.println("3.Karta ro'yxati : ");
            System.out.println("4.Bakomat schyot : ");
            System.out.println("5.Admin saylash : ");
            System.out.println("6.Bosh menu : ");
            switch (mainscanner.nextInt()) {
                case 1:
                    Foydalanuvchi(user_id);
                    break;
                case 2:
                    Admin(user_id);
                    break;
                case 3:
                    Karta(user_id);
                    break;
                case 4:
                    Scanner sign = new Scanner(System.in);
                    System.out.println("Cash pul --> " + bancomat.getBalance() + " so'm.");
                    System.out.println("1.Ha    2.Yo'q");
                    if (sign.nextInt() == 1) {
                        mainMenu(user_id);
                    } else {
                        System.out.println("Hizmatimizdan foydalanganingiz uchun rahmat!!!");
                    }
                    break;
                case 5:
                    SaylaAdmin(user_id);
                    break;
                case 6:
                    enterMenu();
                    break;
            }
        } else if (users[user_id].isAdmin_role()) {
            Scanner scanner=new Scanner(System.in);
            System.out.println("1.Foydalanuvchilar ro'yxati : ");
            System.out.println("2.Foydalanuvchini taxrirlash : ");
            System.out.println("3.Foydalanuvchini o'chirish : ");
            System.out.println("4.Bakomat schyot : ");
            System.out.println("5.Bosh menu : ");
            switch (scanner.nextInt()){
                case 1:
                    Foydalanuvchi(user_id);
                    break;
                case 2:
                    Taxrir(user_id);
                    break;
                case 3:
                    break;
                case 4:
                    Scanner sign = new Scanner(System.in);
                    System.out.println("Cash pul --> " + bancomat.getBalance() + " so'm.");
                    System.out.println("1.Ha    2.Yo'q");
                    if (sign.nextInt() == 1) {
                        mainMenu(user_id);
                    } else {
                        System.out.println("Hizmatimizdan foydalanganingiz uchun rahmat!!!");
                    }
                    break;
                case 5:
                    enterMenu();
            }
        } else {
            System.out.println("1.Karta balans");
            System.out.println("2.Pul o'tkazish");
            System.out.println("3.Karta qo'shish");
            System.out.println("4.Tarix");
            System.out.println("5.Bosh menu");
            System.out.println("6.Bakomat keshi");
            int menu = mainscanner.nextInt();
            switch (menu) {
                case 1:
                    balanse(user_id);
                    break;
                case 2:
                    System.out.println("1.O'z kartalarim orasida.");
                    System.out.println("2.Boshqa kartalarga.");
                    if (mainscanner.nextInt() == 2) {
                        p2p(user_id);
                    } else {
                        p2p2(user_id);

                    }

                    break;
                case 3:
                    addCard(user_id);
                case 4:
                    history(user_id);
                    break;
                case 5:
                    enterMenu();
                    break;
                case 6:
                    System.out.println("Bankomat balansi --> " + bancomat.getBalance());
                    break;
            }
            System.out.println("1.Asosiy  Menu        2.Dasturdan Childish");
            if (mainscanner.nextInt() == 1) {
                mainMenu(user_id);
            } else {
                System.out.println("Etiboringiz uchun Raxmat.");

            }
        }
    }

    public void addCard(Integer user_id) {
        Scanner sign = new Scanner(System.in);
        Card card = new Card();
        card.setId(k);
        System.out.println("Karta raqamini kiriting:");
        card.setNumber(sign.nextLine());
        if (card.getNumber().length()== 16) {
                System.out.println("Amal qilish muddati (01/22):");
                card.setExpireDate(sign.nextLine());
                System.out.println("Karta Balansi: ");
                card.setBalance(sign.nextBigDecimal());
                card.setUsar_id(user_id);
                cards[k] = card;
                k++;
                System.out.println("Karta qo'shildi");
                System.out.println("Boshqa amaliyot istaysizmi .");
                System.out.println("1.Ha    2.Yo'q");
                if (sign.nextInt() == 1) {
                    mainMenu(user_id);
                } else {
                    System.out.println("Hizmatimizdan foydalanganingiz uchun rahmat!!!");
                }


        }else {
            System.out.println(RED + "Error" + ANSI_RESET);
            System.out.println("16 ta raqam kiriting ! ");
            addCard(user_id);
        }
    }
    public void balanse(Integer user_id) {
        Scanner balansescanner = new Scanner(System.in);
        System.out.println("#########Kartani tanlang##########");

        for (int i = 0; i < k; i++) {
            if (cards[i].getUsar_id().equals(user_id)) {
                System.out.println(i + "." + cards[i].getNumber());
            }

        }
        int id = balansescanner.nextInt();
        System.out.println("Balnsingiz --> " + cards[id].getBalance());
    }

    public void p2p(Integer user_id) {
        History history = new History();
        Scanner scanner = new Scanner(System.in);
        int q = -1;
        System.out.println("Pul yechiladigan kartani tanlang .");
        for (int i = 0; i < k; i++) {
            if (cards[i].getUsar_id().equals(user_id)) {
                System.out.println(i + "." + cards[i].getNumber());
            }
        }
        int id = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Karta raqamni kiring:");
        String p2pCard = scanner.nextLine();
        scanner = new Scanner(System.in);
        for (int i = 0; i < k; i++) {
            if (p2pCard.equals(cards[i].getNumber())) {
                q = i;
            }
        }
        if (q != -1) {
            System.out.println("Pulni kiriting : ");
            double pul = scanner.nextDouble();
            if (Double.parseDouble(String.valueOf(cards[id].getBalance())) >= (pul + pul / 100)) {
                cards[id].setBalance(cards[id].getBalance().subtract(BigDecimal.valueOf(pul + pul / 100)));
                cards[q].setBalance(cards[q].getBalance().add(BigDecimal.valueOf(pul)));
                bancomat.setBalance(bancomat.getBalance().add(BigDecimal.valueOf(pul / 100)));
                history.setId(h);
                history.setCardNumber(cards[q].getNumber());
                history.setPul(BigDecimal.valueOf(pul + pul / 100));
                history.setCard_id(id);
                String pattern = "MM-dd-yyyy HH:mm:ss";
                SimpleDateFormat soat = new SimpleDateFormat(pattern);
                String date = soat.format(new Date());
                history.setCreatedDate(date);
                history.setCondition(false);
                histories[h] = history;
                h++;
                history = new History();
                history.setId(h);
                history.setCondition(true);
                history.setPul(BigDecimal.valueOf(pul));
                history.setCard_id(q);
                history.setCardNumber(cards[id].getNumber());
                date = soat.format(new Date());
                history.setCreatedDate(date);
                histories[h] = history;
                h++;
                System.out.println("Amaliyot amalga oshirildi.");
            } else {
                System.out.println("Pul yetarli emas!");
            }

        } else {
            System.out.println("Bunday karta raqam yo'q!");
        }
    }

    public void p2p2(Integer user_id) {
        History history = new History();
        System.out.println("Pul yechiladigan kartani tanlang.");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < k; i++) {
            if (cards[i].getUsar_id().equals(user_id)) {
                System.out.println(i + "." + cards[i].getNumber());
            }

        }
        int id = scanner.nextInt();
        System.out.println("Pul tushdigan kartani tanlang.");
        for (int i = 0; i < k; i++) {
            if (cards[i].getUsar_id().equals(user_id) && cards[i].getId() != id) {
                System.out.println(i + "." + cards[i].getNumber());
            }

        }
        int p_id = scanner.nextInt();
        System.out.println("Pulni kiriting : ");
        double pul = scanner.nextDouble();
        if (Double.parseDouble(String.valueOf(cards[id].getBalance())) >= (pul + pul / 100)) {
            cards[id].setBalance(cards[id].getBalance().subtract(BigDecimal.valueOf(pul + pul / 100)));
            bancomat.setBalance(bancomat.getBalance().add(BigDecimal.valueOf(pul / 100)));
            cards[p_id].setBalance(cards[p_id].getBalance().add(BigDecimal.valueOf(pul)));
            history.setId(h);
            history.setCard_id(id);
            history.setCardNumber(cards[p_id].getNumber());
            history.setPul(BigDecimal.valueOf(pul + pul / 100));
            String pattern = "MM-dd-yyyy HH:mm:ss";
            SimpleDateFormat soat = new SimpleDateFormat(pattern);
            String date = soat.format(new Date());
            history.setCreatedDate(date);
            history.setCondition(false);
            histories[h] = history;
            h++;
            history = new History();
            history.setId(h);
            history.setCondition(true);
            history.setPul(BigDecimal.valueOf(pul));
            history.setCard_id(p_id);
            history.setCardNumber(cards[id].getNumber());
            date = soat.format(new Date());
            history.setCreatedDate(date);
            histories[h] = history;
            h++;

            System.out.println("O'tkazma amalga oshirildi.");
        } else {
            System.out.println("Kartada mablag' yetarli emas.");
        }
    }

    public static final String ANSI_RESET = "\u001B[0m";

    public void history(Integer user_id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("#########Kartani tanlang##########");

        for (int i = 0; i < k; i++) {
            if (cards[i].getUsar_id().equals(user_id)) {
                System.out.println(i + "." + cards[i].getNumber());
            }

        }
        int id = scanner.nextInt();
        for (int i = 0; i < h; i++) {
            if (histories[i].getCard_id().equals(id)) {
                if (histories[i].isCondition()) {
                    System.out.println(GREEN + "#######Pul tushdi#######");
                    System.out.println("Umumiy summa --> " + histories[i].getPul());
                    System.out.println("O'tkazilgan karta --> " + histories[i].getCardNumber());
                    System.out.println("Date --> " + histories[i].getCreatedDate() + ANSI_RESET);
                } else {
                    System.out.println(RED + "#######Pul o'tkazilgan#######");
                    System.out.println("Umumiy summa --> " + histories[i].getPul());
                    System.out.println("O'tkazilgan karta --> " + histories[i].getCardNumber());
                    System.out.println("Date --> " + histories[i].getCreatedDate() + ANSI_RESET);

                }
            }
        }
    }

    public void Foydalanuvchi(Integer user_id) {
        Scanner scanner = new Scanner(System.in);
        if (k != 0) {
            for (int j = 1; j < n; j++) {
               for (int i = 0; i < k; i++) {
                    if (cards[i].getUsar_id().equals(users[j].getId())) {
                        System.out.println("##############Foydalanuvchi malumotlari###########");
                        System.out.println("Ismi --> " + users[j].getFirstName());
                        System.out.println("Familiyasi --> " + users[j].getLastName());
                        System.out.println("Usename --> " + users[j].getUsername());
                        System.out.print("Password --> "+"< ");
                        for (int l = 0; l < users[j].getPassword().length(); l++) {
                            System.out.print("*");
                        }
                        System.out.println(" >");

                        System.out.print("Karta raqami --> "+"< "+cards[i].getNumber().substring(0,4));
                        for (int b = 0; b <8; b++) {
                           System.out.print("*");
                         }
                        System.out.println(cards[i].getNumber().substring(12,16)+" >");
                    } else {
                        System.out.println(RED + "##############Foydalanuvchi malumotlari###########");
                        System.out.println("Ismi --> " + users[j].getFirstName());
                        System.out.println("Familiyasi --> " + users[j].getLastName());
                        System.out.println("Usename --> " + users[j].getUsername());
                        System.out.print("Password --> "+"< ");
                        for (int l = 0; l < users[j].getPassword().length(); l++) {
                            System.out.print("*");
                        }
                        System.out.println(" >"+ANSI_RESET);
                    }
                }
            }
        } else {
            for (int g = 1; g < n; g++) {
                System.out.println(RED + "##############Foydalanuvchi malumotlari###########");
                System.out.println("Ismi --> " + users[g].getFirstName());
                System.out.println("Familiyasi --> " + users[g].getLastName());
                System.out.println("Usename --> " + users[g].getUsername());
                System.out.print("Password --> "+"< ");
                for (int l = 0; l < users[g].getPassword().length(); l++) {
                    System.out.print("*");
                }
                System.out.println(" >");
            }
        }
        if (n == 1) {
            System.out.println("Hech kim obuna bo'lmagan!!!");
        }
        System.out.println("Boshqa amaliyot istaysizmi?");
        System.out.println("1.Ha     2.Yo'q");
        if (scanner.nextInt() == 1) {
            mainMenu(user_id);
        } else {
            System.out.println("Hizmatimizdan foydalanganingizdan xursandmiz!!!");
            enterMenu();

        }
    }

    public void Admin(Integer user_id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("##########Adminlar###########");
        for (int i = 0; i < n; i++) {
            if (users[i].isAdmin_role()) {
                System.out.println(users[i].getUsername());
                bool = true;
            }
        }
        if (!bool) {
            System.out.println("Adminlar mavjud emas!");
        }
        System.out.println("Boshqa amaliyot istaysizmi?");
        System.out.println("1.Ha     2.Yo'q");
        if (scanner.nextInt() == 1) {
            mainMenu(user_id);
        } else {
            System.out.println("Hizmatimizdan foydalanganingizdan xursandmiz!!!");
            enterMenu();
        }


    }

    public void Karta(Integer user_id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("############Kartalar ro'yxati###########");
        for (int i = 0; i < k; i++) {
            System.out.println(cards[i].getNumber());
        }
        if (k == 0) {
            System.out.println("Kartalar mavjud emas!");
        }
        System.out.println("Boshqa amaliyot istaysizmi?");
        System.out.println("1.Ha     2.Yo'q");
        if (scanner.nextInt() == 1) {
            mainMenu(user_id);
        } else {
            System.out.println("HIzmatimizdan foydalanganingizdan xursandmiz!!!");
            enterMenu();
        }

    }

    public void SaylaAdmin(Integer user_id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("####Foydalanuvchini tanlang####");
        if (n!=1){
        for (int i = 1; i < n; i++) {
            System.out.println(i + "." + users[i].getUsername());
        }
        int id = scanner.nextInt();
        users[id].setAdmin_role(true);
        System.out.println("Siz foydalanuvchini Admin deb belgiladingiz");
        System.out.println("Boshqa amaliyot istaysizmi?");
        System.out.println("1.Ha     2.Yo'q");
        if (scanner.nextInt() == 1) {
            mainMenu(user_id);
        } else {
            System.out.println("HIzmatimizdan foydalanganingizdan xursandmiz!!!");
            enterMenu();
        }}else {
            System.out.println("Sizda foyda" +
                    "lanuvchilar mavjud emas!");
            mainMenu(user_id);
        }
    }public void Taxrir(Integer user_id){
        Scanner scanner=new Scanner(System.in);
        for (int j = 1; j < n ; j++) {
       for (int i = 0; i < k; i++) {
            if (cards[i].getUsar_id().equals(users[j].getId())) {
                System.out.println(j + "." + users[j].getUsername());
            }
        }}
        int id = scanner.nextInt();
        System.out.println("1.Ismini taxrirlash ");
        System.out.println("2.Familiyasini taxrirlash ");
        System.out.println("3.Userni taxrirlash ");
        System.out.println("5.Asosiy menu");
        scanner=new Scanner(System.in);
        switch (id){

            case 1:
                String Rename;
                System.out.println("Avvalgi ismi --> "+users[id].getFirstName());
                System.out.println("Yangi ismni kiriting : ");
                Rename=scanner.nextLine();
                users[id].setFirstName(Rename);
                System.out.println("Siz "+id+" raqamga ega bo'lgan foydalanuvchini ismini o'zgartirdingiz!");
                System.out.println("Boshqa amaliyot istaysizmi?");
                System.out.println("1.Ha     2.Yo'q");
                if (scanner.nextInt() == 1) {
                    Taxrir(user_id);
                } else {
                    System.out.println("HIzmatimizdan foydalanganingizdan xursandmiz!!!");
                   mainMenu(user_id);
                }
                break;
            case 2:
                System.out.println("Avvalgi familiyasi --> "+users[id].getLastName());
                System.out.println("Yangi ismni kiriting : ");
                String newLastname=scanner.nextLine();
                users[id].setLastName(newLastname);
                System.out.println("Siz "+id+" raqamga ega bo'lgan foydalanuvchini familiyasini o'zgartirdingiz!");
                System.out.println("Boshqa amaliyot istaysizmi?");
                System.out.println("1.Ha     2.Yo'q");
                if (scanner.nextInt() == 1) {
                    Taxrir(user_id);
                } else {
                    System.out.println("HIzmatimizdan foydalanganingizdan xursandmiz!!!");
                    mainMenu(user_id);
                }break;
            case 3:
                System.out.println("Avvalgi Username --> "+users[id].getUsername());
                System.out.println("Yangi ismni kiriting : ");
                String newUsername=scanner.nextLine();
                users[id].setUsername(newUsername);
                System.out.println("Siz "+id+" raqamga ega bo'lgan foydalanuvchini usernameni o'zgartirdingiz!");
                System.out.println("Boshqa amaliyot istaysizmi?");
                System.out.println("1.Ha     2.Yo'q");
                if (scanner.nextInt() == 1) {
                    Taxrir(user_id);
                } else {
                    System.out.println("HIzmatimizdan foydalanganingizdan xursandmiz!!!");
                    mainMenu(user_id);
                }

                break;
            case 4:
                mainMenu(user_id);
        }
    }
}
