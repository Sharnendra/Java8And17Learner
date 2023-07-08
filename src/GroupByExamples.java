import modal.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByExamples {

    public static void main(String[] args) {
        List<Employee> employee = Employee.getEmployee();

        Map<String, List<String>> collect = employee.stream()
            .collect(Collectors.groupingBy(Employee::getName, Collectors.flatMapping(val ->
                    val.getAddress().stream().map(x -> x.getCity()), Collectors.toList()
            )));

        System.out.println(collect);
    }
}

