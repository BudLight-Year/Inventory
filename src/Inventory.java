package src;

import java.lang.reflect.Array;
import java.util.*;

public class Inventory {

    protected static final int SIZE = 3;
    protected static LinkedList<Item>[] inventory = new LinkedList[SIZE];


    public static LinkedList<Item>[] getInventory() {
        return inventory;
    }

    public static void initialize(){
        for (int i = 0; i < SIZE; i++) {
            inventory[i] = new LinkedList<Item>();
        }
    }
    public static void storeItem(Item item){
        inventory[item.getType()].addLast(item);
    }
    public static void storeItems(Item item, Item item2){
        storeItem(item);
        storeItem(item2);
    }

    public static void sortWeaponInventory(){
        Collections.sort(inventory[0]);
        inventory[0].sort(Comparator.reverseOrder());
    }
    public static void sortArmorInventory(){
        inventory[1].sort(Comparator.reverseOrder());
    }
    public static void sortConsumableInventory(){
        Collections.sort(inventory[2]);
    }

    public static void setInventory(LinkedList<Item>[] inventory) {
        Inventory.inventory = inventory;
    }

    public static void removeItem(int type, int index){
        inventory[type].remove(index);
    }

    public static void removeNull(){
        for (int i = 0; i < inventory[0].size(); i++){
            if (inventory[0].get(i) == null){
                inventory[0].remove(i);
            }
        }

    }
}


