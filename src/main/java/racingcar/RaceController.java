package racingcar;

public class RaceController {

    private UserInput userInput;

    public String init() {
        userInput = new UserInput();
        return UserInput.USER_INPUT_CAR_NAMES;
    }

    public String inputCarNames(String inputCarNames) {
        userInput.setCarNames(inputCarNames);
        return UserInput.USER_INPUT_TURN;
    }

    public String inputTurn(String turn) {
        userInput.setTurn(turn);
        return UserInput.START_RACE;
    }

    public String play() {
        Race race = Race.create(userInput);
        race.playAllTurn();
        return race.getRecord().toString();
    }
}
