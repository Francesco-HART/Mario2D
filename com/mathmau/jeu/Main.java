package com.mathmau.jeu;
import javax.swing.JFrame;

public class Main {

    public static  Scene scene;

    public static  void  main(String[]args){
    // Création de la fenetre
    JFrame fenetrePrincipal = new JFrame("Jeu style Inklio");
    fenetrePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrincipal.setSize(700,360);
        fenetrePrincipal.setLocationRelativeTo(null);
        fenetrePrincipal.setResizable(false);
        fenetrePrincipal.setAlwaysOnTop(true);

        // Instantation de l'objet Scene
        scene = new Scene();
        fenetrePrincipal.setContentPane(scene);// Association de la fenetre principal de l'app a la scene
        fenetrePrincipal.setVisible(true);

    }
}
