/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.HotelRoom;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public class HomeForm extends BaseForm {

    Form current;
    String search;
    private Resources theme;

    public HomeForm(Resources res) {
        super("Home", BoxLayout.y());

        Resources res1 = null;
        current = this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        // super.addSideMenu(res);
        Image img = res.getImage("back.png");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);

        add(LayeredLayout.encloseIn(
                sl
        ));
        Button clientRoom = new Button("list Rooms");

        //Button btnAddFormation = new Button("add Hotel Chain");
        Button btnListFormation = new Button("list Hotel Chain");
        Button btnAddHotel = new Button("add Hotel");
        Button btnListHotels = new Button("list Hotels");

        //Button btnAddRoom = new Button("add Room");
        Button btnListRoom = new Button("list Rooms");

        //Button btnRecherche=new Button("Recherche");
        Button map = new Button("map");
        Button stat = new Button("Statistique");

        //map.addActionListener(e -> new MapGoogleForm(theme, current));

        //btnAddFormation.addActionListener(e -> new AddHCForm(current).show());
        btnListFormation.addActionListener(e -> new ListHCForm(current).show());
        //btnAddHotel.addActionListener(e -> new AddHotelForm(current).show());
        btnListHotels.addActionListener(e -> new ListHotelForm(current).show());
        //btnAddRoom.addActionListener(e -> new AddRoomForm(current).show());
        btnListRoom.addActionListener(e -> new ListeRoomForm(current).show());
        stat.addActionListener(e -> new StatPieForm(current).show());
        clientRoom.addActionListener(e -> new ListRoomsClientForm(current).show());

        addAll( btnListFormation, btnListHotels, btnListRoom, map, stat);

    }

}
