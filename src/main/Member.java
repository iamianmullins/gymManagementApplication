/**
 * @Member class: Subclass of Person
 * Member class is the parent class of PremiumMember and StudentMember
 * @author Ian Mullins
 */

import java.util.*;

public class Member extends Person {
    private float height; //measured in meters: must be between 1 & 3 inclusive
    private float startWeight; //measured in kgs: Must be between 35 and 250
    private Assessment assessment;
    private String chosenPackage;
    private TreeMap<String, Assessment> assessments = new TreeMap<>();

    /**
     * Member constructor
     * Inherits fields from superclass, passes inherited fields in super() method
     *
     * @param email         inherited from superclass - the persons email address
     * @param name          inherited from superclass -the persons name
     * @param address       inherited from superclass -the persons address
     * @param gender        inherited from superclass -the persons gender
     * @param height        the members height
     * @param startWeight   the members start weight
     * @param chosenPackage the members chosen package, determines gym access level
     */
    public Member(String email, String name, String address,
                  String gender, float height, float startWeight, String chosenPackage) {
        super(email, name, address, gender);
        setHeight(height);
        setStartWeight(startWeight);
        setChosenPackage(chosenPackage);
    }

    /**
     * @param date             date of assessment - represents key in TreeMap of assessments
     * @param weighRecord      weight recording at time of assessment
     * @param thighMeasurement weight measurement at time of assessment
     * @param waistMeasurement waist measurement at time of assessment
     * @param trainer          name of trainer recording assessment
     * @param comment          trainer comments regarding assessment and member progress
     */
    public void addAssessment(String date, float weighRecord, float thighMeasurement, float waistMeasurement, String trainer, String comment) {
        assessment = new Assessment(
                weighRecord, thighMeasurement, waistMeasurement, trainer, comment);
        assessments.put(date, assessment);
    }

    /**
     * Lists all assessments recorded for member
     * keyset method iterates through the key values from <k,v> assessments TreeMap
     * Key is then used in the assessments.get() method to get each assessment in the TreeSet and print out to the user
     * If no assessments are stored, print no assessments found
     */
    public void listAssessments() {
        try {
            if (assessments.size() != 0) {
                for (String assessment : assessments.keySet()) {
                    System.out.println("\nDate: " + assessment + "\n" + assessments.get(assessment));
                }
            } else {
                System.out.println("\nNo assessments found");
            }
        } catch (Exception e) {
            System.out.println("\nNo assessments found");
        }
    }

    /**
     * @param date user input passed as parameter. Represents key in key/value pair
     * @return assessment based on user input
     */
    public Assessment getAssessment(String date) {
        try {
            Assessment assessment = assessments.get(date);
        } catch (Exception e) {
            assessment = null;
        }
        return assessment;
    }

    /**
     * retrieves the last assessment stored for the user using the .lastKey method
     *
     * @return the latest assessment stored for the member
     */
    public Assessment latestAssessment() {
        try {
            String assessmentKey = assessments.lastKey();
            assessment = getAssessment(assessmentKey);
        } catch (Exception e) {
            assessment = null;
        }
        return assessment;
    }

    public Assessment secondMostRecentAssessment() {
        try {
            List<Assessment> targetList = new ArrayList<>(assessments.values());
            Assessment assessment = null;
            for (int i = 0; i < targetList.size() - 1; i++) {
                assessment = targetList.get(i);
            }
            return assessment;
        } catch (Exception e) {
            assessment = null;
        }
        return assessment;
    }

    /**
     * retrieves the last assessment stored for the user using the .firstKey method
     *
     * @return the latest assessment stored for the member
     */
    public Assessment firstAssessment() {
        try {
            String assessmentKey = assessments.firstKey();
            assessment = assessments.get(assessmentKey);
        } catch (Exception e) {
            System.out.println("Error encountered, not enough data for: " + getName());
            assessment = null;
        }
        return assessment;
    }

    /**
     * determines member progress based on the weight recording from the latest assessment
     * and the weight recorded for the members last assessment
     *
     * @return float progress : represents the amount of weight lost/gained
     */
    public float weightProgress() {
        Assessment assessment = latestAssessment();
        float lastWeight;
        Assessment lastAssessment = secondMostRecentAssessment();
        float currentWeight = assessment.getWeighRecord();
        if (lastAssessment!=null) {
            lastWeight = lastAssessment.getWeighRecord();
        }
        else{
            lastWeight= currentWeight;
        }
        float progress = lastWeight - currentWeight;
        return progress;
    }

    /**
     * determines member progress based on the waist measurement recording from the latest assessment
     * and the waist measurement recording from the previous assessment
     *
     * @return float progress : represents the amount of increase/decrease in waist size
     */
    public float waistMeasureProgress() {
        Assessment latestAssessment = latestAssessment();
        Assessment lastAssessment = secondMostRecentAssessment();
        float progress = lastAssessment.getWaistMeasurement() - latestAssessment.getWaistMeasurement();
        return progress;
    }


    /**
     * height accessor
     *
     * @return members height
     */
    public float getHeight() {
        return height;
    }

    /**
     * start weight accessor
     *
     * @return members start weight
     */
    public float getStartWeight() {
        return startWeight;
    }

    /**
     * chosen package accessor
     *
     * @return members chosen package
     */
    public String getChosenPackage() {
        return chosenPackage;
    }

    /**
     * Assessment treemap accessor
     *
     * @return all assessments for member
     */
    public TreeMap<String, Assessment> getAssessments() {
        return assessments;
    }

    /**
     * Height mutator
     * measured in meters: must be between 1 & 3 inclusive
     *
     * @param height sets member height  on registration within constraints above
     */
    public void setHeight(float height) {
        if (height >= 1 && height <= 3) {
            this.height = height;
        } else if (height > 3) {
            this.height = 3;
        } else if (height < 1) {
            this.height = 1;
        }
    }

    /**
     * Height mutator
     * measured in kgs: Must be between 35 and 250
     *
     * @param startWeight sets member weight on registration within constraints above
     */
    public void setStartWeight(float startWeight) {
        if (startWeight >= 35 && startWeight <= 250) {
            this.startWeight = startWeight;
        } else if (startWeight < 35) {
            this.startWeight = 35;
        } else if (startWeight > 250) {
            this.startWeight = 250;
        }
    }


    /**
     * Chosen package mutator
     * implemented in MenuController class
     * Selection available for premium members
     * Student members default to a specific package based on college name
     *
     * @param chosenPackage sets member chosen package
     */
    public void setChosenPackage(String chosenPackage) {
        this.chosenPackage = chosenPackage;
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
                + "\nHeight:" + height
                + "\nStart Weight:" + startWeight
                + "\nchosenPackage:" + chosenPackage;
    }
}

