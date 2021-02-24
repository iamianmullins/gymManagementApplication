/**
 * @author Ian Mullins
 * @PremiumMember : Subclass of Member
 * Premium member class stores no additional information
 */
public class PremiumMember extends Member {

    /**
     * PremiumMember constructor
     * Inherits all fields from superclass, passes inherited fields in super() method
     *
     * @param email         inherited from superclass - the persons email address
     * @param name          inherited from superclass -the persons name
     * @param address       inherited from superclass -the persons address
     * @param gender        inherited from superclass -the persons gender
     * @param height        inherited from superclass  - the members height
     * @param startWeight   inherited from superclass  - the members start weight
     * @param chosenPackage inherited from superclass - the members chosen package, determines gym access level
     */
    public PremiumMember(String email, String name, String address,
                         String gender, float height, float startWeight, String chosenPackage) {
        super(email, name, address, gender, height, startWeight, chosenPackage);
    }

    /**
     * The toString method
     * overrides parent class
     *
     * @return String containing all inherited fields and currenct class fields
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nPremium Member**";

    }
}
