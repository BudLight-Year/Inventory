package src.Collections;

import src.Inventory.Armor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ArmorCollection {
    public static final String FILE_NAME  = "armors.csv";
    private static final ArrayList<Armor> armorCollection = new ArrayList<>();

    public static void loadArmors() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(",");
            String name = data[0];
            int type = getType(data[1]);
            int value = Integer.parseInt(data[2]);
            int defense = Integer.parseInt(data[3]);
            int resistance = Integer.parseInt(data[4]);
            armorCollection.add(new Armor(name, type, value, defense, resistance));
        }
        in.close();
    }

    protected static int getType(String data) {
        int type = 5;
        if(data.equalsIgnoreCase("helmet")){
            type = Armor.HELMET;
        }
        if(data.equalsIgnoreCase("shield")){
            type = Armor.SHIELD;
        }
        if(data.equalsIgnoreCase("chest")){
            type = Armor.CHEST;
        }
        if(data.equalsIgnoreCase("gloves")){
            type = Armor.GLOVES;
        }
        if(data.equalsIgnoreCase("pants")){
            type = Armor.PANTS;
        }
        if(data.equalsIgnoreCase("boots")){
            type = Armor.BOOTS;
        }
        return type;
    }

    public static void saveWeapons() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(FILE_NAME));
        for (Armor armor : armorCollection) {
            String armorType = null;
            switch (armor.getArmorType()) {
                case 0 -> armorType = "HELMET";
                case 1 -> armorType = "GLOVES";
                case 2 -> armorType = "CHEST";
                case 3 -> armorType = "BOOTS";
                case 4 -> armorType = "PANTS";
                case 5 -> armorType = "SHIELD";
            }
            out.println(armor.getName() + "," + armorType + "," + armor.getValue() + "," + armor.getdefense() + "," + armor.getResistance());
        }
        out.close();
    }

    public static ArrayList<Armor> getArmorCollection() {
        return armorCollection;
    }
}
