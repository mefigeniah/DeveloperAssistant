package mcc.scrum;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


public class Tools {
    //-----------------Add text at the end--------------------------
    public static void append(String line, JTextPane textArea) {
        try {
            Document doc = textArea.getDocument();
            doc.insertString(doc.getLength(), line, null);
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------

    //-----------------Method to show the numbers in the view-------
    public static void viewNumbersScreen(boolean numbers, JTextPane textArea, JScrollPane scroll) {
        if(numbers) {
            scroll.setRowHeaderView(new TextLineNumber(textArea));
        }
        else {
            scroll.setRowHeaderView(null);
        }
    }

    public static void viewNumberSet(int counter, boolean numbers, ArrayList<JTextPane> textAreaList, ArrayList<JScrollPane> scrollList) {
        if(numbers) {
            for (int i = 0; i < counter; i++) {
                scrollList.get(i).setRowHeaderView(new TextLineNumber(textAreaList.get(i)));
            }
        }
        else {
            for (int i = 0; i < counter; i++) {
                scrollList.get(i).setRowHeaderView(null);
            }
        }
    }
    //--------------------------------------------------------------
    //-------------------------Appearance --------------------------
    public static void aBanckground(int counter, String typeB, ArrayList<JTextPane> list){

        //If the TypeB is white change all the backgrounds to white
        if(typeB.equals("white")) {
            for (int i = 0; i < counter; i++) {
                list.get(i).selectAll();

                StyleContext sc = StyleContext.getDefaultStyleContext();

                //apply Text Color
                AttributeSet attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);

                //Apply text Style
                sc.addAttribute(attributeSet, StyleConstants.FontFamily, "Arial");



                //Apply the new text color, text style and background to all text panel
                list.get(i).setCharacterAttributes(attributeSet, false);
                list.get(i).setBackground(Color.WHITE);
            }
        }
        else if(typeB.equals("dark")) {
            for (int i = 0; i < counter; i++) {
                list.get(i).selectAll();

                StyleContext sc = StyleContext.getDefaultStyleContext();

                //apply Text Color
                AttributeSet attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);

                //Apply text Style
                sc.addAttribute(attributeSet, StyleConstants.FontFamily, "Arial");


                //Apply the new text color, text style and background to all text panel
                list.get(i).setCharacterAttributes(attributeSet, false);
                list.get(i).setBackground(new Color(32, 33, 36));
            }
        }

        //--------------------------------------------------------------

    }


    // ---------------------Google Search---------------------
    public static void GoogleFind(String text) {
        URI uri;
        String googleUrl = "https://www.google.com/search?q=";
        String query = googleUrl + text;

        try {
            uri = new URI(query);
            Desktop.getDesktop().browse(uri);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    // --------------------------------------------------------------
}
