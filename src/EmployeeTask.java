/**
 * Created by meg on 9/14/17.
 */
public class EmployeeTask {

    Long id;
    Employee employee;
    Task task;
    String status;

    public EmployeeTask(Long id, Employee employee, Task task, String status) {
        this.id = id;
        this.employee = employee;
        this.task = task;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
