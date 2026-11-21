import java.util.*;
import java.util.stream.*;
class Learner {
    private final int roll; private final String name; private final double marks;
    Learner(int roll, String name, double marks) { this.roll=roll; this.name=name; this.marks=marks; }
    public int getRoll() { return roll; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public String toString() { return roll + " " + name + " " + marks; }
}
public class StudentManagementStreams {
    public static void main(String[] args) {
        List<Learner> students = Arrays.asList(
            new Learner(1, "Asha", 86), new Learner(2, "Dev", 72),
            new Learner(3, "Ira", 94), new Learner(4, "Neil", 58)
        );
        List<Learner> toppers = students.stream()
            .filter(s -> s.getMarks() >= 75)
            .sorted(Comparator.comparingDouble(Learner::getMarks).reversed())
            .collect(Collectors.toList());
        toppers.forEach(System.out::println);
        double average = students.stream().mapToDouble(Learner::getMarks).average().orElse(0);
        System.out.printf("Class average: %.2f%n", average);
    }
}
