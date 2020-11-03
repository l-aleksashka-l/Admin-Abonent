import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements Serializable {

    private int number;
    private int expense;
    private int servicesPerMinute;
    private int internetPerMinute;
    private int save;
    private int saveS;
    private int saveI;
    private int i1, i2, i3 = 0;
    private static final long serialVersionUID = 1L;

    public Admin(int number, int expense, int servicesPerMinute, int internetPerMinute) {

        this.number = number;
        this.expense = expense;
        this.servicesPerMinute = servicesPerMinute;
        this.internetPerMinute = internetPerMinute;
    }

    public Admin() {
        this.number = 0;
        this.expense = 0;
        this.servicesPerMinute = 0;
        this.internetPerMinute = 0;

    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int closeCallingAndInternet() {
        if (this.expense <= 0) {
            return 0;
        }
        return 1;
    }


    public int getNumber() {
        return number;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getServicesPerMinute() {
        return servicesPerMinute;
    }

    public void setServicesPerMinute(int servicesPerMinute) {
        this.servicesPerMinute = servicesPerMinute;
    }

    public int getInternetPerMinute() {
        return internetPerMinute;
    }

    public void setInternetPerMinute(int internetPerMinute) {
        this.internetPerMinute = internetPerMinute;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getSaveS() {
        return saveS;
    }

    public void setSaveS(int saveS) {
        this.saveS = saveS;
    }

    public int getSaveI() {
        return saveI;
    }

    public void setSaveI(int saveI) {
        this.saveI = saveI;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public int getI3() {
        return i3;
    }

    public void setI3(int i3) {
        this.i3 = i3;
    }

    @Override
    public String toString() {
        return "| " + Main.number + ": +375(99)" + number +
                " | " + Main.balance + ": " + expense +
                " | " + Main.callings + " (" + Main.dpm + ") : " + servicesPerMinute +
                " | " + Main.inet + " (" + Main.dpm + ") : " + internetPerMinute + " |";
    }
}


