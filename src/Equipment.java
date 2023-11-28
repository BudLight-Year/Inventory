package src;

/*
Equipment List:
Weapon
Shield
Helmet
Gloves
Chest
Pants
Boots
 */

public class Equipment {
    private static Weapon weaponEquipped;
    private static Armor shieldEquipped;
    private static Armor helmetEquipped;
    private static Armor glovesEquipped;
    private static Armor chestEquipped;
    private static Armor pantsEquipped;
    private static Armor bootsEquipped;

    Item[] equipment = new Item[7];



    public static Weapon getWeaponEquipped() {
        return weaponEquipped;
    }

    public static void setWeaponEquipped(Weapon weaponEquipped) {
        Equipment.weaponEquipped = weaponEquipped;
    }

    public static void removeWeaponEquipped(){
        if (weaponEquipped != null) {
            Inventory.inventory[Item.WEAPON].add(weaponEquipped);
            weaponEquipped = null;
        }
    }

    public static void removeHelmetEquipped(){
        if (helmetEquipped != null) {
            Inventory.inventory[Item.ARMOR].add(helmetEquipped);
            helmetEquipped = null;
        }
    }

    public static void removeGlovesEquipped(){
        if (glovesEquipped != null) {
            Inventory.inventory[Item.ARMOR].add(glovesEquipped);
            glovesEquipped = null;
        }
    }

    public static void removeChestEquipped(){
        if (chestEquipped != null) {
            Inventory.inventory[Item.ARMOR].add(chestEquipped);
            chestEquipped = null;
        }
    }

    public static void removeShieldEquipped(){
        if (shieldEquipped != null) {
            Inventory.inventory[Item.ARMOR].add(shieldEquipped);
            shieldEquipped = null;
        }
    }

    public static void removePantsEquipped(){
        if (pantsEquipped != null) {
            Inventory.inventory[Item.ARMOR].add(pantsEquipped);
            pantsEquipped = null;
        }
    }

    public static void removeBootsEquipped(){
        if (bootsEquipped != null) {
            Inventory.inventory[Item.ARMOR].add(bootsEquipped);
            bootsEquipped = null;
        }
    }


    public static Armor getShieldEquipped() {
        return shieldEquipped;
    }

    public static void setShieldEquipped(Armor shieldEquipped) {
        Equipment.shieldEquipped = shieldEquipped;
    }

    public static Armor getHelmetEquipped() {
        return helmetEquipped;
    }

    public static void setHelmetEquipped(Armor helmetEquipped) {
        Equipment.helmetEquipped = helmetEquipped;
    }

    public static Armor getGlovesEquipped() {
        return glovesEquipped;
    }

    public static void setGlovesEquipped(Armor glovesEquipped) {
        Equipment.glovesEquipped = glovesEquipped;
    }

    public static Armor getChestEquipped() {
        return chestEquipped;
    }

    public static void setChestEquipped(Armor chestEquipped) {
        Equipment.chestEquipped = chestEquipped;
    }

    public static Armor getPantsEquipped() {
        return pantsEquipped;
    }

    public static void setPantsEquipped(Armor pantsEquipped) {
        Equipment.pantsEquipped = pantsEquipped;
    }

    public static Armor getBootsEquipped() {
        return bootsEquipped;
    }

    public static void setBootsEquipped(Armor bootsEquipped) {
        Equipment.bootsEquipped = bootsEquipped;
    }

    public static void equipItem(int type, int index){
        if (type > 1 || type < 0){
            throw new IllegalArgumentException("Can only equip weapons and armor");
        }
        for (int i = 0; i < Inventory.inventory[type].size(); i++){
            if (i <= index){
                continue;
            }
            Item temp = Inventory.inventory[type].get(index);
            Inventory.inventory[type].set(index, Inventory.inventory[type].get(index + 1));
            Inventory.inventory[type].set(index + 1, temp);
            index++;
        }
        if (type == Item.WEAPON){
            Weapon weapon = (Weapon) Inventory.inventory[0].get(index);
            Inventory.inventory[type].remove(index);
            if (Equipment.getWeaponEquipped() != null){
                Inventory.inventory[type].add(index, Equipment.getWeaponEquipped());
            }
            Equipment.setWeaponEquipped(weapon);
        }
        if (type == Item.ARMOR){
            Armor armor = (Armor) Inventory.inventory[1].get(index);
            Inventory.inventory[type].remove(index);
            switch (armor.armorType){
                case Armor.HELMET:
                    if (Equipment.getHelmetEquipped() != null){
                        Inventory.inventory[type].add(index, Equipment.getHelmetEquipped());
                    }
                    Equipment.setHelmetEquipped(armor);
                    break;
                case Armor.GLOVES:
                    if (Equipment.getGlovesEquipped() != null){
                        Inventory.inventory[type].add(index, Equipment.getGlovesEquipped());
                    }
                    Equipment.setGlovesEquipped(armor);
                    break;
                case Armor.CHEST:
                    if (Equipment.getChestEquipped() != null){
                        Inventory.inventory[type].add(index, Equipment.getChestEquipped());
                    }
                    Equipment.setChestEquipped(armor);
                    break;
                case Armor.BOOTS:
                    if (Equipment.getBootsEquipped() != null){
                        Inventory.inventory[type].add(index, Equipment.getBootsEquipped());
                    }
                    Equipment.setBootsEquipped(armor);
                    break;
                case Armor.PANTS:
                    if (Equipment.getPantsEquipped() != null){
                        Inventory.inventory[type].add(index, Equipment.getPantsEquipped());
                    }
                    Equipment.setPantsEquipped(armor);
                    break;
                case Armor.SHIELD:
                    if (Equipment.getShieldEquipped() != null){
                        Inventory.inventory[type].add(index, Equipment.getShieldEquipped());
                    }
                    Equipment.setShieldEquipped(armor);
                    break;
            }
        }
    }

    public static String makeString() {
        return "Weapon: " + weaponEquipped + ", Helmet: " + helmetEquipped + ", Chest: " + chestEquipped + ", Gloves: " + glovesEquipped + ", Pants: " + pantsEquipped + ", Boots: " + bootsEquipped + ", Shield: " + shieldEquipped;
    }
}
