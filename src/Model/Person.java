package Model;

import Global.DbConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {

    private int personId;
    private String name, family;

    public Person(int personId) {
        this.personId = personId;
        DbConnector db = new DbConnector();
        ResultSet rset = null;
        rset = db.querySelect(" select * from tbl_person where person_id=" + personId);
        try {
            rset.first();
            name = rset.getString(2);
            family = rset.getString(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db = null;
    }

    public static void newPerson(String name, String family) {
        DbConnector db = new DbConnector();
        db.queryInsert("insert into tbl_person (name,family) value ('" + name + "','" + family + "') ");
        db = null;
    }

    public static void deletePerson(int personId) {
        DbConnector db = new DbConnector();
        db.queryInsert("  delete from tbl_person where person_id= " + personId);
        db = null;
    }

    public void updateName(String name) {
        DbConnector db = new DbConnector();
        db.queryUpdate("update tbl_person set name='" + name + "' where person_id= " + personId);
        db = null;
    }

    public void updateFamily(String family) {
        DbConnector db = new DbConnector();
        db.queryUpdate("update tbl_person set family='" + family + "' where person_id= " + personId);
        db = null;
    }


    public int getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }
}
