/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author LENOVO
 */
public class Hotel {

    private int id_Hotel;
    private String hotel_Name;
    private String hotel_Staff;
    private String hotel_Location;
    private String hotel_Phone;
    private String hotel_Description;
    private String hotel_Img;
    private HotelChain hotelChain;
    private int id_HotelChain;
    private String hotelChain_name;

    public Hotel(int id_Hotel, String hotel_Name) {
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
    }

    public Hotel(int id_Hotel, String hotel_Name, String hotel_Staff, String hotel_Location, String hotel_Phone, String hotel_Description, int id_HotelChain) {
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
        this.hotel_Staff = hotel_Staff;
        this.hotel_Location = hotel_Location;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Description = hotel_Description;
        this.id_HotelChain = id_HotelChain;

    }

    public Hotel(String hotel_Name, String hotel_Staff, String hotel_Location, String hotel_Phone, String hotel_Description, int id_HotelChain, String hotelChain_name) {
        this.hotel_Name = hotel_Name;
        this.hotel_Staff = hotel_Staff;
        this.hotel_Location = hotel_Location;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Description = hotel_Description;
        this.id_HotelChain = id_HotelChain;
        this.hotelChain_name = hotelChain_name;

    }

    public Hotel(String hotel_Name, String hotel_Staff, String hotel_Location, String hotel_Phone, String hotel_Description, String hotelChain_name) {
        this.hotel_Name = hotel_Name;
        this.hotel_Staff = hotel_Staff;
        this.hotel_Location = hotel_Location;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Description = hotel_Description;
        this.hotelChain_name = hotelChain_name;

    }

    public Hotel(int id_Hotel) {
        this.id_Hotel = id_Hotel;
    }

    public Hotel(int id_Hotel, String hotel_Name, String hotel_Staff, String hotel_Location, String hotel_Phone, String hotel_Description) {
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
        this.hotel_Staff = hotel_Staff;
        this.hotel_Location = hotel_Location;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Description = hotel_Description;
        //  this.hotel_Img = hotel_Img;
        //this.id_HotelChain = HotelChain.getId_HotelChain();
    }

    public Hotel(String hotel_Name, String hotel_Staff, String hotel_Location, String hotel_Phone, String hotel_Description, HotelChain hotelChain) {
        this.hotel_Name = hotel_Name;
        this.hotel_Staff = hotel_Staff;
        this.hotel_Location = hotel_Location;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Description = hotel_Description;
        this.hotelChain = hotelChain;
        //  this.hotel_Img = hotel_Img;
        //this.id_HotelChain = HotelChain.getId_HotelChain();
    }

    public Hotel(String hotel_Name, String hotel_Staff, String hotel_Location, String hotel_Phone, String hotel_Description) {
        this.hotel_Name = hotel_Name;
        this.hotel_Staff = hotel_Staff;
        this.hotel_Location = hotel_Location;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Description = hotel_Description;
        //  this.hotel_Img = hotel_Img;
        //this.id_HotelChain = HotelChain.getId_HotelChain();
    }

    public Hotel(int id_Hotel, String hotel_Name, String hotel_Staff, String hotel_Location, String hotel_Phone, String hotel_Description, String hotel_Img, HotelChain hotelChain) {
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
        this.hotel_Staff = hotel_Staff;
        this.hotel_Location = hotel_Location;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Description = hotel_Description;
        this.hotel_Img = hotel_Img;
        this.id_HotelChain = hotelChain.getId_HotelChain();
    }

    public Hotel(String hotel_Name, String hotel_Staff, String hotel_Location, String hotel_Phone, String hotel_Description, int id_HotelChain) {
        this.hotel_Name = hotel_Name;
        this.hotel_Staff = hotel_Staff;
        this.hotel_Location = hotel_Location;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Description = hotel_Description;
        this.id_HotelChain = id_HotelChain;
    }

    public Hotel(String hotel_name) {
        this.hotel_Name = hotel_name;
    }

    public Hotel() {

    }

    public Hotel(int i, int id_HotelChain, String hotelChain_name, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Hotel{"
                + "id_Hotel=" + id_Hotel
                + ", hotel_Name='" + hotel_Name + '\''
                + ", hotel_Staff='" + hotel_Staff + '\''
                + ", hotel_Location='" + hotel_Location + '\''
                + ", hotel_Phone='" + hotel_Phone + '\''
                + ", hotel_Description='" + hotel_Description + '\''
                + ", hotel_Img='" + hotel_Img + '\''
                + ", hotelChain='" + hotelChain + '\''
                + '}';
    }

    public int getId_Hotel() {
        return id_Hotel;
    }

    public void setId_Hotel(int id_Hotel) {
        this.id_Hotel = id_Hotel;
    }

    public String getHotel_Name() {
        return hotel_Name;
    }

    public void setHotel_Name(String hotel_Name) {
        this.hotel_Name = hotel_Name;
    }

    public String getHotel_Staff() {
        return hotel_Staff;
    }

    public void setHotel_Staff(String hotel_Staff) {
        this.hotel_Staff = hotel_Staff;
    }

    public String getHotel_Location() {
        return hotel_Location;
    }

    public void setHotel_Location(String hotel_Location) {
        this.hotel_Location = hotel_Location;
    }

    public String getHotel_Phone() {
        return hotel_Phone;
    }

    public void setHotel_Phone(String hotel_Phone) {
        this.hotel_Phone = hotel_Phone;
    }

    public String getHotel_Description() {
        return hotel_Description;
    }

    public void setHotel_Description(String hotel_Description) {
        this.hotel_Description = hotel_Description;
    }

    public String getHotel_Img() {
        return hotel_Img;
    }

    public void setHotel_Img(String hotel_Img) {
        this.hotel_Img = hotel_Img;
    }

    public HotelChain getHotelChain() {
        return hotelChain;
    }

    public void setHotelChain(HotelChain hotelChain) {
        this.hotelChain = hotelChain;
    }

    public int getId_HotelChain() {
        return id_HotelChain;
    }

    public void setId_HotelChain(int id_HotelChain) {
        this.id_HotelChain = id_HotelChain;
    }

}
