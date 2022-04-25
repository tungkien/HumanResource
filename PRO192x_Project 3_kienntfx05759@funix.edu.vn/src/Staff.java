import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Staff{
    private int id;
    private String name;
    private int age;
    private int salaryIndex;
    private Date dateJoin;
    private Department department;
    private int numberOfDayOff;

    public Staff() {
    }

    public Staff(int id, String name, int age, int salaryIndex, String sDateJoin, Department department, int numberOfDayOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryIndex = salaryIndex;
        Date dateJoin = null;
        try {
            dateJoin = new SimpleDateFormat("dd/MM/yyyy").parse(sDateJoin);
        } catch (ParseException e) {
        }
        this.dateJoin = dateJoin;
        this.department = department;
        checkDepartment();
        this.numberOfDayOff = numberOfDayOff;
    }

    public int getId() { // Hàm lấy id
        return id;
    }

    public void inputId() { // Hàm nhập id
        Scanner sc = new Scanner(System.in);
        System.out.print("Id: ");
        int input = sc.nextInt();
        if(HumanResources.staffList.size() == 0){
            id = input;
        }
        for(int i = 0; i < HumanResources.staffList.size(); i++){
            Staff staff = HumanResources.staffList.get(i);
            while (staff.getId() == input){
                System.out.print("Id exist! ");
                System.out.print("Id: ");
                input = sc.nextInt();
            }
        }
        id = input;
    }

    public String getName() { // Hàm lấy tên
        return name;
    }

    public void inputName() { // Hàm nhập tên
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        name = sc.next();
    }

    public int getAge() {
        return age;
    } // Hàm lấy tuổi

    public void inputAge() { // Hàm nhập tuổi
        Scanner sc = new Scanner(System.in);
        System.out.print("Age: ");
        age = sc.nextInt();
    }

    public int getSalaryIndex() {
        return salaryIndex;
    } // Hàm nhập hệ số lương

    public void inputSalaryIndex() { // Hàm nhập hệ số lương
        Scanner sc = new Scanner(System.in);
        System.out.print("Salary index: ");
        salaryIndex = sc.nextInt();
    }

    public Date getDateJoin() {
        return dateJoin;
    } // Hàm lấy ngày tháng năm

    public void inputDateJoin()  { // Hàm nhập ngày tháng năm
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            System.out.print("Date join (dd/mm/yyyy): ");
            date = df.parse(sc.nextLine());
        } catch (ParseException e) {
        }
        dateJoin = date;
    }

    public Department getDepartment() {
        return department;
    } // Hàm lấy văn phòng

    public void inputDepartment() { //Hàm nhập văn phòng
        Department department = new Department();
        department.inputDepartmentId();
        department.inputDepartmentName();
        this.department = department;
        checkDepartment();
    }

    public int getNumberOfDayOff() {
        return numberOfDayOff;
    } // Hàm lấy số ngày nghỉ

    public void inputNumberOfDayOff() { // Hàm nhập số ngày nghỉ
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of day off: ");
        numberOfDayOff = sc.nextInt();

    }

    public abstract String displayInformation(); // Hàm hiển thị thông tin

    public void inputStaff(){ // Hàm nhập thông tin staff
        inputId();
        inputName();
        inputAge();
        inputSalaryIndex();
        inputDateJoin();
        inputDepartment();
        inputNumberOfDayOff();
    }

    public void checkDepartment(){ // Hàm kiểm tra nếu các department trùng nhau thì trỏ về cùng một địa chỉ nếu khác nhau thì add mới vào departmnetList
       List departmentList = HumanResources.departmentList;
        if(departmentList.size() == 0){
            departmentList.add(this.department);
        }
        for(int i = 0; i < departmentList.size(); i++){
            if(this.department.equals(departmentList.get(i))){
                this.department = (Department) departmentList.get(i);
                this.department.getNumberOfEmployee();
                break;
            }
        }
        if(departmentList.contains(this.department) == false){
            departmentList.add(this.department);
            this.department.getNumberOfEmployee();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalaryIndex(int salaryIndex) {
        this.salaryIndex = salaryIndex;
    }

    public void setDateJoin(Date dateJoin) {
        this.dateJoin = dateJoin;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setNumberOfDayOff(int numberOfDayOff) {
        this.numberOfDayOff = numberOfDayOff;
    }

}



