package com.mathmau.jeu;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Scene extends JPanel {

    //Object
    private ImageIcon icoFond;
    private Image imgFond1;
    private Image imgFond2;

    private ImageIcon icoMario;
    private  Image imgMario;
//Abscice du coin superieur gauche de l'image fond
    private int xFond1;
    private int xFond2;
    //Deplacer l'ecran horizontalement
    private int dx;



    //contructeur
    public Scene(){

        super();
        this.xFond1 = -50;
        this.xFond2 = 750;
        this.dx = 0;
        //Instancier img
        icoFond = new ImageIcon(getClass().getResource("/image/fondEcran.png"));
        //Associer à icoFondd a imgfond1
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();

        icoMario = new ImageIcon(getClass().getResource("/image/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();


    //ecouter evenement clavier avec la scene les 2 1er le 3eme relis classe clavier a scene
        this.setFocusable(true);
        //Recup le focus
        this.requestFocusInWindow();
        this.addKeyListener(new clavier());

        //INstance du chrono
        //Minprogramme qui tourne en fond non stop
       Thread chronoEcran = new Thread(new chronoAffichage());
       //Pour demarrer le chronoEcran
        chronoEcran.start();
    }
    //Get and set //


    public int getDx() {return dx;}

    public void setDx(int dx) {this.dx = dx;}

    //Methode deplacement fond
    //Pose fond mis à jour, On change l'abscice de ref lorsque dx != 0
    public void deplacementFond(){
        this.xFond1 = this.xFond1 - this.dx;
        this.xFond2 = this.xFond2 - this.dx;

        if (this.xFond1 == -800){
            //Si on arrive au bout de la map alors on la remet depuis le debut
            //Regler le coté gauche
            this.xFond1 = 800;}
        else if (this.xFond2 == -800){this.xFond2 = 800;}
        //Regler du cote droit
        else if (this.xFond1 == 800){this.xFond1 = 800;}
        else if (this.xFond2 == 800){this.xFond2 = -800;}

    }

    //Méthodes pour dessiner
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //Acceder à graphics 2d pour dessinefr un graph amélioreer la on va le chercher, caster graphics en graphics2d
        Graphics g2 = (Graphics2D)g;
        this.deplacementFond();

        //Dessiner les images
        g2.drawImage(this.imgFond1,this.xFond1,0,null);//Dessin img de fond
        g2.drawImage(this.imgFond2,this.xFond2,0,null);
        g2.drawImage(this.imgMario,300,245, null);
        //Faire fonctionner la méthode déplacement fond

    }




}
