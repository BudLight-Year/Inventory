package src.Collections;

import src.Inventory.Armor;
import src.Inventory.Inventory;
import src.Inventory.Item;
import src.Inventory.Weapon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ConsumableCollection {

    public static final String FILE_NAME  = "consumables.csv";
    public static void loadConsumables() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(",");
            int itemType = Integer.parseInt(data[0]);

        }
        in.close();
    }

    protected static int getType(String data) {
        int type = 5;
        if(data.equalsIgnoreCase("helmet")){
            type = Armor.HELMET;
        }
        if(data.equalsIgnoreCase("shield")){
            type = Armor.SHIELD;
        }
        if(data.equalsIgnoreCase("chest")){
            type = Armor.CHEST;
        }
        if(data.equalsIgnoreCase("gloves")){
            type = Armor.GLOVES;
        }
        if(data.equalsIgnoreCase("pants")){
            type = Armor.PANTS;
        }
        if(data.equalsIgnoreCase("boots")){
            type = Armor.BOOTS;
        }
        return type;
    }



}
