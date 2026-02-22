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
 * Class: NetSalaryPanel
 * Description: GUI panel that fetches an employee by ID and displays the computed
 *              net salary for a selected pay period by delegating computations
 *              to PayrollService.
 */

/*
 * OOP PRINCIPLE: ABSTRACTION
 * The UI layer collects input and displays output only.
 * Payroll calculations are delegated to PayrollService.
 */

public class NetSalaryPanel extends javax.swing.JPanel {

    private final EmployeeService employeeService;
    private final PayrollService payrollService;
    private Employee currentEmployee;

    // CONSTRUCTOR
    // Initializes UI and service dependencies
    public NetSalaryPanel(EmployeeService employeeService,
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

        comboDateRange.removeAllItems();
        comboDateRange.addItem("Select Pay Period...");
        for (String r : ranges) {
            comboDateRange.addItem(r);
        }
    }

    // METHOD NAME: fetchEmployee
    // Retrieves employee from EmployeeService using employee number input.
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

        labelOutput1.setText(String.valueOf(currentEmployee.getEmployeeId()));
        labelOutput2.setText(currentEmployee.getLastName() + ", " + currentEmployee.getFirstName());
        labelOutput3.setText(String.format("%.2f", currentEmployee.getBasicSalary()));

        computeNetSalary();
    }

    // METHOD NAME: computeNetSalary
    // Computes net salary for the selected pay period using PayrollService.
    private void computeNetSalary() {

        if (currentEmployee == null) {
            return;
        }

        if (comboDateRange.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a pay period.");
            labelOutput4.setText("");
            return;
        }

        String selectedRange = comboDateRange.getSelectedItem().toString();

        if ("Select Pay Period...".equals(selectedRange)) {
            JOptionPane.showMessageDialog(this, "Please select a pay period.");
            labelOutput4.setText("");
            return;
        }

        double netSalary = payrollService.calculateNetSalary(currentEmployee, selectedRange);
        labelOutput4.setText(String.format("%.2f", netSalary));
    }

    // METHOD NAME: clearOutputs
    // Clears all output labels and resets current employee.
    private void clearOutputs() {
        labelOutput1.setText("");
        labelOutput2.setText("");
        labelOutput3.setText("");
        labelOutput4.setText("");
    }
    

    /** NetBeans-generated UI setup (components and layout) */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelEmpNo = new javax.swing.JLabel();
        textFieldEmpNo = new javax.swing.JTextField();
        buttonSubmit = new javax.swing.JButton();
        separator = new javax.swing.JSeparator();
        labelEmpNo2 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelBasicSalary = new javax.swing.JLabel();
        labelNetSalary = new javax.swing.JLabel();
        labelcolon1 = new javax.swing.JLabel();
        labelOutput1 = new javax.swing.JLabel();
        labelcolon2 = new javax.swing.JLabel();
        labelcolon3 = new javax.swing.JLabel();
        labelcolon4 = new javax.swing.JLabel();
        labelOutput2 = new javax.swing.JLabel();
        labelOutput3 = new javax.swing.JLabel();
        labelOutput4 = new javax.swing.JLabel();
        comboDateRange = new javax.swing.JComboBox<>();

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

        labelEmpNo2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEmpNo2.setText("Employee NO. ");

        labelName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelName.setText("Name");

        labelBasicSalary.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelBasicSalary.setText("Basic Salary ");

        labelNetSalary.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNetSalary.setText("Net Salary");

        labelcolon1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelcolon1.setText(":");

        labelOutput1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelcolon2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelcolon2.setText(":");

        labelcolon3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelcolon3.setText(":");

        labelcolon4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelcolon4.setText(":");

        labelOutput2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelOutput3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelOutput4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        comboDateRange.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        comboDateRange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Pay Period..." }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelBasicSalary, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelEmpNo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNetSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelcolon1)
                            .addComponent(labelcolon2)
                            .addComponent(labelcolon3)
                            .addComponent(labelcolon4))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelOutput4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOutput3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOutput2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelEmpNo)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textFieldEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSubmit))
                            .addComponent(comboDateRange, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEmpNo)
                            .addComponent(textFieldEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSubmit))
                        .addGap(5, 5, 5)
                        .addComponent(comboDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelOutput1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelEmpNo2)
                                        .addComponent(labelcolon1)))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelName)
                                    .addComponent(labelcolon2)))
                            .addComponent(labelOutput2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBasicSalary)
                            .addComponent(labelcolon3)))
                    .addComponent(labelOutput3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNetSalary)
                        .addComponent(labelcolon4))
                    .addComponent(labelOutput4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed
        fetchEmployee();
    }//GEN-LAST:event_buttonSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JComboBox<String> comboDateRange;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelBasicSalary;
    private javax.swing.JLabel labelEmpNo;
    private javax.swing.JLabel labelEmpNo2;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNetSalary;
    private javax.swing.JLabel labelOutput1;
    private javax.swing.JLabel labelOutput2;
    private javax.swing.JLabel labelOutput3;
    private javax.swing.JLabel labelOutput4;
    private javax.swing.JLabel labelcolon1;
    private javax.swing.JLabel labelcolon2;
    private javax.swing.JLabel labelcolon3;
    private javax.swing.JLabel labelcolon4;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField textFieldEmpNo;
    // End of variables declaration//GEN-END:variables
}
