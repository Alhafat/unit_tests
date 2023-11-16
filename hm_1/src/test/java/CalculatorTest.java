import org.assertj.core.api.Assertions;
import org.example.Calculator;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    public static void main(String[] args) {

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        Assertions.assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        Assertions.assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        Assertions.assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        Assertions.assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

        System.out.println(Calculator.calculateDiscount(2_147_483_647, 1)); // integer overflow
//        System.out.println(Calculator.calculateDiscount());

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 4500.00 == Calculator.calculateDiscount(5_000.00, 10);
        assert 970.00 == Calculator.calculateDiscount(1000.00, 3);
        assert 4950.00 == Calculator.calculateDiscount(5000.00, 5);

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        Assertions.assertThat(Calculator.calculateDiscount(5000.00, 10)).isEqualTo(4500.00);
        Assertions.assertThat(Calculator.calculateDiscount(5000.00, 5)).isEqualTo(4750.00);
        Assertions.assertThat(Calculator.calculateDiscount(5000.00, 1)).isEqualTo(4950.00);

        // Проверка ожидаемого исключения с использованием утверждений AssertJ:
        try {
            double v = Calculator.calculateDiscount(-1.0, -1);
        } catch (ArithmeticException e) {
            assertThatThrownBy(() ->
                    Calculator.calculateDiscount(0, -1)).isInstanceOf(ArithmeticException.class);
        }
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(10, -5)).isInstanceOf(ArithmeticException.class);
    }
}