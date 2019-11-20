package com.francesco.personnages;

import javax.swing.*;
import java.awt.*;

public class tuyauRouge extends Object {
    private Image imgtuyauRouge;
    private ImageIcon icotuyauRouge;

    public tuyauRouge(int x, int y) {


        super(x, y, 43, 65);
        this.icotuyauRouge = new ImageIcon(getClass().getResource("/image/tuyauRouge.png"));
        this.imgtuyauRouge = this.icotuyauRouge.getImage();
    }

    public Image getImgtuyauRouge() {
        return imgtuyauRouge;
    }
}
