package com.rest.webservices.restfulwebservices;

import java.util.Date;
import java.util.Objects;


class Todo {
    private long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isdone;
    private long todoscount;


    public Todo(long id, String username, String description, Date targetDate, boolean isdone, long todoscount) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isdone = isdone;
        this.todoscount = todoscount;
    }
    
    public long getTodo() {
        return this.todoscount;
    }

    public void setTodo(long todoscount) {
        this.todoscount = todoscount;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return this.targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isIsdone() {
        return this.isdone;
    }

    public boolean getIsdone() {
        return this.isdone;
    }

    public void setIsdone(boolean isdone) {
        this.isdone = isdone;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Todo)) {
            return false;
        }
        Todo todo = (Todo) o;
        return id == todo.id && Objects.equals(username, todo.username) && Objects.equals(description, todo.description) && Objects.equals(targetDate, todo.targetDate) && isdone == todo.isdone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, description, targetDate, isdone);
    }


    
    
}
