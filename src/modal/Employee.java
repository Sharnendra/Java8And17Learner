package modal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Created by JavaDeveloperZone on 29-04-2017.
 */
public class Employee  {
    private int no;
    private String name;
    private String designation;
    private String gender;
    private int salary;
    private List<Address> address;
    private java.util.Set<String> language = new HashSet<String>();
    public Employee(int no, String name, String designation, String gender,int salary) {
        this.no = no;
        this.name = name;
        this.designation = designation;
        this.gender = gender;
        this.salary  = salary;
    }
    public int getNo() {
        return no;
    }
    public List<Address> getAddress() {
        return address;
    }
    public void setAddress(List<Address> address) {
        this.address = address;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return this.no + " : " + this.name + " : " + gender + " : " + designation;
    }
    public String addLanguage(String language) {
        this.language.add(language);
        return language;
    }
    public Set<String> getLanguage() {
        return language;
    }
    public static java.util.List<Employee> getEmployee() {
        List<Address> addressList = new ArrayList<>();
        Address ad1 = new Address();
        ad1.setCity("Haryana");
        addressList.add(ad1);
        ad1.setCity("LT");
        addressList.add(ad1);

        Employee em1 = new Employee(1, "Bob", "Developer", "Male",30000);
        em1.addLanguage("Hindi");
        em1.addLanguage("English");
        em1.setAddress(addressList);

        java.util.List<Employee> employees = new ArrayList<>();
        employees.add(em1);
        /*employees.add(new modal.Employee(2, "Joy", "Sr. Developer", "Male",72000));
        employees.add(new modal.Employee(3, "John", "CEO", "Male",100000));
        employees.add(new modal.Employee(4, "Bat", "Developer", "Male",35000));
        employees.add(new modal.Employee(5, "Jolly", "Developer", "Female",36000));
        employees.add(new modal.Employee(6, "Bobby", "Developer", "Female",12000));*/
        return employees;
    }
}