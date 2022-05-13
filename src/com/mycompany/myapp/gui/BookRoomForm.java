/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Book;
import com.mycompany.myapp.entities.Hotel;
import com.mycompany.myapp.entities.HotelRoom;
import com.mycompany.myapp.services.HotelService;
import com.mycompany.myapp.services.RoomService;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class BookRoomForm extends BaseForm {

    public BookRoomForm(Form previous) {

        getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            previous.showBack();
        });

        /*setTitle("add a new");
        setLayout(BoxLayout.y());
        TextField Ffid= new TextField("","formationid");
        TextField Ffnom= new TextField("","formationnom");
        TextField Ffdescription= new TextField("","formationdescription");
        TextField Ffimage= new TextField("","formationimage");
        TextField Ffprix= new TextField("","formationprix");
        TextField Ffdatede= new TextField("","formationdatede");
        TextField Ffdatefin= new TextField("","formationdatede");
        Button btnValider=new Button("Add Formation");
        btnValider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                
                if ((Ffid.getText().length()==0)||(Ffnom.getText().length()==0)||(Ffdescription.getText().length()==0)||(Ffdatede.getText().length()==0)||(Ffdatefin.getText().length()==0) )
                    Dialog.show("alert", "please fill all the fields", new Command("Ok"));
                else
                {
                    try{
                        Formation F =new Formation (Integer.parseInt(Ffid.getText()),Ffnom.getText(),Ffdescription.getText());
                        if (new FormationService().addformation(F)) 
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        else
                            Dialog.show("ERRor", "Server error", new Command("OK"));
                        
                    }catch(NumberFormatException e){
                        Dialog.show("ERROR", " id must be a number", new Command("OK"));
                    }
                    
                }    
                                  
              
            }
            
        });
        addAll(Ffid,Ffnom,Ffdescription,Ffprix,Ffdatede,Ffdatefin,btnValider); 
        
        
        
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack()); */
        setTitle("add a new");
        setLayout(BoxLayout.y());

        TextField tfType = new TextField("", "Start Date");
        tfType.setUIID("TextFieldBlack");
        // addStringValue("",tfName);

        TextField tfCapacity = new TextField("", "End Date");
        tfCapacity.setUIID("TextFieldBlack");
        //addStringValue("",tfStaff);

        Button btnValider = new Button("Add Room Booking");

        //btnValider.addActionListener(new ActionListener(){
        //@Override
        // public void actionPerformed(ActionEvent evt){
        /*  if ((tfType.getText().length()==0)||(tfCapacity.getText().length()==0))
                    Dialog.show("alert", "please fill all the fields", new Command("Ok"));
                else
                {
                    try{
                        
                       //   Book t = new Book(tfType.getText(), tfCapacity.getText());
                         // t.setId_Hotel(cb.getSelectedItem().getId_Hotel());

             //System.out.print("data hc === "+t);
             
            // RoomService.getInstance().addHR(t);
                        
                         if (new RoomService().addHR(t))
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        else
                            Dialog.show("ERRor", "Server error", new Command("OK"));

                    }catch(NumberFormatException e){
                        Dialog.show("ERROR", " id must be a number", new Command("OK"));
                    }
                }
            }
        });
        addAll(tfType,tfCapacity,btnValider);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
        
         */
    }
}
