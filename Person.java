public abstract class Person {
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        setAge(age);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public abstract void performRole();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}