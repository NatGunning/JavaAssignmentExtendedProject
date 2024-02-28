package CakeCompany;

import java.text.NumberFormat;
import java.util.Locale;


public class Employee implements Comparable<Employee>
{
    private String name;
    private int cakes;

    public Employee(){}
    public Employee(String name, int cakes)
    {
        this.name = name;
        this.cakes = cakes;
    }

    public String formatWages(double wage)
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
        return formatter.format(wage);
    }

    public String getName()
    {
        return name;
    }
    public int getCakes()
    {
        return this.cakes;
    }


    public double getWages()
    {
        if (this.cakes <= 50)
        {
            return this.cakes * 0.1;
        }
        else
        {
            return 5 + (this.cakes - 50) * 0.15 ;
        }
    }

    public void addCakes(int addedCakes) throws Exception {
        if (addedCakes > 0)
        {
            this.cakes += addedCakes;
        }
        else
        {
            throw new Exception("An Unusable Value Was Entered.");
        }

    }

    public void minusCakes(int unusedCakes) throws Exception {
        if (unusedCakes > 0)
        {
            this.cakes -= (unusedCakes * 2);
            if (this.cakes < 0)
            {
                this.cakes = 0;
            }
        }
        else
        {
            throw new Exception("An Unusable Value Was Entered");
        }
    }

    @Override
    public String toString()
    {
        return String.format("%-10s %5s %7s", this.name, this.cakes, this.formatWages(this.getWages()));
    }

    @Override
    public int compareTo(Employee o)
    {
        if (o.cakes > this.cakes)
        {
            return 1;
        }
        else if (o.cakes < this.cakes)
        {
            return -1;
        }
        else
        {
            return this.name.compareTo(o.name);
        }
    }
}

