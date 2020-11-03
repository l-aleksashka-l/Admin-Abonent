//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.*;
import java.util.ArrayList;

public class Connector {
    private  String filename;
    public static int ii = 0;
    public Connector(String filename) {
        this.filename = filename;
    }

    public void write(ArrayList<Abonent> abonents) throws IOException {
        FileOutputStream fos = new FileOutputStream(this.filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Throwable var4 = null;

        try {

            for (Abonent abonent : abonents) {
                oos.writeObject(abonent);
            }

            oos.flush();
        } catch (Throwable var13) {
            var4 = var13;
            throw var13;
        } finally {
            if (var4 != null) {
                try {
                    oos.close();
                } catch (Throwable var12) {
                    var4.addSuppressed(var12);
                }
            } else {
                oos.close();
            }

        }
    }
    public void delete() throws IOException {
        FileOutputStream fos = new FileOutputStream(this.filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        fos.flush();
        fos.flush();
    }
    public ArrayList<Abonent> read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(this.filename);
        ObjectInputStream oin = new ObjectInputStream(fis);
        Throwable var3 = null;

        try {
//            int length = oin.readInt();
            ArrayList<Abonent> result = new ArrayList<>();

            for(int i = 0; i < ii; ++i) {
                result.add((Abonent) oin.readObject());
            }



            ArrayList<Abonent> var17 = result;
            return var17;
        } catch (Throwable var15) {
            var3 = var15;
            throw var15;
        } finally {
            if (var3 != null) {
                try {
                    oin.close();
                } catch (Throwable var14) {
                    var3.addSuppressed(var14);
                }
            } else {
                oin.close();
            }

        }
    }
}