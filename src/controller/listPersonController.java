package controller;

import Global.DbConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ListPersonController")
public class listPersonController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listPerson.jsp");

        ArrayList<ArrayList> personList = new ArrayList<>();


        DbConnector db = new DbConnector();

        ResultSet rset = null;

        rset = db.querySelect("select * from tbl_person");
        try {
            while (rset.next()) {

                ArrayList<String> tmp = new ArrayList<>();

                tmp.add(rset.getString(2));
                tmp.add(rset.getString(3));

                personList.add(tmp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        req.setAttribute( "personList", personList );


        dispatcher.forward(req, resp);


    }
}
