/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

/**
 *
 * @author LENOVO
 */
import com.mycompany.myapp.entities.Teams;
import com.mycompany.myapp.services.TeamsService;
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
public class formasearch1 extends Form {

    Form current;

    public formasearch1(Form previous, Teams recc) {
        current = this;

        TeamsService sp = new TeamsService();
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
                // Button rtrie =new Button("Recherche");

                // back = Image.createImage("/logo.png");
                //back.scaled(1000, 1000);
                //add(rtrie);
                Button ttrie = new Button("trie");

                //ttrie.addActionListener(e-> new ListFormationFormtrie(current).show()); 
                // back = Image.createImage("/logo.png");
                //back.scaled(1000, 1000);
                add(ttrie);

                Button trie = new Button("Actualiser");

                //trie.addActionListener(e-> new ListFormationnnForm(current).show());
                add(trie);

                //  List<Formation> listerec = sp.getAllFormations();
                // for(Formation p : listerec)
                {
                    //try {
                    //  Image imagee = Image.createImage("file://C:\\Users\\21628\\Desktop\\final web\\koko444\\pi\\public\\images\\logos\\"+p.getLogo()+"").scaledHeight(350);
                    //add(imagee);
                    //} catch (IOException ex) {

                    //}
                    MultiButton m = new MultiButton();
                    m.setTextLine1("Name: " + recc.getTeam_name());
                    // m.setTextLine3("description: "+rec.getDescription());
                    //m.setTextLine2("Prix: "+rec.getPrix());

                    add(m);

                    /* m.addPointerReleasedListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        if (Dialog.show("Confirmation", "Que voulez vous faire ?", "Supprimer", "Modifier")) {
                                            
                                                if( FormationService.getInstance().delFormation(rec)){
                                                    {
                                                       Dialog.show("Success","L'agence "+rec.getNom()+" a été supprimé avec succées",new Command("OK"));
                                                       previous.showBack();
                                                    }
                                        }
                                    }
                                        else{ 
                                               
                                                 EditFormationForm t = new EditFormationForm(current,rec);
                                                 t.show();
                                        }
                                    }
                                });*/
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
