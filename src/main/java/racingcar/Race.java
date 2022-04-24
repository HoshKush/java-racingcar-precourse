package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private Cars cars;
    private RaceRecord record;
    private RaceTurn turn;
    private PositionOfHead positionOfHead;

    public static Race create(String carNames, int turn) throws IllegalArgumentException {
        Race race = new Race();
        race.cars = Cars.create(carNames);
        race.positionOfHead = new PositionOfHead();
        race.record = new RaceRecord();
        race.turn = new RaceTurn(turn);
        return race;
    }

    public RaceRecord getRecord() {
        return this.record;
    }

    public Cars getCars() {
        return cars;
    }

    public void playAllTurn() {
        while(!turn.isFinished()) {
            nextRaceTurn();
        }
    }

    public void nextRaceTurn() {
        if(turn.isFinished()) {
            record.addWinners(isWhoWinner());
        }
        for(Car car : cars.getCollection().values()) {
            car.canMoveForward(pickRandomNum());
            positionOfHead.setPositionIfNewHead(car);
        }
        turn.decrease();
        record.of(cars.getCollection());
    }

    public Winners isWhoWinner() {
        Winners winners = new Winners();
        for(Car car : cars.getCollection().values()) {
            addToWinnersIfHead(car, winners);
        }
        return winners;
    }

    private void addToWinnersIfHead(Car car, Winners winners) {
        if(positionOfHead.isHead(car)) {
            winners.add(car.getName());
        }
    }

    private int pickRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}