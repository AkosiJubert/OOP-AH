/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package ui;

import model.Employee;
import service.EmployeeService;
import service.PayrollService;

import javax.swing.JOptionPane;

/*
 * Class: HoursWorkedPanel
 * Description: GUI panel that fetches an employee by ID and computes salary
 *              based on actual hours worked within a selected pay period.
 */

/*
 * OOP PRINCIPLE: ABSTRACTION
 * This panel does not parse attendance files directly.
 * It delegates hours computation to PayrollService.
 */

public class HoursWorkedPanel extends javax.swing.JPanel {

    private final EmployeeService employeeService;
    private final PayrollService payrollService;
    private Employee currentEmployee;

    // CONSTRUCTOR
    // Initializes UI and service dependencies
    public HoursWorkedPanel(EmployeeService employeeService,
                            PayrollService payrollService) {
        
        initComponents();
        this.employeeService = employeeService;
        this.payrollService = payrollService;
        
        populateDateRanges();
        clearOutputs();
    }

    // METHOD NAME: populateDateRanges
    // Loads predefined pay period ranges into the combo box.
    private void populateDateRanges() {

        String[] ranges = {
                "2024-06-01 to 2024-06-15", "2024-06-16 to 2024-06-30",
                "2024-07-01 to 2024-07-15", "2024-07-16 to 2024-07-31",
                "2024-08-01 to 2024-08-15", "2024-08-16 to 2024-08-31",
                "2024-09-01 to 2024-09-15", "2024-09-16 to 2024-09-30",
                "2024-10-01 to 2024-10-15", "2024-10-16 to 2024-10-31",
                "2024-11-01 to 2024-11-15", "2024-11-16 to 2024-11-30",
                "2024-12-01 to 2024-12-15", "2024-12-16 to 2024-12-31"
        };

        jcbDateRange.removeAllItems();
        jcbDateRange.addItem("Select Pay Period...");
        for (String r : ranges) {
            jcbDateRange.addItem(r);
        }
    }

    // METHOD NAME: fetchEmployee
    // Retrieves employee object from EmployeeService and updates UI outputs.
    private void fetchEmployee() {

        int employeeId;

        try {
            employeeId = Integer.parseInt(textFieldEmpNo.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Employee Number.");
            clearOutputs();
            currentEmployee = null;
            return;
        }

        currentEmployee = employeeService.getEmployeeById(employeeId);

        if (currentEmployee == null) {
            JOptionPane.showMessageDialog(this, "Employee not found.");
            clearOutputs();
            return;
        }

        labelOutputEmpNo.setText(String.valueOf(currentEmployee.getEmployeeId()));
        labelOutputName.setText(currentEmployee.getFullName());
        labelOutputBasic.setText(String.format("%.2f", currentEmployee.getBasicSalary()));
        labelOutputHoursWorked.setText("");
    }

    // METHOD NAME: calculateSalaryOnHours
    // Computes salary using total hours from PayrollService for the selected pay period.
    private void calculateSalaryOnHours() {

        if (currentEmployee == null) {
            JOptionPane.showMessageDialog(this, "Please fetch employee first.");
            return;
        }

        if (jcbDateRange.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a pay period.");
            return;
        }

        String selectedRange = jcbDateRange.getSelectedItem().toString();

        if ("Select Pay Period...".equals(selectedRange)) {
            JOptionPane.showMessageDialog(this, "Please select a pay period.");
            return;
        }

        double hoursWorked = payrollService.calculateHoursWorked(currentEmployee, selectedRange);

        // Salary-on-hours uses hourly rate derived from monthly salary basis
        double hourlyRate = currentEmployee.getBasicSalary() / 160.0;
        double salaryOnHours = hoursWorked * hourlyRate;

        labelOutputHoursWorked.setText(String.format("%.2f", salaryOnHours));
    }

    // METHOD NAME: clearOutputs
    // Clears all output labels for a clean UI state.
    private void clearOutputs() {
        labelOutputEmpNo.setText("");
        labelOutputName.setText("");
        labelOutputBasic.setText("");
        labelOutputHoursWorked.setText("");
    }

    /** NetBeans-generated UI setup (components and layout) */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHoursWorked = new javax.swing.JPanel();
        labelPayCoverage = new javax.swing.JLabel();
        btnCalculateSalary = new javax.swing.JButton();
        labelEmpNo2 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelBasicSalary = new javax.swing.JLabel();
        labelHoursWorked = new javax.swing.JLabel();
        jcbDateRange = new javax.swing.JComboBox<>();
        labelOutputEmpNo = new javax.swing.JLabel();
        labelOutputBasic = new javax.swing.JLabel();
        labelcolon1 = new javax.swing.JLabel();
        labelOutputHoursWorked = new javax.swing.JLabel();
        labelcolon2 = new javax.swing.JLabel();
        labelcolon3 = new javax.swing.JLabel();
        labelcolon4 = new javax.swing.JLabel();
        labelOutputName = new javax.swing.JLabel();
        labelEmpNo = new javax.swing.JLabel();
        textFieldEmpNo = new javax.swing.JTextField();
        buttonSubmit = new javax.swing.JButton();
        separator = new javax.swing.JSeparator();

        labelPayCoverage.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPayCoverage.setText("Pay Coverage:");

        btnCalculateSalary.setBackground(new java.awt.Color(0, 51, 0));
        btnCalculateSalary.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnCalculateSalary.setForeground(new java.awt.Color(255, 255, 255));
        btnCalculateSalary.setText("Calculate Salary");
        btnCalculateSalary.setToolTipText("");
        btnCalculateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateSalaryActionPerformed(evt);
            }
        });

        labelEmpNo2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEmpNo2.setText("Employee NO.");

        labelName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelName.setText("Name");

        labelBasicSalary.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelBasicSalary.setText("Basic Salary");

        labelHoursWorked.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelHoursWorked.setText("Salary on Hours Worked");

        jcbDateRange.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jcbDateRange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Pay Period..." }));

        labelOutputEmpNo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelOutputBasic.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelcolon1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelcolon1.setText(":");

        labelOutputHoursWorked.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelcolon2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelcolon2.setText(":");

        labelcolon3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelcolon3.setText(":");

        labelcolon4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelcolon4.setText(":");

        labelOutputName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelEmpNo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEmpNo.setText("Employee NO.:");

        textFieldEmpNo.setBackground(new java.awt.Color(204, 204, 204));
        textFieldEmpNo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        buttonSubmit.setBackground(new java.awt.Color(0, 51, 0));
        buttonSubmit.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        buttonSubmit.setForeground(new java.awt.Color(255, 255, 255));
        buttonSubmit.setText("Submit");
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHoursWorkedLayout = new javax.swing.GroupLayout(panelHoursWorked);
        panelHoursWorked.setLayout(panelHoursWorkedLayout);
        panelHoursWorkedLayout.setHorizontalGroup(
            panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoursWorkedLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHoursWorkedLayout.createSequentialGroup()
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelName)
                            .addComponent(labelBasicSalary)
                            .addComponent(labelHoursWorked)
                            .addComponent(labelEmpNo2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelcolon1)
                            .addComponent(labelcolon2)
                            .addComponent(labelcolon3)
                            .addComponent(labelcolon4))
                        .addGap(75, 75, 75)
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelOutputHoursWorked, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOutputBasic, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOutputEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOutputName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(panelHoursWorkedLayout.createSequentialGroup()
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelPayCoverage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelEmpNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbDateRange, 0, 184, Short.MAX_VALUE)
                            .addComponent(textFieldEmpNo))
                        .addGap(18, 18, 18)
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCalculateSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoursWorkedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator)
                .addContainerGap())
        );
        panelHoursWorkedLayout.setVerticalGroup(
            panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoursWorkedLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmpNo)
                    .addComponent(textFieldEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSubmit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPayCoverage)
                    .addComponent(btnCalculateSalary)
                    .addComponent(jcbDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEmpNo2)
                    .addComponent(labelOutputEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelcolon1))
                .addGap(40, 40, 40)
                .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHoursWorkedLayout.createSequentialGroup()
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelName)
                            .addComponent(labelcolon2))
                        .addGap(40, 40, 40)
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBasicSalary)
                            .addComponent(labelcolon3))
                        .addGap(40, 40, 40)
                        .addGroup(panelHoursWorkedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelHoursWorked)
                            .addComponent(labelcolon4)))
                    .addGroup(panelHoursWorkedLayout.createSequentialGroup()
                        .addComponent(labelOutputName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelOutputBasic, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(labelOutputHoursWorked, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHoursWorked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHoursWorked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Computes salary based on hours worked in the selected pay period,
     * then displays the basic salary and computed amount.
     */
    private void btnCalculateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateSalaryActionPerformed
      
    }//GEN-LAST:event_btnCalculateSalaryActionPerformed

    /**
     * Fetches an employee’s details by EmpNo, displays number and name,
     * and clears any previous salary‐on‐hours output.
     */
    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed

    }//GEN-LAST:event_buttonSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculateSalary;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JComboBox<String> jcbDateRange;
    private javax.swing.JLabel labelBasicSalary;
    private javax.swing.JLabel labelEmpNo;
    private javax.swing.JLabel labelEmpNo2;
    private javax.swing.JLabel labelHoursWorked;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelOutputBasic;
    private javax.swing.JLabel labelOutputEmpNo;
    private javax.swing.JLabel labelOutputHoursWorked;
    private javax.swing.JLabel labelOutputName;
    private javax.swing.JLabel labelPayCoverage;
    private javax.swing.JLabel labelcolon1;
    private javax.swing.JLabel labelcolon2;
    private javax.swing.JLabel labelcolon3;
    private javax.swing.JLabel labelcolon4;
    private javax.swing.JPanel panelHoursWorked;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField textFieldEmpNo;
    // End of variables declaration//GEN-END:variables

}

