package src;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Inventory.initialize();
        WeaponCollection.loadWeapons();
        ArmorCollection.loadArmors();
        InventoryCollection.loadInventory();
        EquipmentCollection.loadEquipment();
        System.out.println(Equipment.makeString());
        System.out.println(Arrays.toString(Inventory.getInventory()));


    }
}