package com.example.tasklist.metier;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Task implements Serializable {

    private int id;
    private String title;
    private Date date;

    public Task(int i, String t, Date d){
        this.id = i;
        this.title = t;
        this.date = d;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date);
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }

    public String getTitle() {
        return title;
    }
}
