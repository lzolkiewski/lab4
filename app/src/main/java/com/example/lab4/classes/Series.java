package com.example.lab4.classes;

public class Series {
    private Integer id;
    private String weight;
    private String repetitions;

    public Series(Integer id, String weight, String repetitions) {
        this.id = id;
        this.weight = weight;
        this.repetitions = repetitions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(String repetitions) {
        this.repetitions = repetitions;
    }
}
