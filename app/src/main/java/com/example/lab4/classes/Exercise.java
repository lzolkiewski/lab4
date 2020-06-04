package com.example.lab4.classes;

import java.util.ArrayList;

public class Exercise {
    private String exerciseName;
    private ArrayList<Series>seriesArrayList;

    public Exercise(String exerciseName, ArrayList<Series> seriesArrayList) {
        this.exerciseName = exerciseName;
        this.seriesArrayList = seriesArrayList;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public ArrayList<Series> getSeriesArrayList() {
        return seriesArrayList;
    }

    public void setSeriesArrayList(ArrayList<Series> seriesArrayList) {
        this.seriesArrayList = seriesArrayList;
    }
}
