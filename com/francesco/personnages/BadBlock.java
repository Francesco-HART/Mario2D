package com.francesco.personnages;

import javax.swing.*;
import java.awt.*;

public class BadBlock extends Object {

    private Image imgBadBlock;
    private ImageIcon icoBadBlock;

    public BadBlock(int x, int y) {


        super(x, y, 43, 65);
        this.icoBadBlock = new ImageIcon(getClass().getResource("/image/bloc.png"));
        this.imgBadBlock = this.icoBadBlock.getImage();
    }

    public Image getImgBadBlock() {
        return imgBadBlock;
    }
}
