import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main implements Serializable {
    public static int I;
    public static String begin;
    public static String enterNumber;
    public static String ErrOfEnt;
    public static String TRYagain;
    public static String dpm;
    public static String number;
    public static String balance;
    public static String inet;
    public static String callings;
    public static String fAd;
    public static String fAb;
    public static String dontneed;
    public static String b0;
    public static String entWithDig;
    public static String enter7;
    public static String crNew;
    public static String nie;
    public static String entNew;
    public static String confirm;
    public static String notconfirm;
    public static String entersc;
    public static String enteric;
    public static String enterscNew;
    public static String entericNew;
    public static String date;
    public static String bomzh;
    public static String entTConf;
    public static String sef;
    public static String spt;
    public static String pay;
    public static String regi;
    public static String wantN;
    public static String wantC;
    public static String wantI;
    public static String emptyq;


    public static void Main(FileInputStream fileInputStream) throws IOException {

        Properties properties = new Properties();
        properties.load(fileInputStream);
        begin = properties.getProperty("begin");
        enterNumber = properties.getProperty("enterNumber");
        ErrOfEnt = properties.getProperty("Error");
        TRYagain = properties.getProperty("TRYagain");
        dpm = properties.getProperty("dpm");
        number = properties.getProperty("number");
        balance = properties.getProperty("balance");
        inet = properties.getProperty("inet");
        callings = properties.getProperty("callings");
        fAd = properties.getProperty("fAd");
        fAb = properties.getProperty("fAb");
        dontneed = properties.getProperty("dontneed");
        b0 = properties.getProperty("b0");
        entWithDig = properties.getProperty("entWithDig");
        enter7 = properties.getProperty("enter7");
        crNew = properties.getProperty("crNew");
        nie = properties.getProperty("nie");
        entNew = properties.getProperty("entNew");
        confirm = properties.getProperty("confirm");
        notconfirm = properties.getProperty("notconfirm");
        entersc = properties.getProperty("entersc");
        enteric = properties.getProperty("enteric");
        enterscNew = properties.getProperty("enterscNew");
        entericNew = properties.getProperty("entericNew");
        date = properties.getProperty("date");
        bomzh = properties.getProperty("bomzh");
        entTConf = properties.getProperty("entTConf");
        sef = properties.getProperty("set");
        spt = properties.getProperty("spt");
        emptyq = properties.getProperty("emptyq");
        regi = properties.getProperty("regi");
        pay = properties.getProperty("pay");
        wantC = properties.getProperty("wantC");
        wantN = properties.getProperty("wantN");
        wantI = properties.getProperty("wantI");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String ru = args[0];
        String by = args[1];
        String en = args[2];
        ArrayList<Abonent> abonents = new ArrayList<>();
        Connector connector = new Connector("t.dat");
        Admin admin = new Admin();
        Abonent abonent = new Abonent();
        System.out.println("RU BY EN");
        Scanner in = new Scanner(System.in);
        String inw = in.next();
        lang(abonent, connector, abonents, admin, ru, by, en, inw);
    }

    public static void lang(Abonent abonent, Connector connector, ArrayList<Abonent> abonents, Admin admin, String ru, String by, String en, String in) throws IOException, ClassNotFoundException {

        if(in.equals(en)) {
            FileInputStream fileInputStreamq = new FileInputStream("D:\\folder\\lab6\\src\\res.properties");
            Main(fileInputStreamq);
            abonent.abonent(1898501, 10, 20, abonents, connector);
            abonent.abonent(6267504, 1, 10, abonents, connector);
            ChooseWhoYou(admin, abonents, abonent, connector, fileInputStreamq);
        }else if(in.equals(ru)){
            FileInputStream fileInputStreamr = new FileInputStream("D:\\folder\\lab6\\src\\resRU.properties");
            Main(fileInputStreamr);
            abonent.abonent(1898501, 10, 20, abonents, connector);
            abonent.abonent(6267504, 1, 10, abonents, connector);
            ChooseWhoYou(admin, abonents, abonent, connector, fileInputStreamr);
        }else if(in.equals(by)){
            FileInputStream fileInputStreamb = new FileInputStream("D:\\folder\\lab6\\src\\resBY.properties");
            Main(fileInputStreamb);
            abonent.abonent(1898501, 10, 20, abonents, connector);
            abonent.abonent(6267504, 1, 10, abonents, connector);
            ChooseWhoYou(admin, abonents, abonent, connector, fileInputStreamb);
        }else {
            lang(abonent, connector, abonents, admin, ru, by, en, in);
        }
    }
    public static void show(ArrayList<Abonent> abonents, Connector connector) throws IOException, ClassNotFoundException {

        abonents = connector.read();
        for (Abonent abonent : abonents) {
            System.out.println(abonent);
        }
    }

    public static void AbOrAdV(String man, Admin admin, ArrayList<Abonent> abonents, Abonent abonent, Connector connector, FileInputStream fileInputStream) throws IOException, ClassNotFoundException {
        switch (man) {
            case "Abonent", "abonent", "ab", "Ab", "2", "Абонент", "абонент", "Аб", "Абанэнт", "абанэнт" -> {
                System.out.print(enterNumber);
                Scanner in = new Scanner(System.in);
                if (in.hasNextInt()) {
                    int number = in.nextInt();
                    if (number <= 9999999 && number >= 1000000) {
                        if (abonents.size() != 0) {
                            if (findByNumber(number, abonents) != null) {
                                fAb(findByNumber(number, abonents), admin, abonents, connector, fileInputStream);
                            } else {
                                System.out.println(Main.nie + Main.TRYagain);
                                AbOrAdV(man, admin, abonents, abonent, connector, fileInputStream);
                            }
                        } else {
                            System.out.println(Main.crNew);
                            fAd(admin, abonents, abonent, connector, fileInputStream);
                        }
                    } else {
                        System.out.println(Main.enter7);
                        AbOrAdV(man, admin, abonents, abonent, connector, fileInputStream);
                    }
                } else {
                    System.out.println(Main.entWithDig);
                }
            }
            case "Admin", "admin", "ad", "Ad", "1", "Админ", "Ад", "ад", "админ", "адзьмін", "Адзмін" -> fAd(admin, abonents, abonent, connector, fileInputStream);
            case "close", "Close", "выйсці", "Выйсці", "Выйти", "выйти" -> {
                System.exit(1);
            }
            default -> {
                System.out.println(Main.ErrOfEnt + Main.TRYagain);
                ChooseWhoYou(admin, abonents, abonent, connector, fileInputStream);
            }
        }

    }

    public static Abonent findByNumber(int number, ArrayList<Abonent> abonents) {
        for (int i = 0; true; ++i) {
            if (abonents.get(i).getNumber() == number) {
                return abonents.get(i);
            } else if (i == abonents.size() - 1) {
                return null;
            }
        }
    }

    public static void ChooseWhoYou(Admin admin, ArrayList<Abonent> abonents, Abonent abonent, Connector connector, FileInputStream fileInputStream) throws IOException, ClassNotFoundException {

        System.out.println(Main.begin);
        Scanner in = new Scanner(System.in);
        String a = in.next();
        AbOrAdV(a, admin, abonents, abonent, connector, fileInputStream);
    }

    public static void fAd(Admin admin, ArrayList<Abonent> abonents, Abonent abonent, Connector connector, FileInputStream fileInputStream) throws IOException, ClassNotFoundException {
        System.out.println(Main.fAd);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n) {
            case 0:
                ChooseWhoYou(admin, abonents, abonent, connector, fileInputStream);
                break;
            case 1:
                if (I != 0) {
                    abonent.changeNumberTrue(abonents, connector);
                    fAd(admin, abonents, abonent, connector, fileInputStream);
                } else {
                    System.out.println(Main.dontneed);
                    fAd(admin, abonents, abonent, connector, fileInputStream);
                }
            case 2:
                if (I != 0) {
                    abonent.changeSTrue(abonents, connector);
                    fAd(admin, abonents, abonent, connector, fileInputStream);
                } else {
                    System.out.println(Main.dontneed);
                    fAd(admin, abonents, abonent, connector, fileInputStream);
                }
            case 3:
                if (I != 0) {
                    abonent.changeITrue(abonents, connector);
                    fAd(admin, abonents, abonent, connector, fileInputStream);
                } else {
                    System.out.println(Main.dontneed);
                    fAd(admin, abonents, abonent, connector, fileInputStream);
                }
            case 4:
                show(abonents, connector);
                fAd(admin, abonents, abonent, connector, fileInputStream);
            case 5:
                abonent.abonentByEnter(abonents, connector);
                fAd(admin, abonents, abonent, connector, fileInputStream);
            case 6:
                abonent.fullList();
                fAd(admin, abonents, abonent, connector, fileInputStream);
            default:
                System.out.println(Main.TRYagain + " (" + Main.b0 + " 6) ");
                fAd(admin, abonents, abonent, connector, fileInputStream);


        }
    }

    public static void fAb(Abonent abonent, Admin admin, ArrayList<Abonent> abonents, Connector connector, FileInputStream fileInputStream) throws IOException, ClassNotFoundException {
        System.out.println(Main.fAb);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n) {
            case 0 -> ChooseWhoYou(admin, abonents, abonent, connector, fileInputStream);
            case 1 -> {
                abonent.calling();
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
            case 2 -> {
                abonent.SerfingInInternet();
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
            case 3 -> {
                abonent.Payment();
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
            case 4 -> {
                abonent.changeNumber();
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
            case 5 -> {
                abonent.otherService();
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
            case 6 -> {
                abonent.otherInternet();
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
            case 7 -> {
                System.out.println("\n" + Main.balance + ": " + abonent.getExpense());
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
            case 8 -> {
                System.out.println("\n1. " + Main.callings + " - " + abonent.getServicesPerMinute() + " " + Main.dpm + ", \n2. " + Main.inet + " - " + abonent.getInternetPerMinute() + " " + Main.dpm +"\n");
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
            default -> {
                System.out.println(Main.TRYagain + " (" + Main.b0 + "8) ");
                fAb(abonent, admin, abonents, connector, fileInputStream);
            }
        }

    }
}
