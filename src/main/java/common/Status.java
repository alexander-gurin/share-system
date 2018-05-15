package common;

public enum Status {
    BAD(-1),
    OPEN(0),
    CLOSE(1);

    private int val;

    Status(int i) {
    }

    public int getVal(){
        return val;
    }
}
