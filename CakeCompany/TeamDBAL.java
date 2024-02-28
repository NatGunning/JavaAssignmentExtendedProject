package CakeCompany;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class TeamDBAL
{
    private ArrayList<Employee> employees = new ArrayList<>();

    public TeamDBAL() throws SQLException
    {
        readAllEmployees();
    }

    public void readAllEmployees() throws SQLException
    {
        String dbURL = "jdbc:mysql://localhost:3306/summer_project";
        Connection conn = getConnection(dbURL, "root", "**********");
        String query = "SELECT * FROM employee";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next())
        {
            this.employees.add(new Employee(rs.getString("name"), rs.getInt("cakes_covered")));
        }

        stmt.close();
        conn.close();
    }
    public ArrayList<Employee> getEmployees()
    {
        return this.employees;
    }

}
