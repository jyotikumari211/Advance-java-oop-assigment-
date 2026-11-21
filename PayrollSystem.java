import java.util.*;

abstract class Employee {
    private final int id;
    private final String name;
    protected Employee(int id, String name) {
        this.id = id; this.name = Objects.requireNonNull(name);
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public abstract double calculateSalary();
    public void printPaySlip() {
        System.out.printf("%d | %s | Salary: %.2f%n", id, name, calculateSalary());
    }
}
class FullTimeEmployee extends Employee {
    private final double monthlySalary, bonus;
    FullTimeEmployee(int id, String name, double monthlySalary, double bonus) {
        super(id, name);
        if (monthlySalary < 0 || bonus < 0) throw new IllegalArgumentException("Salary/bonus cannot be negative");
        this.monthlySalary = monthlySalary; this.bonus = bonus;
    }
    @Override public double calculateSalary() { return monthlySalary + bonus; }
}
class ContractEmployee extends Employee {
    private final int hours;
    private final double hourlyRate;
    ContractEmployee(int id, String name, int hours, double hourlyRate) {
        super(id, name);
        if (hours < 0 || hourlyRate < 0) throw new IllegalArgumentException("Invalid contract details");
        this.hours = hours; this.hourlyRate = hourlyRate;
    }
    @Override public double calculateSalary() { return hours * hourlyRate; }
}
public class PayrollSystem {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new FullTimeEmployee(101, "Aarav", 45000, 5000),
            new ContractEmployee(102, "Meera", 120, 400)
        );
        employees.forEach(Employee::printPaySlip); // Runtime polymorphism
    }
}
