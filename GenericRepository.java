import java.util.*;
interface Identifiable { int getId(); }
class Student implements Identifiable {
    private final int id; private final String name;
    Student(int id, String name) { this.id = id; this.name = name; }
    public int getId() { return id; }
    public String toString() { return id + " - " + name; }
}
class Repository<T extends Identifiable> {
    private final Map<Integer, T> records = new HashMap<>();
    public void save(T item) {
        if (records.containsKey(item.getId())) throw new IllegalArgumentException("Duplicate ID");
        records.put(item.getId(), item);
    }
    public Optional<T> findById(int id) { return Optional.ofNullable(records.get(id)); }
    public boolean delete(int id) { return records.remove(id) != null; }
    public List<T> findAll() { return new ArrayList<>(records.values()); }
}
public class GenericRepository {
    public static void main(String[] args) {
        Repository<Student> repo = new Repository<>();
        repo.save(new Student(1, "Riya"));
        repo.save(new Student(2, "Kabir"));
        System.out.println(repo.findById(1).orElseThrow());
        repo.findAll().forEach(System.out::println);
        repo.delete(2);
        System.out.println("Remaining: " + repo.findAll());
    }
}
