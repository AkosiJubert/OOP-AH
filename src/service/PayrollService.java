/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package service;

import model.Employee;
import repository.AttendanceRepository;

import java.time.LocalDate;

/*
 * Class: PayrollService
 * Description: Centralizes all payroll-related computations
 *              and salary processing logic.
 *
 * OOP PRINCIPLES APPLIED:
 *
 * 1. ABSTRACTION
 *    - Encapsulates payroll computation logic.
 *
 * 2. METHOD OVERLOADING
 *    - Supports multiple calculateNetSalary methods.
 *
 * 3. POLYMORPHISM
 *    - Works on Employee abstraction, allowing
 *      different subclasses to be processed uniformly.
 */

public class PayrollService {

    private static final double STANDARD_MONTHLY_HOURS = 160.0;

    private final AttendanceRepository attendanceRepository;

    // CONSTRUCTOR (Dependency Injection)
    public PayrollService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // CONSTRUCTOR (Convenience)
    public PayrollService() {
        this.attendanceRepository = new AttendanceRepository();
    }

    // =========================
    // HOURS WORKED
    // =========================

    // METHOD NAME: calculateHoursWorked
    // Placeholder monthly hours (no date range)
    public double calculateHoursWorked(Employee employee) {
        return (employee == null) ? 0.0 : STANDARD_MONTHLY_HOURS;
    }

    // METHOD NAME: calculateHoursWorked (Overloaded)
    // Returns total hours worked within "YYYY-MM-DD to YYYY-MM-DD"
    public double calculateHoursWorked(Employee employee, String dateRange) {

        if (employee == null || dateRange == null) {
            return 0.0;
        }

        LocalDate[] range = parseDateRange(dateRange);
        if (range == null) {
            return 0.0;
        }

        return attendanceRepository.getHoursWorked(employee.getEmployeeId(), range[0], range[1]);
    }

    // =========================
    // GROSS SALARY
    // =========================

    // METHOD NAME: calculateGrossSalary
    // Computes gross salary including allowances.
    public double calculateGrossSalary(Employee employee) {

        if (employee == null) {
            return 0.0;
        }

        return employee.getBasicSalary()
                + employee.getRiceSubsidy()
                + employee.getPhoneAllowance()
                + employee.getClothingAllowance();
    }

    // =========================
    // DEDUCTIONS (Simplified)
    // =========================

    // METHOD NAME: calculateDeductions
    // Computes total statutory deductions (simplified).
    public double calculateDeductions(Employee employee) {

        if (employee == null) {
            return 0.0;
        }

        double gross = calculateGrossSalary(employee);

        double sss = gross * 0.045;
        double philHealth = gross * 0.03;
        double pagIbig = 100;
        double withholdingTax = gross * 0.10;

        return sss + philHealth + pagIbig + withholdingTax;
    }

    // =========================
    // NET SALARY
    // =========================

    // METHOD NAME: calculateNetSalary
    // Computes net salary without date range.
    public double calculateNetSalary(Employee employee) {

        if (employee == null) {
            return 0.0;
        }

        double gross = calculateGrossSalary(employee);
        double deductions = calculateDeductions(employee);

        return gross - deductions;
    }

    // METHOD NAME: calculateNetSalary (Overloaded)
    // Computes net salary using actual hours worked.
    public double calculateNetSalary(Employee employee, double hoursWorked) {

        if (employee == null || hoursWorked <= 0) {
            return 0.0;
        }

        double hourlyRate = employee.getBasicSalary() / STANDARD_MONTHLY_HOURS;
        double adjustedBasic = hourlyRate * hoursWorked;

        double gross = adjustedBasic
                + employee.getRiceSubsidy()
                + employee.getPhoneAllowance()
                + employee.getClothingAllowance();

        double sss = gross * 0.045;
        double philHealth = gross * 0.03;
        double pagIbig = 100;
        double withholdingTax = gross * 0.10;

        double deductions = sss + philHealth + pagIbig + withholdingTax;

        return gross - deductions;
    }

    // METHOD NAME: calculateNetSalary (Overloaded)
    // Computes net salary using attendance hours within selected pay period.
    public double calculateNetSalary(Employee employee, String dateRange) {

        if (employee == null || dateRange == null) {
            return 0.0;
        }

        LocalDate[] range = parseDateRange(dateRange);
        if (range == null) {
            return 0.0;
        }

        double hoursWorked = attendanceRepository.getHoursWorked(employee.getEmployeeId(), range[0], range[1]);
        return calculateNetSalary(employee, hoursWorked);
    }

    // =========================
    // PAYSLIP
    // =========================

    // METHOD NAME: generatePayslip
    // Returns formatted payslip summary (no date range).
    public String generatePayslip(Employee employee) {

        if (employee == null) {
            return "Invalid employee.";
        }

        double gross = calculateGrossSalary(employee);
        double deductions = calculateDeductions(employee);
        double net = calculateNetSalary(employee);

        return "---------------------------------------\n"
                + "MotorPH Payroll System\n"
                + "Employee: " + employee.getFullName() + "\n"
                + "Position: " + employee.getPosition() + "\n"
                + "---------------------------------------\n"
                + "Gross Salary: " + String.format("%.2f", gross) + "\n"
                + "Total Deductions: " + String.format("%.2f", deductions) + "\n"
                + "Net Salary: " + String.format("%.2f", net) + "\n"
                + "---------------------------------------";
    }

    // =========================
    // HELPER
    // =========================

    // METHOD NAME: parseDateRange
    // Parses "YYYY-MM-DD to YYYY-MM-DD" into LocalDate start/end.
    private LocalDate[] parseDateRange(String dateRange) {
        try {
            String[] parts = dateRange.split(" to ");
            if (parts.length != 2) return null;

            LocalDate start = LocalDate.parse(parts[0].trim());
            LocalDate end = LocalDate.parse(parts[1].trim());

            return new LocalDate[]{start, end};
        } catch (Exception e) {
            return null;
        }
    }
}


