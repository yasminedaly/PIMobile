/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.mycompany.myapp.entities.HotelChain;
import com.mycompany.myapp.services.HotelChainService;
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
import com.mycompany.myapp.entities.Product;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Lenovo
 */
public class EditHCForm extends Form {

    public EditHCForm(Form previous, Product t) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddAgence, on peut y revenir
        en utilisant le bouton back
         */
        setTitle("Modifier HC " + t.getName()+ "");
        setLayout(BoxLayout.y());

        //try {
        // Image ban = Image.createImage("file://C:\\Users\\21628\\Desktop\\Mobile\\Final\\src\\Attraction\\Images\\banner.jpg").scaledHeight(1000);
        //add(ban);
        //} catch (IOException ex) {
        //}
        //Button logos= new Button("Image");
        TextField tfName = new TextField(t.getName());
        tfName.setUIID("TextFieldBlack");
        
        Button btnValider = new Button("Modifier");

        CheckBox multiSelect = new CheckBox("Multi-select");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length() == 0) ) {
                    Dialog.show("Alert", "Fill the fields !", new Command("OK"));
                } else {
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    // int staff = Integer.parseInt(tfStaff.getText());

                    t.setName(tfName.getText());
                    tfName.setUIID("TextFieldBlack");
                    /*t.setHotelChain_Staff(tfStaff.getText());
                    tfStaff.setUIID("TextFieldBlack");
                    t.setHotelChain_Description(tfDesc.getText());
                    tfDesc.setUIID("TextFieldBlack");
                    t.setPhone(tfPhone.getText());
                    tfPhone.setUIID("TextFieldBlack");*/

                    if (HotelChainService.getInstance().editHC(t)) {
                        iDialog.dispose();
                        Dialog.show("Success", "Hotel Chain updated", new Command("OK"));
                        //previous.showBack();
                    } else {
                        iDialog.dispose();
                        Dialog.show("ERROR", "Erreur", new Command("OK"));
                    }
                }

            }
        });

        addAll(tfName, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                 e -> previous.showBack()); // Revenir vers l'interface précédente

    }

}
