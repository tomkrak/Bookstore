package bookstore;

class Category {
    private final int id;
    private final String categoryName;
    private final int priority;

    public Category(int id, String categoryName, int priority) {
        this.id = id;
        this.categoryName = categoryName;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "bookstore.Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", priority=" + priority +
                '}';
    }
}
