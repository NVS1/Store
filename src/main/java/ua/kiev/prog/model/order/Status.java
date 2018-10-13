package ua.kiev.prog.model.order;

public enum Status {
    NEW,
    DELIVERY,
    EXECUTE,
    REJECTED,;

    @Override
    public String toString() {
        return name();
    }
}
