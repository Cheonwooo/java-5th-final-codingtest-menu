package menu.constant;

public enum NumberConstant {

    MIN_NAME_LENGTH(2),
    MAX_NAME_LENGTH(4),
    MIN_COACH_COUNT(2),
    MAX_COACH_COUNT(5),
    MAX_DISLIKE_COUNT(2),
    MIN_RANDOM_NUMBER_INDEX(1),
    MAX_RANDOM_NUMBER_INDEX(5),
    MAX_CATEGORY_COUNT(2);

    private final int value;

    NumberConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
