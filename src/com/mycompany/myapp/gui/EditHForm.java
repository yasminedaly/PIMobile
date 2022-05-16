/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.mycompany.myapp.entities.Teams;
import com.mycompany.myapp.services.TeamsService;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Lenovo
 */
public class EditHForm extends Form {

    public EditHForm(Form previous, Teams t) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddAgence, on peut y revenir
        en utilisant le bouton back
         */
        setTitle("Update Team " + t.getTeam_name()+ "");
        setLayout(BoxLayout.y());

        TextField tfName = new TextField("", "Team name");
        tfName.setUIID("TextFieldBlack");
        // addStringValue("",tfName);

        TextField tfTag = new TextField("", "Tag");
        tfTag.setUIID("TextFieldBlack");
        //addStringValue("",tfTag);

        TextField tfMail = new TextField("", "Mail");
        tfMail.setUIID("TextFieldBlack");
        //addStringValue("",tfDesc);

        TextField tfReg = new TextField("", "Region");
        tfReg.setUIID("TextFieldBlack");

        Button btnValider = new Button("Update");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               if ((tfName.getText().length() == 0) || (tfTag.getText().length() == 0)  || (tfMail.getText().length() == 0) || (tfReg.getText().length() == 0)){
                    Dialog.show("Alert", "You Should fill all the fields!", new Command("OK"));
                } else {
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    // int staff = Integer.parseInt(tfStaff.getText());

                    t.setTeam_name(tfName.getText());
                    tfName.setUIID("TextFieldBlack");
                    t.setTeam_tag(tfTag.getText());
                    tfTag.setUIID("TextFieldBlack");
                    t.setTeam_mail(tfMail.getText());
                    tfMail.setUIID("TextFieldBlack");

                    t.setTeam_reg(tfReg.getText());
                    tfReg.setUIID("TextFieldBlack");
                    

                    if (TeamsService.getInstance().editTeam(t)) {
                        iDialog.dispose();
                        Dialog.show("Success", "Team updated!", new Command("OK"));
                        previous.showBack();
                    } else {
                        iDialog.dispose();
                        Dialog.show("ERROR", "Erreur", new Command("OK"));
                    }
                }

            }
        });

        addAll(tfName, tfTag, tfMail, tfReg, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                 e -> previous.showBack()); 

    }

}
