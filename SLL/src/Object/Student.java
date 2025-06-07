package Object;

public class Student {
    private final String StudentID;
    private final String StudentName;
    private final int StudentAge;

    public Student(String studentID, String studentName, int studentAge) {
        StudentID = studentID;
        StudentName = studentName;
        StudentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", StudentAge=" + StudentAge +
                '}';
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public int getStudentAge() {
        return StudentAge;
    }
}
