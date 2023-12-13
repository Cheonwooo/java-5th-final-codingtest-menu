package menu.util;

import static menu.constant.ErrorMessage.*;
import static menu.constant.NumberConstant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidation {

    public List<String> validateCoachNames(String input) {
        validateNull(input);
        validateSeparator(input);
        String[] names = input.split(",");
        List<String> coaches = new ArrayList<>(Arrays.asList(names));
        validateCoachName(coaches);
        validateNameLength(coaches);
        validateCoachCount(coaches);

        return coaches;
    }

    public List<String> validateDislikeMenus(String input) {
        validateSeparator(input);
        String[] menus = input.split(",");
        List<String> dislikeMenus = new ArrayList<>(Arrays.asList(menus));
        validateDislikeCount(dislikeMenus);

        return dislikeMenus;
    }

    public void validateNull(String input) {
        if(!input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL.getMessage());
        }
    }

    public void validateSeparator(String input) {
        String deleteBlank = input.replaceAll(" ", "");
        String deleteCharacter = deleteBlank.replaceAll("[0-9a-zA-Zㄱ-ㅎ-가-힣,]", "");
        if(!deleteCharacter.isEmpty()) {
            throw new IllegalArgumentException(INPUT_CORRECT_SEPARATOR.getMessage());
        }
    }

    public void validateCoachName(List<String> coaches) {
        for(String name : coaches) {
            String deleteCharacter = name.replaceAll("[가-힣a-zA-Z]", "");
            if (!deleteCharacter.isEmpty()) {
                throw new IllegalArgumentException(INPUT_EXACTLY_WORDS.getMessage());
            }
        }
    }

    public void validateNameLength(List<String> coaches) {
        for(String name : coaches) {
            if(name.length() < MIN_NAME_LENGTH.getValue() || name.length() > MAX_NAME_LENGTH.getValue()) {
                throw new IllegalArgumentException(String.format(LIMIT_COACH_LENGTH.getMessage(), MIN_NAME_LENGTH.getValue(), MAX_NAME_LENGTH.getValue()));
            }
        }
    }

    public void validateCoachCount(List<String> coaches) {
        if(coaches.size() < MIN_COACH_COUNT.getValue() || coaches.size() > MAX_COACH_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format(LIMIT_COACH_COUNT.getMessage(), MIN_COACH_COUNT.getValue(), MAX_COACH_COUNT.getValue()));
        }
    }

    public void validateDislikeCount(List<String> dislikeMenus) {
        if(dislikeMenus.size() > MAX_DISLIKE_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format(LIMIT_DISLIKE_COUNT.getMessage(), MAX_DISLIKE_COUNT.getValue()));
        }
    }

}
