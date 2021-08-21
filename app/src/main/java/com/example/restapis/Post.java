package com.example.restapis;

public class Post {
    private String name;
    private int age;
    private String address;

    public Post(String name,int age,String address){
        this.name=name;
        this.age=age;
        this.address=address;
    }
    public  String getName(){
        return  this.name;
    }
    public  String getAddress(){
        return  this.address;
    }
    public  int getAge(){
        return  this.age;
    }

}
