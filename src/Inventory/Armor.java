package src.Inventory;

public class Armor extends Item {

    public static final int HELMET = 0;
    public static final int GLOVES = 1;
    public static final int CHEST = 2;
    public static final int BOOTS = 3;
    public static final int PANTS = 4;
    public static final int SHIELD = 5;

    int armorType;
    int defense;
    int resistance;
    int type = Item.ARMOR;

    public Armor(String name, int armorType, int value, int defense, int resistance) {
        super(name, value);
        this.armorType = armorType;
        this.defense = defense;
        this.resistance = resistance;
    }

    public Armor(Armor armor){
        super(armor.getName(), armor.getValue());
        this.armorType = armor.getArmorType();
        this.defense = armor.getdefense();
        this.resistance = armor.getResistance();
    }

    public int getArmorType() {
        return armorType;
    }

    public void setArmorType(int armorType) {
        this.armorType = armorType;
    }

    public int getdefense() {
        return defense;
    }

    public void setdefense(int defense) {
        this.defense = defense;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    public boolean defenseDominant(){
        return defense > resistance;
    }

    @Override
    public int compareTo(Item o) {
        Armor armor = (Armor) o;
        if (this.armorType < armor.getArmorType()){
            return -1;
        }else if (this.armorType > armor.getArmorType()){
            return 1;
        }
        if (defenseDominant() && armor.defenseDominant()){
            if(this.defense > armor.getdefense()){
                return 1;
            }else{
                return -1;
            }
        }
        if (!defenseDominant() && !armor.defenseDominant()){
            if(this.resistance > armor.getResistance()){
                return 1;
            }else{
                return -1;
            }
        }
        if (defenseDominant() && !armor.defenseDominant()){
            return 1;
        }
        if(!defenseDominant() && armor.defenseDominant()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        String type = null;

        switch (armorType) {
            case Armor.HELMET -> type = "HELMET";
            case Armor.GLOVES -> type = "GLOVES";
            case Armor.CHEST -> type = "CHEST";
            case Armor.BOOTS -> type = "BOOTS";
            case Armor.PANTS -> type = "PANTS";
            case Armor.SHIELD -> type = "SHIELD";
        }
        return "Name: " + name + ", Type: " + type + ", Defense: " + defense + ", Resistance: " + resistance;
    }
}
