package src;

import java.util.Comparator;

public class WeaponSort implements Comparator<Weapon> {


    @Override
    public int compare(Weapon o1, Weapon o2) {
        /*if (o1.getWeaponType() < o2.getWeaponType()){
            return 1;
        }else if(o1.getWeaponType() > o2.getWeaponType()){
            return -1;
        }else
         */
        if (o1.getDamage() > o2.getDamage()){
            return 1;
        }else if(o1.getDamage() < o2.getDamage()){
            return -1;
        }
        return 0;
    }
}
