/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

/**
 *
 * @author LENOVO
 */
public class HotelRoom {

    public int id_Room;
    public String room_capacity;
    private String room_Type;
    public boolean isEmpty;
    private Hotel hotel;
    private int id_Hotel;
    private String hotel_Name;
    private String nbrRoom;
    private String price;
    private String image; 

    public HotelRoom() {
    }

    public HotelRoom(int id_Room, String room_capacity, String room_Type, boolean isEmpty, int id_Hotel, String hotel_Name, String nbrRoom) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
        this.nbrRoom = nbrRoom;
    }

    
    
    public HotelRoom(int id_Room, String room_capacity, String room_Type, boolean isEmpty, int id_Hotel, String hotel_Name, String nbrRoom, String price) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
        this.nbrRoom = nbrRoom;
        this.price = price;
    }

    
    public HotelRoom(int id_Room, String room_capacity, String room_Type, boolean isEmpty, int id_Hotel, String hotel_Name, String nbrRoom, String price, String image) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
        this.nbrRoom = nbrRoom;
        this.price = price;
        this.image = image; 
    }
    
    
    public HotelRoom(String room_capacity, String room_Type, boolean isEmpty, int id_Hotel, String hotel_Name, String nbrRoom) {
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
        this.nbrRoom = nbrRoom;
    }

    public HotelRoom(String room_capacity, String room_Type, boolean isEmpty, int id_Hotel, String hotel_Name, String nbrRoom, String price) {
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
        this.nbrRoom = nbrRoom;
        this.price = price;
    }

    public HotelRoom(String room_capacity, String room_Type, boolean isEmpty, String hotel_Name, String nbrRoom) {
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.hotel_Name = hotel_Name;
        this.nbrRoom = nbrRoom;
    }

    public HotelRoom(int id_Room, String room_capacity, String room_Type, boolean isEmpty, int id_Hotel, String hotel_Name) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.id_Hotel = id_Hotel;
        this.hotel_Name = hotel_Name;
    }

    public HotelRoom(String room_capacity, String room_Type, String hotel_Name) {
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.hotel_Name = hotel_Name;
    }

    public HotelRoom(int id_Room, String room_capacity, String room_Type, boolean isEmpty, int id_Hotel) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.id_Hotel = id_Hotel;
    }

    public HotelRoom(int id_Room, String room_capacity, String room_Type, boolean isEmpty, String hotel_Name) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.hotel_Name = hotel_Name;
    }

    public HotelRoom(int id_Room, String room_capacity, String room_Type, boolean isEmpty) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
    }

    public HotelRoom(int id_Room, String room_capacity, String room_Type, int id_Hotel) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.id_Hotel = id_Hotel;
    }

    public HotelRoom(String room_Type, String room_capacity, String nbrRoom, int id_Hotel) {
        this.room_Type = room_Type;
        this.room_capacity = room_capacity;
        this.nbrRoom = nbrRoom;
        this.id_Hotel = id_Hotel;

    }

    public HotelRoom(int id_Room, String room_capacity, String room_Type, boolean isEmpty, String nbrRoom, int id_Hotel) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
        this.nbrRoom = nbrRoom;
        this.id_Hotel = id_Hotel;

    }

    public HotelRoom(String room_capacity, String room_Type, int id_Hotel) {
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.id_Hotel = id_Hotel;
    }

    public HotelRoom(String room_capacity, String room_Type, boolean isEmpty) {
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;
        this.isEmpty = isEmpty;
    }

    public HotelRoom(String room_capacity, String room_Type) {
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;

    }

    public HotelRoom(int id_Room) {
        this.id_Room = id_Room;
    }

    public HotelRoom(int id_Room, String room_capacity, String room_Type) {
        this.id_Room = id_Room;
        this.room_capacity = room_capacity;
        this.room_Type = room_Type;

    }

    public HotelRoom(String room_Type, String room_capacity, String price, String nbrRoom) {
        this.room_Type = room_Type;
        this.room_capacity = room_capacity;
        this.nbrRoom = nbrRoom;
        this.price = price;

    }

    @Override
    public String toString() {
        return "HotelRoom{" + "id_Room=" + id_Room + ", room_capacity=" + room_capacity + ", room_Type=" + room_Type + ", isEmpty=" + isEmpty + ", id_Hotel=" + id_Hotel + ", hotel_Name=" + hotel_Name + ", nbrRoom=" + nbrRoom + ", price=" + price + ", image=" + image + '}';
    }

   

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId_Room() {
        return id_Room;
    }

    public void setId_Room(int id_Room) {
        this.id_Room = id_Room;
    }

    public String getRoom_capacity() {
        return room_capacity;
    }

    public void setRoom_capacity(String room_capacity) {
        this.room_capacity = room_capacity;
    }

    public String getRoom_Type() {
        return room_Type;
    }

    public void setRoom_Type(String room_Type) {
        this.room_Type = room_Type;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public int getId_Hotel() {
        return id_Hotel;
    }

    public void setId_Hotel(int id_Hotel) {
        this.id_Hotel = id_Hotel;
    }

    public String getNbrRoom() {
        return nbrRoom;
    }

    public void setNbrRoom(String nbrRoom) {
        this.nbrRoom = nbrRoom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
