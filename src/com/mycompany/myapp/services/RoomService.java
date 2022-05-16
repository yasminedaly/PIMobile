/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.mycompany.myapp.utils.Statics;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Teams;
import com.mycompany.myapp.entities.HotelRoom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class RoomService {

    public ArrayList<HotelRoom> h;
    public static RoomService instance;

    public boolean resultOK;
    private ConnectionRequest req;

    public RoomService() {
        req = new ConnectionRequest();

    }

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;

    }

    public boolean addHR(HotelRoom t) {

        //String url = Statics.BASE_URL+"/Formation/"+F.getId()+"/"+F.getNom()+"/"+F.getDescription()+"/"+F.getImage()+"/"+F.getPrix()+"/"+F.getDatede()+"/"+F.getDatefin();
        //String url = Statics.BASE_URL+"/formmattionAddCommande/new?nom="+F.getNom()+"&description="+F.getDescription()+"&datede="+F.getDatede()+"&prix="+F.getPrix();
        String url = Statics.BASE_URL + "/room/add?" + "roomType=" + t.getRoom_Type() + "&" + "roomCapacity=" + t.getRoom_capacity() + "&" + "nbrroom=" + t.getNbrRoom() + "&" + "price=" + t.getPrice() + "&" + "fkHotel=" + t.getId_Hotel()+"&"+"image=" + t.getImage()+""; //création de l'URL

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseCodeListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;

    }

    public ArrayList<HotelRoom> parseR(String jsonText) {
        try {
            h = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> FormationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) FormationsListJson.get("root");
            for (Map<String, Object> obj : list) {
                HotelRoom t = new HotelRoom();
                float id = Float.parseFloat(obj.get("idRoom").toString());
                t.setId_Room((int) id);
                t.setRoom_Type(obj.get("roomType").toString());
                t.setRoom_capacity(((obj.get("roomCapacity").toString())));
                t.setNbrRoom(((obj.get("nbrroom").toString())));
                t.setPrice(((obj.get("price").toString())));

                h.add(t);

            }

        } catch (IOException ex) {

        }
        return h;
    }

    public ArrayList<HotelRoom> getAllHR() {
        //String url = Statics.BASE_URL+"/Categories/";
        String url = Statics.BASE_URL + "/room/liste";
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                h = parseR(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return h;
    }

    public boolean deleteHR(HotelRoom t) {
        String url = "http://127.0.0.1:8000/room/del?idRoom=" + t.getId_Room() + "";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean editHR(HotelRoom t) {
        String url = Statics.BASE_URL + "/room/modifier/updateJSON?idRoom=" + t.getId_Room() + "&roomType=" + t.getRoom_Type() + "&roomCapacity=" + t.getRoom_capacity() + "&nbrroom=" + t.getNbrRoom() + "&price=" + t.getPrice() + "";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    /*  public ArrayList<HotelChain>orderByStaff(){
         //String url = Statics.BASE_URL+"/Categories/";
        String url = Statics.BASE_URL +"/HotelChain/orderByStaff";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                hc = parseHC(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return hc;
    }
     */
    public ArrayList<HotelRoom> listEvenements;

    //***********Recherche***********************
    public ArrayList<HotelRoom> Recherche(int idRoom) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/" + idRoom);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                RoomService ser = new RoomService();
                listEvenements = ser.parseR(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }

    /**
     * *
     */
    /*
    public ArrayList<Formation> parseTasks(String jsonText){
        try {
            Formations =new ArrayList<>();  
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Formation v = new Formation();
                float id = Float.parseFloat(obj.get("id").toString());
                v.setId((int)id);
                v.setNom(obj.get("Dest").toString());
                v.setDescription(obj.get("NomVoy").toString());
                //v.setDuree_Voyage(obj.get("Duree").toString());
                v.setPrix((int) obj.get("Prix"));
               // v.setValabilite(obj.get("Valabilite").toString());
                //v.setImage(obj.get("image").toString());
              Formations.add(v);
            }
            
            
        } catch (IOException ex) {
            
        }
        return Formations;
    }
    * 
    * */
}
