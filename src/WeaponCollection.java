package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//TODO read csv file of weapons and store them in a data structure
public class WeaponCollection {

    public static final String FILE_NAME  = "weapons.csv";
    private static ArrayList<Weapon> weaponCollection = new ArrayList<>();

    private void loadWeapons() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String data[] = line.split(",");
            String name = data[0];
            int type = 0;
            if(data[1].equalsIgnoreCase("sword")){
                type = Weapon.SWORD;
            }
            if(data[1].equalsIgnoreCase("dagger")){
                type = Weapon.DAGGER;
            }
            if(data[1].equalsIgnoreCase("spear")){
                type = Weapon.SPEAR;
            }
            if(data[1].equalsIgnoreCase("bow")){
                type = Weapon.BOW;
            }
            if(data[1].equalsIgnoreCase("wand")){
                type = Weapon.WAND;
            }
            int value = Integer.parseInt(data[2]);
            int damage = Integer.parseInt(data[3]);
            Weapon weapon = new Weapon(name, type, value, damage);
            weaponCollection.add(weapon);
        }
        in.close();
    }

    public void saveWeapons() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(FILE_NAME));
        Iterator<Weapon> it = weaponCollection.iterator();
        while (it.hasNext()) {
            Weapon weapon = it.next();
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
}
