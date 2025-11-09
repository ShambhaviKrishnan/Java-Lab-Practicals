import java.io.*; import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes; import java.util.*;
// --- Helper class for Problem 5 --- class StudentRecord {
String name; int totalMarks;
public StudentRecord(String name, int totalMarks) { this.name = name;
this.totalMarks = totalMarks;
}
@Override
public String toString() {
return "Name: " + name + ", Total Marks: " + totalMarks;
}
}
public class FileHandlingPracticals {
// Helper method to create sample files needed for other problems
private static void setupFiles() {
// MODIFIED: Create student.csv instead of students.txt try (FileWriter fw = new FileWriter("student.csv")) {
fw.write("Alice,85,90,75\n");
fw.write("Bob,70,60,80\n");
fw.write("Charlie,95,92,98");
} catch (IOException e) {
System.err.println("Setup error for student.csv: " + e.getMessage());
}
}
public static void main(String[] args) {
setupFiles(); // Ensure files exist for demonstration
// ... (Problems 1-4 remain unchanged) ...
// --- Problem 1: Append Text --- System.out.println("--- 1. Appending Text ---");
appendToFile("student.csv", "\n-- Appended text: This line was added later.");
// --- Problem 2: Determine Bytes Written using DataOutputStream ---
System.out.println("\n--- 2. DataOutputStream Bytes Written
---");
determineBytesWritten("data.bin");
// --- Problem 3: Read and Write (Copy) --- System.out.println("\n--- 3. File Copy ---"); copyFile("student.csv", "destination.csv");
// --- Problem 4: Get File Attributes --- System.out.println("\n--- 4. File Attributes ---"); getFileAttributes("student.csv");
// --- Problem 5: Read, Transfer to Collection, and Process ---
System.out.println("\n--- 5. Student File Processing (using student.csv) ---");
// MODIFIED: Call with student.csv processStudentFile("student.csv");
}
//	Method Implementations (Partial for brevity)

 

// Problem 1 Implementation (Unchanged)
public static void appendToFile(String fileName, String contentToAppend) {
try (FileWriter fw = new FileWriter(fileName, true)) { fw.write(contentToAppend); System.out.println("Text successfully appended to " +
fileName);
} catch (IOException e) { System.err.println("Error during file append: " +
e.getMessage());
}
}
// Problem 2 Implementation (Unchanged)
public static void determineBytesWritten(String fileName) { long totalBytesWritten = 0;
try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
dos.writeBoolean(true); totalBytesWritten += 1; dos.writeInt(12345); totalBytesWritten += 4; dos.writeDouble(98.76); totalBytesWritten += 8;
String str = "Test"; dos.writeUTF(str); totalBytesWritten
+= 2 + str.length();
System.out.println("Data written to " + fileName + " in binary format.");
System.out.println("Total bytes theoretically written: " + totalBytesWritten + " bytes");
} catch (IOException e) {
System.err.println("Error with DataOutputStream: " + e.getMessage());
}
}
// Problem 3 Implementation (Unchanged)
public static void copyFile(String sourceFile, String destFile) { try (BufferedReader reader = new BufferedReader(new
FileReader(sourceFile));
BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {
String line;
while ((line = reader.readLine()) != null) { writer.write(line);
writer.newLine();
}
System.out.println("Content successfully copied from " + sourceFile + " to " + destFile);
} catch (IOException e) {
System.err.println("Error during file copying: " + e.getMessage());
}
}
// Problem 4 Implementation (Unchanged)
public static void getFileAttributes(String fileName) { File file = new File(fileName);
if (!file.exists()) { System.out.println("File not found: " + fileName); return; }
System.out.println("File Name: " + file.getName()); System.out.println("File Size (bytes): " + file.length()); System.out.println("Last Modified (ms): " +
file.lastModified()); try {
Path path = file.toPath();
BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
System.out.println("Is Directory? " + attrs.isDirectory()); System.out.println("Creation Time: " +
attrs.creationTime());
} catch (IOException e) {
System.err.println("Could not read NIO attributes: " + e.getMessage());
}
}
// Problem 5 Implementation (Logic is already correct for CSV format)
public static void processStudentFile(String fileName) { List<StudentRecord> students = new ArrayList<>();
try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
String line;
while ((line = reader.readLine()) != null) {
// The split(",") method correctly handles CSV data String[] parts = line.split(",");
if (parts.length == 4) { try {
String name = parts[0].trim(); int total = 0;
for (int i = 1; i < 4; i++) {
total += Integer.parseInt(parts[i].trim());
}
students.add(new StudentRecord(name, total));
} catch (NumberFormatException e) {
System.err.println("Skipping line due to invalid mark format: " + line);
}
}
}
} catch (IOException e) {
System.err.println("Error reading the student file: " + e.getMessage());
return;
}
System.out.println("Student Records with Total Marks:"); for (StudentRecord student : students) {
System.out.println(student);
}
}
}
