/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package model;

/*
 * Class: ITEmployee
 * Description: Represents employees responsible for system administration functions.
 *              Authorized to reset passwords and manage system-level controls.
 */

/*
 * OOP PRINCIPLE: INHERITANCE & POLYMORPHISM
 * ITEmployee extends Employee and overrides permission methods
 * to enable system administration features.
 */

public class ITEmployee extends Employee {

    // =========================
    // CONSTRUCTOR
    // =========================

    // ITEmployee Constructor
    // Creates an IT employee with password reset privileges
    public ITEmployee(int employeeId,
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
        return false;
    }

    // Determines if employee can process payroll
    @Override
    public boolean canProcessPayroll() {
        return false;
    }

    // Determines if employee can reset passwords
    @Override
    public boolean canResetPassword() {
        return true;
    }
}