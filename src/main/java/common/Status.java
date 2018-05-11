package common;

public enum Status {
    bad(-1),
    open(0),
    close(1);

    private int val;

    Status(int i) {
    }

    public int getVal(){
        return val;
    }
}
