package src;

public class Equipment {
    private static Weapon weaponEquipped;


    public static Weapon getWeaponEquipped() {
        return weaponEquipped;
    }

    public static void setWeaponEquipped(Weapon weaponEquipped) {
        Equipment.weaponEquipped = weaponEquipped;
    }

    public static void removeWeaponEquipped(){
        weaponEquipped = null;
    }


}
