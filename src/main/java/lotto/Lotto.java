package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int price = 1000;
    private static final ExceptionHandler exceptionHandler = new ExceptionHandler();

    public static int numberOfLottosQuantity(int amountPaid) {
        int lottoQuantity = amountPaid/price;
        if (amountPaid%price != 0) {
            exceptionHandler.foolExceaption("amount");
        }
        return lottoQuantity;
    }

    public Lotto(List<Integer> numbers, int number) {
        validateCntNumber(numbers);
        validateDuplicate(numbers);
        validateNumberCondition(numbers);
        validateBonusDuplicate(numbers, number);
        validateBonusNumberCondition(number);
        Collections.sort(numbers);

        numbers.add(number);
        this.numbers = numbers;
    }

    private void validateCntNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            exceptionHandler.foolExceaption("lottoLength");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-1).equals(numbers.get(i))) {
                exceptionHandler.foolExceaption("lottoDuplicate");
            }
        }
    }

    private void validateNumberCondition(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-1) < 1 || numbers.get(i-1) > 45) {
                exceptionHandler.foolExceaption("lottoCondition");
            }
        }
    }

    private void validateBonusDuplicate(List<Integer> numbers, int number) {
        for (int compareNumber : numbers) {
            if (compareNumber == number) {
                exceptionHandler.foolExceaption("lottoDuplicate");
            }
        }
    }

    private void validateBonusNumberCondition(int number) {
        if (number < 1 || number > 45) {
            exceptionHandler.foolExceaption("lottoCondition");
        }
    }
}
