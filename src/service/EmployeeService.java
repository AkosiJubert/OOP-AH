/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package service;

import model.Employee;
import repository.EmployeeRepository;

import java.util.List;

/*
 * Class: EmployeeService
 * Description: Manages employee-related operations such as
 *              creation, updating, deletion, and retrieval.
 *
 *              This service acts as the business logic layer
 *              between GUI and repository.
 */

/*
 * OOP PRINCIPLES APPLIED:
 *
 * 1. ABSTRACTION
 *    - Encapsulates employee CRUD logic away from the GUI.
 *
 * 2. ENCAPSULATION
 *    - Validates data before interacting with repository.
 */

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    // CONSTRUCTOR
    // Initializes repository dependency
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // METHOD NAME: addEmployee
    // Adds a new employee if ID does not already exist.
    public boolean addEmployee(Employee employee) {

        if (employee == null) {
            return false;
        }

        if (employeeRepository.findById(employee.getEmployeeId()) != null) {
            return false;
        }

        employeeRepository.addEmployee(employee);
        employeeRepository.saveEmployees();
        return true;
    }

    // METHOD NAME: updateEmployee
    // Updates an existing employee record.
    public boolean updateEmployee(Employee updatedEmployee) {

        if (updatedEmployee == null) {
            return false;
        }

        if (employeeRepository.findById(updatedEmployee.getEmployeeId()) == null) {
            return false;
        }

        employeeRepository.updateEmployee(updatedEmployee);
        employeeRepository.saveEmployees();
        return true;
    }

    // METHOD NAME: deleteEmployee
    // Removes employee by ID.
    public boolean deleteEmployee(int employeeId) {

        Employee employee = employeeRepository.findById(employeeId);
        if (employee == null) {
            return false;
        }

        employeeRepository.deleteEmployeeById(employeeId);
        employeeRepository.saveEmployees();
        return true;
    }

    // METHOD NAME: getEmployeeById
    // Retrieves employee by ID.
    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    // METHOD NAME: getAllEmployees
    // Retrieves all employees.
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}


