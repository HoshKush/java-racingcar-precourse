package racingcar;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Cars {
    private static final String EMPTY_CAR_NAME = "[ERROR] 차량 이름이 비었습니다.";
    private static final String NO_INPUT_STRING = "[ERROR] 문자열이 입력되지 않았습니다.";
    private static final String DUPLICATE_CAR_NAME= "[ERROR] 중복된 이름의 차가 존재합니다.";

    private LinkedHashMap<String, Car> cars;

    public Cars(LinkedHashMap<String, Car> cars) {
        this.cars = cars;
    }

    public static Cars create(String carNames) {
        validateCarNames(carNames);
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        for(String carName : carNames.split(",")) {
            validateCarName(carName, cars);
            cars.put(carName, Car.create(carName));
        }
        return new Cars(cars);
    }

    private static void validateCarNames(String carNames) {
        if(carNames.isEmpty()) {
            throw new IllegalArgumentException(NO_INPUT_STRING);
        }
    }

    public LinkedHashMap<String, Car> getCollection() {
        return cars;
    }

    private static void validateCarName(String carName, HashMap<String, Car> cars) {
        if(carName.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
        if(cars.containsKey(carName)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }
}
