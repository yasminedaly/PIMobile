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

public class Teams {
     int id;
    private String team_name,team_tag,team_mail, team_reg,team_logo;

    public Teams() {
    }

    public Teams(String team_name, String team_tag, String team_mail, String team_reg) {
        this.team_name = team_name;
        this.team_tag = team_tag;
        this.team_mail = team_mail;
        this.team_reg = team_reg;
    }

    public int getTeamid() {
        return id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getTeam_tag() {
        return team_tag;
    }

    public String getTeam_mail() {
        return team_mail;
    }

    public String getTeam_reg() {
        return team_reg;
    }

    public String getTeam_logo() {
        return team_logo;
    }

    public void setTeamid(int teamid) {
        this.id = teamid;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public void setTeam_tag(String team_tag) {
        this.team_tag = team_tag;
    }

    public void setTeam_mail(String team_mail) {
        this.team_mail = team_mail;
    }

    public void setTeam_reg(String team_reg) {
        this.team_reg = team_reg;
    }

    public void setTeam_logo(String team_logo) {
        this.team_logo = team_logo;
    }

    @Override
    public String toString() {
        return "Teams{" + "id=" + id + ", team_name=" + team_name + ", team_tag=" + team_tag + ", team_mail=" + team_mail + ", team_reg=" + team_reg + ", team_logo=" + team_logo + '}';
    }

 

    

    
   
    
    
    
}