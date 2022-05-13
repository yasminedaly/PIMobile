/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 * @author LENOVO
 */
public class HotelChain {

    private int id_HotelChain;
    public String hotelChain_name;
    private String hotelChain_Staff;
    private String hotelChain_Description;
    private String phone;

    public HotelChain() {

    }

    public HotelChain(int id_HotelChain) {
        this.id_HotelChain = id_HotelChain;
    }

    public HotelChain(String hotelChain_name) {
        this.hotelChain_name = hotelChain_name;
    }

    public HotelChain(int id_HotelChain, String hotelChain_name, String hotelChain_Staff, String hotelChain_Description, String phone) {
        this.id_HotelChain = id_HotelChain;
        this.hotelChain_name = hotelChain_name;
        this.hotelChain_Staff = hotelChain_Staff;
        this.hotelChain_Description = hotelChain_Description;
        this.phone = phone;
    }

    public HotelChain(String hotelChain_name, String hotelChain_Staff, String hotelChain_Description, String phone) {
        this.hotelChain_name = hotelChain_name;
        this.hotelChain_Staff = hotelChain_Staff;
        this.hotelChain_Description = hotelChain_Description;
        this.phone = phone;
    }

    public HotelChain(int id_HotelChain, String hotelChain_name, String hotelChain_Staff, String hotelChain_Description) {
        this.id_HotelChain = id_HotelChain;
        this.hotelChain_name = hotelChain_name;
        this.hotelChain_Staff = hotelChain_Staff;
        this.hotelChain_Description = hotelChain_Description;
    }

    public HotelChain(int id_HotelChain, String hotelChain_name) {
        this.id_HotelChain = id_HotelChain;
        this.hotelChain_name = hotelChain_name;
    }

    public HotelChain(String hotelChain_name, String hotelChain_Staff, String hotelChain_Description) {
        this.hotelChain_name = hotelChain_name;
        this.hotelChain_Staff = hotelChain_Staff;
        this.hotelChain_Description = hotelChain_Description;
    }

    @Override
    public String toString() {
        return "HotelChain{"
                + "id_HotelChain=" + id_HotelChain
                + ", hotelChain_name='" + hotelChain_name + '\''
                + ", hotelChain_Staff='" + hotelChain_Staff + '\''
                + ", hotelChain_Description='" + hotelChain_Description + '\''
                + '}';
    }

    public int getId_HotelChain() {
        return id_HotelChain;
    }

    public void setId_HotelChain(int id_HotelChain) {
        this.id_HotelChain = id_HotelChain;
    }

    public String getHotelChain_name() {
        return hotelChain_name;
    }

    public void setHotelChain_name(String hotelChain_name) {
        this.hotelChain_name = hotelChain_name;
    }

    public String getHotelChain_Staff() {
        return hotelChain_Staff;
    }

    public void setHotelChain_Staff(String hotelChain_Staff) {
        this.hotelChain_Staff = hotelChain_Staff;
    }

    public String getHotelChain_Description() {
        return hotelChain_Description;
    }

    public void setHotelChain_Description(String hotelChain_Description) {
        this.hotelChain_Description = hotelChain_Description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
