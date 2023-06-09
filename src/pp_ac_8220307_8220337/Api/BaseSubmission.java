/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

package pp_ac_8220307_8220337.Api;

import java.time.LocalDateTime;
import ma02_resources.participants.Student;
import ma02_resources.project.Submission;

/**
 * The BaseSubmission class represents a basic implementation of the Submission
 * interface.
 *
 * It contains fields for student, date, and text.
 *
 * This class provides constructors to create a submission with student, date,
 * and text,
 * or with student and text (in which case the current date is used).
 */
public class BaseSubmission implements Submission {

    /**
     * The student who submitted the submission.
     */
    private Student student;

    /**
     * The date and time of the submission.
     */
    private LocalDateTime date;

    /**
     * The text content of the submission.
     */
    private String text;

    /**
     * Constructs a BaseSubmission object with the specified student, date, and
     * text.
     *
     * @param student the student who submitted the submission
     * @param date    the date and time of the submission
     * @param text    the text content of the submission
     */
    public BaseSubmission(Student student, LocalDateTime date, String text) {
        this.student = student;
        this.date = date;
        this.text = text;
    }

    /**
     * Constructs a BaseSubmission object with the specified student, text, and the
     * current date and time.
     *
     * @param student the student who submitted the submission
     * @param text    the text content of the submission
     */
    public BaseSubmission(Student student, String text) {
        this.student = student;
        this.text = text;
        this.date = LocalDateTime.now();
    }

    /**
     * Compares this submission with the specified submission for order.
     * 
     * @param sbmsn The submission to be compared.
     * @return A negative integer, zero, or a positive integer if this submission is
     *         less than, equal to,
     *         or greater than the specified submission, respectively.
     */
    @Override
    public int compareTo(Submission sbmsn) {
        if (this.date.isBefore(sbmsn.getDate())) {
            return -1;
        } else if (this.date.isAfter(sbmsn.getDate())) {
            return 1;
        } else {
            // Compare by the name of the student if the dates are equal
            return this.student.getName().compareTo(sbmsn.getStudent().getName());
        }
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

    @Override
    public String toString() {
        return "\tStudent: " + student.getName() + '\n'
                + "\tDate: " + date.toString() + '\n'
                + "\tText: " + text + '\n';
    }

}
