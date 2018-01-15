package com.example.ishu.repairproject;

/**
 * Created by ishu on 1/11/2018.
 */
public class Company {
    public String cname,clocation,ctimmings;


    public Company(String cname, String clocation, String ctimmings) {
        this.cname = cname;
        this.clocation = clocation;
        this.ctimmings = ctimmings;
    }

    public String getCname() {
        return cname;
    }

    public String getClocation() {
        return clocation;
    }

    public String getCtimmings() {
        return ctimmings;
    }
}
