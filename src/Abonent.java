import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Abonent extends Admin implements Serializable {


    public Abonent(int number, int expense, int servicesPerMinute, int internetPerMinute) {
        super(number, expense, servicesPerMinute, internetPerMinute);
    }


    public Abonent() {
    }


    public void abonentByEnter(ArrayList<Abonent> abonents, Connector connector) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print(Main.enter7 + ": +375(99)");
        int a = in.nextInt();
        int b = 0;
        System.out.print(Main.entersc);
        int c = in.nextInt();
        System.out.print(Main.enteric);
        int d = in.nextInt();
        if (in.hasNextInt()){
            if (BeOrNotToBe(abonents, a)) {
                Date date = new Date();
                Abonent abonent = new Abonent(a, b, c, d);
                abonents.add(abonent);
                connector.write(abonents);
                Connector.ii++;
                System.out.println(Main.date + date);
            } else {
                abonentByEnter(abonents, connector);
            }
        }else {
            System.out.println(Main.entWithDig);
            abonentByEnter(abonents, connector);
        }
    }

    public void abonent(int a, int c, int d, ArrayList<Abonent> abonents, Connector connector) throws IOException {
        Date date = new Date();
        Abonent abonent = new Abonent(a, 0, c, d);
        abonents.add(abonent);
        connector.write(abonents);
        Connector.ii++;
        System.out.println(Main.date + date);
    }

    public void calling() {
        System.out.print(Main.sef);
        Scanner in = new Scanner(System.in);

        if (in.hasNextInt()) {
            int time = in.nextInt();
            if (closeCallingAndInternet() == 0) {
                System.out.println(Main.bomzh);
            } else {
                setExpense(this.getExpense() - (this.getServicesPerMinute() * time));
            }
        } else {
            System.out.println(Main.entWithDig);
            calling();
        }
    }

    public void SerfingInInternet() {
        System.out.print(Main.spt);
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int time = in.nextInt();
            if (closeCallingAndInternet() == 0) {
                System.out.println(Main.bomzh);
            } else {
                setExpense(this.getExpense() - (this.getInternetPerMinute() * time));
            }
        } else {
            System.out.println(Main.entWithDig);
            SerfingInInternet();
        }
    }

    public void Payment() {
        System.out.print(Main.pay);
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int cash = in.nextInt();
            setExpense(this.getExpense() + cash);
        } else {
            System.out.println(Main.entWithDig);
            Payment();
        }
    }

    public void changeNumber() {
        System.out.print(Main.entNew + ": ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int number = in.nextInt();
            if (number <= 9999999 && number >= 1000000) {
                setSave(number);
            } else {
                System.out.println(Main.enter7);
                changeNumber();
            }
        } else {
            System.out.println(Main.entWithDig);
            changeNumber();
        }
        setI1(this.getNumber());
    }

    public boolean BeOrNotToBe(ArrayList<Abonent> abonents, int number) {
        for (int i = 0; true; ++i) {
            if (abonents.get(i).getNumber() == number) {
                System.out.println(Main.regi);
                return false;
            } else if (i == abonents.size() - 1) {
                return true;
            }
        }
    }

    public void fullList() {
        if (getI1() != 0) {
            System.out.println("+375(99)" + getI1() + " "+Main.wantN +" +375(99)" + getSave());
            Main.I = 1;
        }
        if (getI2() != 0) {
            System.out.println("+375(99)" + getI2() + " "+Main.wantC+" " + getSaveS() + " " +Main.dpm);
            Main.I = 1;
        }
        if (getI3() != 0) {
            System.out.println("+375(99)" + getI3() + " "+Main.wantI + " " + getSaveI() + " " + Main.dpm);
            Main.I = 1;
        }
        if (getI1() == 0 && getI2() == 0 && getI3() == 0) {
            System.out.println(Main.emptyq);
            Main.I = 0;
        }
    }


    public void changeNumberTrue(ArrayList<Abonent> abonents, Connector conector) throws IOException {
        conector.delete();
        System.out.print(Main.entTConf);
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int number = in.nextInt();
            if (BeOrNotToBe(abonents, getSave())) {
                if (Main.findByNumber(number, abonents) != null) {
                    Objects.requireNonNull(Main.findByNumber(number, abonents)).setNumber(getSave());
                    conector.write(abonents);
                    System.out.println("\n"+Main.confirm+"\n");
                    setI1(0);
                } else {
                    System.out.println(Main.nie + Main.TRYagain);
                    changeNumberTrue(abonents, conector);
                    setI1(0);
                }
            } else {
                System.out.println("\n"+Main.notconfirm +"\n");
                setI1(0);
            }
        } else {
            System.out.println(Main.entWithDig);
            changeNumberTrue(abonents, conector);
        }
    }

    public void otherService() {
        System.out.print(Main.enterscNew+"("+Main.dpm +"): ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int number = in.nextInt();
            setSaveS(number);
        } else {
            System.out.println(Main.entWithDig);
            otherService();
        }
        setI2(this.getNumber());
    }

    public void changeSTrue(ArrayList<Abonent> abonents, Connector conector) throws IOException {
        conector.delete();
        System.out.print(Main.entTConf);
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int number = in.nextInt();
            if (Main.findByNumber(number, abonents) != null) {
                Objects.requireNonNull(Main.findByNumber(number, abonents)).setServicesPerMinute(getSaveS());
                conector.write(abonents);
                System.out.println("\n"+Main.confirm+"\n");
                setI2(0);
            } else {
                System.out.println(Main.nie + Main.TRYagain);
                changeSTrue(abonents, conector);
            }
        } else {
            System.out.println(Main.entWithDig);
            changeSTrue(abonents, conector);
        }
    }

    public void otherInternet() {
        System.out.print(Main.entericNew +"("+Main.dpm+"): ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int number = in.nextInt();
            setSaveI(number);
        } else {
            System.out.println(Main.entWithDig);
            otherInternet();
        }
        setI3(this.getNumber());
    }

    public void changeITrue(ArrayList<Abonent> abonents, Connector conector) throws IOException {
        conector.delete();
        System.out.print(Main.entTConf);
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int number = in.nextInt();
            if (Main.findByNumber(number, abonents) != null) {
                Objects.requireNonNull(Main.findByNumber(number, abonents)).setInternetPerMinute(getSaveI());
                conector.write(abonents);
                System.out.println("\n"+Main.confirm+"\n");
                setI3(0);
            } else {
                System.out.println(Main.nie + Main.TRYagain);
                changeITrue(abonents, conector);
            }
        } else {
            System.out.println(Main.entWithDig);
            changeITrue(abonents, conector);
        }
    }

}