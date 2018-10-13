package ua.kiev.prog.model.user;

public enum Role {
    USER, ADMIN;

    @Override
    public String toString() {
        return name();
    }
}
