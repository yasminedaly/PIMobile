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
import com.mycompany.myapp.entities.HotelChain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class TeamsService {

    public ArrayList<Teams> h;
    public static TeamsService instance;

    public boolean resultOK;
    private ConnectionRequest req;

    public TeamsService() {
        req = new ConnectionRequest();

    }

    public static TeamsService getInstance() {
        if (instance == null) {
            instance = new TeamsService();
        }
        return instance;

    }

    public boolean addTeam(Teams team) {
        System.out.println("trying to add");
        String url = Statics.BASE_URL+"/teams/AddTeamMobile?team_name="+ team.getTeam_name()+"&team_tag=" + team.getTeam_tag()+"&team_mail="+team.getTeam_mail()+"&team_reg="+team.getTeam_reg();
        System.out.println(url);
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
    
    
    public ArrayList<Teams> parseTeam(String jsonText) {
        try {
            h = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> FormationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) FormationsListJson.get("root");
            for (Map<String, Object> obj : list) {
                Teams t = new Teams();
                t.setTeam_name(obj.get("team_name").toString());
                t.setTeam_tag(((obj.get("team_tag").toString())));
                t.setTeam_mail(obj.get("team_mail").toString());
                t.setTeam_reg(obj.get("team_reg").toString());

                h.add(t);

            }

        } catch (IOException ex) {

        }
        return h;
    }

    public ArrayList<Teams> getAllTeams() {
        String url = Statics.BASE_URL+"/teams/DisplayAllTeamsMobile";
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                h = parseTeam(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return h;
    }

    public boolean deleteTeam(Teams t) {
        String url = "http://127.0.0.1:8000/teams/DeleteTeam?id=" + t.getTeamid()+ "";
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

    public boolean editTeam(Teams t) {
        String url = Statics.BASE_URL+"/teams/UpdateTeam?id=" + t.getTeamid()+ "&team_name=" + t.getTeam_name()+ "&team_tag=" + t.getTeam_tag()+ "&team_mail=" + t.getTeam_mail()+ "&team_reg=" + t.getTeam_reg();
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

    public ArrayList<Teams> listEvenements;

    //***********Recherche***********************
    public ArrayList<Teams> Recherche(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/hotelchain/Hotelchain/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                TeamsService ser = new TeamsService();
                listEvenements = ser.parseTeam(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }

    

}
