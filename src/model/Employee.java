/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package model;

/*
 * Class: Employee
 * Description: Abstract parent class that represents the fundamental
 *              business entity of the MotorPH Payroll System.
 *
 *              This class defines the core attributes and behaviors
 *              common to all employees regardless of role or employment status.
 *
 *              It serves as the base abstraction for role-based subclasses
 *              such as HR, Finance, IT, and Staff employees.
 *
 *              Login Rule:
 *              Username = Employee ID
 *              Password = Birthday
 */

/*
 * OOP PRINCIPLES APPLIED:
 *
 * 1. ENCAPSULATION
 *    - All fields are private.
 *    - Access is controlled through getters.
 *
 * 2. ABSTRACTION
 *    - Represents a generalized employee concept.
 *    - Defines abstract permission methods that must be implemented
 *      by concrete subclasses.
 *
 * 3. INHERITANCE
 *    - Serves as the superclass for specialized employee subclasses.
 */

public abstract class Employee {

    // =========================
    // ATTRIBUTES (Encapsulated)
    // =========================

    private int employeeId;
    private String firstName;
    private String lastName;
    private String birthday; // Used as login password
    private String position;
    private String department;

    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;

    private EmploymentStatus employmentStatus;

    // =========================
    // CONSTRUCTOR
    // =========================

    // Employee Constructor
    // Initializes core employee attributes
    public Employee(int employeeId,
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

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.position = position;
        this.department = department;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.employmentStatus = employmentStatus;
    }

    // =========================
    // GETTERS
    // =========================

    // GET Employee ID (Username)
    public int getEmployeeId() {
        return employeeId;
    }

    // GET First Name
    public String getFirstName() {
        return firstName;
    }

    // GET Last Name
    public String getLastName() {
        return lastName;
    }

    // GET Full Name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // GET Birthday (Password)
    public String getBirthday() {
        return birthday;
    }

    // GET Position
    public String getPosition() {
        return position;
    }

    // GET Department
    public String getDepartment() {
        return department;
    }

    // GET Basic Salary
    public double getBasicSalary() {
        return basicSalary;
    }

    // SET Basic Salary
    // Used only by authorized roles (e.g., Finance)
    public void setBasicSalary(double basicSalary) {

        if (basicSalary < 0) {
            throw new IllegalArgumentException("Basic salary cannot be negative.");
        }

        this.basicSalary = basicSalary;
    }

    // GET Rice Subsidy
    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    // GET Phone Allowance
    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    // GET Clothing Allowance
    public double getClothingAllowance() {
        return clothingAllowance;
    }

    // GET Total Allowances
    public double getTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }

    // GET Employment Status
    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    // =========================
    // ABSTRACT PERMISSION METHODS
    // =========================

    // Determines if employee can manage employee records
    public abstract boolean canManageEmployees();

    // Determines if employee can process payroll
    public abstract boolean canProcessPayroll();

    // Determines if employee can reset passwords
    public abstract boolean canResetPassword();

}