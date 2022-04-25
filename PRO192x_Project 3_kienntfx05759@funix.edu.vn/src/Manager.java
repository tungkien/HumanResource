import java.util.Scanner;

public class Manager extends Staff implements ICaculator{
    private String position;

    public Manager() {
    }

    public Manager(String position) {
        this.position = position;
    }

    public Manager(int id, String name, int age, int salary, String sDateJoin, Department department, int numberOfDayOff, String position) {
        super(id, name, age, salary, sDateJoin, department, numberOfDayOff);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void inputPosition() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Position: ");
        String input  = sc.nextLine();
        while (input.equalsIgnoreCase("business leader") == false && input.equalsIgnoreCase("project leader") == false && input.equalsIgnoreCase("technical leader") == false){
            System.out.print("Position invalid! ");
            System.out.print("Position: ");
            input = sc.nextLine();
        }
        position = input;
    }

    @Override
    public String displayInformation() { // Ghi đè lại phương thức displayInformation() từ class cha trả về theo kiểu manager
        return "Id: " + getId() + ", Name: " + getName() + ", Age: " + getAge() + ", Salary index: " + getSalaryIndex() + ", Date join: "
                + getDateJoin() + ", Department: " + getDepartment() + ", Number of day off: " + getNumberOfDayOff()
                + ", Position: " + getPosition();
    }

    public void inputManager(){ // Hàm nhập thông tin manager
        super.inputStaff();
        inputPosition();
    }

    @Override
    public int calculateSalary() { // Hàm tính lương của manager
        int responsibility = 0;
        if (this.position.equalsIgnoreCase("business leader")){
            responsibility = 8000000;
        }

        if (this.position.equalsIgnoreCase("project leader")){
            responsibility = 5000000;
        }

        if (this.position.equalsIgnoreCase("technical leader")){
            responsibility = 6000000;
        }
        int salary = getSalaryIndex() * 5000000 + responsibility;
        return salary;
    }
}
