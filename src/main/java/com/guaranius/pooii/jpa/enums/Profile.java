package com.guaranius.pooii.jpa.enums;

public enum Profile {
    ADM("Adm"),
    USER("User");

    private String profile;

    private Profile (String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
