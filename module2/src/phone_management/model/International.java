package phone_management.model;

public class International extends Phone{
    private String country;
    private String status;

    public International(int id, String name, double price, int quantity, String manufacturer, String country, String status) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.status = status;
    }

    public International(String country, String status) {
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "International{" +
                "country='" + country + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
