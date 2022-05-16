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
import com.mycompany.myapp.entities.HotelRoom;
import com.mycompany.myapp.services.HotelChainService;
import com.mycompany.myapp.services.TeamsService;
import com.mycompany.myapp.services.RoomService;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class AddRoomForm extends BaseForm {

    public AddRoomForm(Form previous) {

        getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            previous.showBack();
        });
        setTitle("add a new");
        setLayout(BoxLayout.y());

        ComboBox<Teams> cb = new ComboBox();
        TeamsService AGG = new TeamsService();
        ArrayList<Teams> list = AGG.getAllTeams();

        for (int i = 0; i < list.size(); i++) {
            cb.addItem(list.get(i));
        }

        TextField tfType = new TextField("", "Room Type");
        tfType.setUIID("TextFieldBlack");
        // addStringValue("",tfName);

        TextField tfCapacity = new TextField("", "Room Capacity");
        tfCapacity.setUIID("TextFieldBlack");
        //addStringValue("",tfStaff);

        TextField tfNbr = new TextField("", "Room Number");
        tfNbr.setUIID("TextFieldBlack");
        //addStringValue("",tfDesc);

        TextField tfPrice = new TextField("", "Price");
        tfPrice.setUIID("TextFieldBlack");
        //addStringValue("",tfPhone);
        CheckBox multiSelect = new CheckBox("Multi-select");

        Button btnValider = new Button("Add Hotel Room");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfType.getText().length() == 0) || (tfCapacity.getText().length() == 0) || (tfNbr.getText().length() == 0) || (tfPrice.getText().length() == 0)) {
                    Dialog.show("alert", "please fill all the fields", new Command("Ok"));
                } else {
                        MultipartRequest cr = new MultipartRequest();
            String filePath = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);

            cr.setUrl(Statics.BASE_URL+"/room/mobile/uploadImg");
            cr.setPost(true);
            String mime = "image/"+filePath.substring(filePath.lastIndexOf(".")+1);
            try {
                cr.addData("file", filePath, mime);
            } catch (IOException ex) {
                Dialog.show("Error", ex.getMessage(), "OK", null);
            }
            cr.setFilename("file",filePath.substring(filePath.lastIndexOf("/")));//any unique name you want
            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInifiniteBlocking();
            cr.setDisposeOnCompletion(dlg);
            NetworkManager.getInstance().addToQueueAndWait(cr);
                    try {

//                        Teams t = new Teams(tfName.getText(), tfCapacity.getText(), tfNbr.getText(), tfPrice.getText());
//                        t.setImage(filePath.substring(filePath.lastIndexOf("/")).substring(1));
//
//                        t.setId_Hotel(cb.getSelectedItem().setTeamid(CENTER));
//
//                        System.out.print("data hc === " + t);
//
//                        // RoomService.getInstance().addHR(t);
//                        if (new RoomService().addHR(t)) {
//                            Dialog.show("Success", "Connection accepted", new Command("OK"));
//                        } else {
//                            Dialog.show("ERRor", "Server error", new Command("OK"));
//                        }

                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", " id must be a number", new Command("OK"));
                    }
                }
            }
        });
        addAll(tfType, tfCapacity, tfNbr, tfPrice, cb, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

}
