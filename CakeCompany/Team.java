package CakeCompany;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;


class Team
{
    private ArrayList<Employee> team;
    private TeamDBAL teamDBAL = new TeamDBAL();
    public Team() throws SQLException
    {
        this.team = teamDBAL.getEmployees();
    }

    public void addEmployee(Employee employee)
    {
        this.team.add(employee);
    }

    public String displayTeam()
    {
        StringBuilder str = new StringBuilder();
        for (Employee x : team)
        {
            str.append(x);
            str.append("\n");
        }
        return str.toString();
    }

    public int getTotalCakes()
    {
        int totalCakes = 0;
        for (Employee y : team)
        {
            totalCakes += y.getCakes();
        }
        return totalCakes;
    }

    public double getTotalWages()
    {
        double totalWages = 0;
        for (Employee z : team)
        {
            totalWages += z.getWages();
        }
        return totalWages;
    }

    public void sortList()
    {
        Collections.sort(team);
    }


    //Returns the arrayList as an observable list in AllEmployeesScreenController
    public ObservableList<Employee> getTeamAsOAL()
    {
        return FXCollections.observableArrayList(team);
    }


}
