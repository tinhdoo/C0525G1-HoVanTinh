package case_study.model;

public class Food {
    private int id;
    private String name;
    private String category;
    private double pricePerPerson;

    public Food(int id, String name, String category, double pricePerPerson){
        this.id = id;
        this.name = name;
        this.category = category;
        this.pricePerPerson = pricePerPerson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-20s | %-15s | %10.2f |", id, name, category, pricePerPerson);
    }
}
