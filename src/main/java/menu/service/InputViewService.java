package menu.service;

import static menu.constant.SystemMessage.INPUT_COACH_NAMES;
import static menu.constant.SystemMessage.INPUT_DISLIKE_MENU;

import java.util.List;
import menu.view.InputView;
import menu.view.OutputView;

public class InputViewService {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public List<String> getCoachNames() {
        try {
            outputView.print(INPUT_COACH_NAMES.getMessage());
            List<String> coaches = inputView.getCoachNames();
            return coaches;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getCoachNames();
        }
    }

    public List<String> getDislikeMenus(String coach) {
        try {
            outputView.print(String.format(INPUT_DISLIKE_MENU.getMessage(), coach));
            List<String> dislikeMenus = inputView.getDislikeMenus();
            return dislikeMenus;
        } catch(IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getDislikeMenus(coach);
        }
    }
}
