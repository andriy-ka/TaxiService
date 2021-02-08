package andriy.kachur.model;

public class Car {
    private int id;
    private int places;
    private String model;
    private String category;
    private String state;

    public Car(){}

    public Car(String model, String category, String state, int places) {
        this.places = places;
        this.model = model;
        this.category = category;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", places=" + places +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
