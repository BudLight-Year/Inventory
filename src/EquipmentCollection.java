package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class EquipmentCollection {
    public static final String FILE_NAME  = "equipment.csv";

    public static void loadEquipment() throws FileNotFoundException {
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
                Equipment.setWeaponEquipped(new Weapon(name, weaponType, value, damage));
            }else if (itemType == Item.ARMOR){
                int armorType = ArmorCollection.getType(data[2]);
                String name = data[1];
                int value = Integer.parseInt(data[3]);
                int defense = Integer.parseInt(data[4]);
                int resistance = Integer.parseInt(data[5]);
                switch (armorType){
                    case Armor.HELMET -> Equipment.setHelmetEquipped(new Armor(name, armorType, value, defense, resistance));
                    case Armor.GLOVES -> Equipment.setGlovesEquipped(new Armor(name, armorType, value, defense, resistance));
                    case Armor.CHEST -> Equipment.setChestEquipped(new Armor(name, armorType, value, defense, resistance));
                    case Armor.BOOTS -> Equipment.setBootsEquipped(new Armor(name, armorType, value, defense, resistance));
                    case Armor.PANTS -> Equipment.setPantsEquipped(new Armor(name, armorType, value, defense, resistance));
                    case Armor.SHIELD -> Equipment.setShieldEquipped(new Armor(name, armorType, value, defense, resistance));
                }
            }
        }
        in.close();
    }

    public static void saveEquipment() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(FILE_NAME));
        Weapon weapon = Equipment.getWeaponEquipped();
        String weaponType = null;
        switch (weapon.getWeaponType()) {
            case 0 -> weaponType = "DAGGER";
            case 1 -> weaponType = "SWORD";
            case 2 -> weaponType = "SPEAR";
            case 3 -> weaponType = "BOW";
            case 4 -> weaponType = "WAND";
        }
        out.println(Item.WEAPON + "," +  weapon.getName() + "," + weaponType + "," + weapon.getValue() + "," + weapon.getDamage());

        Armor armor = Equipment.getHelmetEquipped();
        out.println(Item.ARMOR + "," +  armor.getName() + "," + "HELMET" + "," + armor.getValue() + "," + armor.getdefense() + "," + armor.getResistance());
        armor = Equipment.getChestEquipped();
        out.println(Item.ARMOR + "," +  armor.getName() + "," + "CHEST" + "," + armor.getValue() + "," + armor.getdefense() + "," + armor.getResistance());
        armor = Equipment.getGlovesEquipped();
        out.println(Item.ARMOR + "," +  armor.getName() + "," + "GLOVES" + "," + armor.getValue() + "," + armor.getdefense() + "," + armor.getResistance());
        armor = Equipment.getPantsEquipped();
        out.println(Item.ARMOR + "," +  armor.getName() + "," + "PANTS" + "," + armor.getValue() + "," + armor.getdefense() + "," + armor.getResistance());
        armor = Equipment.getBootsEquipped();
        out.println(Item.ARMOR + "," +  armor.getName() + "," + "BOOTS" + "," + armor.getValue() + "," + armor.getdefense() + "," + armor.getResistance());
        armor = Equipment.getShieldEquipped();
        out.println(Item.ARMOR + "," +  armor.getName() + "," + "SHIELD" + "," + armor.getValue() + "," + armor.getdefense() + "," + armor.getResistance());
        out.close();
    }

}
