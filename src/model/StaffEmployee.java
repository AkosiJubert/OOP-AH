/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package model;

/*
 * Class: StaffEmployee
 * Description: Represents general employees without HR, Finance, or IT privileges.
 *              Access is limited to employee self-service features only.
 */

/*
 * OOP PRINCIPLE: INHERITANCE & POLYMORPHISM
 * StaffEmployee extends Employee and overrides permission methods
 * to restrict access to administrative features.
 */

public class StaffEmployee extends Employee {

    // =========================
    // CONSTRUCTOR
    // =========================

    // StaffEmployee Constructor
    // Creates a general staff employee with self-service access only
    public StaffEmployee(int employeeId,
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
        return false;
    }
}