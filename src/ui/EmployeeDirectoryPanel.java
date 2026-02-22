/*
 * Programmer: A1101 GROUP 4 | Armilla, A., Belga, E., Franco, C., Jardeliza, L., Lasic, J.
 * Date: June 2025
 * Project: MotorPH Payroll System
 */

package ui;

import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * Class: EmployeeDirectoryPanel
 * Description: Panel displaying a table of all employees with controls to view details
 *              or add a new employee.
 */
public class EmployeeDirectoryPanel extends JPanel {

    /** Model for loading and saving employee data from file */
    private EmployeeModelFromFile employeeModel;
    /** Index of the currently selected row in the table */
    private int selectedRow = -1;
    /** Panel for displaying detailed information on a selected employee */
    private EmployeeInformationPanel empInformationPanel;

    /**
     * Main entry point for standalone testing of this panel.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Directory");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(531, 445);
            frame.setLocationRelativeTo(null);          // center on screen
            frame.add(new EmployeeDirectoryPanel());
            frame.setVisible(true);
        });
    }

    /**
     * Constructor: initializes UI components, formats the table, and loads data.
     */
    public EmployeeDirectoryPanel() {
        initComponents();

        // Remove any placeholder rows
        DefaultTableModel model = (DefaultTableModel) tableDirectory.getModel();
        model.setRowCount(0);

        // Make header font bold at size 12
        tableDirectory.getTableHeader()
                      .setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));

        // Center header titles
        DefaultTableCellRenderer headerRenderer =
            (DefaultTableCellRenderer) tableDirectory.getTableHeader()
                                                     .getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Center all cell contents
        centerTableContents();

        // Populate with employee records
        loadEmployeeDataToTable();
    }

    /**
     * Centers the text within every cell of the table.
     */
    private void centerTableContents() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableDirectory.getColumnCount(); i++) {
            tableDirectory.getColumnModel()
                          .getColumn(i)
                          .setCellRenderer(centerRenderer);
        }
    }

    /** NetBeans-generated UI setup (do not modify) */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actionPanel = new javax.swing.JPanel();
        viewBtn = new javax.swing.JButton();
        addEmployeeBtn = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        scrollPane = new javax.swing.JScrollPane();
        tableDirectory = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblPersonalInformation = new javax.swing.JLabel();
        labelEmpNo = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblGovernmentBenefits = new javax.swing.JLabel();
        lblSSSNO = new javax.swing.JLabel();
        lblPhilHealthNO = new javax.swing.JLabel();
        lblTINNO = new javax.swing.JLabel();
        lblPagIbigNO = new javax.swing.JLabel();
        txtOutputEmployeeNO = new javax.swing.JTextField();
        txtOutputLastName = new javax.swing.JTextField();
        txtOutputFirstName = new javax.swing.JTextField();
        txtOutputSSSNO = new javax.swing.JTextField();
        txtOutputPhilHealthNO = new javax.swing.JTextField();
        txtOutputTINNO = new javax.swing.JTextField();
        txtOutputPagIbigNO = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(569, 445));
        setPreferredSize(new java.awt.Dimension(550, 445));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        viewBtn.setText("View Employee");
        viewBtn.setToolTipText("");
        viewBtn.setContentAreaFilled(true);
        viewBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        addEmployeeBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addEmployeeBtn.setText("New Employee");
        addEmployeeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(addEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addComponent(viewBtn)
                .addGap(10, 10, 10)
                .addComponent(addEmployeeBtn)
                .addContainerGap())
        );

        add(actionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 60));

        jSplitPane1.setDividerLocation(290);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(1.0);
        jSplitPane1.setToolTipText("");
        jSplitPane1.setMinimumSize(new java.awt.Dimension(44, 44));

        scrollPane.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tableDirectory.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableDirectory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee NO.", "Last Name", "First Name", "SSS NO.", "PhilHealth NO.", "TIN NO.", "Pag-IBIG NO."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDirectory.setToolTipText("");
        tableDirectory.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableDirectory.setGridColor(new java.awt.Color(0, 0, 0));
        tableDirectory.setRowHeight(40);
        tableDirectory.setShowGrid(true);
        tableDirectory.setShowVerticalLines(false);
        tableDirectory.getTableHeader().setReorderingAllowed(false);
        tableDirectory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDirectoryMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tableDirectory);
        if (tableDirectory.getColumnModel().getColumnCount() > 0) {
            tableDirectory.getColumnModel().getColumn(0).setResizable(false);
            tableDirectory.getColumnModel().getColumn(0).setPreferredWidth(150);
            tableDirectory.getColumnModel().getColumn(1).setResizable(false);
            tableDirectory.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableDirectory.getColumnModel().getColumn(2).setResizable(false);
            tableDirectory.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableDirectory.getColumnModel().getColumn(3).setResizable(false);
            tableDirectory.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableDirectory.getColumnModel().getColumn(4).setResizable(false);
            tableDirectory.getColumnModel().getColumn(4).setPreferredWidth(150);
            tableDirectory.getColumnModel().getColumn(5).setResizable(false);
            tableDirectory.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableDirectory.getColumnModel().getColumn(6).setResizable(false);
            tableDirectory.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        jSplitPane1.setTopComponent(scrollPane);

        lblPersonalInformation.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPersonalInformation.setText("PERSONAL INFORMATION");

        labelEmpNo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEmpNo.setText("Employee NO.");

        lblLastName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLastName.setText("Last Name");

        lblFirstName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFirstName.setText("First Name");

        lblGovernmentBenefits.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblGovernmentBenefits.setText("GOVERNMENT BENEFITS");

        lblSSSNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSSSNO.setText("SSS NO.");

        lblPhilHealthNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPhilHealthNO.setText("PhilHealth NO.");

        lblTINNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTINNO.setText("TIN NO.");

        lblPagIbigNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPagIbigNO.setText("Pag-IBIG NO.");

        txtOutputEmployeeNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtOutputLastName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtOutputFirstName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtOutputSSSNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtOutputPhilHealthNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtOutputTINNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtOutputPagIbigNO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnUpdate.setBackground(new java.awt.Color(0, 51, 0));
        btnUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 0, 0));
        btnDelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPersonalInformation)
                            .addComponent(lblGovernmentBenefits)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblLastName)
                                        .addGap(120, 120, 120)
                                        .addComponent(txtOutputLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102)
                                        .addComponent(txtOutputEmployeeNO, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblFirstName)
                                        .addGap(120, 120, 120)
                                        .addComponent(txtOutputFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSSSNO)
                                        .addGap(133, 133, 133)
                                        .addComponent(txtOutputSSSNO, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPhilHealthNO)
                                        .addGap(100, 100, 100)
                                        .addComponent(txtOutputPhilHealthNO, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblTINNO)
                                        .addGap(138, 138, 138)
                                        .addComponent(txtOutputTINNO, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPagIbigNO)
                                        .addGap(108, 108, 108)
                                        .addComponent(txtOutputPagIbigNO, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))))))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOutputEmployeeNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOutputLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOutputFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGovernmentBenefits, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSSSNO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOutputSSSNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhilHealthNO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOutputPhilHealthNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTINNO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOutputTINNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPagIbigNO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOutputPagIbigNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jSplitPane1.setRightComponent(jScrollPane1);

        add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 460, 420));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Shows the detailed view of the selected employee,
     * or prompts the user to select one first.
     */
    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                "Please select an employee from the table first.");
            return;
        }
        empInformationPanel = new EmployeeInformationPanel(this, selectedRow);

        JFrame frame = new JFrame("Employee Record");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.add(empInformationPanel);
        frame.setVisible(true);

        empInformationPanel.loadEmployeeDataToFields(selectedRow, employeeModel);
    }//GEN-LAST:event_viewBtnActionPerformed

    /**
     * Opens the form to add a new employee.
     */
    private void addEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeBtnActionPerformed
        new AddNewEmployeeForm(this).setVisible(true);
    }//GEN-LAST:event_addEmployeeBtnActionPerformed

    /**
     * Remember which row was clicked by the user.
     */
    private void tableDirectoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDirectoryMouseClicked
        selectedRow = tableDirectory.getSelectedRow();
        if (selectedRow < 0) return;

        DefaultTableModel model = (DefaultTableModel) tableDirectory.getModel();
     
        txtOutputEmployeeNO.setText(model.getValueAt(selectedRow, 0).toString());
        txtOutputLastName   .setText(model.getValueAt(selectedRow, 1).toString());
        txtOutputFirstName  .setText(model.getValueAt(selectedRow, 2).toString());
        txtOutputSSSNO      .setText(model.getValueAt(selectedRow, 3).toString());
        txtOutputPhilHealthNO.setText(model.getValueAt(selectedRow, 4).toString());
        txtOutputTINNO      .setText(model.getValueAt(selectedRow, 5).toString());
        txtOutputPagIbigNO  .setText(model.getValueAt(selectedRow, 6).toString());
    }//GEN-LAST:event_tableDirectoryMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an employee first.");
        return;
    }
        
    DefaultTableModel model = (DefaultTableModel) tableDirectory.getModel();

    
    model.setValueAt(txtOutputEmployeeNO.getText(),    selectedRow, 0);
    model.setValueAt(txtOutputLastName.getText(),      selectedRow, 1);
    model.setValueAt(txtOutputFirstName.getText(),     selectedRow, 2);
    model.setValueAt(txtOutputSSSNO.getText(),         selectedRow, 3);
    model.setValueAt(txtOutputPhilHealthNO.getText(),  selectedRow, 4);
    model.setValueAt(txtOutputTINNO.getText(),         selectedRow, 5);
    model.setValueAt(txtOutputPagIbigNO.getText(),     selectedRow, 6);

    Employee emp = employeeModel.getEmployeeModelList()[selectedRow];
    emp.setEmpNo(      txtOutputEmployeeNO.getText());
    emp.setLastName(   txtOutputLastName.getText());
    emp.setFirstName(  txtOutputFirstName.getText());
    emp.setSssNo(      txtOutputSSSNO.getText());
    emp.setPhilHealthNo(txtOutputPhilHealthNO.getText());
    emp.setTinNo(      txtOutputTINNO.getText());
    emp.setPagibigNo(  txtOutputPagIbigNO.getText());
    
    JOptionPane.showMessageDialog(this, "Employee updated successfully.");
    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an employee first.");
        return;
    }
    int choice = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete this employee?",
        "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (choice != JOptionPane.YES_OPTION) return;

    // 1) Delete from the CSV via your model
    boolean ok = employeeModel.deleteEmployee(selectedRow);
    if (!ok) {
        JOptionPane.showMessageDialog(this, "Error deleting employee from file.",
                                      "Delete Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 2) Reload the JTable from the now‑updated model
    loadEmployeeDataToTable();

    // 3) Clear selection & form
    selectedRow = -1;
    txtOutputEmployeeNO.setText("");
    txtOutputLastName .setText("");
    txtOutputFirstName.setText("");
    txtOutputSSSNO     .setText("");
    txtOutputPhilHealthNO.setText("");
    txtOutputTINNO     .setText("");
    txtOutputPagIbigNO .setText("");

    JOptionPane.showMessageDialog(this, "Employee deleted.");
    
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * Loads all employees from file into the table.
     */
    public void loadEmployeeDataToTable(){
        DefaultTableModel model = (DefaultTableModel) tableDirectory.getModel();
        model.setRowCount(0);
        employeeModel = new EmployeeModelFromFile();
        for (Employee emp : employeeModel.getEmployeeModelList()) {
            model.addRow(new Object[]{
                emp.getEmpNo(),
                emp.getLastName(),
                emp.getFirstName(),
                emp.getSssNo(),
                emp.getPhilHealthNo(),
                emp.getTinNo(),
                emp.getPagibigNo()
            });
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton addEmployeeBtn;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel labelEmpNo;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGovernmentBenefits;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPagIbigNO;
    private javax.swing.JLabel lblPersonalInformation;
    private javax.swing.JLabel lblPhilHealthNO;
    private javax.swing.JLabel lblSSSNO;
    private javax.swing.JLabel lblTINNO;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableDirectory;
    private javax.swing.JTextField txtOutputEmployeeNO;
    private javax.swing.JTextField txtOutputFirstName;
    private javax.swing.JTextField txtOutputLastName;
    private javax.swing.JTextField txtOutputPagIbigNO;
    private javax.swing.JTextField txtOutputPhilHealthNO;
    private javax.swing.JTextField txtOutputSSSNO;
    private javax.swing.JTextField txtOutputTINNO;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
