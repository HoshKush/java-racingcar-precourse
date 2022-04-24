package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void 경기_생성() {
        String carNames = "pobi,brown";
        assertThatNoException().isThrownBy(() -> Race.create(carNames, 1));
    }

    @Test
    void 경기_생성_실패() {
        String carNames = "";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Race.create(carNames, 1));
    }

    @Test
    void 우승자_판별() {
        String carNames = "pobi,brown";
        Race race = Race.create(carNames, 1);

        race.getCars().getCollection().get("pobi").moveForward();
        race.getCars().getCollection().get("pobi").moveForward();
        race.getCars().getCollection().get("pobi").moveForward();

        race.playAllTurn();

        assertThat(race.isWhoWinner().getWinnerList()).contains("pobi").doesNotContain("brown");

    }

    @Test
    void 경기_1턴_진행() {
        String carNames = "pobi";
        int turn = 5;
        
        Race race = Race.create(carNames, turn);
        race.nextRaceTurn();
        
        assertThat(race.getRecord().getList().size()).isEqualTo(3);
    }
    
    @Test
    void 경기_모든턴_진행() {
        String carNames = "pobi";
        int turn = 3;

        Race race = Race.create(carNames, turn);
        race.playAllTurn();

        assertThat(race.getRecord().getList().size()).isEqualTo(7);
    }


}