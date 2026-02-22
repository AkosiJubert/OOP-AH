/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package repository;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Class: EmployeeRepository
 * Description: Handles data persistence and retrieval of employee records
 *              from CSV storage.
 *
 * OOP PRINCIPLES APPLIED:
 *
 * 1. ABSTRACTION
 *    - Encapsulates all CSV reading and writing logic.
 *
 * 2. ENCAPSULATION
 *    - Manages internal employee list privately.
 */

public class EmployeeRepository {

    private static final String FILE_PATH = "src/resources/employee_record.csv";

    private List<Employee> employeeList;

    // =========================
    // CONSTRUCTOR
    // =========================

    public EmployeeRepository() {
        employeeList = new ArrayList<>();
        loadEmployees();
    }

    // =========================
    // ADD EMPLOYEE
    // =========================

    public void addEmployee(Employee employee) {
        if (employee != null) {
            employeeList.add(employee);
        }
    }

    // =========================
    // UPDATE EMPLOYEE
    // =========================

    public void updateEmployee(Employee updatedEmployee) {

        if (updatedEmployee == null) return;

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeId() == updatedEmployee.getEmployeeId()) {
                employeeList.set(i, updatedEmployee);
                return;
            }
        }
    }

    // =========================
    // DELETE EMPLOYEE
    // =========================

    // Delete by ID
    public void deleteEmployeeById(int employeeId) {
        employeeList.removeIf(emp -> emp.getEmployeeId() == employeeId);
    }

    // Overloaded delete (optional flexibility)
    public void deleteEmployee(Employee employee) {
        if (employee == null) return;
        deleteEmployeeById(employee.getEmployeeId());
    }

    // =========================
    // LOAD EMPLOYEES
    // =========================

    public void loadEmployees() {
        employeeList.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {

                List<String> data = splitCSVLine(line);
                if (data.size() < 19) continue;

                int id = Integer.parseInt(data.get(0));
                String lastName = data.get(1);
                String firstName = data.get(2);
                String birthday = data.get(3);
                String position = data.get(11);

                String department = determineDepartment(position);

                double basicSalary = Double.parseDouble(data.get(13).replace(",", ""));
                double riceSubsidy = Double.parseDouble(data.get(14).replace(",", ""));
                double phoneAllowance = Double.parseDouble(data.get(15).replace(",", ""));
                double clothingAllowance = Double.parseDouble(data.get(16).replace(",", ""));

                EmploymentStatus status = data.get(10).equalsIgnoreCase("Regular")
                        ? EmploymentStatus.REGULAR
                        : EmploymentStatus.PROBATIONARY;

                Employee employee = createEmployeeByRole(
                        id,
                        firstName,
                        lastName,
                        birthday,
                        position,
                        department,
                        basicSalary,
                        riceSubsidy,
                        phoneAllowance,
                        clothingAllowance,
                        status
                );

                employeeList.add(employee);
            }

        } catch (IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }

    // =========================
    // SAVE EMPLOYEES
    // =========================

    public void saveEmployees() {
        // Still placeholder – implement only if required by milestone
        System.out.println("Save functionality placeholder.");
    }

    // =========================
    // FIND BY ID
    // =========================

    public Employee findById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == id) {
                return emp;
            }
        }
        return null;
    }

    // =========================
    // GET ALL EMPLOYEES
    // =========================

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeList);
    }

    // =========================
    // HELPER METHODS
    // =========================

    private String determineDepartment(String position) {

        if (position.toLowerCase().contains("hr")) {
            return "HR";

        } else if (position.toLowerCase().contains("account")
                || position.toLowerCase().contains("finance")) {
            return "Finance";

        } else if (position.toLowerCase().contains("it")) {
            return "IT";

        } else {
            return "Operations";
        }
    }

    private Employee createEmployeeByRole(int id,
                                          String firstName,
                                          String lastName,
                                          String birthday,
                                          String position,
                                          String department,
                                          double basicSalary,
                                          double riceSubsidy,
                                          double phoneAllowance,
                                          double clothingAllowance,
                                          EmploymentStatus status) {

        if (department.equalsIgnoreCase("HR")) {

            return new HREmployee(id, firstName, lastName, birthday,
                    position, department, basicSalary,
                    riceSubsidy, phoneAllowance,
                    clothingAllowance, status);

        } else if (department.equalsIgnoreCase("Finance")) {

            return new FinanceEmployee(id, firstName, lastName, birthday,
                    position, department, basicSalary,
                    riceSubsidy, phoneAllowance,
                    clothingAllowance, status);

        } else if (department.equalsIgnoreCase("IT")) {

            return new ITEmployee(id, firstName, lastName, birthday,
                    position, department, basicSalary,
                    riceSubsidy, phoneAllowance,
                    clothingAllowance, status);

        } else {

            return new StaffEmployee(id, firstName, lastName, birthday,
                    position, department, basicSalary,
                    riceSubsidy, phoneAllowance,
                    clothingAllowance, status);
        }
    }

    // Safe CSV splitting (handles quoted commas)
    private List<String> splitCSVLine(String line) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            if (c == '\"') {
                inQuotes = !inQuotes;

            } else if (c == ',' && !inQuotes) {
                result.add(sb.toString().trim().replace("\"", ""));
                sb.setLength(0);

            } else {
                sb.append(c);
            }
        }

        result.add(sb.toString().trim().replace("\"", ""));
        return result;
    }
}

