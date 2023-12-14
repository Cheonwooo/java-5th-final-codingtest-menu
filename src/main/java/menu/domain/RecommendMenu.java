package menu.domain;

import java.util.List;
import java.util.Map;
import menu.constant.Category;
import menu.constant.WeekDay;
import menu.model.CategoryCount;
import menu.model.Coach;
import menu.model.Menu;
import menu.model.Recommend;
import menu.model.RecommendResult;

public class RecommendMenu {

    CategoryGenerator categoryGenerator = new CategoryGenerator();
    CategoryCount categoryCount = new CategoryCount();
    RecommendResult recommendResult = new RecommendResult();

    public void recommend(WeekDay weekDay, List<Coach> coaches, List<Menu> menus) {
        String day = weekDay.getDay();
        String category = categoryGenerator.generateCategory();
        category = checkCategoryCount(category);
        for(Coach coach : coaches) {
            recommendResult.saveCategoryByDay(day, category);
            String recommendMenu = getRecommendMenu(category, menus);
            recommendMenu = checkAlreadyRecommend(coach, recommendMenu, menus, category);
            recommendMenu = checkDislikeMenu(coach, recommendMenu, menus, category);
            Recommend recommend = new Recommend(day, recommendMenu);
            recommendResult.saveRecommendMenu(coach, recommend);
        }
    }

    public String getRecommendMenu(String category, List<Menu> menus) {
        for(Menu menu : menus) {
            if(category.equals(menu.getCategory())) {
                return menu.getRecommendMenu();
            }
        }
        throw new IllegalArgumentException();
    }

    public String checkCategoryCount(String category) {
        while(!categoryCount.isSaveCategory(category)) {
            category = categoryGenerator.generateCategory();
            categoryCount.isSaveCategory(category);
        }
        return category;
    }

    public String checkAlreadyRecommend(Coach coach, String recommendMenu, List<Menu> menus, String category) {
        while(recommendResult.checkAlreadyRecommend(coach, recommendMenu)) {
            recommendMenu = getRecommendMenu(category, menus);
            recommendResult.checkAlreadyRecommend(coach,recommendMenu);
        }
        return recommendMenu;
    }

    public String checkDislikeMenu(Coach coach, String recommendMenu, List<Menu> menus, String category) {
        while(coach.checkDislikeMenu(recommendMenu)) {
            recommendMenu = getRecommendMenu(category, menus);
            coach.checkDislikeMenu(recommendMenu);
        }
        return recommendMenu;
    }

    public Map<String, String> getCategoryByDay() {
        return recommendResult.getCategoryByDayMap();
    }

    public Map<Coach, List<Recommend>> getRecommendResult() {
        return recommendResult.getRecommendResult();
    }

}
