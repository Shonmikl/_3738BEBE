package _14_11_2022;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataBase {
    List<Employee> employeeList = new LinkedList<>();
    Map<BusinessPosition, List<Employee>> map = new HashMap<>();


    public void addEmp(Employee employee) {
        employeeList.add(employee);
    }

    public int getListSize(List<Employee> list) {
        return list.size();
    }
}
