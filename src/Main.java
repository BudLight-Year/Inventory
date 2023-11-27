package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inventory.initialize();
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
    }
}