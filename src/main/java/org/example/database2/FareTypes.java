package org.example.database2;

public class FareTypes {
    private String id;
    private String name;
    private String cost;
    private String number_of_journeys;
    private String requirements;

    public FareTypes(){

    }
    public FareTypes(String id, String name, String cost, String number_of_journeys, String requirements) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.number_of_journeys = number_of_journeys;
        this.requirements = requirements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNumber_of_journeys() {
        return number_of_journeys;
    }

    public void setNumber_of_journeys(String number_of_journeys) {
        this.number_of_journeys = number_of_journeys;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}
