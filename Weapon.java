/*
Weapon types:
Daggers
Swords
Wands
Spears
Bows





 */


import java.util.LinkedList;

public class Weapon extends Item {
    private int damage;
    protected int weaponType;
    public static final int DAGGER = 0;
    public static final int SWORD = 1;
    public static final int SPEAR = 2;
    public static final int BOW = 3;
    public static final int WAND = 4;
    public Weapon(String name, int weaponType, int value, int damage) {
        super(name, value);
        //type = WEAPON;
        this.damage = damage;
    }

    @Override
    public String getName() {
        return name;
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
    public void setName(String name) {
        this.name = name;
    }

    public int getDamage(){
        return damage;
    }
    public void setDamage(int newDamage){
        if (newDamage >= 0) {
            damage = newDamage;
        }else{
            throw new IllegalArgumentException("positive number required");
        }
    }
    public int getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(int weaponType) {
        this.weaponType = weaponType;
    }

    public boolean equals(Weapon otherWeapon) {
        return type == otherWeapon.type && damage == otherWeapon.damage && name.equals(otherWeapon.name);
    }

    @Override
    public int compareTo(Item o) {
        Weapon weapon = (Weapon) o;
        if (this.damage > weapon.getDamage()){
            return 1;
        }else if(this.damage < weapon.getDamage()){
            return -1;
        }
        return 0;
    }
}
