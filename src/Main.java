package src;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Inventory.initialize();
        /*
        ArrayList<Weapon> weaponArray = new ArrayList<Weapon>();
        weaponArray.add(new Weapon("Kris", Weapon.DAGGER, 20, 5));
        weaponArray.add(new Weapon("Atomizer", Weapon.WAND, 300, 50));
        weaponArray.add(new Weapon("LongSword", Weapon.SWORD, 70, 17));
        weaponArray.add(new Weapon("Javelin", Weapon.SPEAR, 80, 20));
        weaponArray.add(new Weapon("EagleEye", Weapon.BOW, 150, 35));

        for (int i = 0; i < weaponArray.size(); i++){
            Inventory.storeItem(weaponArray.get(i));
        }
        System.out.println(Arrays.toString(Inventory.getInventory()));
        Inventory.sortWeaponInventory();
        System.out.println(Arrays.toString(Inventory.getInventory()));
        Inventory.equipWeapon(2);
        System.out.println(Equipment.getWeaponEquipped());
        System.out.println(Arrays.toString(Inventory.getInventory()));
        Inventory.equipWeapon(2);
        System.out.println(Equipment.getWeaponEquipped());
        System.out.println(Arrays.toString(Inventory.getInventory()));
        Inventory.equipWeapon(2);
        System.out.println(Equipment.getWeaponEquipped());
        System.out.println(Arrays.toString(Inventory.getInventory()));
        Inventory.removeWeapon(2);
        System.out.println(Arrays.toString(Inventory.getInventory()));
         */

        WeaponCollection.loadWeapons();
        ArmorCollection.loadArmors();
        System.out.println(WeaponCollection.getWeaponCollection());
        System.out.println(ArmorCollection.getArmorCollection());
        WeaponCollection.getWeaponCollection().sort(Comparator.naturalOrder());
        ArmorCollection.getArmorCollection().sort(Comparator.naturalOrder());
        System.out.println(WeaponCollection.getWeaponCollection());
        System.out.println(ArmorCollection.getArmorCollection());
        for (int i = 0; i < WeaponCollection.getWeaponCollection().size(); i++){
            System.out.println(i + " :" + WeaponCollection.getWeaponCollection().get(i));
        }
        for (int i = 0; i < ArmorCollection.getArmorCollection().size(); i++){
            System.out.println(i + " :" + ArmorCollection.getArmorCollection().get(i));
        }

        Inventory.storeItem(new Weapon (WeaponCollection.getWeaponCollection().get(4)));
        Inventory.storeItem(new Weapon (WeaponCollection.getWeaponCollection().get(0)));
        Inventory.storeItem(new Weapon (WeaponCollection.getWeaponCollection().get(0)));
        Inventory.storeItem(new Weapon (WeaponCollection.getWeaponCollection().get(0)));
        Inventory.storeItem(new Weapon (WeaponCollection.getWeaponCollection().get(1)));
        Inventory.storeItem(new Weapon (WeaponCollection.getWeaponCollection().get(6)));
        Inventory.storeItem(new Weapon (WeaponCollection.getWeaponCollection().get(2)));
        Inventory.storeItem(new Weapon (WeaponCollection.getWeaponCollection().get(7)));
        System.out.println(Arrays.toString(Inventory.getInventory()));
        Inventory.sortWeaponInventory();
        System.out.println(Arrays.toString(Inventory.getInventory()));
        Equipment.equipItem(Item.WEAPON,3);

        System.out.println(Equipment.getWeaponEquipped());
        System.out.println(Arrays.toString(Inventory.getInventory()));

        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(0)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(1)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(3)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(5)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(6)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(7)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(8)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(9)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(12)));
        Inventory.storeItem(new Armor (ArmorCollection.getArmorCollection().get(13)));

        System.out.println(Arrays.toString(Inventory.getInventory()));

        Inventory.sortArmorInventory();

        System.out.println(Arrays.toString(Inventory.getInventory()));

        for (int i = 0; i < ArmorCollection.getArmorCollection().size(); i++){
            System.out.println(i + " :" + ArmorCollection.getArmorCollection().get(i));
        }

        Equipment.equipItem(Item.ARMOR, 0);
        System.out.println(Equipment.makeString());
        for (int i = 0; i < ArmorCollection.getArmorCollection().size(); i++){
            System.out.println(i + " :" + ArmorCollection.getArmorCollection().get(i));
        }


    }
}