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
public class Book {

    private String StartDate;
    private String endDate;
    private int idUser;
    private int idRoom;
    private int idHotel;
    private int idHotelChain;
    private int idBook;

    public Book() {
    }

    public Book(int idBook, int idUser, int idRoom, int idHotel, int idHotelChain, String StartDate, String endDate) {
        this.idBook = idBook;
        this.idUser = idUser;
        this.idRoom = idRoom;
        this.idHotel = idHotel;
        this.idHotelChain = idHotelChain;
        this.StartDate = StartDate;
        this.endDate = endDate;
    }

    public Book(String StartDate, String endDate, int idUser, int idRoom, int idHotel, int idHotelChain) {
        this.StartDate = StartDate;
        this.endDate = endDate;
        this.idUser = idUser;
        this.idRoom = idRoom;
        this.idHotel = idHotel;
        this.idHotelChain = idHotelChain;
    }

    public Book(String StartDate, String endDate, int idUser, int idRoom, int idHotel) {
        this.StartDate = StartDate;
        this.endDate = endDate;
        this.idUser = idUser;
        this.idRoom = idRoom;
        this.idHotel = idHotel;
    }

    public Book(int idBook, int idUser, int idRoom, int idHotel, String StartDate, String endDate) {
        this.idBook = idBook;
        this.idUser = idUser;
        this.idRoom = idRoom;
        this.idHotel = idHotel;
        this.StartDate = StartDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdHotelChain() {
        return idHotelChain;
    }

    public void setIdHotelChain(int idHotelChain) {
        this.idHotelChain = idHotelChain;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    @Override
    public String toString() {
        return "Rent{" + "StartDate=" + StartDate + ", endDate=" + endDate + ", idUser=" + idUser + ", idRoom=" + idRoom + ", idHotel=" + idHotel + ", idHotelChain=" + idHotelChain + ", idBook=" + idBook + '}';
    }

}
