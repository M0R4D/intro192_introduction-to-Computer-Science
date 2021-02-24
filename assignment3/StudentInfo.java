/*---------------------------------------
 Genuine authors: 	<Morad Abu Alkeaan>,	I.D.:	<id number>
					<Khaled Zbidat>,	I.D.:	<id number>
 Date: xx-05-2019
---------------------------------------*/

/* Administrative information of a student */
public class StudentInfo {
    private String firstName;
    private String familyName;
    private int id;
    private String address;
    private int requiredCredits;
    private int credits = 0;

    public StudentInfo(String firstName, String familyName, int identityNumber, int maxCredit) {
        if(firstName == null || familyName == null || firstName == "" || familyName == "" || !isValidName(firstName) || !isValidName(familyName) || identityNumber <= 0 || maxCredit <= 0) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.familyName = familyName;
        this.id = identityNumber;
        this.requiredCredits = maxCredit;
    }

    private boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (! ((c > 'a' && c < 'z') || (c >'A' && c < 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public int getIdentityNumber() {
        return this.id;
    }

    public int getRequiredCredits() {
        return this.requiredCredits; 
    }
   
    public void addCredit(int credit) {
        if(credit <= 0) 
            throw new IllegalArgumentException();
        this.credits += credit;
    }

    public int getCredit() {
        return this.credits;
    }

    public void setAddress(String address){
        if (address == null || address == "" || !isValidName(address)) {
            throw new IllegalArgumentException();
        }
        this.address = address;
    }

    public String getAddress(){
        if (this.address == null) {
            return "";
        }
        return this.address;
    }
	
	public String toString(){
		return "Name: " + this.firstName + ", Family: " + this.familyName + ", ID: " + this.id + ", Address: " + this.address + ", CompletedCredits: " + this.credits; // + ", Credits: " + this.credits;
	}
	
	public boolean isEqualTo(StudentInfo other){
		return this.id == other.getIdentityNumber();
	}

}
