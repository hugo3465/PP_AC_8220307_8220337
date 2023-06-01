package pp_ac_8220307_8220337.Api;

import java.time.LocalDateTime;
import ma02_resources.participants.Student;
import ma02_resources.project.Submission;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class BaseSubmission implements Submission {
    private Student student;
    private LocalDateTime date;
    private String text;

    public BaseSubmission(Student student, LocalDateTime date, String text) {
        this.student = student;
        this.date = date;
        this.text = text;
    }

    @Override
    public int compareTo(Submission sbmsn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Retrieves the date of the submission.
     * 
     * @return The date of the submission.
     */
    @Override
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Retrieves the student who made the submission.
     * 
     * @return The student who made the submission.
     */
    @Override
    public Student getStudent() {
        return student;
    }

    /**
     * Retrieves the text content of the submission.
     * 
     * @return The text content of the submission.
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * Sets the date of the submission.
     * 
     * @param date The date of the submission.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Sets the student who made the submission.
     * 
     * @param student The student who made the submission.
     */
    public void setStudent(BaseStudent student) {
        this.student = student;
    }

    /**
     * Sets the text content of the submission.
     * 
     * @param text The text content of the submission.
     */
    public void setText(String text) {
        this.text = text;
    }
}
