package com.ioc.example.task2;

public class DatabaseOperation {

    private String url;

    private String username;

    private String password;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void saveData(String vehicleName) {
        System.out.println(
                "Database operation saved for " + vehicleName + '\n' +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\n');
    }
}
