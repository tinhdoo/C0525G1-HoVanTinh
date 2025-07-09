package case_study.model;

public class Table {
    private int id;
    private int numberOfGuests;
    private String status;

    public Table(){};
    public Table(int id, int numberOfGuests, String status){
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.status = status;
    }

    public Table(int id, int numberOfGuests) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", numberOfGuests=" + numberOfGuests +
                ", status='" + status + '\'' +
                '}';
    }
}
