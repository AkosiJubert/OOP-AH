/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package model;

/*
 * Class: EmploymentStatus
 * Description: Enumeration that defines the employment classification
 *              of an employee within the MotorPH Payroll System.
 *              It is used to distinguish between Regular and Probationary employees.
 *
 *              This classification supports labeling, filtering,
 *              and potential future business rules related to employment status.
 */

/*
 * OOP PRINCIPLE: ABSTRACTION
 * The enum abstracts the concept of employment classification
 * into a fixed set of meaningful constants.
 * It prevents invalid status values and ensures consistency
 * across the entire system.
 */

public enum EmploymentStatus {

    REGULAR,
    PROBATIONARY

}