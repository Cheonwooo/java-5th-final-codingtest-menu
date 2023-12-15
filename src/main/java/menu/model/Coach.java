package menu.model;

import java.util.List;
import java.util.Objects;

public class Coach {

    private final String coach;
    private final List<String> dislikeMenus;

    public Coach(String coach, List<String> dislikeMenus) {
        this.coach = coach;
        this.dislikeMenus = dislikeMenus;
    }

    public boolean checkDislikeMenu(String recommendMenu) {
        if(dislikeMenus.contains(recommendMenu)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return coach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach selection = (Coach) o;
        return Objects.equals(coach, selection.coach) &&
                Objects.equals(dislikeMenus, selection.dislikeMenus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach, dislikeMenus);
    }
}
