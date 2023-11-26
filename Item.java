public abstract class Item implements Comparable<Item> {
    public static final int WEAPON = 0;
    public static final int ARMOR = 1;
    public static final int POTION = 2;
    protected int type;
    protected int value;
    protected String name;


    public abstract int getValue();
    public abstract void setValue(int value);
    public abstract int getType();
    public abstract String getName();
    public abstract void setName(String name);

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
