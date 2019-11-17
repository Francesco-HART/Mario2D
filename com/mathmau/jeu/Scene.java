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

    private ImageIcon icoMario;
    private  Image imgMario;
//Abscice du coin superieur gauche de l'image fond
    private int xFond1;



    //contructeur
    public Scene(){

        super();
        this.xFond1 =-50;
        //Instancier img
        icoFond = new ImageIcon(getClass().getResource("/image/fondEcran.png"));
        //Associer à icoFondd a imgfond1
        this.imgFond1 = this.icoFond.getImage();

        icoMario = new ImageIcon(getClass().getResource("/image/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();
    }

    //Méthodes pour dessiner
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //Acceder à graphics 2d pour dessinefr un graph amélioreer la on va le chercher, caster graphics en graphics2d
        Graphics g2 = (Graphics2D)g;
        //Dessiner les images
        g2.drawImage(this.imgFond1,this.xFond1,0,null);//Dessin img de fond
        g2.drawImage(this.imgMario,300,245, null);

    }
}
