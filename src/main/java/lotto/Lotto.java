package lotto;

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

    public Lotto(List<Integer> numbers) {
        validateCntNumber(numbers);
        validateCheckDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateCntNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            exceptionHandler.foolExceaption("lottoLength");
        }
    }

    // TODO: 추가 기능 구현
    private void validateCheckDuplicate(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-1).equals(numbers.get(i))) {
                exceptionHandler.foolExceaption("lottoDuplicate");
            }
        }
    }
}
