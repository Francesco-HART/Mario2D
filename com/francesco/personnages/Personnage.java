package com.francesco.personnages;

import com.mathmau.jeu.Main;

import javax.swing.ImageIcon;

import java.awt.Image;


public class Personnage {
    private int largeur, hauteur;
    private int x, y;
    private boolean marche;//True when walk
    private boolean versDroite;//True right
    public int compteur;// compteur des pas du personnage

    //Comstructeur
    public Personnage(int x, int y, int largeur, int hauteur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
    }


    //GETTER//
    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMarche() {
        return marche;
    }

    public boolean isVersDroite() {
        return versDroite;
    }

    public int getCompteur() {
        return compteur;
    }


    //SETTER//

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMarche(boolean marche) {
        this.marche = marche;
    }

    public void setVersDroite(boolean versDroite) {
        this.versDroite = versDroite;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }


    //METHODE//

    public Image marche(String nom, int frequence) {
        String str;
        ImageIcon ico;
        Image img;
        //Perso arrete ou completement a gauche ecran
        if (this.marche == false || Main.scene.getxPos() <= 0) {
            if (this.versDroite == true) {
                str = "/image/" + nom + "ArretDroite.png";
            } else {
                str = "/image/" + nom + "ArretGauche.png";
            }
        } else {
            this.compteur++;
            //Deux nombre entier donc le quotien ne peut pas avoir de virgule. Le quotient doit faire 1
            if (this.compteur / frequence == 0) {
                if (this.versDroite == true) {
                    str = "/image/" + nom + "ArretDroite.png";
                } else {
                    str = "/image/" + nom + "ArretGauche.png";
                }
            }
            else {
                if (this.versDroite == true) {str = "/image/" + nom + "MarcheDroite.png"; }
                else {str = "/image/" + nom + "MarcheGauche.png";}
            }

            if (this.compteur == 2 * frequence) {this.compteur = 0;}
        }
        //Affichache perso
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;


    }
}







