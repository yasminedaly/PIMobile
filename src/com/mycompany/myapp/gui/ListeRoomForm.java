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
import com.mycompany.myapp.entities.HotelRoom;
import com.mycompany.myapp.services.RoomService;
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
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entities.Hotel;
import com.mycompany.myapp.services.HotelService;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ListeRoomForm extends Form {

    Form current;

    public ListeRoomForm(Form previous) {
        current = this;
        getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            previous.showBack();
        });

        RoomService sp = new RoomService();
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

                // Button ttrie =new Button("trie");
                ///// ttrie.addActionListener(e-> new ListFormationFormtrie(current).show()); 
                // back = Image.createImage("/logo.png");
                //back.scaled(1000, 1000);
                // add(ttrie);
               
                
                Button btnAddRoom = new Button("add Room");
                btnAddRoom.addActionListener(e -> new AddRoomForm(current).show());
                addAll( btnAddRoom);
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
                TextField searchField = new TextField("", "Toolbar Search"); // <1>
                searchField.getHintLabel().setUIID("Title");
                searchField.setUIID("Title");
                searchField.getAllStyles().setAlignment(Component.LEFT);
                hi.getToolbar().setTitleComponent(searchField);
                FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
                ArrayList<HotelRoom> list1;
                list1 = RoomService.getInstance().getAllHR();
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
                for (HotelRoom recc : list1) {
                    Label b = new Label(recc.getRoom_Type());

                    hi.add(b);

                    b.addPointerPressedListener(e -> {

                        //   if (recc.getRoom_Type()== b.getText())
                        //{
                        //  new  formasearch2(current,reccc).show();
                        //}
                    });
                }
                Button trie = new Button("Actualiser");

                trie.addActionListener(e -> new ListeRoomForm(current).show());
                add(trie);

                List<HotelRoom> listerec = sp.getAllHR();
                for (HotelRoom p : listerec) {
                    //try {
                    //  Image imagee = Image.createImage("file://C:\\Users\\21628\\Desktop\\final web\\koko444\\pi\\public\\images\\logos\\"+p.getLogo()+"").scaledHeight(350);
                    //add(imagee);
                    //} catch (IOException ex) {

                    //}
                    MultiButton m = new MultiButton();
                    m.setTextLine1("TYpe: " + p.getRoom_Type());
                    m.setTextLine2("Number: " + p.getNbrRoom());

                    add(m);

                    m.addPointerReleasedListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (Dialog.show("Confirmation", "What do you want?", "Delete", "Update")) {

                                if (RoomService.getInstance().deleteHR(p)) {
                                    {
                                        Dialog.show("Success", "Room " + p.getNbrRoom() + " is deleted !! ", new Command("OK"));
                                        previous.showBack();
                                    }
                                }
                            } else {

                                EditRoomForm t = new EditRoomForm(current, p);
                                t.show();
                            }
                        }
                    });
                }

                /* Button pdf=new Button("             PDF             ");
 add(pdf);  
 pdf.addActionListener(new ActionListener() {
                  
                    public void actionPerformed(ActionEvent evt) {
                        String path="C:\\Users\\21628\\Desktop\\PDF soka\\";
        
        Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path+"Agence.pdf"));
           document.open();
          PdfPTable tb1 = new PdfPTable(4);
          tb1.addCell("Nom");
          tb1.addCell("Adresse");
          tb1.addCell("Email");
          tb1.addCell("Tel");
          
         ServiceCours es = new ServiceCours();
        ArrayList<Cours> list = es.getAllAgences();
          for (int i = 0; i < list.size(); i++) {
            
              String Nom= String.valueOf(list.get(i).getNom());
              String Q1= String.valueOf(list.get(i).getDescription());
              
              
          tb1.addCell(Nom);
          tb1.addCell(Q1);
         
          
         
         
          }
         document.add(new Paragraph("Agence"));
         document.add(tb1);
         document.close();
         writer.close();
                           Dialog.show("Success","Le PDF a été crée",new Command("OK"));  

        com.codename1.io.File file=new com.codename1.io.File("test.pdf");
        //desktop.open(file);
      } catch (DocumentException e)
      {
         e.printStackTrace();
      }catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
                        //Logger.getLogger(ListFormation.class.getName()).log(Level.SEVERE, null, ex);

                     
                    }
                    
                }
                
                
                );*/
                revalidate();
            });
        });
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

}
