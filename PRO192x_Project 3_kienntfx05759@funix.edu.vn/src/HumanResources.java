import java.util.*;

public class HumanResources {

     static List<Staff> staffList =  new ArrayList();
     static List departmentList = new ArrayList();

     private static void showMenu(){
        System.out.println("1. Show all staff");
        System.out.println("2. Show all department");
        System.out.println("3. Show all staff in each department");
        System.out.println("4. Add employee");
        System.out.println("5. Add manager");
        System.out.println("6. Find staff by name");
        System.out.println("7. Show all staff's salary");
        System.out.println("8. Show all staff's salary in ascending order");
        System.out.println("9. Show all staff's salary in descending order");
        System.out.println("0. Exit program");
    }

    public static void main(String[] args) {



        Employee emp1 = new Employee(1,"kien",18,2,"12/02/2021",new Department(1,"Java"),3,4);
        Employee emp2 = new Employee(2,"thao",19,1,"12/03/2021",new Department(2,"Python"),3,5);
        Employee emp3 = new Employee(3,"hung",20,2,"10/02/2021",new Department(3,"C"),1,4);
        Employee emp4 = new Employee(1,"kien",18,2,"12/02/2020",new Department(1,"Java"),3,4);
        Manager mng  = new Manager(1,"kien",45,2,"20/01/2001",new Department(1,"Java"),4,"Project Leader");
        Manager mng1  = new Manager(1,"kien",46,2,"20/01/2001",new Department(2,"Python"),4,"Business Leader");

        staffList.add(emp1);
        staffList.add(emp2);
        staffList.add(emp3);
        staffList.add(emp4);
        staffList.add(mng);
        staffList.add(mng1);

        Scanner sc = new Scanner(System.in);
        int choose = 0;
        do {
            showMenu();
            System.out.print("Please select: ");
            switch (sc.nextInt()){
                case 0: // Thoát chương trình
                    choose = 0;
                    break;
                case 1: // Hiển thị toàn bộ employee và manager
                    if(staffList.size() == 0){
                        System.out.println("There is no staff!, please choose 4 or 5 to add staff");
                    }
                    for(int i = 0; i < staffList.size();i++){
                        System.out.println(staffList.get(i).displayInformation());
                    }
                    choose = 1;
                    break;

                case 2: // Hiển thị toàn bộ department
                    System.out.println(departmentList);
                    choose = 2;
                    break;

                case 3: // Hiển thị thông tin employee và manager trong từng department
                    for(int i = 0; i < departmentList.size(); i++){
                        System.out.println(departmentList.get(i));
                        for(int j = 0; j < staffList.size();j++){
                            if(departmentList.get(i).equals(staffList.get(j).getDepartment())){
                                System.out.println(staffList.get(j).displayInformation());
                            }
                        }
                        System.out.println("");
                    }
                    choose = 3;
                    break;

                case 4: // Thêm employee
                    Employee employee = new Employee();
                    employee.inputEmployee();
                    staffList.add(employee);
                    choose = 4;
                    break;

                case 5: // Thêm manager
                    Manager manager = new Manager();
                    manager.inputManager();
                    staffList.add(manager);
                    choose = 5;
                    break;

                case 6: // Tìm employee và manager theo tên
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("Input name: ");
                    String input = sc1.nextLine();
                    List name = new ArrayList();
                    for(int i = 0; i < staffList.size();i++){
                        name.add(staffList.get(i).getName());
                    }
                    while (name.contains(input.toLowerCase()) == false){
                        System.out.println("Name don't exist");
                        System.out.print("Input name: ");
                        input = sc1.nextLine();
                    }

                    for(int i = 0; i < staffList.size();i++){
                        if(input.equalsIgnoreCase(staffList.get(i).getName())){
                            System.out.println(staffList.get(i).displayInformation());
                        }
                    }
                    choose = 6;
                    break;

                case 7: // Hiển thị lương employee và manager
                    for(int i = 0; i < staffList.size(); i++){
                        if(staffList.get(i) instanceof Employee || staffList.get(i) instanceof Manager){
                            System.out.println(staffList.get(i).displayInformation() + ", Salary: " + ((ICaculator) staffList.get(i)).calculateSalary());
                        }

                    }
                    choose = 7;
                    break;

                case 8: // Hiển thị employee và manager theo thứ tự lương tăng dần
                    List salary = new ArrayList();
                    for(int i = 0; i < staffList.size(); i++){
                        if(staffList.get(i) instanceof Employee || staffList.get(i) instanceof Manager){
                            int salaryE =  ((ICaculator) staffList.get(i)).calculateSalary();
                            if(salary.contains(salaryE) == false){
                                salary.add(salaryE);
                            }
                        }
                    }
                    Collections.sort(salary);
                    for(int k = 0; k < salary.size();k++){
                        for(int j = 0; j < staffList.size(); j++){
                            if(staffList.get(j) instanceof Employee || staffList.get(j) instanceof Manager){
                                if(salary.get(k).equals(((ICaculator) staffList.get(j)).calculateSalary())){
                                    System.out.println(staffList.get(j).displayInformation() + ", Salary: " + ((ICaculator) staffList.get(j)).calculateSalary());
                                }
                            }
                        }
                    }
                    choose = 8;
                    break;

                case 9: // Hiển thị employee và manager theo thứ tự lương giảm dần
                    List salary1 = new ArrayList();
                    for(int i = 0; i < staffList.size(); i++){
                        if(staffList.get(i) instanceof Employee || staffList.get(i) instanceof Manager){
                            int salaryE =  ((ICaculator) staffList.get(i)).calculateSalary();
                            if(salary1.contains(salaryE) == false){
                                salary1.add(salaryE);
                            }
                        }
                    }
                    Collections.sort(salary1,Collections.reverseOrder());
                    for(int k = 0; k < salary1.size();k++){
                        for(int j = 0; j < staffList.size(); j++){
                            if(staffList.get(j) instanceof Employee || staffList.get(j) instanceof Manager){
                                if(salary1.get(k).equals(((ICaculator) staffList.get(j)).calculateSalary())){
                                    System.out.println(staffList.get(j).displayInformation() + ", Salary: " + ((ICaculator) staffList.get(j)).calculateSalary());
                                }
                            }
                        }
                    }
                    choose = 9;
                    break;

            }
            System.out.println("-------------------------------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------"
                    );
        }while (choose != 0);
    }
}
