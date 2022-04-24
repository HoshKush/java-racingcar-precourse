package racingcar;

public class RaceTurn {

    private int turn;

    public RaceTurn(int turn) {
        this.turn = turn;
    }

    public void decrease() {
        turn--;
    }

    public boolean isFinished() {
        return turn == 0;
    }
}
