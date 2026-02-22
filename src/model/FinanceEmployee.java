/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package model;

/*
 * Class: FinanceEmployee
 * Description: Represents employees assigned to payroll and financial operations.
 *              Authorized to process payroll and update salary-related data.
 */

/*
 * OOP PRINCIPLE: INHERITANCE & POLYMORPHISM
 * FinanceEmployee extends Employee and overrides permission methods
 * to enable payroll processing features.
 */

public class FinanceEmployee extends Employee {

    // =========================
    // CONSTRUCTOR
    // =========================

    // FinanceEmployee Constructor
    // Creates a Finance employee with payroll processing privileges
    public FinanceEmployee(int employeeId,
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
        return true;
    }

    // Determines if employee can reset passwords
    @Override
    public boolean canResetPassword() {
        return false;
    }
}