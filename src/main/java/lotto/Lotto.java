package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.ErrorMsg.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final int price = 1000;

    public static int numberOfLottosQuantity(int amountPaid) {
        String pattern = "^[\\D]*$";
        if (pattern.matches(String.valueOf(amountPaid))) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
        }
        int lottoQuantity = amountPaid/price;
        if (amountPaid%price != 0) {
            throw new IllegalArgumentException(INPUT_AMOUNT.getMessage());
        }
        return lottoQuantity;
    }

    public Lotto(List<Integer> numbers) {
        validateCntNumber(numbers);
        validateDuplicate(numbers);
        validateNumberCondition(numbers);
        Collections.sort(numbers);

        this.numbers = numbers;
    }

    private void validateCntNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INPUT_NUMBER.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-1).equals(numbers.get(i))) {
                throw new IllegalArgumentException(INPUT_NUMBER_DUPLICATE.getMessage());
            }
        }
    }

    private void validateNumberCondition(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-1) < 1 || numbers.get(i-1) > 45) {
                throw new IllegalArgumentException(INPUT_NUMBER_CONDITION.getMessage());
            }
        }
    }
}
