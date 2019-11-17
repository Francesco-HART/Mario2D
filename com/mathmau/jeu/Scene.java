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

    private ImageIcon icoChateau1;
    private Image imgChateau1;

    private ImageIcon icoDepart;
    private Image imgDepart;

    private ImageIcon icoMario;
    private  Image imgMario;
    //Abscice du coin superieur gauche de l'image fond
    private int xFond1;
    private int xFond2;
    //Deplacer l'ecran horizontalement
    private int dx;
    private int xPos;



    //contructeur
    public Scene(){

        super();
        this.xFond1 = -50;
        this.xFond2 = 750;
        this.dx = 0;
        this.xPos = -1;

        //Instancier img
        icoFond = new ImageIcon(getClass().getResource("/image/fondEcran.png"));
        //Associer à icoFondd a imgfond1
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();
        //Depart


        icoMario = new ImageIcon(getClass().getResource("/image/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();

        this.icoChateau1 = new ImageIcon(getClass().getResource("/image/chateau1.png"));
        this.imgChateau1 = this.icoChateau1.getImage();

        this.icoDepart = new ImageIcon(getClass().getResource("/image/depart.png"));
        this.imgDepart = this.icoDepart.getImage();


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

    public int getxPos() {return xPos;}
    public void setxPos(int xPos) {this.xPos = xPos;}

    public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

    public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

    //Methode deplacement fond
    //Pose fond mis à jour, On change l'abscice de ref lorsque dx != 0
    public void deplacementFond(){
        if(this.xPos >= 0){
            this.xPos = this.xPos + this.dx;
            this.xFond1 = this.xFond1 - this.dx;
            this.xFond2 = this.xFond2 - this.dx;
        }

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
        //Dessin du depart avec mise a jour -this.xPos
        g2.drawImage(this.imgChateau1, 10 - this.xPos, 95, null);
        g2.drawImage(this.imgDepart, 220 - this.xPos, 234, null);
        //Faire fonctionner la méthode déplacement fond

    }




}
