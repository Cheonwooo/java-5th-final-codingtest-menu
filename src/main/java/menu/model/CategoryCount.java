package menu.model;

import java.util.HashMap;
import java.util.Map;
import menu.constant.Category;

public class CategoryCount {

    private final int MAX_COUNT_CATEGORY = 2;
    private final Map<String, Integer> categoryCount = new HashMap<>();

    public boolean isSaveCategory(String category) {
        categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        if(categoryCount.get(category) > MAX_COUNT_CATEGORY) {
            categoryCount.put(category, categoryCount.get(category) - 1);
            return false;
        }
        return true;
    }
}
