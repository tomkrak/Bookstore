package bookstore;

class Category {
    private int id;
    private String categoryName;
    private int priority;

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

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
