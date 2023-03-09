import pro.sky.java.course1.course_work.Employee;
import java.util.Scanner; //утилита сканнер

public class Main {

    public static void main(String[] args) {

        int id=1; // создали счетчик ID
        Employee[] employee= new Employee[10]; // создали хранилище данных о работниках
        employee[0] = new  Employee("PyotrPetrov", 70000,1, id);
        employee[1] = new  Employee("DmitriyDmitriev", 80000,1, id);
        employee[2] = new Employee("KonstantinKonstantinov", 71000,1, id);
        employee[3] = new Employee("IvanIvanov", 45000,2, id);
        employee[4] = new  Employee("AleksandrAleksandrov", 33000,2, id);
        employee[5] = new Employee("AndreyAndreev", 48000,3, id);
        employee[6] = new Employee("AlekseyAlekseev", 200000,4, id);
        employee[7] = new  Employee("MaksimMaksimov", 90000,4, id);
        employee[8] = new Employee("DenisDenisov", 50000,5, id);
        employee[9] = new Employee("AntonAntonov", 100000,5, id);

        Scanner scanner = new Scanner(System.in); // создали утилиту сканнер
        System.out.println("Введите номер отдела (1-5)");
        int deptID= scanner.nextInt(); // присваиваем значение переменной deptID следующее введенное число
        System.out.println();

        maxSalary(employee,deptID); //работник с максимальной зарплатой в введенном отделе
        minSalary(employee,deptID); //работник с минимальной зарплатой в введенном отделе
        calculateSalary(employee,deptID); //сумма и средняя зарплата в отделе

        System.out.println("Введите процент индексации");
        double percent = scanner.nextInt(); // присваиваем значение переменной percent следующее введенное число
        System.out.println();

        System.out.println("Индексируем зарплату");
        increaseSalary(employee,deptID,percent); // индексируем зарплату
        getAllData(employee,deptID); // выводим данные всех работников отдела после индексации
        System.out.println();

        System.out.println("Введите число (зарплату)");
        double salaryDiff = scanner.nextDouble(); // присваиваем значение переменной salaryDiff следующее введенное число

        System.out.println("Сотрудники с зарплатой меньше "+ salaryDiff);
        for (int i = 0; i < employee.length; i++) {
        if (salaryDiff>employee[i].getSalary()) {
            System.out.println(employee[i]);
        }
        }
        System.out.println(); // выводим сотрудников с зарплатой меньше введенного числа

        System.out.println("Сотрудники с зарплатой больше "+ salaryDiff);
        for (int i = 0; i < employee.length; i++) {
            if (salaryDiff<=employee[i].getSalary()) {
                System.out.println(employee[i]);
            }
        }// выводим сотрудников с зарплатой больше введенного числа
    }

    public static void getAllData (Employee[] employee, int deptID) { // метод для получения всей информации о сотрудниках отдела
        for (Employee object:employee){
            if (object.getDept()==deptID) {
                System.out.println(object);
            }
        }
        System.out.println();
    }
    public static void calculateSalary(Employee[] employee, int deptID) { // метод для вычисления средней и суммарной зарплаты в отделе
        int sum = 0;
        int counter=0;
        for (Employee object:employee ) {
            counter++;
            if (object.getDept()==deptID) {
                sum += object.getSalary();
            }
        }
        double averageSalary=sum/counter;
        System.out.println("Сумма зарплат в отделе "+deptID+": " + sum);
        System.out.println("Средняя зарплата в отделе "+deptID+": "+averageSalary);
        System.out.println();
    }
    public static void maxSalary (Employee[] employee, int deptID) { // метод для нахождения работника с максимальной зарплатой
        double max=0;
        int maxId=0;
        for (Employee object:employee ){
            if (object.getDept()==deptID && object.getSalary()>max) {
                max=object.getSalary();
                maxId=object.getId();
            }
        }
        System.out.println(employee[maxId-1].getEmployeeName()+" - работник с максимальной зарплатой");
        System.out.println();
    }
    public static void minSalary (Employee[] employee, int deptID) { // метод для нахождения работника с минимальной зарплатой
        double min = 100000000;
        int minId=0;
        for (Employee object:employee ){
            if (object.getDept()==deptID && object.getSalary()<min) {
                min=object.getSalary();
                minId=object.getId();
            }
        }
        System.out.println(employee[minId-1].getEmployeeName()+" - работник с минимальной зарплатой");
        System.out.println();
    }
    public static void employeeNames (Employee[] employee, int deptID){ // метод для вывода ФИО сотрудников отдела
        System.out.println("ФИО Сотрудников:");
        for (Employee object:employee ) {
            System.out.println(object.getEmployeeName());
        }
        System.out.println();
    }
    public static void increaseSalary (Employee[] employee, int deptID, double percent){ // метод для индексации зарплаты сотрудников отдела
        double index = 1 + percent/100;
        for (Employee object:employee ) {
            if (object.getDept() == deptID) {
                object.setSalary(object.getSalary() * index);
            }
        }
    }

}