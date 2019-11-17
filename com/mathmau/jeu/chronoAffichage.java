package com.mathmau.jeu;

//Classe a qui on crée une interface
public class chronoAffichage implements Runnable {
    //Temps de Pause entre 2 boucles
    private final int PAUSE = 3;//Temps d'attente entre deux tours de boucles

    @Override
    public void run() {
        //Donc boucle infinie
        while (true) {
            //Acceder à scene grace a main car elle est déclaré dans main
            Main.scene.repaint();
            try {
                Thread.sleep(PAUSE);
                //Faire augtre chose au cas ou la commande sleep ne fonctionne pas
            } catch (InterruptedException e) {
            }
        }

    }
}
