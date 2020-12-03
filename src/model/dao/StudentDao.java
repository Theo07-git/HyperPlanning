package model.dao;

import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao implements StudentDaoInterface{

    private Connection connect;
    ResultSet resultSet;

    // Constructeur
    public StudentDao(Connection connect){ this.connect = connect; }

    /**
     * Retourne un étudiant trouvé par son id
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Student findById(String id) throws SQLException, ClassNotFoundException {
        Student student = new Student();

        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE idUser = " + id);
            ResultSet result1 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM student WHERE id_UserS = " + id);
            if(result.first() && result1.first()) {
                student = new Student(
                        id,
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("permission"),
                        result1.getString("number"),
                        result1.getString("id_group_promotionS"));
            }
            else System.out.println("Erreur identification eleve non trouve");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    /**
     * Requête sql : insertion
     * Créée l'étudiant et l'utilisateur associé
     * @param student
     */
    public void createStudent(Student student) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO user VALUES('" + student.getId() + "', '" + student.getEmail() + "', '" + student.getPassword() + "', '" + student.getLastName() + "', '" + student.getFirstName() + "', '" + student.getPermission() + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "INSERT INTO student VALUES('" + student.getId() + "', '" + student.getStudentNumber() + "', '" + student.getIdGroupPromotion() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Requête sql : suppression
     * Supprime l'étudiant à l'aide de son id
     * @param idStudent
     */
    public void deleteStudent(String idStudent) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM student WHERE (id_UserS = '" + idStudent + "')");
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM user WHERE idUser = '" + idStudent + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remplit le resultSet avec la requête sql
     * en fonction de l'id d'un groupe
     * @param idGroupPromotion
     */
    public void resultSetByGroupPromotion(String idGroupPromotion) {
        try{
            resultSet = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user JOIN student ON user.idUser = student.id_UserS WHERE student.id_group_promotionS ='" + idGroupPromotion + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Remplit un étudiant en fonction de l'id d'un groupe et retourne true tant qu'il y a un étudiant dans le resultSet
     * @param student
     * @return
     */
    public boolean resultSetByGroupPromotionNext(Student student) {
        boolean found = false;
        try{
            if(resultSet.next()){
                found = true;
                student.setId(resultSet.getString("idUser"));
                student.setEmail(resultSet.getString("email"));
                student.setPassword(resultSet.getString("password"));
                student.setLastName(resultSet.getString("last_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setPermission(resultSet.getString("permission"));
                student.setStudentNumber(resultSet.getString("number"));
                student.setIdGroupPromotion(resultSet.getString("id_group_promotionS"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found;
    }
}

