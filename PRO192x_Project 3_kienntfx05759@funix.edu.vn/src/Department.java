
import java.util.Objects;
import java.util.Scanner;

public class Department {
    private int departmentId;
    private String departmentName;
    private int numberOfEmployee = 0;

    public Department() {
    }

    public Department(int departmentId, String departmentName, int numberOfEmployee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.numberOfEmployee = numberOfEmployee;
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public void inputDepartmentId() { // Hàm nhập department id
        Scanner sc = new Scanner(System.in);
        System.out.print("Id department: ");
        departmentId = sc.nextInt();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void inputDepartmentName() { // Hàm nhập department name
        Scanner sc = new Scanner(System.in);
        System.out.print("Department name: ");
        departmentName = sc.next();
    }

    public int getNumberOfEmployee() { // Hàm trả về numberOfEmployee
        return numberOfEmployee++;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() { // Phương thức toString hiển thị dữ liệu của đối tượng
        return "{" +
                "departmentId: " + departmentId +
                ", departmentName: " + departmentName +
                ", numberOfEmployee: " + numberOfEmployee +
                '}';
    }

    @Override
    public boolean equals(Object o) { // Ghi đè lại phương thức equals để có thể só sánh hai đối tượng với nhau
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId
                && Objects.equals(departmentName, that.departmentName);
    }

}
