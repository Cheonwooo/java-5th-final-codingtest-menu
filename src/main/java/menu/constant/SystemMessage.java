package menu.constant;

public enum SystemMessage {

    START_RECOMMEND("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_DISLIKE_MENU("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    RECOMMEND_RESULT("메뉴 추천 결과입니다."),
    COMPLETE_RECOMMEND("추천을 완료했습니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
