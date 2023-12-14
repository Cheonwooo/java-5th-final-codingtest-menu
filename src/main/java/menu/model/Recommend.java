package menu.model;

public class Recommend {

    private final String day;
    private final String recommendMenu;

    public Recommend(String day, String recommendMenu) {
        this.day = day;
        this.recommendMenu = recommendMenu;
    }

    public String getRecommendMenu() {
        return recommendMenu;
    }
}
