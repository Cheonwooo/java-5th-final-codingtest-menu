package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.InputValidation;

public class InputView {

    private InputValidation inputValidation = new InputValidation();

    public List<String> inputCoach() {
        String input = Console.readLine();

        List<String> coaches = inputValidation.validateCoachNames(input);
        return coaches;
    }
}
