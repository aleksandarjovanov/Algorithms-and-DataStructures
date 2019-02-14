import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
 
public class HW01_5 {
   
    static String SOURCE = "C:\\Users\\Aleksandar\\Desktop\\rezultati.csv";
    static String DESTINATION = "C:\\Users\\Aleksandar\\Desktop\\rezultati.tsv";
   
    public static void main(String[] args) throws IOException {
       
        File inputFile = new File(SOURCE);
        File outputFile = new File(DESTINATION);
       
        if (!inputFile.exists())
            throw new FileNotFoundException();
       
        List<Student> students = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();
       
 
        readInput(inputFile,students,subjects);
 
        writeOutput(outputFile,students,subjects);
 
       
    }
   
    static void readInput(File file, List<Student> students, List<Subject> subjects) throws IOException {
       
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
           
            String line = reader.readLine();
            String parts[] = line.split(",");
            createSubjects(subjects,parts);
           
            while ((line = reader.readLine()) != null) {
                parts = line.split(",");
                students.add(new Student(parts));
                updateSubjects(subjects,parts);
            }
 
        }
        finally {
            if (reader != null) reader.close();
 
        }
       
    }
   
    static void writeOutput(File file, List<Student> students, List<Subject> subjects) throws IOException {
       
        PrintStream writer = null;
        try {
            writer = new PrintStream(file);
            writer.println("Prosechna ocenka po studenti:");
            writer.println(String.format("%-10s\t%s","Index:","Ocenka:"));
            for (Student student : students) {
                writer.println(String.format("%-10s\t%.2f", student.getIndex(),student.getAvgGrade()));
            }
            writer.println("Prosechna ocenka po predmeti:");
            writer.println(String.format("%-10s\t%s","Predmet:","Ocenka:"));
            for (Subject subject : subjects) {
                writer.println(String.format("%-10s\t%.2f", subject.getName(),subject.getAvgGrade()));
            }
 
        }
        finally {
            if (writer != null) writer.close();
        }
       
       
    }
   
    static void createSubjects(List<Subject> subjects,String [] parts) {
       
        for (int i=1; i< parts.length; ++i)
            subjects.add(new Subject(parts[i]));
       
    }
   
    static void updateSubjects(List<Subject> subjects, String[] parts) {
       
        for (int i=1; i < parts.length; ++i )
            subjects.get(i-1).addGrade(parts[i]);
    }
   
   
 
}
 
class Student  {
   
    private long index;
    private int[] grades;
   
    public Student(String []parts) {
        this.index = Long.parseLong(parts[0]);
        grades = new int[parts.length-1];
        for (int i=1; i < parts.length; ++i)
            grades[i-1] = Integer.parseInt(parts[i]);
    }
   
    public double getAvgGrade() {
        double sum = 0;
        for (Integer grade : grades)
            sum += grade;
        return sum / grades.length;
    }
   
    public long getIndex() {
        return index;
    }
   
}
 
class Subject {
   
    private String name;
    private List<Integer> grades;
   
    public Subject(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }
   
    public double getAvgGrade() {
        return grades.stream()
                .mapToDouble(each -> Double.valueOf(each))
                .sum() / grades.size();
    }
   
    public void addGrade(String grade) {
        grades.add(Integer.parseInt(grade));
    }
   
    public String getName() {
        return name;
    }
   
   
}