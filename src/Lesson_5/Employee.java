package Lesson_5;

public class Employee {

    private String fullName;
    private String post;
    private String email;
    private String number;
    private int salary;
    private int age;

    public Employee(String fullName, String post, String email, String number, int salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void info() {
        System.out.println( "Employee{" +
                "fullName='" + fullName + '\'' +
                ", post='" + post + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}');
    }
}
