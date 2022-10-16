import entity.Fdibamon;

public class Arena {
    private Fdibamon firstFdibamon;
    private Fdibamon secondFdibamon;

    public Arena(Fdibamon firstFdibamon, Fdibamon secondFdibamon) {
        this.firstFdibamon = firstFdibamon;
        this.secondFdibamon = secondFdibamon;
    }

    public Fdibamon getFirstFdibamon() {
        return firstFdibamon;
    }

    public Fdibamon getSecondFdibamon() {
        return secondFdibamon;
    }
}
