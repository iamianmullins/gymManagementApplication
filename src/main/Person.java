/**
 * Superclass @Person
 * Person class Is the Parent class of Trainer and Member,
 *
 * @author Ian Mullins
 */
public class Person {
    private String name;
    private String email;
    private String address;
    private String gender;

    /**
     * Person constructor with all fields as parameters
     *
     * @param email   the persons email address
     * @param name    the persons name
     * @param address the persons address
     * @param gender  the persons gender
     */
    public Person(String email, String name, String address, String gender) {
        setName(name);
        this.email = email;
        this.address = address;
        setGender(gender);
    }

    /**
     * Name accessor
     *
     * @return the persons name
     */
    public String getName() {
        return name;
    }

    /**
     * Email accessor
     *
     * @return the persons email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Address accessor
     *
     * @return the persons address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gender accessor
     *
     * @return the persons gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * The name mutator method
     * validation to ensure name length does not exceed 30 characters
     *
     * @param name the persons name
     */
    public void setName(String name) {
        try {
            this.name = name;
            if (name.length() >= 1 && name.length() <= 30) {
                this.name = name;
            } else if (name.length() > 30) {
                this.name = name.substring(0, 30);
            } else {
                System.out.println("Invalid name entered");
            }
        } catch (Exception e) {
            System.out.println("Issue with name");
        }
    }


    /**
     * The address mutator method
     *
     * @param address the persons address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * The gender mutator method
     * validation to ensure gender in M/F/Unspecified
     *
     * @param gender the persons name
     */
    public void setGender(String gender) {
        this.gender = gender;
        switch (this.gender) {
            case "M":
            case "m":
                this.gender = "M";
                break;
            case "F":
            case "f":
                this.gender = "F";
                break;
            default:
                this.gender = "Unspecified";
        }
    }

    /**
     * The toString method
     *
     * @return String containing all person fields
     */
    public String toString() {
        return "\nName: " + name
                + "\nEmail:" + email
                + "\nAddress:" + address
                + "\nGender:" + gender;
    }
}


