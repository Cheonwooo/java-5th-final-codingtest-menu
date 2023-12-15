package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RecommendResult {

    private final Map<String, String> categoryByDay = new ConcurrentHashMap<>();
    private final Map<Coach, List<String>> alreadyRecommend = new ConcurrentHashMap<>();
    private final Map<Coach, List<Recommend>> recommendResult = new HashMap<>();

    public void saveCategoryByDay(String day, String category) {
        categoryByDay.put(day, category);
    }

    public void saveRecommendMenu(Coach coach, Recommend recommend) {
        List<Recommend> recommends = recommendResult.getOrDefault(coach, new ArrayList<>());
        recommends.add(recommend);
        recommendResult.put(coach, recommends);
    }

    public boolean checkAlreadyRecommend(Coach coach, String recommendMenu) {
        List<String> menus = alreadyRecommend.getOrDefault(coach, new ArrayList<>());
        if (menus.contains(recommendMenu)) {
            return true;
        }
        menus.add(recommendMenu);
        alreadyRecommend.put(coach, menus);
        return false;
    }

    public Map<String, String> getCategoryByDayMap() {
        return categoryByDay;
    }

    public Map<Coach, List<Recommend>> getRecommendResult() {
        return recommendResult;
    }
}
