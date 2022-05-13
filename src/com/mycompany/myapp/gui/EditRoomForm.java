/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.mycompany.myapp.entities.HotelRoom;
import com.mycompany.myapp.services.RoomService;
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
public class EditRoomForm extends Form {

    public EditRoomForm(Form previous, HotelRoom t) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddAgence, on peut y revenir
        en utilisant le bouton back
         */
        setTitle("Modifier room " + t.getNbrRoom() + "");
        setLayout(BoxLayout.y());

        //try {
        // Image ban = Image.createImage("file://C:\\Users\\21628\\Desktop\\Mobile\\Final\\src\\Attraction\\Images\\banner.jpg").scaledHeight(1000);
        //add(ban);
        //} catch (IOException ex) {
        //}
        //Button logos= new Button("Image");
        TextField tfType = new TextField(t.getRoom_Type());
        tfType.setUIID("TextFieldBlack");
        TextField tfCapacity = new TextField(t.getRoom_capacity());
        tfCapacity.setUIID("TextFieldBlack");
        TextField tfNbr = new TextField(t.getNbrRoom());
        tfNbr.setUIID("TextFieldBlack");
        TextField tfPrice = new TextField(t.getPrice());
        tfPrice.setUIID("TextFieldBlack");

        Button btnValider = new Button("Update");

        CheckBox multiSelect = new CheckBox("Multi-select");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfType.getText().length() == 0) || (tfCapacity.getText().length() == 0) || (tfNbr.getText().length() == 0) || (tfPrice.getText().length() == 0)) {
                    Dialog.show("Alert", "Fill the fields !", new Command("OK"));
                } else {
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    // int staff = Integer.parseInt(tfStaff.getText());

                    t.setRoom_Type(tfType.getText());
                    tfType.setUIID("TextFieldBlack");
                    t.setRoom_capacity(tfCapacity.getText());
                    tfCapacity.setUIID("TextFieldBlack");
                    t.setNbrRoom(tfNbr.getText());
                    tfNbr.setUIID("TextFieldBlack");
                    t.setPrice(tfPrice.getText());
                    tfPrice.setUIID("TextFieldBlack");

                    if (RoomService.getInstance().editHR(t)) {
                        iDialog.dispose();
                        Dialog.show("Success", "room updated", new Command("OK"));
                        previous.showBack();
                    } else {
                        iDialog.dispose();
                        Dialog.show("ERROR", "Erreur", new Command("OK"));
                    }
                }

            }
        });

        addAll(tfType, tfCapacity, tfNbr, tfPrice, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                 e -> previous.showBack()); // Revenir vers l'interface précédente

    }

}
