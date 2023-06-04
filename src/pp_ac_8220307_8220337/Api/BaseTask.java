package pp_ac_8220307_8220337.Api;

import java.time.LocalDate;

import ma02_resources.project.Submission;
import ma02_resources.project.Task;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class BaseTask implements Task {
    private final int DEFAULT_NUMBER_SUBMISSIONS = 1;
    private LocalDate start;
    private LocalDate end;
    private int duration;
    private String title;
    private String description;
    private Submission[] submissions;
    private int numberOfSubmissions;

    /**
     * Constructs a BaseTask.
     * 
     * @param start
     * @param end
     * @param duration
     * @param title
     * @param description
     * @param submissions
     */
    public BaseTask(LocalDate start, LocalDate end, int duration, String title, String description,
            BaseSubmission[] submissions) {
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.submissions = submissions;
        this.numberOfSubmissions = submissions.length;
    }

    /**
     * Constructs a BaseTask.
     * 
     * This constructor is mostly used in the addTask in the BaseProject Class
     * 
     * @param title
     * @param description
     * @param startAt
     * @param duration
     */
    public BaseTask(String title, String description, int startAt, int duration) {
        this.start = LocalDate.of(startAt, LocalDate.now().getMonth(), LocalDate.now().getYear());
        this.end = start.plusDays(duration);
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.submissions = new BaseSubmission[DEFAULT_NUMBER_SUBMISSIONS];
        this.numberOfSubmissions = 0;
    }

    /**
     * 
     * Adds a submission to the task.
     * 
     * @param submission The submission to be added.
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

        // TODO Adicionar submissões a projetos de uma edição ativa apenas por
        // estudantes pertencentes aos projetos respetivos.
    }

    @Override
    public void extendDeadline(int arg0) {
        this.end = end.plusDays(arg0);
    }

    @Override
    public int compareTo(Task arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
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
        return "\tTitle: " + title + "\n"
                + "\tStart: " + start + "\n"
                + "\tEnd: " + end + "\n"
                + "\tDuration: " + duration + "\n";

        // It was chosen that the description will not be shown because it takes up a
        // lot of space on the console.
    }
}
