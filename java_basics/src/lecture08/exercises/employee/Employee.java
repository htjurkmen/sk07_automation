package lecture08.exercises.employee;

public class Employee {
    private final int id;
    private double salaryPerMonth;
    private final String firstName;
    private final String lastName;

    public Employee(int id, double salaryPerMonth, String firstName, String lastName) {
        this.id = id;
        this.salaryPerMonth = salaryPerMonth;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public double raiseSalary(int percent) {
        this.salaryPerMonth += this.salaryPerMonth * percent;
        return this.salaryPerMonth;
    }

    public double getAnnualSalary() {
        return this.salaryPerMonth * 12;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee name: ").append(this.getName());
        sb.append("\n");
        sb.append("Employee annual salary ").append(this.getAnnualSalary());
        return sb.toString();
    }
}
