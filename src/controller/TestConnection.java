package controller;

import model.Student;
import model.User;
import java.sql.SQLException;

public class TestConnection {

    private String email;
    private String mdp;
    private String permission;
    private boolean isConnect;

    public TestConnection() {
        isConnect = false;
    }

    public void isConnected(String email, String mdp) throws SQLException, ClassNotFoundException {
        User user = new User();

        user = user.findByEmail(email);

        if (mdp.equals(user.getPassword()) && ( email.equals(user.getEmail()) || email.equals(user.getId()))){
            System.out.println("Connexion Réussi");
            isConnect = true;
            this.permission = user.getPermission();
            this.email = email;
            this.mdp = mdp;
        }
        else
            System.out.println("Connexion Échoué : Vous avez entrez mdp:"+mdp+" id:"+email);
    }

    /*public void permissionChoice() throws SQLException, ClassNotFoundException {
        switch (permission) {
            case "STUDENT" -> {
                Student student = new Student();

                student = student.findByEmail(email);

                DAO<Student> StudentDao = DAOInstance.getStudentDao();
                Student student = StudentDao.find(IdUSER);
                System.out.println("STUDENT: "+student.getFirstName());
                P_Acceuil_Student pageAcceuil_student = new P_Acceuil_Student(student);
                pageAcceuil_student.fenetre();
                pageAcceuil_student.setVisible(true);
            }
            case "TEACHER" -> {
                DAO<Teacher> TeacherDao = DAOInstance.getTeacherDao();
                Teacher teacher = TeacherDao.find(IdUSER);
                P_Acceuil_Teacher pageAcceuil_teacher = new P_Acceuil_Teacher(teacher);
                pageAcceuil_teacher.fenetre();
                pageAcceuil_teacher.setVisible(true);
            }
            case "EDUCATIONAL REFERENT" -> {

                P_Acceuil_Educational_Referent pageAcceuil_EducationalReferent = new P_Acceuil_Educational_Referent(user); // Trouver Moyen De reference par id ? nom/prenom ? la personne qui c'est log
                pageAcceuil_EducationalReferent.fenetre();
                pageAcceuil_EducationalReferent.setVisible(true);
            }
            case "ADMIN" -> {
                P_Acceuil_Admin pageAcceuil = new P_Acceuil_Admin(user); // Trouver Moyen De reference par id ? nom/prenom ? la personne qui c'est log
                pageAcceuil.fenetre();
                pageAcceuil.setVisible(true);
            }
            default -> System.out.println("Erreur - Permission non reconnu");
        }
    }*/

    public boolean getIsConnect() {
        return isConnect;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
