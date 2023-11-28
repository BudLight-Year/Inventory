package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class InventoryCollection {
    public static final String FILE_NAME  = "inventory.csv";

    public static void loadInventory() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String data[] = line.split(",");
            int itemType = Integer.parseInt(data[0]);
            if(itemType == Item.WEAPON){
                int weaponType = WeaponCollection.getType(data[2]);
                String name = data[1];
                int value = Integer.parseInt(data[3]);
                int damage = Integer.parseInt(data[4]);
                Inventory.storeItem(new Weapon(name, weaponType, value, damage));
            }else if (itemType == Item.ARMOR){
                int armorType = ArmorCollection.getType(data[2]);
                String name = data[1];
                int value = Integer.parseInt(data[3]);
                int defense = Integer.parseInt(data[4]);
                int resistance = Integer.parseInt(data[5]);
                Inventory.storeItem(new Armor(name, armorType, value, defense, resistance));
            }
        }
        in.close();
    }

    public static int getItemType(String data) {
        int type = 5;
        if(data.equalsIgnoreCase("weapon")){
            type = Item.WEAPON;
        }
        if(data.equalsIgnoreCase("armor")){
            type = Item.ARMOR;
        }
        return type;
    }

    public static void saveInventory() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(FILE_NAME));
        Iterator<Item> it = Inventory.inventory[0].iterator();
        Iterator<Item> it2 = Inventory.inventory[1].iterator();
        while (it.hasNext()) {
            Weapon weapon = (Weapon) it.next();
            String weaponType = null;
            switch (weapon.getWeaponType()) {
                case 0 -> weaponType = "DAGGER";
                case 1 -> weaponType = "SWORD";
                case 2 -> weaponType = "SPEAR";
                case 3 -> weaponType = "BOW";
                case 4 -> weaponType = "WAND";
            }
            out.println(Item.WEAPON + "," + weapon.getName() + "," + weaponType + "," + weapon.getValue() + "," + weapon.getDamage());
        }
        while (it2.hasNext()) {
            Armor armor = (Armor) it2.next();
            String armorType = null;
            switch (armor.getArmorType()) {
                case 0 -> armorType = "HELMET";
                case 1 -> armorType = "GLOVES";
                case 2 -> armorType = "CHEST";
                case 3 -> armorType = "BOOTS";
                case 4 -> armorType = "PANTS";
                case 5 -> armorType = "SHIELD";
            }
            out.println(Item.ARMOR + "," + armor.getName() + "," + armorType + "," + armor.getValue() + "," + armor.getdefense() + "," + armor.getResistance());
        }
        out.close();
    }
}
