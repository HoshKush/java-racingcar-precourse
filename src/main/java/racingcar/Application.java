package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RaceController rc = new RaceController();
        System.out.println(rc.init());
        System.out.println(rc.inputCarNames(Console.readLine()));
        System.out.println(rc.inputTurn(Console.readLine()));
        System.out.println(rc.play());
    }
}
