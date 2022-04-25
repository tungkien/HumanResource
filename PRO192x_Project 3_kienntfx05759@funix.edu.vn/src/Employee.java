import java.util.Scanner;

public class Employee extends Staff implements ICaculator{
    private int overTime;

    public Employee() {
    }

    public Employee(int id, String name, int age, int salaryIndex, String sDateJoin, Department department, int numberOfDayOff, int overTime) {
        super(id, name, age, salaryIndex, sDateJoin, department, numberOfDayOff);
        this.overTime = overTime;
    }

    public int getOverTime() { // Hàm trả về overtime
        return overTime;
    }

    public void inputOverTime() { // Hàm nhập overtime
        Scanner sc = new Scanner(System.in);
        System.out.print("Over time: ");
        overTime = sc.nextInt();
    }

    @Override
    public String displayInformation() { // Hàm hiển thị thông tin employee
        return "Id: " + getId() + ", Name: " + getName() + ", Age: " + getAge() + ", Salary index: " + getSalaryIndex() + ", Date join: "
                + getDateJoin() + ", Department: " + getDepartment() + ", Number of day off: " + getNumberOfDayOff()
                + ", Overtime: " + getOverTime();
    }

    @Override
    public int calculateSalary() { //hàm tính lương của employee trả về lương employee nhận được
        int salary = getSalaryIndex() * 3000000 + getOverTime() * 200000;
        return salary;
    }

    public void inputEmployee(){ //hàm nhập thông tin employee
        super.inputStaff();
        inputOverTime();

    }

}
