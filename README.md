# grademanagementsystem
The Grade Management System is a Java console-based application designed to store and manage student academic records efficiently.
The system accepts student details and subject marks, automatically calculates total, percentage, and grade, identifies the topper, displays all results, and allows saving the full report into a txt file.

Features

Feature Description

Add Student Result | Inputs name, roll number & 3 subject marks | View All Results | Displays complete results list | View Topper | Automatically identifies highest scorer | Save Report | Saves results to 'class_report.txt' | Menu System | Loops until user exits the application |

Project Structure

GradeManagementSystem�└── src�├── com.gradeapp.model�│ ├── Student.java�│ └── Result.java�├── com.gradeapp.service�│ └── GradeService.java�├── com.gradeapp.util�│ ├── InputValidator.java�│ └── FileLogger.java�└── com.gradeapp.ui�└── Main.java

Technologies Used

- Java 8+
- Eclipse IDE
- OOP Concepts
- File Handling

How to Run

- Open the project in Eclipse
- Expand 'com.gradeapp.ui'
- Right-click 'Main.java'
- Select:

Student Grade Management System Add Student Result View All Results View Topper Save Report to File Exit�Enter choice:

Output File When the user selects option '4. Save Report to File', a text report is generated:

It contains timestamp, student list, and total student count.

Future Enhancements

- GUI using JavaFX / Swing
- Database integration (MySQL)
- Export report to Excel / PDF format
- Login system for teachers and admin
- Online result portal
