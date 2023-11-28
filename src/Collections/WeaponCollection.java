package src.Collections;

import src.Inventory.Weapon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

//TODO read csv file of weapons and store them in a data structure
public class WeaponCollection {

    public static final String FILE_NAME  = "weapons.csv";
    private static final ArrayList<Weapon> weaponCollection = new ArrayList<>();

    public static void loadWeapons() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(",");
            String name = data[0];
            int type = getType(data[1]);
            int value = Integer.parseInt(data[2]);
            int damage = Integer.parseInt(data[3]);
            weaponCollection.add(new Weapon(name, type, value, damage));
        }
        in.close();
    }

    protected static int getType(String data) {
        int type = 5;
        if(data.equalsIgnoreCase("sword")){
            type = Weapon.SWORD;
        }
        if(data.equalsIgnoreCase("dagger")){
            type = Weapon.DAGGER;
        }
        if(data.equalsIgnoreCase("spear")){
            type = Weapon.SPEAR;
        }
        if(data.equalsIgnoreCase("bow")){
            type = Weapon.BOW;
        }
        if(data.equalsIgnoreCase("wand")){
            type = Weapon.WAND;
        }
        return type;
    }

    public static void saveWeapons() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(FILE_NAME));
        for (Weapon weapon : weaponCollection) {
            String weaponType = null;
            switch (weapon.getWeaponType()) {
                case 0 -> weaponType = "DAGGER";
                case 1 -> weaponType = "SWORD";
                case 2 -> weaponType = "SPEAR";
                case 3 -> weaponType = "BOW";
                case 4 -> weaponType = "WAND";
            }
            out.println(weapon.getName() + "," + weaponType + "," + weapon.getValue() + "," + weapon.getDamage());
        }
        out.close();
    }

    public static ArrayList<Weapon> getWeaponCollection() {
        return weaponCollection;
    }
}
