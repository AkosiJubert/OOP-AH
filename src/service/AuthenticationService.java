/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package service;

import model.Employee;
import repository.EmployeeRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/*
 * Class: AuthenticationService
 * Description: Handles user authentication and role identification.
 *
 * OOP PRINCIPLES APPLIED:
 *
 * 1. ABSTRACTION
 *    - Encapsulates authentication logic away from GUI.
 *
 * 2. POLYMORPHISM
 *    - Returns Employee reference that may hold different subclass types.
 */

public class AuthenticationService {

    private EmployeeRepository employeeRepository;
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("MM/dd/yyyy");

    // =========================
    // CONSTRUCTOR
    // =========================

    public AuthenticationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // =========================
    // AUTHENTICATE METHOD
    // =========================

    public Employee authenticate(int employeeId, String password) {

        Employee employee = employeeRepository.findById(employeeId);

        if (employee == null) {
            return null;
        }

        try {

            LocalDate storedBirthday =
                    LocalDate.parse(employee.getBirthday(), formatter);

            LocalDate inputBirthday =
                    LocalDate.parse(password, formatter);

            if (storedBirthday.equals(inputBirthday)) {
                return employee;
            }

        } catch (DateTimeParseException e) {
            return null; // malformed date in CSV or input
        }

        return null;
    }
}

