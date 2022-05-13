/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.HotelChain;
import com.mycompany.myapp.entities.Product;
import com.mycompany.myapp.services.HotelChainService;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public class AddHCForm extends BaseForm {

    public AddHCForm(Form previous) {

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
        TextField tfName = new TextField("", "Product name");
        tfName.setUIID("TextFieldBlack");
        // addStringValue("",tfName);

        TextField tfRef = new TextField("", "Ref");
        tfRef.setUIID("TextFieldBlack");
        //addStringValue("",tfStaff);

        TextField tfDesc = new TextField("", "Description");
        tfDesc.setUIID("TextFieldBlack");
        //addStringValue("",tfDesc);

        TextField tfPrice = new TextField("", "price");
        tfPrice.setUIID("TextFieldBlack");
        //addStringValue("",tfPhone);

        TextField tfReview = new TextField("", "review");
        tfReview.setUIID("TextFieldBlack");
        //addStringValue("",tfPhone);
        
        TextField tfState = new TextField("", "state");
        tfState.setUIID("TextFieldBlack");
        //addStringValue("",tfPhone);
        
        TextField tfsupplier_id = new TextField("", "supplier_id");
        tfsupplier_id.setUIID("TextFieldBlack");
        //addStringValue("",tfPhone);
        
        
        Button btnValider = new Button("Add Hotel Chain");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length() == 0) || (tfRef.getText().length() == 0) || (tfDesc.getText().length() == 0) || (tfPrice.getText().length() == 0)) {
                    Dialog.show("alert", "please fill all the fields", new Command("Ok"));
                } else {
                    try {

                        Product t = new Product(
                                tfName.getText(),
                                Integer.parseInt(tfRef.getText()) , 
                                tfDesc.getText(), 
                                Integer.parseInt(tfReview.getText()),
                                Integer.parseInt(tfPrice.getText()),
                                tfState.getText(), 
                                Integer.parseInt(tfsupplier_id.getText()));
                        System.out.print("data hc === " + t);

                        HotelChainService.getInstance().addHC(t);

                        if (new HotelChainService().addHC(t)) {
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        } else {
                            Dialog.show("ERRor", "Server error", new Command("OK"));
                        }

                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", " id must be a number", new Command("OK"));
                    }
                }
            }
        });
        addAll(tfName, tfsupplier_id, tfDesc, tfState, tfPrice,tfReview,tfRef,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

}
