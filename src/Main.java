import Controller.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.*;


public class Main {


    public static void main(String[] args ){

        System.out.println("Test");

////////--- Creation du Campus Virtuel-----/////

        /** Creation des salles*/
        Room room1 = new Room("F303", 30, "Salle Info");
        Room room2 = new Room("F303", 40, "Amphi St-Ex");
        /** Creation deliste de salle*/
        List<Room> ListRoomCampusLyon = Arrays.asList(room1, room2);


        /** Creation de Site*/
        Site lyon = new Site("LY", "ECE-Lyon", ListRoomCampusLyon);


        /** Creation des student*/
        Student st1 = new Student("th", "th@", "mdp", "Perrier@", "auhodd",1 , 20938);
        Student st2 = new Student("Sa", "sa@", "mdp", "Quintana@", "dqnjf",1 , 20939);
        Student st3 = new Student("S", "s@", "mdp", "Quin@", "kqjbf", 1, 20940);
        Student st4 = new Student("a", "a@", "mdp", "tana@", "kjfbd",1 , 20942);
        Student st5 = new Student("T", "T@", "mdp", "Perr@", "kfjz", 1, 20942);
        /** Creation des listes d'etudiants */
        List<Student> listStudentGrp1 = Arrays.asList(st1, st3, st4);
        List<Student> listStudentGrp2 = Arrays.asList(st2, st5);

        /** Creation list de cours ( vide ) */
        List<Course> ListeCoursGrp1 = new ArrayList<>();
        List<Course> ListeCoursGrp2 = new ArrayList<>();



        /** Creation des groupe d'étudiants */
        Group Grp_1 = new Group("GR1", "Groupe 1",ListeCoursGrp1 ,listStudentGrp1);
        Group Grp_2 = new Group("GR2", "Groupe 2",ListeCoursGrp2, listStudentGrp2);
        /** Creation deliste de groupe*/
        List<Group> ListGroupCampusLyon = Arrays.asList(Grp_1, Grp_2);


        /** Creation des promotions*/
        Promotion promotionTest = new Promotion("ING1", "ING1", ListGroupCampusLyon );

        /** Affectation des valeurs d'ID*/
        //st1.setIdPromotion(promotionTest);
        //st1.setIdGroupPromotion(gp1);




        /////////////////////////////



        /** Creation des teachers*/
        Teacher teacher1 = new Teacher("NM", "mauti", "michalak", "mauti@inseec", "nico",2);
        Teacher teacher2 = new Teacher("AH", "hintzy", "antoine", "hintzy@inseec", "antoine",2);



        /** Creation des listes de profs*/
        List<Teacher> listTeacher = Collections.singletonList(teacher1);
        List<Teacher> listTeacher2 = Collections.singletonList(teacher2);

        /** Creation des sessions*/
        Session session1 = new Session("MA", 2, "27-10-2020-00:00:00", "14:30:00", "16:00:00" , listTeacher);
        //Session session2 = new Session("MA", 2, "27-10-2020", "16:00:00", "17:30:00", Session.State.VALIDATED);

        /** Creation de listes de sessions*/
        List<Session> listSession = Collections.singletonList(session1);

        /** Creation des cours*/
        Course cours1 = new Course("Ma", "Mathématiques", listSession);




        main__app();

        /** Visualisation en console*/
        System.out.println(Grp_1.toString());
        System.out.println(Grp_2.toString());
        System.out.println(promotionTest.toString());
    }

    private static void main__app() {


        System.out.println("Interface Connection");
        System.out.println("                 ");
        System.out.println("                 ");
        System.out.println("Identifiant :    ");
        Scanner input_Id  = new Scanner(System.in);
        System.out.println("                 ");
        System.out.println("Mot de Passe :   ");
        Scanner input_Password = new Scanner(System.in);
        System.out.println("Connection Reussi ");


        // implementer Fonction Login, True si bonne id et mdp, false sinon + println("identifiant ou mdp erroné")

        //if login :
    }
}
