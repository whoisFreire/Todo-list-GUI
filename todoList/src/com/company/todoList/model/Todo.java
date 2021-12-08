package com.company.todoList.model;

public class Todo {
    private String description;
    private boolean done = false;

    public boolean getDone() {
        return done;
    }

    public String getDescription() {
        return description;
    }

    public void create(String e){
        description = e;
    }

    public void isDone(){
        done = true;
    }
}
