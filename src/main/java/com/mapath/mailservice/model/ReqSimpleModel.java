package com.mapath.mailservice.model;

/**
 * Created by ulongx on 2017/2/17.
 */
public class ReqSimpleModel {

    private String name;
    private String emialAddress;
    private String state;
    private String category;
    private String phoneNumber;
    private String projectContext;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmialAddress() {
        return emialAddress;
    }

    public void setEmialAddress(String emialAddress) {
        this.emialAddress = emialAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProjectContext() {
        return projectContext;
    }

    public void setProjectContext(String projectContext) {
        this.projectContext = projectContext;
    }
}
