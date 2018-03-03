package practice.example.aakash.myretrofitpractice.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aakash on 3/3/18.
 */

public class EmployeeList {
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @SerializedName("employeeList")
    private List<Employee> employeeList;


    public EmployeeList(List<Employee>employeeList){
        this.employeeList=employeeList;

    }
}
