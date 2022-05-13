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


import com.mycompany.myapp.entities.HotelChain;
import com.mycompany.myapp.services.HotelChainService;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
//import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entities.Product;

//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ListHCForm extends Form {

    Form current;

    public ListHCForm(Form previous) {
        current = this;

        HotelChainService sp = new HotelChainService();
        add(new InfiniteProgress());
        Display.getInstance().scheduleBackgroundTask(() -> {

            Display.getInstance().callSerially(() -> {
                //try {
                //Image ban = Image.createImage("file://C:\\Users\\21628\\Desktop\\Mobile\\Final\\src\\Attraction\\Images\\banner.jpg").scaledHeight(1000);
                // add(ban);
                //} catch (IOException ex) {

                //}
                removeAll();
                setLayout(BoxLayout.y());
                Button btnAddFormation = new Button("add Hotel Chain");
                btnAddFormation.addActionListener(e -> new AddHCForm(current).show());
                addAll(btnAddFormation);
                //Button ttrie =new Button("trie");

                Button search = new Button("Search");
                add(search);
                // ttrie.addActionListener(e-> new ListFormationFormtrie(current).show()); 
                // back = Image.createImage("/logo.png");
                //back.scaled(1000, 1000);
                // add(ttrie);

                Style s = UIManager.getInstance().getComponentStyle("Title");

                Form hi = new Form("Toolbar", new BoxLayout(BoxLayout.Y_AXIS));
                search.addActionListener(e -> {
                    hi.show();
                });
                Button gui_Button_12 = new Button();
                gui_Button_12.setText("search");
                gui_Button_12.setUIID("Label");
                gui_Button_12.setName("Button_12");
                FontImage.setMaterialIcon(gui_Button_12, FontImage.MATERIAL_CIRCLE);
                
                        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

                TextField searchField = new TextField("", "Toolbar Search"); // <1>
                searchField.getHintLabel().setUIID("Title");

                searchField.setUIID("Title");
                searchField.getAllStyles().setAlignment(Component.LEFT);
                hi.getToolbar().setTitleComponent(searchField);
                FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
                ArrayList<Product> list1;
                list1 = HotelChainService.getInstance().getAllHC();
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
                for (Product rec : list1) {
                    Label b = new Label("name:" + rec.getName());
                    

                    hi.add(b);
                    

                    b.addPointerPressedListener(e -> {

                        if (rec.getName()== b.getText() ) {
                            //new formasearch(current, rec).show();
                            
                        }
                    });
                }

                Button trie = new Button("Actualiser");
                trie.addActionListener(e -> new ListHCForm(current).show());
                add(trie);

                List<Product> listerec = sp.getAllHC();
                for (Product p : listerec) {
                    MultiButton m = new MultiButton();
                    m.setTextLine1("Name: " + p.getName());
                    m.setTextLine2("description: " + p.getDescription());
                    m.setTextLine3("price: " + p.getPrice());
                    m.setTextLine4("ID : " + p.getId());

                    add(m);

                    m.addPointerReleasedListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (Dialog.show("Confirmation", "What do you want?", "Delete", "Update")) {

                                if (HotelChainService.getInstance().deleteHC(p)) {
                                    {
                                        Dialog.show("Success", "HC " + p.getName()+ " is deleted !! ", new Command("OK"));
                                    }
                                }
                            } else {

                                EditHCForm t = new EditHCForm(current, p);
                                t.show();
                            }
                        }
                    });
                }
                revalidate();
            });
        });

    }

}
