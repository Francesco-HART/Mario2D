package com.francesco.personnages;

import javax.swing.*;
import java.awt.*;

public class Mario extends Personnage{
    private Image imgMario;
    private ImageIcon icoMario;



    public Mario(int x, int y){
        super(x , y , 28, 50);
        //Instance
        icoMario = new ImageIcon(getClass().getResource("/image/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();
    }

    public Image getImgMario() {return imgMario;}



}
