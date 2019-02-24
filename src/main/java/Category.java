public class Category {
    int id;
    String category;
    int priority;

    public Category(int id, String category, int priority) {
        this.id = id;
        this.category = category;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", priority=" + priority +
                '}';
    }
}
