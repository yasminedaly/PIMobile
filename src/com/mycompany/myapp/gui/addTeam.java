/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entities.Teams;
import com.mycompany.myapp.services.TeamsService;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class addTeam extends Form {

    Form current;
    Form res;

    //Ressources res;
    public addTeam(Form previous) {
        current = this;

        TeamsService sp = new TeamsService();
        add(new InfiniteProgress());
        Display.getInstance().scheduleBackgroundTask(() -> {

            Display.getInstance().callSerially(() -> {
               
                removeAll();
                setLayout(BoxLayout.y());
        Button btnAddTeam = new Button("add Team");
        btnAddTeam.addActionListener(e -> new AddTeamForm(current).show());
        addAll(btnAddTeam);
             
                Button search = new Button("Search");
                add(search);

                Style s = UIManager.getInstance().getComponentStyle("Title");

                Form hi = new Form("Toolbar", new BoxLayout(BoxLayout.Y_AXIS));
                search.addActionListener(e -> {
                    hi.show();
                });
                Button gui_Button_12 = new Button();
                gui_Button_12.setText("Search");
                gui_Button_12.setUIID("Label");
                gui_Button_12.setName("Button_12");
                FontImage.setMaterialIcon(gui_Button_12, FontImage.MATERIAL_CIRCLE);
                TextField searchField = new TextField("", "Toolbar Search"); // <1>
                searchField.getHintLabel().setUIID("Team Name");
                searchField.setUIID("Team Name");
                searchField.getAllStyles().setAlignment(Component.LEFT);
                hi.getToolbar().setTitleComponent(searchField);
                FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
                ArrayList<Teams> list1;
                list1 = TeamsService.getInstance().getAllTeams();
                //hi.add(gui_Button_12);
                searchField.addDataChangeListener((i1, i2) -> { // <2>
                    String t = searchField.getText();

                    if (t.length() < 1) {
                        for (Component cmp : hi.getContentPane()) {
                            cmp.setHidden(false);
                            cmp.setVisible(true);
                        }
                    } else {
                        t = t.toLowerCase();
                        for (Component cmp : hi.getContentPane()) {
                            String val = null;
                            //hi.add(gui_Button_12);
                            if (cmp instanceof Label) {
                                val = ((Label) cmp).getText();
                            } else {
                                if (cmp instanceof TextArea) {
                                    val = ((TextArea) cmp).getText();
                                } else {
                                    val = (String) cmp.getPropertyValue("text");
                                }
                            }
                            boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
                            cmp.setHidden(!show); // <3>
                            cmp.setVisible(show);
                            //hi.add(gui_Button_12);
                        }
                    }
                    hi.getContentPane().animateLayout(250);
                    //  hi.add(gui_Button_12);
                });
                hi.getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
                    searchField.startEditingAsync(); // <4>
                    //    hi.add(gui_Button_12);
                });
                for (Teams recc : list1) {
                    Label b = new Label(recc.getTeam_name());
                    hi.add(b);

                    b.addPointerPressedListener(e -> {

                        if (recc.getTeam_name() == b.getText()) {
                            new formasearch1(current, recc).show();
                        }
                    });
                }
                Button trie = new Button("Refresh");

                trie.addActionListener(e -> new addTeam(current).show());
                add(trie);

                List<Teams> listerec = sp.getAllTeams();
                for (Teams p : listerec) {
                    MultiButton m = new MultiButton();
                    m.setTextLine1("Name: " + p.getTeam_name());
                    m.setTextLine2("Tag: " + p.getTeam_tag());

                    add(m);

                    m.addPointerReleasedListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (Dialog.show("Confirmation", "What do you want?", "Delete", "Update")) {

                                if (TeamsService.getInstance().deleteTeam(p)) {
                                    {
                                        Dialog.show("Success", "Team " + p.getTeam_name() + " is deleted !! ", new Command("OK"));
                                        previous.showBack();
                                    }
                                }
                            } else {

                                EditHForm t = new EditHForm(current, p);
                                t.show();
                            }
                        }
                    }
                    );
                }

                revalidate();
            });
        });
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

}
