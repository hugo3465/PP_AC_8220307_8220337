/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

package pp_ac_8220307_8220337.Application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Submission;
import ma02_resources.project.Task;
import pp_ac_8220307_8220337.Api.BaseContact;
import pp_ac_8220307_8220337.Api.BaseEdition;
import pp_ac_8220307_8220337.Api.BaseFacilitator;
import pp_ac_8220307_8220337.Api.BaseInstitution;
import pp_ac_8220307_8220337.Api.BasePartner;
import pp_ac_8220307_8220337.Api.BaseProject;
import pp_ac_8220307_8220337.Api.BaseStudent;
import pp_ac_8220307_8220337.Api.BaseSubmission;
import pp_ac_8220307_8220337.Api.BaseTask;


/**
 * The InitialTestingValues class provides initial testing values for various
 * objects related to the project management application.
 */
public class InitialTestingValues {
    // Create LocalDate objects for start and end dates
    LocalDate start1 = LocalDate.of(2023,06,01);
    LocalDate end1 = LocalDate.of(2023, 6, 10);
    LocalDate start2 = LocalDate.of(2023, 6, 5);
    LocalDate end2 = LocalDate.of(2023, 6, 15);
    LocalDate start3 = LocalDate.of(2023, 6, 10);
    LocalDate end3 = LocalDate.of(2023, 6, 20);
    LocalDate start4 = LocalDate.of(2023, 6, 15);
    LocalDate end4 = LocalDate.of(2023, 6, 25);
    LocalDate start5 = LocalDate.of(2023, 6, 20);
    LocalDate end5 = LocalDate.of(2023, 6, 30);

    // Create Contacts objects
    Contact contact1 = new BaseContact("Street 1", "City", "State", "12345", "Country", "123456789");
    Contact contact2 = new BaseContact("Street of New York", "New York City", "New York", "10001", "USA", "555-1234");
    Contact contact3 = new BaseContact("Rue de la Paix", "Paris", "Île-de-France", "75000", "France", "01-23456789");
    Contact contact4 = new BaseContact("Calle Principal", "Madrid", "Comunidad de Madrid", "28001", "Spain",
            "+34 123 456 789");
    Contact contact5 = new BaseContact("Via Roma", "Rome", "Lazio", "00100", "Italy", "+39 06 12345678");

    // Create Institutions objects
    Instituition institution1 = new BaseInstitution("University of Example", "university@example.com",
            InstituitionType.UNIVERSITY, contact1, "https://www.example.edu",
            "A prestigious university focused on research and education.");
    Instituition institution2 = new BaseInstitution("ABC Company", "company@example.com", InstituitionType.COMPANY,
            contact1, "https://www.abccompany.com",
            "A leading company in the industry providing innovative solutions.");
    Instituition institution3 = new BaseInstitution("XYZ NGO", "ngo@example.com", InstituitionType.NGO, contact1,
            "https://www.xyzngo.org",
            "A non-governmental organization dedicated to making a positive impact in society.");
    Instituition institution4 = new BaseInstitution("State University", "stateuniversity@example.com",
            InstituitionType.UNIVERSITY, contact1, "https://www.stateuniversity.edu",
            "A public university offering a wide range of academic programs.");
    Instituition institution5 = new BaseInstitution("Other Institution", "other@example.com", InstituitionType.OTHER,
            contact1, "https://www.otherinstitution.com",
            "An institution specializing in a unique field or area of expertise.");

    // Create BaseStudent objects
    Student student1 = new BaseStudent(123456, "John Doe", "john.doe@example.com", contact1, institution1);
    Student student2 = new BaseStudent(789012, "Jane Smith", "jane.smith@example.com", contact2, institution2);
    Student student3 = new BaseStudent(345678, "David Johnson", "david.johnson@example.com", contact3, institution3);
    Student student4 = new BaseStudent(901234, "Emily Davis", "emily.davis@example.com", contact4, institution4);
    Student student5 = new BaseStudent(567890, "Michael Wilson", "michael.wilson@example.com", contact5, institution5);

    // Create BasePartners objects
    BasePartner partner1 = new BasePartner("123456789", "https://www.partner1.com", "Partner 1", "partner1@example.com",
            contact1, institution1);
    BasePartner partner2 = new BasePartner("987654321", "https://www.partner2.com", "Partner 2", "partner2@example.com",
            contact2, institution2);
    BasePartner partner3 = new BasePartner("456789123", "https://www.partner3.com", "Partner 3", "partner3@example.com",
            contact3, institution3);
    BasePartner partner4 = new BasePartner("789123456", "https://www.partner4.com", "Partner 4", "partner4@example.com",
            contact4, institution4);
    BasePartner partner5 = new BasePartner("321654987", "https://www.partner5.com", "Partner 5", "partner5@example.com",
            contact5, institution5);

    // Create BaseFacilitatorss objects
    BaseFacilitator facilitator1 = new BaseFacilitator("Expertise 1", "Facilitator 1", "facilitator1@example.com",
            contact1, institution1);
    BaseFacilitator facilitator2 = new BaseFacilitator("Expertise 2", "Facilitator 2", "facilitator2@example.com",
            contact2, institution2);
    BaseFacilitator facilitator3 = new BaseFacilitator("Expertise 3", "Facilitator 3", "facilitator3@example.com",
            contact3, institution3);
    BaseFacilitator facilitator4 = new BaseFacilitator("Expertise 4", "Facilitator 4", "facilitator4@example.com",
            contact4, institution4);
    BaseFacilitator facilitator5 = new BaseFacilitator("Expertise 5", "Facilitator 5", "facilitator5@example.com",
            contact5, institution5);

    // Create BaseSubmissions objects
    BaseSubmission submission1 = new BaseSubmission(student1, LocalDateTime.now(), "Submission 1 text");
    BaseSubmission submission2 = new BaseSubmission(student2, LocalDateTime.now(), "Submission 2 text");
    BaseSubmission submission3 = new BaseSubmission(student3, LocalDateTime.now(), "Submission 3 text");
    BaseSubmission submission4 = new BaseSubmission(student4, LocalDateTime.now(), "Submission 4 text");
    BaseSubmission submission5 = new BaseSubmission(student5, LocalDateTime.now(), "Submission 5 text");

    // Create Tags Objects
    String[] tags1 = { "Web Development", "Data Analysis", "Research Study" };
    String[] tags2 = { "Web Development", "Sustainable Development", "Research Study" };
    String[] tags3 = { "Community Outreach", "Data Analysis", "Research Study" };
    String[] tags4 = { "Marketing Campaign", "Data Analysis", "Research Study" };
    String[] tags5 = { "Graphic Design", "Event Planning", "Research Study" };

    // Create Task objects
    Task task1 = new BaseTask(start1, end1, 10, "Task 1", "Description 1",
            new Submission[] { submission1, submission2 });
    Task task2 = new BaseTask(start2, end2, 11, "Task 2", "Description 2",
            new Submission[] { submission2, submission4 });
    Task task3 = new BaseTask(start3, end3, 12, "Task 3", "Description 3", new Submission[] { submission3 });
    Task task4 = new BaseTask(start4, end4, 13, "Task 4", "Description 4",
            new Submission[] { submission4, submission5, submission3 });
    Task task5 = new BaseTask(start5, end5, 14, "Task 5", "Description 5", new Submission[] { submission5 });

    // Create Projects Objects
    Project project1 = new BaseProject("Project 1", "Description for Project 1", 4, 1, 1, 2, 2,
            new Participant[] { partner1, facilitator1, student1, student2 },
            tags1, new Task[] { task1, task2 });

    Project project2 = new BaseProject("Project 2", "Description for Project 2", 3, 0, 1, 2, 2,
            new Participant[] { facilitator2, student3, student4 }, tags2, new Task[] { task2, task3 });

    Project project3 = new BaseProject("Project 3", "Description for Project 3", 4, 1, 1, 2, 2,
            new Participant[] { partner4, facilitator5, student1, student5 }, tags3, new Task[] { task2, task3 });

    Project project4 = new BaseProject("Project 4", "Description for Project 4", 5, 2, 1, 2, 3,
            new Participant[] { partner4, partner3, facilitator4, student3, student4 }, tags4,
            new Task[] { task3, task4, task5 });

    Project project5 = new BaseProject("Project 5", "Description for Project 5", 5, 0, 1, 4, 4,
            new Participant[] { facilitator3, student1, student2, student3, student4 }, tags5,
            new Task[] { task1, task2, task3, task4 });

    /**
     * Editions Test Values
     */
    public Edition edition1 = new BaseEdition("Edition 1", "Template 1", Status.ACTIVE,
            new Project[] { project1, project2 }, start1, end1);

    public Edition edition2 = new BaseEdition("Edition 2", "Template 2", Status.INACTIVE,
            new Project[] { project3, project4 }, start2, end2);

    public Edition edition3 = new BaseEdition("Edition 3", "Template 3", Status.CLOSED,
            new Project[] { project3, project4, project5 }, start3, end3);

}
