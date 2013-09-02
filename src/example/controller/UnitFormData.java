package example.controller;

import java.util.Map;

public class UnitFormData {

    private String name;

    private Map<Long, String> units;

    public Map<Long, String> getAgeGroups() {
        return units;
    }

    public void setAgeGroups(Map<Long, String> units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
