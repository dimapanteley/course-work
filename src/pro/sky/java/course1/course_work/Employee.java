package pro.sky.java.course1.course_work;

public class Employee {
    private String employeeName;
    private double salary;
    private int dept;
    private int id;
    public static int counter = 1;

    public Employee (String employeeName, int salary, int dept,int id) { // создали класс Employee
        this.employeeName=employeeName;
        this.salary=salary;
        this.dept=dept;
        this.id=counter++;
        }

        public String getEmployeeName () { // геттер для имени
        return this.employeeName;
        }
        public double getSalary () { // геттер для зарплаты
        return this.salary;
        }
        public int getDept () { // геттер для номера отдела
        return this.dept;
        }
        public int getId () { // геттер для ID сотрудника
        return this.id;
        }
        public void setSalary (double salary) { // сеттер для зарплаты
        this.salary=salary;
        }
        public void setDept (int dept) { // сеттер для отдела
        this.dept=dept;
        }
        public String toString() { // вывод полной информации о сотруднике
        return "ID работника - "+this.id+", Имя работника - "+this.employeeName+", Зарплата работника - "+this.salary;
        }

}
