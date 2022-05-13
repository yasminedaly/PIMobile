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
import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
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
import com.codename1.ui.util.Resources;

public class ListHotelForm extends Form {

    Form current;
    Form res;

    //Ressources res;
    public ListHotelForm(Form previous) {
        current = this;

        HotelService sp = new HotelService();
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
        Button btnAddHotel = new Button("add Hotel");
        btnAddHotel.addActionListener(e -> new AddHotelForm(current).show());
        addAll( btnAddHotel);
                
                //Button ttrie = new Button("trie");

                ///// ttrie.addActionListener(e-> new ListFormationFormtrie(current).show()); 
                // back = Image.createImage("/logo.png");
                //back.scaled(1000, 1000);
                // add(ttrie);
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
                ArrayList<Hotel> list1;
                list1 = HotelService.getInstance().getAllH();
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
                for (Hotel recc : list1) {
                    Label b = new Label(recc.getHotel_Name());
                    hi.add(b);

                    b.addPointerPressedListener(e -> {

                        if (recc.getHotel_Name() == b.getText()) {
                            new formasearch1(current, recc).show();
                        }
                    });
                }
                /*     
        Toolbar.setGlobalToolbar(true);
Form F = new Form("Rounder", new BorderLayout());
Label picture = new Label("", "Container");
F.add(BorderLayout.CENTER, picture);
F.getUnselectedStyle().setBgColor(0xff0000);
F.getUnselectedStyle().setBgTransparency(255);
//Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
Image camera = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);
F.getToolbar().addCommandToRightBar("", camera, (ev) -> {
    try {
        int width = Display.getInstance().getDisplayWidth();
        Image capturedImage = Image.createImage(Capture.capturePhoto(width, -1));
        Image roundMask = Image.createImage(width, capturedImage.getHeight(), 0xff000000);
        Graphics gr = roundMask.getGraphics();
        gr.setColor(0xffffff);
        gr.fillArc(0, 0, width, width, 0, 360);
        Object mask = roundMask.createMask();
        capturedImage = capturedImage.applyMask(mask);
        picture.setIcon(capturedImage);
        F.revalidate();
    } catch(IOException err) {
        System.out.println("hehe");
    }
});
        
                 */

                ////////////////////////
                Button trie = new Button("Actualiser");

                trie.addActionListener(e -> new ListHotelForm(current).show());
                add(trie);

                List<Hotel> listerec = sp.getAllH();
                for (Hotel p : listerec) {
                    //try {
                    //  Image imagee = Image.createImage("file://C:\\Users\\21628\\Desktop\\final web\\koko444\\pi\\public\\images\\logos\\"+p.getLogo()+"").scaledHeight(350);
                    //add(imagee);
                    //} catch (IOException ex) {

                    //}
                    MultiButton m = new MultiButton();
                    m.setTextLine1("Name: " + p.getHotel_Name());
                    m.setTextLine2("description: " + p.getHotel_Description());

                    add(m);

                    m.addPointerReleasedListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (Dialog.show("Confirmation", "What do you want?", "Delete", "Update")) {

                                if (HotelService.getInstance().deleteH(p)) {
                                    {
                                        Dialog.show("Success", "HC " + p.getHotel_Name() + " is deleted !! ", new Command("OK"));
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

                /*     
                       Button pdf=new Button("             PDF             ");
 add(pdf);  
 pdf.addActionListener(new ActionListener() {
                  
                    public void actionPerformed(ActionEvent evt) {
         
       // Document document = new Document();
      try
      {
          
          
        String file_name = "hotelDetails.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        
            document.open();
          PdfPTable tb1 = new PdfPTable(4);
          tb1.addCell("Nom");
          tb1.addCell("Adresse");
          tb1.addCell("Email");
          tb1.addCell("Tel");
          
         HotelService es = new HotelService();
        ArrayList<Hotel> list = es.getAllH();
          for (int i = 0; i < list.size(); i++) {
            
              String Nom= String.valueOf(list.get(i).getHotel_Name());
              String Q1= String.valueOf(list.get(i).getHotel_Description());
              
              
          tb1.addCell(Nom);
          tb1.addCell(Q1);
         
          
         
         
          }
         document.add(new Paragraph("Agence"));
         document.add(tb1);
         document.close();
         //writer.close();
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
                
                
                );
                        
                        
                        
                        
                 */
                revalidate();
            });
        });
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

}
