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
import com.mycompany.myapp.entities.Hotel;
import com.mycompany.myapp.entities.HotelChain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class HotelService {

    public ArrayList<Hotel> h;
    public static HotelService instance;

    public boolean resultOK;
    private ConnectionRequest req;

    public HotelService() {
        req = new ConnectionRequest();

    }

    public static HotelService getInstance() {
        if (instance == null) {
            instance = new HotelService();
        }
        return instance;

    }

    public boolean addH(Hotel t) {

        //String url = Statics.BASE_URL+"/Formation/"+F.getId()+"/"+F.getNom()+"/"+F.getDescription()+"/"+F.getImage()+"/"+F.getPrix()+"/"+F.getDatede()+"/"+F.getDatefin();
        //String url = Statics.BASE_URL+"/formmattionAddCommande/new?nom="+F.getNom()+"&description="+F.getDescription()+"&datede="+F.getDatede()+"&prix="+F.getPrix();
        String url = Statics.BASE_URL + "/hotel/add?" + "hotelName=" + t.getHotel_Name() + "&" + "hotelStaff=" + t.getHotel_Staff() + "&" + "hotelLocation=" + t.getHotel_Location() + "&" + "hotelPhone=" + t.getHotel_Phone() + "&" + "hotelDescription=" + t.getHotel_Description() + "&" + "fkHotelchain=" + t.getId_HotelChain() + "&"+"hotelImg="+t.getHotel_Img()+""; //création de l'URL

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

    public ArrayList<Hotel> parseH(String jsonText) {
        try {
            h = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> FormationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) FormationsListJson.get("root");
            for (Map<String, Object> obj : list) {
                Hotel t = new Hotel();
                float id = Float.parseFloat(obj.get("idHotel").toString());
                t.setId_Hotel((int) id);
                t.setHotel_Name(obj.get("hotelName").toString());
                t.setHotel_Staff(((obj.get("hotelStaff").toString())));
                t.setHotel_Location(obj.get("hotelLocation").toString());
                t.setHotel_Phone(obj.get("hotelPhone").toString());
                t.setHotel_Description(obj.get("hotelDescription").toString());

                h.add(t);

            }

        } catch (IOException ex) {

        }
        return h;
    }

    public ArrayList<Hotel> getAllH() {
        //String url = Statics.BASE_URL+"/Categories/";
        String url = Statics.BASE_URL + "/hotel/mobile/liste";
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                h = parseH(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return h;
    }

    public boolean deleteH(Hotel t) {
        String url = "http://127.0.0.1:8000/hotel/delete/delJSON?idHotel=" + t.getId_Hotel() + "";
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

    public boolean editH(Hotel t) {
        String url = Statics.BASE_URL + "/hotel/modifier/updateJSON?idHotel=" + t.getId_Hotel() + "&hotelName=" + t.getHotel_Name() + "&hotelStaff=" + t.getHotel_Staff() + "&hotelLocation=" + t.getHotel_Location() + "&hotelPhone=" + t.getHotel_Phone() + "&hotelDescription=" + t.getHotel_Description() + "";
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
    public ArrayList<Hotel> listEvenements;

    //***********Recherche***********************
    public ArrayList<Hotel> Recherche(int idHotelchain) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/hotelchain/Hotelchain/" + idHotelchain);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                HotelService ser = new HotelService();
                listEvenements = ser.parseH(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }

    public boolean deletedVoyage(int id) {

        String url = Statics.BASE_URL + "/hotelchain/delete/idHotelchain" + id + "";
        req.setUrl(url);
        req.setPost(true);
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

    /**
     * *
     */
    public boolean UpdateVoyage(HotelChain F, int idHotelchain) {
        String url = Statics.BASE_URL + "/hotelchain/mod/" + idHotelchain + "?&hotelchainName=" + F.getHotelChain_name() + "&hotelchainStaff=" + F.getHotelChain_Staff() + "&hotelchainDescription=" + F.getHotelChain_Description() + "&phone=" + F.getPhone();
        //  String url = Statics.BASE_URL + "create";
        req.setUrl(url);
        req.addResponseListener((e) -> {
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            String str = new String(req.getResponseData());
            System.out.println("data" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
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
