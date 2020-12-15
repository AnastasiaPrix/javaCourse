package Lesson_5;

public class Main {

    public static void main(String[] args) {
        int lookingAge = 40;

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Developer", "ivanov@mail.ru", "88451002000", 70000, 32);
        employees[1] = new Employee("Petrov Petr", "Developer", "petrovP@mail.ru", "89652454550", 80000, 41);
        employees[2] = new Employee("Lukin Aleksey", "Engineer", "LukinAleks@mail.ru", "89001234350", 50000, 45);
        employees[3] = new Employee("Zapasova Olga", "Accountant", "zapas@mail.ru", "89612364790", 50000, 27);
        employees[4] = new Employee("Kalinkina Natalia", "Manager", "kalinkinaN@mail.ru", "89751543513", 45000, 53);

        for (Employee i: employees) {
            if (i.getAge() > lookingAge) {
                i.info();
            }
        }
    }
}
