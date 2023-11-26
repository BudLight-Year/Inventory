package src;

import java.lang.reflect.Array;
import java.util.*;

public class Inventory {

    protected static final int SIZE = 3;
    private static LinkedList<Item>[] inventory = new LinkedList[SIZE];


    public static LinkedList<Item>[] getInventory() {
        return inventory;
    }

    public static void initialize(){
        for (int i = 0; i < SIZE; i++) {
            inventory[i] = new LinkedList<Item>();
        }
    }
    public void storeItem(Item item){
        inventory[item.type].addLast(item);
    }

    public static void sortWeaponInventory(){
        //inventory[0].sort();
        Collections.sort(inventory[0]);
    }

}


