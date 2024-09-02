
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.sql.Timestamp;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author acv
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private String currentSemester;
    private String author;
    private String project;
    private SemesterQueries SemesterQueries = new SemesterQueries();
    private StudentQueries StudentQueries = new StudentQueries();
    private ClassQueries ClassQueries = new ClassQueries();
    private CourseQueries CourseQueries = new CourseQueries();
    private ScheduleQueries ScheduleQueries = new ScheduleQueries();
    private MultiTableQueries MultiTableQueries = new MultiTableQueries();

    public MainFrame() {
        initComponents();
        checkData();
        rebuildSemesterComboBoxes();
        
        rebuildStudentComboBoxes1();
        rebuildStudentComboBoxes2();
        rebuildStudentComboBoxes3();
        rebuildStudentComboBoxes4();
        
        rebuildCourseComboBoxes1(); 
        
        rebuildStudentComboBoxes();
        
        rebuildClassComboBox();
        rebuildClassComboBox2();
        rebuildClassComboBox3();
        rebuildClassComboBox4();
    }

    public void rebuildSemesterComboBoxes() {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel(semesters.toArray()));
        if (semesters.size() > 0) {
            currentSemesterLabel.setText(semesters.get(0));
            currentSemester = semesters.get(0);
        } else {
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
    }
    public void rebuildClassComboBox(){
        ArrayList<String> classes = ClassQueries.getAllCourseCodes(currentSemester);
        selectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));

    }
    public void rebuildClassComboBox2(){
        ArrayList<String> classes = ClassQueries.getAllCourseCodes(currentSemester);
        displayClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));

    }
    public void rebuildClassComboBox3(){
        ArrayList<String> classes = ClassQueries.getAllCourseCodes(currentSemester);
        dropClassAdminComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));

    }
    
    public void rebuildClassComboBox4(){
        ArrayList<String> classes = ClassQueries.getAllCourseCodes(currentSemester);
        dropStudentClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));

    }
    
    public void rebuildStudentComboBoxes() {
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();

        ArrayList<String> names = new ArrayList<>();
    for (StudentEntry student : students) {
        String fullName = student.getLastName() + ", " + student.getFirstName();
        names.add(fullName);
    }

    selectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
  
      
        
    }
    
    public void rebuildStudentComboBoxes1() {
    ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
    
    // Assuming StudentEntry has methods getLastName() and getFirstName()
    ArrayList<String> studentNames = new ArrayList<>();
    for (StudentEntry student : students) {
        String fullName = student.getLastName() + ", " + student.getFirstName();
        studentNames.add(fullName);
    }

    selectStudentDisplayComboBox.setModel(new javax.swing.DefaultComboBoxModel(studentNames.toArray()));
  
    }
    public void rebuildStudentComboBoxes2() {
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();

        ArrayList<String> names = new ArrayList<>();
    for (StudentEntry student : students) {
        String fullName = student.getLastName() + ", " + student.getFirstName();
        names.add(fullName);
    }

    dropClassStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
  
      
        
    }
    public void rebuildStudentComboBoxes3() {
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();

        ArrayList<String> names = new ArrayList<>();
    for (StudentEntry student : students) {
        String fullName = student.getLastName() + ", " + student.getFirstName();
        names.add(fullName);
    }

    chooseDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
  
      
        
    }
    public void rebuildStudentComboBoxes4() {
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();

        ArrayList<String> names = new ArrayList<>();
    for (StudentEntry student : students) {
        String fullName = student.getLastName() + ", " + student.getFirstName();
        names.add(fullName);
    }

    dropStudentAdminComboBox.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
  
      
        
    }
    
    
    public void rebuildCourseComboBoxes1() {
    ArrayList<String> courseCodes = CourseQueries.getAllCourseCodes();

    selectCourseCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel(courseCodes.toArray()));
}


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        courseSchedulerTitle = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dropClassAdminTab = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        addCourseCodeTextfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addCourseDescriptionTextfield = new javax.swing.JTextField();
        addCourseSubmitButton = new javax.swing.JButton();
        addCourseStatusLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        selectCourseCodeComboBox = new javax.swing.JComboBox<>();
        courseCodeLabel = new javax.swing.JLabel();
        seatLabel = new javax.swing.JLabel();
        selectSeatsSpinner = new javax.swing.JSpinner();
        submitButtonAddClassLabel = new javax.swing.JButton();
        addClassStatusLabel = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
        studentIDLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        studentIDTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        submitButtonStudent = new javax.swing.JButton();
        addStudentStatusLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        chooseDisplayClassJLabel = new javax.swing.JLabel();
        displayClassComboBox = new javax.swing.JComboBox<>();
        chooseClassDisplayButton = new javax.swing.JButton();
        scheduledStudentsJLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        scheduledStudentsClassTable = new javax.swing.JTable();
        waitlistedStudentsJLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        waitlistedStudentsTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        chooseStudentJLabel = new javax.swing.JLabel();
        chooseDropStudentComboBox = new javax.swing.JComboBox<>();
        dropStudentAdminButton = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        dropStudentTextArea = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        chooseDropStudentAdminJLabel = new javax.swing.JLabel();
        chooseClassAdminJLabel = new javax.swing.JLabel();
        dropStudentAdminComboBox = new javax.swing.JComboBox<>();
        dropClassAdminComboBox = new javax.swing.JComboBox<>();
        submitDropStudentAdminButton = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        displayDropClassAdminTextField = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        dropClassStudentTab = new javax.swing.JTabbedPane();
        displayClassPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayClassTextArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        displayClassTable = new javax.swing.JTable();
        displayClassesButton = new javax.swing.JButton();
        scheduleClassPane = new javax.swing.JPanel();
        selectClassLabel = new javax.swing.JLabel();
        selectStudentLabel = new javax.swing.JLabel();
        selectClassComboBox = new javax.swing.JComboBox<>();
        selectStudentComboBox = new javax.swing.JComboBox<>();
        scheduleClassSubmitButton = new javax.swing.JButton();
        addClassStatusLabel1 = new javax.swing.JLabel();
        displayStudentSchedulePane = new javax.swing.JPanel();
        selectStudentLabelDisplay = new javax.swing.JLabel();
        selectStudentDisplayComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayScheduleTextArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        displayScheduleTable = new javax.swing.JTable();
        displayScheduleButton = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        chooseStudentDropJLabel = new javax.swing.JLabel();
        chooseClassDropJLabel = new javax.swing.JLabel();
        dropClassStudentComboBox = new javax.swing.JComboBox<>();
        dropStudentClassComboBox = new javax.swing.JComboBox<>();
        submitDropClassStudentButton = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        dropStudentClassesTextField = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        courseSchedulerTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        courseSchedulerTitle.setForeground(new java.awt.Color(0, 153, 153));
        courseSchedulerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseSchedulerTitle.setText("Course Scheduler");

        jLabel3.setText("Semester Name:");

        addSemesterTextfield.setColumns(20);
        addSemesterTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterTextfieldActionPerformed(evt);
            }
        });

        addSemesterSubmitButton.setText("Submit");
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        addSemesterStatusLabel.setText("                                                   ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(addSemesterSubmitButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addSemesterSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(addSemesterStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dropClassAdminTab.addTab("Add Semester", jPanel3);

        jLabel4.setText("Course Code:");

        addCourseCodeTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseCodeTextfieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Course Description:");

        addCourseDescriptionTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseDescriptionTextfieldActionPerformed(evt);
            }
        });

        addCourseSubmitButton.setText("Submit");
        addCourseSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseSubmitButtonActionPerformed(evt);
            }
        });

        addCourseStatusLabel.setText("        ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCourseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCourseCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseDescriptionTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseSubmitButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addCourseCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(addCourseDescriptionTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addCourseSubmitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCourseStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dropClassAdminTab.addTab("Add Course", jPanel4);

        selectCourseCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectCourseCodeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCourseCodeComboBoxActionPerformed(evt);
            }
        });

        courseCodeLabel.setText("Course Code:");

        seatLabel.setText("Seats:");

        submitButtonAddClassLabel.setText("Submit");
        submitButtonAddClassLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonAddClassLabelActionPerformed(evt);
            }
        });

        addClassStatusLabel.setText("                                                   ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseCodeLabel)
                            .addComponent(seatLabel))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButtonAddClassLabel)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(selectSeatsSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(selectCourseCodeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(addClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(selectCourseCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectSeatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(courseCodeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seatLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitButtonAddClassLabel)
                .addGap(41, 41, 41)
                .addComponent(addClassStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dropClassAdminTab.addTab("Add Class", jPanel6);

        studentIDLabel.setText("Student ID:");

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        studentIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIDTextFieldActionPerformed(evt);
            }
        });

        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });

        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        submitButtonStudent.setText("Submit");
        submitButtonStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonStudentActionPerformed(evt);
            }
        });

        addStudentStatusLabel1.setText("                                                   ");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(addStudentStatusLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addComponent(studentIDLabel)
                                .addGap(46, 46, 46))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel)
                                    .addComponent(lastNameLabel))
                                .addGap(44, 44, 44)))
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButtonStudent)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(studentIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(firstNameTextField)
                                .addComponent(lastNameTextField)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentIDLabel)
                    .addComponent(studentIDTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitButtonStudent)
                .addGap(18, 18, 18)
                .addComponent(addStudentStatusLabel1)
                .addGap(94, 94, 94))
        );

        dropClassAdminTab.addTab("Add Student", jPanel);

        chooseDisplayClassJLabel.setText("Choose Class:");

        displayClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chooseClassDisplayButton.setText("Display");
        chooseClassDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseClassDisplayButtonActionPerformed(evt);
            }
        });

        scheduledStudentsJLabel.setText("Scheduled Students in the Class");

        scheduledStudentsClassTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "StudentID"
            }
        ));
        jScrollPane7.setViewportView(scheduledStudentsClassTable);

        waitlistedStudentsJLabel.setText("Waitlisted Students in the Class in Waitlist Order");

        waitlistedStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "StudentID"
            }
        ));
        jScrollPane8.setViewportView(waitlistedStudentsTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waitlistedStudentsJLabel)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(chooseDisplayClassJLabel)
                        .addGap(31, 31, 31)
                        .addComponent(displayClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(chooseClassDisplayButton))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scheduledStudentsJLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseDisplayClassJLabel)
                    .addComponent(displayClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseClassDisplayButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scheduledStudentsJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(waitlistedStudentsJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dropClassAdminTab.addTab("Display Class List", jPanel5);

        jLabel8.setText("jLabel8");

        chooseStudentJLabel.setText("Choose Student:");

        chooseDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropStudentAdminButton.setText("Drop Student");
        dropStudentAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentAdminButtonActionPerformed(evt);
            }
        });

        dropStudentTextArea.setColumns(20);
        dropStudentTextArea.setRows(5);
        jScrollPane9.setViewportView(dropStudentTextArea);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(chooseStudentJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dropStudentAdminButton)
                                    .addComponent(chooseDropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 298, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseStudentJLabel)
                    .addComponent(chooseDropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dropStudentAdminButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        dropClassAdminTab.addTab("Drop Student", jPanel7);

        chooseDropStudentAdminJLabel.setText("Choose Student:");

        chooseClassAdminJLabel.setText("Choose Class:");

        dropStudentAdminComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropClassAdminComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitDropStudentAdminButton.setText("Submit");
        submitDropStudentAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDropStudentAdminButtonActionPerformed(evt);
            }
        });

        displayDropClassAdminTextField.setColumns(20);
        displayDropClassAdminTextField.setRows(5);
        jScrollPane11.setViewportView(displayDropClassAdminTextField);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitDropStudentAdminButton)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(chooseDropStudentAdminJLabel)
                            .addGap(34, 34, 34)
                            .addComponent(dropStudentAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(chooseClassAdminJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dropClassAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane11)))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseDropStudentAdminJLabel)
                    .addComponent(dropStudentAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseClassAdminJLabel)
                    .addComponent(dropClassAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitDropStudentAdminButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        dropClassAdminTab.addTab("Drop Class", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dropClassAdminTab)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(dropClassAdminTab, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admin", jPanel1);

        displayClassTextArea.setColumns(20);
        displayClassTextArea.setRows(5);
        jScrollPane1.setViewportView(displayClassTextArea);

        displayClassTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Code", "Description", "Seats"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(displayClassTable);
        if (displayClassTable.getColumnModel().getColumnCount() > 0) {
            displayClassTable.getColumnModel().getColumn(2).setHeaderValue("Seats");
        }

        displayClassesButton.setText("Display");
        displayClassesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayClassesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayClassPaneLayout = new javax.swing.GroupLayout(displayClassPane);
        displayClassPane.setLayout(displayClassPaneLayout);
        displayClassPaneLayout.setHorizontalGroup(
            displayClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayClassPaneLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(displayClassPaneLayout.createSequentialGroup()
                .addGroup(displayClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(displayClassPaneLayout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(displayClassesButton)))
                .addGap(321, 321, 321))
        );
        displayClassPaneLayout.setVerticalGroup(
            displayClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayClassPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(displayClassesButton)
                .addContainerGap())
        );

        dropClassStudentTab.addTab("Display Classes", displayClassPane);

        selectClassLabel.setText("Select Class:");

        selectStudentLabel.setText("Select Student:");

        selectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        selectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        scheduleClassSubmitButton.setText("Submit");
        scheduleClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleClassSubmitButtonActionPerformed(evt);
            }
        });

        addClassStatusLabel1.setText("                                                   ");

        javax.swing.GroupLayout scheduleClassPaneLayout = new javax.swing.GroupLayout(scheduleClassPane);
        scheduleClassPane.setLayout(scheduleClassPaneLayout);
        scheduleClassPaneLayout.setHorizontalGroup(
            scheduleClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleClassPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scheduleClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectStudentLabel)
                    .addGroup(scheduleClassPaneLayout.createSequentialGroup()
                        .addComponent(selectClassLabel)
                        .addGap(45, 45, 45)
                        .addGroup(scheduleClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scheduleClassSubmitButton)
                            .addGroup(scheduleClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(selectStudentComboBox, 0, 122, Short.MAX_VALUE)
                                .addComponent(selectClassComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(addClassStatusLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(371, Short.MAX_VALUE))
        );
        scheduleClassPaneLayout.setVerticalGroup(
            scheduleClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleClassPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scheduleClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectClassLabel)
                    .addComponent(selectClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(scheduleClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectStudentLabel)
                    .addComponent(selectStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(scheduleClassSubmitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addClassStatusLabel1)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        dropClassStudentTab.addTab("Schedule Class", scheduleClassPane);

        selectStudentLabelDisplay.setText("Select Student:");

        selectStudentDisplayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        displayScheduleTextArea.setColumns(20);
        displayScheduleTextArea.setRows(5);
        jScrollPane2.setViewportView(displayScheduleTextArea);

        displayScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Code", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(displayScheduleTable);

        displayScheduleButton.setText("Display");
        displayScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayScheduleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayStudentSchedulePaneLayout = new javax.swing.GroupLayout(displayStudentSchedulePane);
        displayStudentSchedulePane.setLayout(displayStudentSchedulePaneLayout);
        displayStudentSchedulePaneLayout.setHorizontalGroup(
            displayStudentSchedulePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayStudentSchedulePaneLayout.createSequentialGroup()
                .addGroup(displayStudentSchedulePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayStudentSchedulePaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(selectStudentLabelDisplay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectStudentDisplayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(displayStudentSchedulePaneLayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(displayScheduleButton)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        displayStudentSchedulePaneLayout.setVerticalGroup(
            displayStudentSchedulePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayStudentSchedulePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayStudentSchedulePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectStudentLabelDisplay)
                    .addComponent(selectStudentDisplayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(displayScheduleButton)
                .addContainerGap())
        );

        dropClassStudentTab.addTab("Display Student Schedule", displayStudentSchedulePane);

        chooseStudentDropJLabel.setText("Choose Student:");

        chooseClassDropJLabel.setText("Choose Class:");

        dropClassStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropStudentClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitDropClassStudentButton.setText("Submit");
        submitDropClassStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDropClassStudentButtonActionPerformed(evt);
            }
        });

        dropStudentClassesTextField.setColumns(20);
        dropStudentClassesTextField.setRows(5);
        jScrollPane10.setViewportView(dropStudentClassesTextField);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(submitDropClassStudentButton)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chooseStudentDropJLabel)
                                .addComponent(chooseClassDropJLabel))
                            .addGap(48, 48, 48)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dropClassStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addComponent(dropStudentClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(285, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseStudentDropJLabel)
                    .addComponent(dropClassStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseClassDropJLabel)
                    .addComponent(dropStudentClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitDropClassStudentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        dropClassStudentTab.addTab("Drop Class", jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dropClassStudentTab)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dropClassStudentTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Student", jPanel2);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setText("Current Semester: ");

        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");

        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        currentSemesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentSemesterComboBoxActionPerformed(evt);
            }
        });

        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseSchedulerTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeSemesterButton)
                                .addGap(31, 31, 31)
                                .addComponent(aboutButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(courseSchedulerTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton)
                    .addComponent(aboutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        // display about information.
        author = "Prapti Kanani";
        project= "Course Scheduler Fall 2023";
        JOptionPane.showMessageDialog(null, "Author: " + author + " Project: " + project);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        String semester = addSemesterTextfield.getText();
        SemesterQueries.addSemester(semester);
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        rebuildSemesterComboBoxes();
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    private void addSemesterTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterTextfieldActionPerformed
        // TODO add your handling code here:
        String semester = addSemesterTextfield.getText();
    
    if (!semester.isEmpty()) {
        SemesterQueries.addSemester(semester);
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        rebuildSemesterComboBoxes();
    } else {
        // Handle empty semester name
        addSemesterStatusLabel.setText("Please enter a valid semester name.");
    }

        
    }//GEN-LAST:event_addSemesterTextfieldActionPerformed

    private void addCourseCodeTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseCodeTextfieldActionPerformed
        // TODO add your handling code here:
    
        

    }//GEN-LAST:event_addCourseCodeTextfieldActionPerformed

    private void addCourseDescriptionTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseDescriptionTextfieldActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_addCourseDescriptionTextfieldActionPerformed

    private void addCourseSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseSubmitButtonActionPerformed
        // TODO add your handling code here:
       String courseCode = addCourseCodeTextfield.getText();
        String courseDescription = addCourseDescriptionTextfield.getText();
    
        if (!courseCode.isEmpty() && !courseDescription.isEmpty()) {
        // Create a CourseEntry object
        CourseEntry courseEntry = new CourseEntry(courseCode, courseDescription);

        // Use CourseQueries class to add the course to the database
        CourseQueries.addCourse(courseEntry);
        addCourseStatusLabel.setText("Course " + courseCode + " has been added.");

        // Add courseCode to the selectCourseCodeComboBox
        selectCourseCodeComboBox.addItem(courseCode);

        // Optionally, you can clear the text fields after adding the course
        addCourseCodeTextfield.setText("");
        addCourseDescriptionTextfield.setText("");
        rebuildCourseComboBoxes1();

    }  
        
    }//GEN-LAST:event_addCourseSubmitButtonActionPerformed
    
    private void selectCourseCodeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseCodeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectCourseCodeComboBoxActionPerformed

    private void submitButtonAddClassLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonAddClassLabelActionPerformed
        // TODO add your handling code here:
       String courseCode = (String) selectCourseCodeComboBox.getSelectedItem();
       int seats = (int) selectSeatsSpinner.getValue();
       ClassEntry classEntry = new ClassEntry(currentSemester, courseCode, seats);

        ClassQueries.addClass(classEntry);
        addClassStatusLabel.setText("Class " + courseCode + " has been added.");
        selectClassComboBox.addItem(courseCode);
        displayClassComboBox.addItem(courseCode);
        dropClassAdminComboBox.addItem(courseCode);
        rebuildClassComboBox();
        rebuildClassComboBox2();
        rebuildClassComboBox3();
        rebuildClassComboBox4();
       
    }//GEN-LAST:event_submitButtonAddClassLabelActionPerformed

    private void studentIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIDTextFieldActionPerformed

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void submitButtonStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonStudentActionPerformed
        // TODO add your handling code here:
        String studentID = studentIDTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        StudentEntry StudentEntry = new StudentEntry(studentID,firstName,lastName );
        StudentQueries.addStudent(StudentEntry);
        addStudentStatusLabel1.setText(lastName + ", " + firstName + " has been added.");
        selectStudentComboBox.addItem(lastName + ", " + firstName);
        selectStudentDisplayComboBox.addItem(lastName + ", " + firstName);
        rebuildStudentComboBoxes();
        rebuildStudentComboBoxes1();
        rebuildStudentComboBoxes2();
        rebuildStudentComboBoxes3();
        rebuildStudentComboBoxes4();
                
        

        
    }//GEN-LAST:event_submitButtonStudentActionPerformed

    private void currentSemesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentSemesterComboBoxActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_currentSemesterComboBoxActionPerformed

    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemesterButtonActionPerformed
        // TODO add your handling code here:
         String semester = (String) currentSemesterComboBox.getSelectedItem();
         currentSemester = semester;
         currentSemesterLabel.setText(semester);
    }//GEN-LAST:event_changeSemesterButtonActionPerformed

    private void scheduleClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleClassSubmitButtonActionPerformed
        // TODO add your handling code here:
       // TODO add your handling code here:
    String Semester = currentSemesterLabel.getText();
    String Coursecode = (String) selectClassComboBox.getSelectedItem();
    ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
    String currentStudentName = (String) selectStudentComboBox.getSelectedItem();
    String StudentID = "";
    int Seats = CourseQueries.getCourseSeats(Semester, Coursecode);
    int availableSeats = ScheduleQueries.getScheduledStudentCount(Semester, Coursecode);
    String status; 

    // Iterate through the list of students to find the StudentID
    for (StudentEntry student : students) {
        // Assuming the existence of getFullName() method in StudentEntry
        String fullName = student.getLastName() + ", " +  student.getFirstName();

        // Check if the full name matches the selected student
        if (fullName.equals(currentStudentName)) {
            StudentID = student.getStudentID();
            break; // Exit the loop once the StudentID is found
        }
    }

    // Check if a StudentID is found
        Timestamp timestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

        if (Seats <= availableSeats) {
                status = "W";
        addClassStatusLabel1.setText(selectClassComboBox.getSelectedItem() + " has been waitlisted");
        }
        else{
            status = "S";
        addClassStatusLabel1.setText(selectClassComboBox.getSelectedItem() + " has been scheduled");
        }
        ScheduleEntry scheduler = new ScheduleEntry(Semester, Coursecode, StudentID, status, timestamp);
        ScheduleQueries.addScheduleEntry(scheduler);



    }//GEN-LAST:event_scheduleClassSubmitButtonActionPerformed

    private void displayClassesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayClassesButtonActionPerformed
        // TODO add your handling code here:
       // TODO add your handling code here:
try {
    ArrayList<String> courses = ClassQueries.getAllCourseCodes(currentSemester);
    ArrayList<ClassDescription> descriptions = MultiTableQueries.getAllClassDescriptions(currentSemester);

    DefaultTableModel displayCourseTableModel = (DefaultTableModel) displayClassTable.getModel();
    displayCourseTableModel.setNumRows(0);
    StringBuilder displayText = new StringBuilder();


    // Loop through all available courses
    int i = 0;
    for (String course : courses) {
        Object[] rowData = new Object[3];
        rowData[0] = course;

        // Find the corresponding description using MultiTableQueries
        ClassDescription description = findDescription(descriptions, course);

        // Check if a description is found, set it; otherwise, set an empty string
     
        rowData[1] = (description != null) ? description.getDescription() : "";

        // Get seats using ClassQueries
        rowData[2] = ClassQueries.getClassSeats(currentSemester, course);

        displayCourseTableModel.addRow(rowData);
         // Append data to the StringBuilder
            if (i == 0){
            displayText.append("Course      ");
            displayText.append("Description      ");
            displayText.append("Seats      ").append("\n");
    }
            displayText.append(rowData[0]).append("      ").append(rowData[1]).append("      ").append(rowData[2]).append("\n");
        
    
        // Set the text in the JTextArea
        displayClassTextArea.setText(displayText.toString());
        i+=1;
    }
    }
 catch (Exception e) {
    e.printStackTrace();  // Handle the exception appropriately (log or display a message)
}

// Keep your previous method of finding description



    }//GEN-LAST:event_displayClassesButtonActionPerformed
// Keep your previous method of finding description
private ClassDescription findDescription(ArrayList<ClassDescription> descriptions, String courseCode) {
    for (ClassDescription description : descriptions) {
        if (description.getCourseCode().equals(courseCode)) {
            return description;
        }
    }
    return null;  // Description not found
}


    private void displayScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayScheduleButtonActionPerformed
        // TODO add your handling code here:
    ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
    String studentID = "";
    String currentStudentName = (String) selectStudentDisplayComboBox.getSelectedItem();
    StringBuilder displayText = new StringBuilder();

    // Iterate through the list of students to find the StudentID
    for (StudentEntry student : students) {
        // Assuming the existence of getFullName() method in StudentEntry
        String fullName = student.getLastName() + ", " + student.getFirstName();

        // Check if the full name matches the selected student
        if (fullName.equals(currentStudentName)) {
            studentID = student.getStudentID();
            break; // Exit the loop once the StudentID is found
        }
    }

    ArrayList<ScheduleEntry> schedule = ScheduleQueries.getScheduleByStudent(currentSemester, studentID);
    DefaultTableModel displayscheduleModel = (DefaultTableModel) displayScheduleTable.getModel();
    displayscheduleModel.setNumRows(0);
    Object[] rowData = new Object[2];
    int i = 0;

    for (ScheduleEntry scheduler : schedule) {
        rowData[0] = scheduler.getCourseCode();
        rowData[1] = scheduler.getStatus();
        displayscheduleModel.addRow(rowData);

        if (i == 0) {
            displayText.append("CourseCode      ");
            displayText.append("Status      ").append("\n");
        }
        displayText.append(rowData[0]).append("      ").append(rowData[1]).append("\n");

        i += 1;
    }

    // Set the text in the JTextArea
    displayScheduleTextArea.setText(displayText.toString());

    }//GEN-LAST:event_displayScheduleButtonActionPerformed

    private void chooseClassDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseClassDisplayButtonActionPerformed
        // TODO add your handling code here:
        String course = (String) displayClassComboBox.getSelectedItem();
        DefaultTableModel displayscheduleModel = (DefaultTableModel) scheduledStudentsClassTable.getModel();
        Object[] rowData = new Object[2];

        displayscheduleModel.setNumRows(0);

        ArrayList<StudentEntry> scheduledStudents = MultiTableQueries.getScheduledStudentsByClass(currentSemester, course);
        for (StudentEntry student : scheduledStudents) {
        rowData[0] = student.getLastName();
        rowData[1] = student.getFirstName();
        rowData[2] = student.getStudentID();
        displayscheduleModel.addRow(rowData);    

        
    }//GEN-LAST:event_chooseClassDisplayButtonActionPerformed
    }
    private void dropStudentAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentAdminButtonActionPerformed
        // TODO add your handling code here:
        String student = (String) chooseDropStudentComboBox.getSelectedItem();
        String[] nameParts = student.split(", ");
        String lastName = nameParts[0];
        String firstName = nameParts[1];
        String studentID = "";
        
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
        for (StudentEntry currStudent : students) {
            if (currStudent.getLastName()== lastName && currStudent.getFirstName()==firstName){
                 studentID = currStudent.getStudentID();
                 break;
            }
        
    }
        StudentQueries.dropStudent(studentID);
        rebuildStudentComboBoxes();
        rebuildStudentComboBoxes1();
        rebuildStudentComboBoxes2();
        rebuildStudentComboBoxes3();
        rebuildStudentComboBoxes4();
                
        
    }//GEN-LAST:event_dropStudentAdminButtonActionPerformed

    private void submitDropStudentAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDropStudentAdminButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_submitDropStudentAdminButtonActionPerformed

    private void submitDropClassStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDropClassStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitDropClassStudentButtonActionPerformed

    private void checkData() {
        try {
            FileReader reader = new FileReader("xzq789yy.txt");
            BufferedReader breader = new BufferedReader(reader);

            String encodedAuthor = breader.readLine();
            String encodedProject = breader.readLine();
            byte[] decodedAuthor = Base64.getDecoder().decode(encodedAuthor);
            author = new String(decodedAuthor);
            byte[] decodedProject = Base64.getDecoder().decode(encodedProject);
            project = new String(decodedProject);
            reader.close();

        } catch (FileNotFoundException e) {
            //get user info and create file
            author = JOptionPane.showInputDialog("Enter your first and last name.");
            project = "Course Scheduler Fall 2023";

            //write data to the data file.
            try {
                FileWriter writer = new FileWriter("xzq789yy.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                // encode the output data.
                String encodedAuthor = Base64.getEncoder().encodeToString(author.getBytes());

                bufferedWriter.write(encodedAuthor);
                bufferedWriter.newLine();

                String encodedProject = Base64.getEncoder().encodeToString(project.getBytes());
                bufferedWriter.write(encodedProject);

                bufferedWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JLabel addClassStatusLabel;
    private javax.swing.JLabel addClassStatusLabel1;
    private javax.swing.JTextField addCourseCodeTextfield;
    private javax.swing.JTextField addCourseDescriptionTextfield;
    private javax.swing.JLabel addCourseStatusLabel;
    private javax.swing.JButton addCourseSubmitButton;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JLabel addStudentStatusLabel1;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JLabel chooseClassAdminJLabel;
    private javax.swing.JButton chooseClassDisplayButton;
    private javax.swing.JLabel chooseClassDropJLabel;
    private javax.swing.JLabel chooseDisplayClassJLabel;
    private javax.swing.JLabel chooseDropStudentAdminJLabel;
    private javax.swing.JComboBox<String> chooseDropStudentComboBox;
    private javax.swing.JLabel chooseStudentDropJLabel;
    private javax.swing.JLabel chooseStudentJLabel;
    private javax.swing.JLabel courseCodeLabel;
    private javax.swing.JLabel courseSchedulerTitle;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JComboBox<String> displayClassComboBox;
    private javax.swing.JPanel displayClassPane;
    private javax.swing.JTable displayClassTable;
    private javax.swing.JTextArea displayClassTextArea;
    private javax.swing.JButton displayClassesButton;
    private javax.swing.JTextArea displayDropClassAdminTextField;
    private javax.swing.JButton displayScheduleButton;
    private javax.swing.JTable displayScheduleTable;
    private javax.swing.JTextArea displayScheduleTextArea;
    private javax.swing.JPanel displayStudentSchedulePane;
    private javax.swing.JComboBox<String> dropClassAdminComboBox;
    private javax.swing.JTabbedPane dropClassAdminTab;
    private javax.swing.JComboBox<String> dropClassStudentComboBox;
    private javax.swing.JTabbedPane dropClassStudentTab;
    private javax.swing.JButton dropStudentAdminButton;
    private javax.swing.JComboBox<String> dropStudentAdminComboBox;
    private javax.swing.JComboBox<String> dropStudentClassComboBox;
    private javax.swing.JTextArea dropStudentClassesTextField;
    private javax.swing.JTextArea dropStudentTextArea;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JPanel scheduleClassPane;
    private javax.swing.JButton scheduleClassSubmitButton;
    private javax.swing.JTable scheduledStudentsClassTable;
    private javax.swing.JLabel scheduledStudentsJLabel;
    private javax.swing.JLabel seatLabel;
    private javax.swing.JComboBox<String> selectClassComboBox;
    private javax.swing.JLabel selectClassLabel;
    private javax.swing.JComboBox<String> selectCourseCodeComboBox;
    private javax.swing.JSpinner selectSeatsSpinner;
    private javax.swing.JComboBox<String> selectStudentComboBox;
    private javax.swing.JComboBox<String> selectStudentDisplayComboBox;
    private javax.swing.JLabel selectStudentLabel;
    private javax.swing.JLabel selectStudentLabelDisplay;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JTextField studentIDTextField;
    private javax.swing.JButton submitButtonAddClassLabel;
    private javax.swing.JButton submitButtonStudent;
    private javax.swing.JButton submitDropClassStudentButton;
    private javax.swing.JButton submitDropStudentAdminButton;
    private javax.swing.JLabel waitlistedStudentsJLabel;
    private javax.swing.JTable waitlistedStudentsTable;
    // End of variables declaration//GEN-END:variables

}