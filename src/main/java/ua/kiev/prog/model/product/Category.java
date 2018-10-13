package ua.kiev.prog.model.product;

public enum Category {
    SMARTPHONE,
    COMPUTER,
    SMART_WATCH,
    ACCESSORY;

    @Override
    public String toString() {
        return name();
    }
}
