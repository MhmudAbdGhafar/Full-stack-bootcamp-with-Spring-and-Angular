package com.bean.scopes_lifecycle;

public class DatabaseOperation {

    public void connectToDatabase(){
        System.out.println("Connecting to database...\n");
    }

    public void disconnectFromDatabase(){
        System.out.println("\nDisconnecting from database...");
    }

}
