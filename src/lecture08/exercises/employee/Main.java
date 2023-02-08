package lecture08.exercises.employee;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(1, 200, "Harry", "Potter");
        String name = employee.getName();
        double annualSalary = employee.getAnnualSalary();
        System.out.println(employee);
    }
}
