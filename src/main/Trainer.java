/**
 * @Trainer : Subclass of Person
 * Inherits fields from Super class
 * Additional field stored: trainer speciality
 */
public class Trainer extends Person {
    private String speciality;

    /**
     * Inherits fields from superclass, passes inherited fields in super() method
     *
     * @param email      inherited from superclass - the persons email address
     * @param name       inherited from superclass -the persons name
     * @param address    inherited from superclass -the persons address
     * @param gender     inherited from superclass -the persons gender
     * @param speciality represents training speciality of the trainer
     */
    public Trainer(String email, String name, String address, String gender, String speciality) {
        super(email, name, address, gender);
        this.speciality = speciality;
    }

    /**
     * speciality accessor
     * @return the training speciality of trainer
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * speciality mutator
     * @param speciality training speciality of trainer
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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
                + "\nSpeciality:" + speciality;
    }
}
