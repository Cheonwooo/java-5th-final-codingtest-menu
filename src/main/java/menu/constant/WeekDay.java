package menu.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum WeekDay {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String day;

    WeekDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public static String getDayWeekInfo() {
        List<String> dayWeekInfo = Arrays.stream(WeekDay.values())
                .map(weekDay -> weekDay.day)
                .collect(Collectors.toList());
        return "[ 구분 | " + String.join(" | ", dayWeekInfo) + " ]";
    }
}
