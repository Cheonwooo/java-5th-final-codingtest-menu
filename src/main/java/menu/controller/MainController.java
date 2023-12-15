package menu.controller;

import static menu.constant.SystemMessage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.constant.SystemMessage;
import menu.constant.WeekDay;
import menu.domain.MenuReader;
import menu.domain.RecommendMenu;
import menu.model.Coach;
import menu.model.Menu;
import menu.model.Recommend;
import menu.model.RecommendResult;
import menu.service.InputViewService;
import menu.view.OutputView;

public class MainController {

    RecommendMenu recommendMenu = new RecommendMenu();
    MenuReader menuReader = new MenuReader();
    InputViewService inputViewService = new InputViewService();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.print(START_RECOMMEND.getMessage());
        List<String> coachNames = inputViewService.getCoachNames();
        List<Coach> coaches = getCoachAndDislikeMenus(coachNames);
        List<Menu> menus = getCategoryAndMenu();
        recommendByDay(coaches, menus);
        getRecommendResult(coaches);
    }

    public List<Coach> getCoachAndDislikeMenus(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coach : coachNames) {
            List<String> dislikeMenus = inputViewService.getDislikeMenus(coach);
            coaches.add(new Coach(coach, dislikeMenus));
        }
        return coaches;
    }

    public List<Menu> getCategoryAndMenu() {
        return menuReader.getCategoryAndMenu();
    }

    public void recommendByDay(List<Coach> coaches, List<Menu> menus) {
        for(WeekDay weekDay : WeekDay.values()) {
            recommendMenu.recommend(weekDay, coaches, menus);
        }
    }

    public void getRecommendResult(List<Coach> coaches) {
        outputView.print(RECOMMEND_RESULT.getMessage());
        outputView.print(WeekDay.getDayWeekInfo());
        outputView.print(getCategoryByDay());
        outputView.print(getRecommendMenu(coaches).toString());
        outputView.print(COMPLETE_RECOMMEND.getMessage());
    }

    public StringBuilder getRecommendMenu(List<Coach> coaches) {
        StringBuilder sb = new StringBuilder();

        for (Coach coach : coaches) {
            List<String> recommendMenus = new ArrayList<>();
            List<Recommend> menus = recommendMenu.getRecommendResult().get(coach);
            for (Recommend menu : menus) {
                recommendMenus.add(menu.getRecommendMenu());
            }
            sb.append("[ ").append(coach).append(" | ").append(String.join(" | ", recommendMenus))
                    .append(" ]").append("\n");
        }
        return sb;
    }

    public String getCategoryByDay() {
        Map<String, String> map = recommendMenu.getCategoryByDay();
        List<String> categories = new ArrayList<>();
        for (WeekDay weekDay : WeekDay.values()) {;
            String category = map.get(weekDay.getDay());
            categories.add(category);
        }
        return "[ 카테고리 | " + String.join(" | ", categories) + " ]";
    }
}
