package com.example.milogin.Logic;

import java.io.Serializable;
import java.util.Objects;

public class Job implements Serializable {

    private int id;
    private String description;

    public Job(int id, String description){
        this.id = id;
        this.description = description;
    }

    public Job(){
        this(0,"");
    }

    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getDescription().equals(job.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }
}
