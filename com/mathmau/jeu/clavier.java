package com.mathmau.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Gérer les touches du clavier
public class clavier implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        //code de la touche
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            Main.scene.setDx(1);

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Main.scene.setDx(-1);
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.setDx(0);
    }
}
