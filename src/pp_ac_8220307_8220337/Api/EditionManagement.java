package pp_ac_8220307_8220337.Api;

import java.util.Arrays;

import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import pp_ac_8220307_8220337.Api.interfaces.IEditionManagement;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class EditionManagement implements IEditionManagement {

    private final int DEFALUT_NUMBER_EDITION;
    private Edition[] editions;
    private int numEditions;

    /**
     * Default constructor for EditionManagement class.
     * Initializes the editions array with a default size.
     */
    public EditionManagement() {
        this.DEFALUT_NUMBER_EDITION = 5;
        this.numEditions = 0;
        this.editions = new Edition[DEFALUT_NUMBER_EDITION];
    }

    /**
     * Resizes the editions array by creating a new array with double the size
     * and copying the elements from the original array.
     */
    private void resizeEdition() {
        Edition[] newEditions = new Edition[this.editions.length * 2];
        for (int i = 0; i < this.editions.length; i++) {
            newEditions[i] = this.editions[i];
        }
        this.editions = newEditions;
    }

    /**
     * Returns the index of the edition with the specified name in the editions
     * array.
     *
     * @param name the name of the edition
     * @return the index of the edition, or -1 if not found
     */
    private int getEditionIndex(String name) {
        int i = 0;
        while (i < this.numEditions && this.editions[i].getName().compareTo(name) != 0) {
            i++;
        }

        if (i >= this.numEditions) {
            return -1;
        }

        return i;
    }

    /**
     * Adds a new edition to the editions array.
     *
     * @param edition the edition to be added
     */
    @Override
    public void addEdition(Edition edition) {

        try {
            if (this.numEditions >= this.editions.length) {
                resizeEdition();
            }

            this.editions[this.numEditions] = edition;

            this.numEditions++;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    /**
     * Removes an edition from the editions array.
     *
     * @param editionName the name of the edition to be removed
     */
    @Override
    public void removeEdition(String editionName) {
        try {
            int index = getEditionIndex(editionName);

            for (int i = index; i < this.numEditions - 1; i++) {
                this.editions[i] = this.editions[i + 1];
            }

            this.numEditions--;
            this.editions[this.numEditions] = null;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns an array of all editions.
     *
     * @return the array of editions
     */
    @Override
    public Edition[] getEditions() {
        return this.editions;
    }

    /**
     * Returns the edition with the specified name.
     *
     * @param editionName the name of the edition
     * @return the edition object, or null if not found
     */
    @Override
    public Edition getEdition(String editionName) {
        for (int i = 0; i < this.numEditions; i++) {
            if (editions[i].getName().equals(editionName)) {
                return editions[i];
            }
        }

        return null;
    }

    /**
     * Defines the edition with the specified name as active.
     * Sets the status of other active editions as Inactive, because only one
     * edition can be set as Active.
     *
     * @param editionName the name of the edition to be set as active
     */
    @Override
    public void defineAsActive(String editionName) {
        for (int i = 0; i < this.numEditions; i++) {
            // Sets the status of other active editions as Inactive
            if (editions[i].getStatus().equals(Status.ACTIVE)) {
                editions[i].setStatus(Status.INACTIVE);
            }

            // Defines the edition with the specifided name as active.
            if (editions[i].getName().equals(editionName)) {
                editions[i].setStatus(Status.ACTIVE);
            }
        }
    }

    /**
     * Retrieves the number of CBL Editions
     * 
     * @return number of CBL Editions
     */
    @Override
    public int getNumberOfCBLEditions() {
        return this.numEditions;
    }

    /**
     * Defines the edition with the specified name as inactive.
     *
     * @param editionName the name of the edition to be set as inactive
     */
    @Override
    public void defineAsInactive(String editionName) {
        try {
            int index = getEditionIndex(editionName);

            editions[index].setStatus(Status.INACTIVE);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    /**
     * Defines the edition with the specified name as canceled.
     *
     * @param editionName the name of the edition to be set as canceled
     */
    @Override
    public void defineAsCanceled(String editionName) {
        try {
            int index = getEditionIndex(editionName);

            editions[index].setStatus(Status.CANCELED);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /**
     * Defines the edition with the specified name as closed.
     *
     * @param editionName the name of the edition to be set as closed
     */
    @Override
    public void defineAsClosed(String editionName) {
        try {
            int index = getEditionIndex(editionName);

            editions[index].setStatus(Status.CLOSED);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves an array of editions with the unfinished projects in all editions.
     * 
     * @return array of projects with the unfinished projects in all editions
     */
    public Edition[] getunfinishedEditions() {
        Edition[] unfinishedEditions = new BaseEdition[numEditions];
        int countUnfinishedEditions = 0;

        for (int i = 0; i < numEditions; i++) {
            for (Project project : this.editions[i].getProjects()) {
                if (project.isCompleted()) {
                    unfinishedEditions[countUnfinishedEditions] = editions[i];
                    countUnfinishedEditions++;
                }

            }
        }

        // Create a new array to hold only the unfinished Projects in all editions
        Edition[] onlyunfinishedEditions = new BaseEdition[countUnfinishedEditions];
        System.arraycopy(unfinishedEditions, 0, onlyunfinishedEditions, 0, countUnfinishedEditions);

        return onlyunfinishedEditions;
    }

    @Override
    public String toString() {
        String string = "";

        for (int i = 0; i < numEditions; i++) {
            string += "\n" + editions[i].toString();
        }

        return string;
    }

    @Override
    public Participant[] getAllStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllStudents'");
    }

    @Override
    public Participant[] getAllFacilitators() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFacilitators'");
    }

    @Override
    public Participant[] getAllPartners() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPartners'");
    }

    @Override
    public Participant getStudent(String name) {
        for(int i = 0; i < numEditions; i++) {
            for(int j = 0; j < editions[i].getNumberOfProjects(); i++) {
                if(editions[i].getProjects()[j].getParticipant(name) != null) {
                    return editions[i].getProjects()[j].getParticipant(name);
                }
            }
        }

        return null;
    }

    @Override
    public Participant getFacilitator(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFacilitator'");
    }

    @Override
    public Participant getPartner(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPartner'");
    }

    @Override
    public Participant[] getAllParticipantsFromEdition(String EditionName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllParticipants'");
    }

}
