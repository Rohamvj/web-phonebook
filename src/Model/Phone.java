package Model;

import Global.DbConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Phone {

    private int phoneId, personId, type;
    private String number;

    public final static int TYPE_MOBILE = 1, TYPE_HOME = 2, TYPE_WORK = 3;


    public Phone(int phoneId) {
        this.phoneId = phoneId;

        DbConnector db = new DbConnector();
        ResultSet rset = null;

        rset = db.querySelect("select * from tbl_phone where phone_id=" + phoneId);
        try {
            rset.first();
            personId = rset.getInt(2);
            type = rset.getInt(4);
            number = rset.getString(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void newNumber(Person person, String number, int type) {
        DbConnector db = new DbConnector();
        db.queryInsert("insert into tbl_phone (person_id,number,type) value (" + person.getPersonId() + ",'" + number + "'," + type + " ) ");
    }


    public Person getPerson() {
        return new Person(personId);
    }

    public int getPhoneId() {
        return phoneId;
    }

    public int getPersonId() {
        return personId;
    }

    public int getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
