package menu.constant;

public enum ErrorMessage {

    ERROR("[ERROR] "),
    INPUT_NULL(ERROR.getMessage() + "입력값을 확인하세요."),
    INPUT_CORRECT_SEPARATOR(ERROR.getMessage() + "쉼표(,)를 사용하여 입력해야 합니다."),
    INPUT_EXACTLY_WORDS(ERROR.getMessage() + "한글 및 영어만 사용하여 입력해야 합니다."),
    LIMIT_COACH_LENGTH(ERROR.getMessage() + "코치 이름은 최소 %d글자 최대 %d글자로 입력해야 합니다."),
    LIMIT_COACH_COUNT(ERROR.getMessage() + "코치는 최소 %d명 최대 %d명을 입력해야 합니다."),
    LIMIT_DISLIKE_COUNT(ERROR.getMessage() + "못 먹는 메뉴는 최대 %d개 까지 입력해야 합니다."),
    CATEGORY_CONTAIN_MENU(ERROR.getMessage() + "카테고리에 없는 메뉴를 입력했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
