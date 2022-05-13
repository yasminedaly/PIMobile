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
import com.mycompany.myapp.entities.HotelChain;
import com.mycompany.myapp.entities.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class HotelChainService {

    public ArrayList<Product> hc;
    public static HotelChainService instance;

    public boolean resultOK;
    private ConnectionRequest req;

    public HotelChainService() {
        req = new ConnectionRequest();

    }

    public static HotelChainService getInstance() {
        if (instance == null) {
            instance = new HotelChainService();
        }
        return instance;

    }

    public boolean addHC(Product t) {

        //String url = Statics.BASE_URL+"/Formation/"+F.getId()+"/"+F.getNom()+"/"+F.getDescription()+"/"+F.getImage()+"/"+F.getPrix()+"/"+F.getDatede()+"/"+F.getDatefin();
        //String url = Statics.BASE_URL+"/formmattionAddCommande/new?nom="+F.getNom()+"&description="+F.getDescription()+"&datede="+F.getDatede()+"&prix="+F.getPrix();
        String url = Statics.BASE_URL + "/admin/product/AddProductMobile?" + "name=" + t.getName()+ "&" + "ref=" + t.getRef()+ "&" + "state=" + "&" + "description=" + t.getDescription()+ "&" + "review=" + t.getReview()+ "&" + "price=" + t.getPrice()+  "&" + "state=" + t.getState()+ "&"+   "supplier=" + t.getSupplier_id(); //création de l'URL

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

    public ArrayList<Product> parseHC(String jsonText) {
        try {
            hc = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> FormationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) FormationsListJson.get("root");
            for (Map<String, Object> obj : list) {
                Product t = new Product();
                float id = Float.parseFloat(obj.get("id").toString());
                                t.setId((int)id);

                t.setName(obj.get("name").toString());
                t.setDescription(((obj.get("description").toString())));
                float price = Float.parseFloat(obj.get("price").toString());
                //  t.setPrice(price);
                t.setPrice((int)price);
                
                


                hc.add(t);

            }

        } catch (IOException ex) {

        }
        return hc;
    }

    public ArrayList<Product> getAllHC() {
        //String url = Statics.BASE_URL+"/Categories/";
        String url = Statics.BASE_URL + "/admin/product/DisplayAllProductsMobile";
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

    public boolean deleteHC(Product t) {
        //  String url = Statics.BASE_URL + "/hotelchain/delete/?idHotelchain="+t.getId_HotelChain()+"";
        String url = "http://127.0.0.1:8000/admin/product/DeleteMobile?id=" + t.getId();
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

    public boolean editHC(Product t) {
                String url = Statics.BASE_URL + "/admin/product/UpdateMobile?id=" + t.getId() + "&name=" + t.getName();

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
    public boolean deleteEvent(int idHotelchain) {
        String url = Statics.BASE_URL + "/hotelchain/delete/" + idHotelchain;

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Product> listEvenements;

    //***********Recherche***********************
    public ArrayList<Product> Recherche(int idHotelchain) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/hotelchain/Hotelchain/" + idHotelchain);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                HotelChainService ser = new HotelChainService();
                listEvenements = ser.parseHC(new String(con.getResponseData()));
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
