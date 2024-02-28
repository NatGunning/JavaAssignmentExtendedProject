package CakeCompany;

public class QualityController extends Employee {
    public QualityController(String name, int cakes) {
        super(name, cakes);
    }

    @Override
    public double getWages() {
        return super.getWages() * 1.12;
    }
    @Override
    public String toString()
    {
        return String.format("%-10s %5s %7s", "QC "+super.getName(), super.getCakes(), super.formatWages(super.getWages()));
    }
}