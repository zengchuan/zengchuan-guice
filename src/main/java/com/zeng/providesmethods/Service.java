package com.zeng.providesmethods;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Service {

    private String name;

    public Service() {
    }

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
