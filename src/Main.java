import com.sun.javafx.scene.EnteredExitedHandler;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Main {



    public static void main(String[] args) {

        Employee employee1 = new Employee(1234L, "meg", "Margaret", "employee");
        Employee employee2 = new Employee(5678L, "joel", "Joel", "employee");
        Employee employee3 = new Employee(9123L, "francis", "Francis", "employee");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        Task task1 = new Task(1111L, "Task 1", "Task 1");
        Task task2 = new Task(2222L, "Task 2", "Task 1");
        Task task3 = new Task(3333L, "Task 3", "Task 1");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        EmployeeTask employeeTask1 = new EmployeeTask(911L, employee1, task1, "Unaswered");
        EmployeeTask employeeTask2 = new EmployeeTask(922L, employee1, task2, "Pending");
        EmployeeTask employeeTask3 = new EmployeeTask(933L, employee1, task3, "Pending");

        EmployeeTask employeeTask4 = new EmployeeTask(944L, employee2, task1, "Unaswered");
        EmployeeTask employeeTask5 = new EmployeeTask(955L, employee2, task2, "Pending");
        EmployeeTask employeeTask6 = new EmployeeTask(966L, employee2, task3, "Approved");

        List<EmployeeTask> employeeTaskList = new ArrayList<>();
        employeeTaskList.add(employeeTask1);
        employeeTaskList.add(employeeTask2);
        employeeTaskList.add(employeeTask3);
        employeeTaskList.add(employeeTask4);
        employeeTaskList.add(employeeTask5);
        employeeTaskList.add(employeeTask6);


        Map<Employee, Map<Task, Map<String, Long>>> collect = employeeTaskList.stream().collect(
                groupingBy(EmployeeTask::getEmployee,
                        groupingBy(EmployeeTask::getTask,
                                groupingBy(EmployeeTask::getStatus,
                                        Collectors.counting()
                                )
                        )
                )
        );



        Map<Employee, Map<String,  Long>> collect2 = employeeTaskList.stream().collect(
                groupingBy(EmployeeTask::getEmployee,
                        groupingBy(EmployeeTask::getStatus,
                                //groupingBy(EmployeeTask::getTask,
                                        Collectors.counting()
                               // )
                        )
                )
        );

        Iterator it = collect2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Employee, Map<String, Long>> pair = (Map.Entry<Employee, Map<String, Long>>)it.next();
            System.out.println(pair.getKey().getName() );
            Iterator it2 = pair.getValue().entrySet().iterator();

            while (it2.hasNext()){
                Map.Entry<String, Long> pair2 = (Map.Entry<String, Long>) it2.next();
               String formatted =  String.format(" \t Task Type %s, Count %d", pair2.getKey(), pair2.getValue());
                System.out.println(formatted);
            }
        }

    }


}
