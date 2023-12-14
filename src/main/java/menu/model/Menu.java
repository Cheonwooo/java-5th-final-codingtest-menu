package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;

public class Menu {

    private final String category;
    private final List<String> menu;

    public Menu(String category, List<String> menu) {
        this.category = category;
        this.menu = menu;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getRecommendMenu() {
        List<String> shuffledMenu = Randoms.shuffle(menu);
//        System.out.println(menu.size());

        return shuffledMenu.get(0);
    }
}
