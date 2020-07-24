package com.example.dragonfly_main;

public class Species {

    private String species_name;
    private String common_name;
    private String type;

    public Species(String species_name, String common_name,  String type) {
        this.common_name = common_name;
        this.species_name = species_name;
        this.type = type;
    }

    public String getcommon_name() {
        return common_name;
    }

    public void setcommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getspecies_name() {
        return species_name;
    }

    public void setspecies_name(String species_name) {
        this.species_name = species_name;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }
}
