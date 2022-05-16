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
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Teams;
import com.mycompany.myapp.entities.HotelChain;
import com.mycompany.myapp.services.HotelChainService;
import com.mycompany.myapp.services.TeamsService;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class AddTeamForm extends BaseForm {

    public AddTeamForm(Form previous) {

        getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            previous.showBack();
        });

        setTitle("Create New");
        setLayout(BoxLayout.y());
        setLayout(BoxLayout.y());
        TextField tfName = new TextField("", "team_name");
        tfName.setUIID("TextFieldBlack1");
        // addStringValue("",tfName);

        TextField tfTag = new TextField("", "team_tag");
        tfTag.setUIID("TextFieldBlack2");
        //addStringValue("",tfTag);

        TextField tfMail = new TextField("", "team_mail");
        tfMail.setUIID("TextFieldBlack3");
        //addStringValue("",tfDesc);

        TextField tfReg = new TextField("", "team_reg");
        tfReg.setUIID("TextFieldBlack4");
        //addStringValue("",tfReg);

        

        Button btnValider = new Button("Add Team ");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length() == 0) || (tfTag.getText().length() == 0)   || (tfMail.getText().length() == 0)|| (tfReg.getText().length() == 0)) {
                    Dialog.show("alert", "All fields should be filled", new Command("Ok"));
                } else {
                    
                       MultipartRequest cr = new MultipartRequest();
            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInifiniteBlocking();
            cr.setDisposeOnCompletion(dlg);
            NetworkManager.getInstance().addToQueueAndWait(cr);
                    
                    try {

                        Teams t = new Teams(tfName.getText(), tfTag.getText(), tfMail.getText(), tfReg.getText());
                        System.out.println(t);
                        t.toString();
                        System.out.print("data hc === " + t);

                        // TeamsService.getInstance().addTeam(t);
                        if (new TeamsService().addTeam(t)) {
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }

                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", " id must be a number", new Command("OK"));
                    }
                }
            }
        });
        addAll(tfName, tfTag, tfMail,tfReg, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

}
