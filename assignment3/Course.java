/*---------------------------------------
 Genuine authors: 	<Morad Abu Alkeaan>,	I.D.:	<id number>
					<Khaled Zbidat>,	I.D.:	<id number>
 Date: xx-05-2019
---------------------------------------*/

public class Course {
    private String name;
    private int number;
    private int credits;
   
    public Course(String name, int number, int credits){
        if(name == null || number <= 0 || credits <= 0 || !isValidName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.number = number;
        this.credits = credits;
    }

    private boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (! ((c > 'a' && c < 'z') || (c >'A' && c < 'Z') || (c > '0' && c < '9') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return this.name;
    }

    public int getCredits() {
        return this.credits;
    }

    public int getNumber() {
        return this.number;
    }
	
	public String toString(){
		return "Course Name: " + this.name + ", Number: " + this.number + ", Credits: " + this.credits;
	}
	
	public boolean isEqualTo(Course other){
		// return (other.name == this.name && other.number == this.number && other.credits == this.credits;
		return this.number == other.getNumber();
    }
    
    public static void main(String[] args) {
        Student s = new Student("John", "Smith", 11111);
        Course c1 = new Course("someCourse1",1234, 2);
        Course c2 = new Course("someCourse2",1111, 3);
        s.addCourseGrade(c1, 100);
        s.addCourseGrade(c2, 90);
        System.out.println(s.averageGrade()); // prints 94.0
        StudentInfo studentInfo = s.getStudentInfo();
        System.out.println(studentInfo.getCredit()); //prints 5
        System.out.println(studentInfo.getRequiredCredits()); //prints 120
    }
}