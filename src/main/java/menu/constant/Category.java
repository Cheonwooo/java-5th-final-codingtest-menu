package menu.constant;

public enum Category {

    JAPAN("일식", "src/main/java/resources/japan.md", 1),
    KOREA("한식", "src/main/java/resources/korea.md", 2),
    CHINESE("중식", "src/main/java/resources/chinese.md", 3),
    ASIAN("아시안", "src/main/java/resources/asian.md", 4),
    WESTERN("양식", "src/main/java/resources/western.md", 5);

    private final String categoryName;
    private final String filePath;
    private final int categoryNumber;

    Category(String categoryName, String filePath, int categoryNumber) {
        this.categoryName = categoryName;
        this.filePath = filePath;
        this.categoryNumber = categoryNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public static String findCategory(int randomIndex) {
        for(Category category : Category.values()) {
            if(category.getCategoryNumber() == randomIndex) {
                return category.getCategoryName();
            }
        }
        throw new IllegalArgumentException();
    }



}
