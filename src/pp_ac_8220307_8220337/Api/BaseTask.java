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

import java.time.LocalDate;

import ma02_resources.project.Submission;
import ma02_resources.project.Task;

/**
 * The BaseTask class represents a basic implementation of the Task interface.
 *
 * It contains fields for start date, end date, duration, title, description,
 * submissions, and the number of submissions.
 *
 * This class provides methods to access and modify these task details.
 */
public class BaseTask implements Task {

    /**
     * The default number of submissions for a task.
     */
    private final int DEFAULT_NUMBER_SUBMISSIONS = 1;

    /**
     * The start date of the task.
     */
    private LocalDate start;

    /**
     * The end date of the task.
     */
    private LocalDate end;

    /**
     * The duration of the task in days.
     */
    private int duration;

    /**
     * The title of the task.
     */
    private String title;

    /**
     * The description of the task.
     */
    private String description;

    /**
     * The submissions for the task.
     */
    private Submission[] submissions;

    /**
     * The number of submissions for the task.
     */
    private int numberOfSubmissions;

    /**
     * Constructs a BaseTask.
     * 
     * @param start       the start date of the task
     * @param end         the end date of the task
     * @param duration    the duration of the task in days
     * @param title       the title of the task
     * @param description the description of the task
     * @param submissions the array of submissions for the task
     */
    public BaseTask(LocalDate start, LocalDate end, int duration, String title, String description,
            Submission[] submissions) {
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.submissions = submissions;
        this.numberOfSubmissions = 0;
    }

    /**
     * Constructs a BaseTask.
     * 
     * This constructor is mostly used in the addProject in the BaseEdition Class.
     * 
     * When a new project is added, the tasks will have a default number of
     * submissions,
     * defined by {@code DEFAULT_NUMBER_SUBMISSIONS}.
     * 
     * @param title            the title of the task
     * @param description      the description of the task
     * @param startAt          the start date of the task in the format YYYYMMDD
     * @param duration         the duration of the task in days
     * @param editionStartDate the start date of the edition that the task is in
     */
    public BaseTask(String title, String description, int startAt, int duration, LocalDate editionStartDate) {

        this.start = editionStartDate.plusDays(startAt); // Calculate the end date based on start and duration

        this.end = start.plusDays(duration); // Calculate the end date based on start and duration

        this.duration = duration;
        this.title = title;
        this.description = description;
        this.submissions = new BaseSubmission[DEFAULT_NUMBER_SUBMISSIONS];
        this.numberOfSubmissions = 0;
    }

    /**
     * Constructs a BaseTask.
     * 
     * This constructor is mostly used in the addTask in the BaseProject Class.
     * 
     * @param title                 the title of the task
     * @param description           the description of the task
     * @param startAt               the start date of the task in the format
     *                              YYYYMMDD
     * @param duration              the duration of the task in days
     * @param maxNumberOfSubmission the maximum number of submissions allowed for
     *                              the task
     */
    public BaseTask(String title, String description, int startAt, int duration, int maxNumberOfSubmission) {
        int year = startAt / 10000; // Extract the year from the integer
        int month = (startAt / 100) % 100; // Extract the month from the integer
        int day = startAt % 100; // Extract the day from the integer

        this.start = LocalDate.of(day, month, year);

        this.end = start.plusDays(duration); // Calculate the end date based on start and duration

        this.duration = duration;
        this.title = title;
        this.description = description;
        this.submissions = new BaseSubmission[maxNumberOfSubmission];
        this.numberOfSubmissions = 0;
    }

    /**
     * 
     * Adds a submission to the task.
     * 
     * @param arg0 The submission to be added.
     * 
     * @throws IllegalArgumentException       if the provided submission is not an
     *                                        instance of BaseSubmission.
     * 
     * @throws ArrayIndexOutOfBoundsException if the submissions array is already
     *                                        full.
     * 
     * @throws NullPointerException           if the provided submission is null.
     */
    @Override
    public void addSubmission(Submission arg0) {
        try {
            this.submissions[numberOfSubmissions] = arg0;

            this.numberOfSubmissions++;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            throw new ArrayIndexOutOfBoundsException(aioobe + " in addSubmission");
        } catch (NullPointerException npe) {
            throw new NullPointerException(npe + " in addSubmission");
        }
    }

    /**
     * Extends the deadline of the task by a specified number of days.
     * 
     * @param arg0 The number of days by which to extend the deadline.
     */
    @Override
    public void extendDeadline(int arg0) {
        this.end = end.plusDays(arg0);
    }

    /**
     * Compares this task with another task based on their end dates.
     * 
     * @param arg0 The task to compare with.
     * @return A negative integer if this task's end date is earlier than the other
     *         task's end date,
     *         a positive integer if this task's end date is later than the other
     *         task's end date,
     *         or zero if both tasks have the same end date.
     */
    @Override
    public int compareTo(Task arg0) {
        // Comparar as tarefas com base na data de término
        return this.getEnd().compareTo(arg0.getEnd());
    }

    /**
     * Retrieves the start date of the task.
     * 
     * @return The start date of the task.
     */
    @Override
    public LocalDate getStart() {
        return start;
    }

    /**
     * Retrieves the end date of the task.
     * 
     * @return The end date of the task.
     */
    @Override
    public LocalDate getEnd() {
        return end;
    }

    /**
     * Retrieves the duration of the task.
     * 
     * @return The duration of the task.
     */
    @Override
    public int getDuration() {
        return duration;
    }

    /**
     * Retrieves the title of the task.
     * 
     * @return The title of the task.
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the description of the task.
     * 
     * @return The description of the task.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the submissions associated with the task.
     * 
     * @return An array of submissions associated with the task.
     */
    @Override
    public Submission[] getSubmissions() {
        return submissions;
    }

    /**
     * Retrieves the number of submissions associated with the task.
     * 
     * @return The number of submissions associated with the task.
     */
    @Override
    public int getNumberOfSubmissions() {
        return numberOfSubmissions;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n"
                + "\t\tStart: " + start + "\n"
                + "\t\tEnd: " + end + "\n"
                + "\t\tDuration: " + duration + "\n";

        // It was chosen that the description will not be shown because it takes up a
        // lot of space on the console.
    }
}
