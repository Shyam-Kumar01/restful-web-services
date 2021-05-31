package com.rest.webservices.restfulwebservices;

public class TodoArray {

    private long arrcounter;
    private String name;

    public TodoArray(long arrcounter,  String name) {
        this.arrcounter = arrcounter;
        this.name = name;
    }

    public long getArrcounter() {
        return this.arrcounter;
    }

    public void setArrcounter(long arrcounter) {
        this.arrcounter = arrcounter;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
}
