/*---------------------------------------
 Genuine authors: 	<Morad Abu Alkeaan>,	I.D.:	<id number>
					<Khaled Zbidat>,	I.D.:	<id number>
 Date: xx-05-2019
---------------------------------------*/

public class Student {
    private StudentInfo student;
    private double average = 0;

    public Student(String firstName, String familyName, int identityNumber) {
        this.student = new StudentInfo(firstName, familyName, identityNumber, 120);
    }

    public StudentInfo getStudentInfo(){
        return this.student;
    }

    public void addCourseGrade(Course course, int grade) {
        this.average = this.average * this.student.getCredit() + course.getCredits() * grade;
        this.average /= (this.student.getCredit() + course.getCredits());
        this.student.addCredit(course.getCredits());
    }

    public double averageGrade() {
        return this.average;
    }
	
	public String toString(){
		return this.student.toString() + ", with Average: " + this.average;
	}
	
	public boolean isEqualTo(Student other){
		return this.student.getIdentityNumber() == other.student.getIdentityNumber();
	}

}