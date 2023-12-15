package menu.domain;

import static menu.constant.NumberConstant.MAX_RANDOM_NUMBER_INDEX;
import static menu.constant.NumberConstant.MIN_RANDOM_NUMBER_INDEX;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;

public class CategoryGenerator {

    public String generateCategory() {
        int randomIndex = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER_INDEX.getValue(), MAX_RANDOM_NUMBER_INDEX.getValue());
        return Category.findCategory(randomIndex);
    }
}
