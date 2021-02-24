/**
 * @author Ian Mullins
 * @StudentMember: Subclass of Member
 */
public class StudentMember extends Member {
    private int studentId;
    private String collegeName;


    /**
     * StudentMember constructor
     * Inherits fields from superclass, passes inherited fields in super() method
     *
     * @param email         inherited from superclass - the persons email address
     * @param name          inherited from superclass -the persons name
     * @param address       inherited from superclass -the persons address
     * @param gender        inherited from superclass -the persons gender
     * @param height        inherited from superclass  - the members height
     * @param startWeight   inherited from superclass  - the members start weight
     * @param chosenPackage inherited from superclass - the members chosen package, determines gym access level
     * @param studentId     represents the student members studentID
     * @param collegeName   represents the student members college name, determines student package
     */
    public StudentMember(String email, String name, String address,
                         String gender, float height, float startWeight, String chosenPackage, int studentId, String collegeName) {
        super(email, name, address, gender, height, startWeight, chosenPackage);
        this.studentId = studentId;
        this.collegeName = collegeName;
    }

    /**
     * StudentID accessor
     * @return the student members studentID
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * College name accessor
     * @return the student members college name, determines student package and access levels to the gym
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * The toString method
     * overrides parent class
     *
     * @return String containing all inherited fields and current class fields
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nStudent Member**"
                + "\nStudent ID:" + studentId
                + "\nCollege Name ID:" + collegeName;
    }
}
