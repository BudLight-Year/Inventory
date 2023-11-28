package src;

import src.Collections.ArmorCollection;
import src.Collections.EquipmentCollection;
import src.Collections.InventoryCollection;
import src.Collections.WeaponCollection;
import src.Inventory.Equipment;
import src.Inventory.Inventory;

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