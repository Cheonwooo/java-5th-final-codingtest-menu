package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.constant.Category;
import menu.model.Menu;
import menu.util.ResourceReader;

public class MenuReader {

    ResourceReader resourceReader = new ResourceReader();

    public List<Menu> getCategoryAndMenu() {
        List<Menu> menus = new ArrayList<>();
        for (Category category : Category.values()) {
            List<String> menu = resourceReader.readResource(category.getFilePath());
            menus.add(new Menu(category.getCategoryName(), menu));
        }
        return menus;
    }

}
