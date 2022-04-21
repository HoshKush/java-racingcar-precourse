package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_전진() {
        String name = "test";
        Car car = new Car(name);
        car.goForward();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값_기준값_이상_자동차_전진() {
        String name = "test";
        int no = CarProperties.STANDARD;
        Car car = new Car(name);
        car.canGoForward(no);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
