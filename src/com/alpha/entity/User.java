/*
  Created by:oumar
  Project:MyBatis
  Name:entity
  Date: 7/16/2021
  Time: 5:12 PM
*/
package com.alpha.entity;

public class User
{
    private int id;
    private String fullName;
    private String email;
    private String gender;
    private String mobile;
    private String country;
    private String address;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
