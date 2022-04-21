package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void goForward() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public void canGoForward(int no) {
        if(isBiggerThanStandard(no)) {
            goForward();
        }
    }

    private boolean isBiggerThanStandard(int no) {
        return no >= CarProperties.STANDARD;
    }
}
