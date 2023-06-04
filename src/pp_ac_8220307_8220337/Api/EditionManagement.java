/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_ac_8220307_8220337.Api;

import ma02_resources.project.Edition;
import pp_ac_8220307_8220337.Api.interfaces.IEditionManagement;

/**
 *
 * @author pedro
 */
public class EditionManagement implements IEditionManagement {

    private static int MAX_EDITION;
    private int numEdtion;
    private Edition[] editions;

    public EditionManagement() {
        this.MAX_EDITION = 5;
        this.numEdtion = 0;
        this.editions = new Edition[MAX_EDITION];
    }

    private void resizeEdition() {
        Edition[] newEditions = new Edition[this.editions.length * 2];
        for (int i = 0; i < this.editions.length; i++) {
            newEditions[i] = this.editions[i];
        }
        this.editions = newEditions;
    }

    private int searchByName(String name) {
        int i = 0;
        while (i < this.numEdtion && this.editions[i].getName().compareTo(name) != 0) {
            i++;
        }

        if (i >= this.numEdtion) {
            return -1;
        }

        return i;
    }

    @Override
    public void addEdition(Edition edition) {

        if (this.numEdtion >= this.editions.length) {
            resizeEdition();
        }
        this.editions[this.numEdtion] = edition;

        this.numEdtion++;
    }

    @Override
    public void removeEdition(String editionName) {
        if (this.numEdtion <= 0) {
            //TODO (Colocar exceções)
            return;
        }

        int index = searchByName(editionName);

        if (index < 0) {
            //TODO (Colocar exceções)
            return;
        }

        for (int i = index; i < this.numEdtion - 1; i++) {
            this.editions[i] = this.editions[i + 1];
        }

        this.numEdtion--;
        this.editions[this.numEdtion] = null;
    }

    @Override
    public Edition[] getEditions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
