package src.Inventory;

public class Consumable extends Item{
    private boolean affectsStatus = false;
    private int healthRecovery;
    private int manaRecovery;
    private String statusEffect;

    public Consumable(String name, int value, int healthRecovery, int manaRecovery, boolean affectsStatus, String statusEffect) {
        super(name, value);
        this.healthRecovery = healthRecovery;
        this.manaRecovery = manaRecovery;
        this.statusEffect = statusEffect;
        this.affectsStatus = affectsStatus;
        this.type = Item.CONSUMABLE;
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

    @Override
    public int compareTo(Item o) {
        Consumable consumable = (Consumable) o;
        if (affectsStatus && !consumable.affectsStatus){
            return 1;
        }
        if (!affectsStatus && consumable.affectsStatus){
            return -1;
        }
        if (healthRecovery > consumable.healthRecovery && manaRecovery > consumable.manaRecovery || healthRecovery > consumable.getHealthRecovery() && manaRecovery < consumable.getManaRecovery()){
            return 1;
        }
        if (healthRecovery < consumable.healthRecovery && manaRecovery < consumable.manaRecovery || healthRecovery < consumable.getHealthRecovery() && manaRecovery > consumable.getManaRecovery()){
            return -1;
        }
        return 0;
    }

    public boolean isAffectsStatus() {
        return affectsStatus;
    }

    public void setAffectsStatus(boolean affectsStatus) {
        this.affectsStatus = affectsStatus;
    }

    public int getHealthRecovery() {
        return healthRecovery;
    }

    public void setHealthRecovery(int healthRecovery) {
        this.healthRecovery = healthRecovery;
    }

    public int getManaRecovery() {
        return manaRecovery;
    }

    public void setManaRecovery(int manaRecovery) {
        this.manaRecovery = manaRecovery;
    }

    public String getStatusEffect() {
        return statusEffect;
    }

    public void setStatusEffect(String statusEffect) {
        this.statusEffect = statusEffect;
    }

    @Override
    public String toString() {
        return "Consumable{" +
                "affectsStatus=" + affectsStatus +
                ", healthRecovery=" + healthRecovery +
                ", manaRecovery=" + manaRecovery +
                ", statusEffect='" + statusEffect + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}

