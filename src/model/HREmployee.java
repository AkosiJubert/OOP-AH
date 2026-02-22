/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package model;

/*
 * Class: HREmployee
 * Description: Represents employees assigned to the Human Resources department
 *              with employee management privileges.
 */

/*
 * OOP PRINCIPLE: INHERITANCE & POLYMORPHISM
 * HREmployee extends Employee and overrides permission methods
 * to enable employee management features.
 */

public class HREmployee extends Employee {

    // =========================
    // CONSTRUCTOR
    // =========================

    // HREmployee Constructor
    // Creates an HR employee with employee management privileges
    public HREmployee(int employeeId,
                      String firstName,
                      String lastName,
                      String birthday,
                      String position,
                      String department,
                      double basicSalary,
                      double riceSubsidy,
                      double phoneAllowance,
                      double clothingAllowance,
                      EmploymentStatus employmentStatus) {

        super(employeeId, firstName, lastName, birthday, position, department,
              basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, employmentStatus);
    }

    // =========================
    // PERMISSIONS (Overrides)
    // =========================

    // Determines if employee can manage employee records
    @Override
    public boolean canManageEmployees() {
        return true;
    }

    // Determines if employee can process payroll
    @Override
    public boolean canProcessPayroll() {
        return false;
    }

    // Determines if employee can reset passwords
    @Override
    public boolean canResetPassword() {
        return false;
    }
}