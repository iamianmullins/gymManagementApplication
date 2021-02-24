import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;

/**
 * @author Ian Mullins
 * @GymAPI facilitates much of the functionality of the application
 * Operates between the model classes and the menu driver class
 */
public class GymAPI {
    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;

    /**
     * GymAPI constructor
     * Initialises ArrayLists of Member and Trainer Objects
     */
    public GymAPI() {
        members = new ArrayList<Member>();
        trainers = new ArrayList<Trainer>();
    }


    /**
     * Returns a String containing member weight and height metrics
     * both in imperial and metric formats
     * If no assessments are stored for the member
     * Value is derived from registration
     * startWeight
     *
     * @return String containing imperial and metric values (weight/height) for all members
     */
    public String listMemberDetailsImperialAndMetric() {
        String str = "";
        if (members.size() != 0) {
            for (Member member : members) {
                String name;
                float weight;
                float height;
                if (member.latestAssessment() != null) {
                    name = member.getName();
                    weight = member.latestAssessment().getWeighRecord();
                    height = member.getHeight();
                    str = str + name + ": "
                            + weight + " kg(" + (GymUtility.roundDecimalPlaces(weight * 2.20)) + " lbs)\t\t"
                            + height + " metres (" + (GymUtility.roundDecimalPlaces(height * 39.37)) + " inches)\n";
                } else {
                    name = member.getName();
                    weight = member.getStartWeight();
                    height = member.getHeight();
                    str = str + name + ": "
                            + weight + " kg(" + (GymUtility.roundDecimalPlaces(weight * 2.20)) + " lbs)\t\t"
                            + height + " metres (" + (GymUtility.roundDecimalPlaces(height * 39.37)) + " inches)\n";
                }
            }
        } else {
            str = "No registered members";
        }
        return str;
    }

    /**
     * Returns a ArrayList containing each member with an ideal weight
     * returns only members that have had an assessment recorded
     *
     * @return Returns a ArrayList containing each member with an ideal weight
     */
    public ArrayList<Member> listMembersWithIdealWeight() {
        ArrayList<Member> membersWithIdealWeight = new ArrayList<Member>();
        if (members.size() >0) {
                for (Member member : members) {
                    Assessment assessment = member.latestAssessment();
                    if (assessment!=null) {
                        Boolean idealBW = GymUtility.isIdealBodyWeight(member, assessment);
                        if (idealBW) {
                            membersWithIdealWeight.add(member);
                        }
                    }
                }
                return membersWithIdealWeight;
            }
        return membersWithIdealWeight;
        }


    /**
     * Returns a String containing member name and calculated BMI for all qualifying members
     * returns only members that have had an assessment recorded
     *
     * @return String containing imperial and metric values (weight/height) for all members
     */
    public String allMembersBmi() {
        String membersBmiAnalysis = "";
        if (members.size() != 0) {
            ArrayList<Member> membersWithIdealWeight = new ArrayList<Member>();
                for (Member member : members) {
                    Assessment assessment = member.latestAssessment();
                    double currentBmi = GymUtility.calculateBMI(member, assessment);
                    membersBmiAnalysis = membersBmiAnalysis + "Name: " + member.getName() + "\tBMI: " + currentBmi + "\n";
                }
                return membersBmiAnalysis;
        }
        return membersBmiAnalysis = "No data found";
    }

    /**
     * Returns a String containing analysis of a specific member
     * Current BMI, BMI category and bmi clasification(ideal/not ideal)
     *
     * @param member instance of Member
     * @return Returns a String containing fitness and health analysis for a member
     */
    public String bmiAnalysis(Member member) {
        Assessment assessment = member.latestAssessment();
        double calculateBMI = GymUtility.calculateBMI(member, assessment);
        String currentBmiCat = GymUtility.determineBMICategory(calculateBMI);
        Boolean idealBW = GymUtility.isIdealBodyWeight(member, assessment);
        String endOfString;
        if (idealBW == true) {
            endOfString = " has an ideal body weight";
        } else {
            endOfString = " does not have an ideal body weight";
        }
        String name = member.getName();
        String str = "\nMember:" + member.getName()
                + "\n--Has a BMI of " + calculateBMI
                + "\n--This is categorised as " + currentBmiCat
                + "\n--" + name + endOfString;
        return str;
    }

    /**
     * Returns an ArrayList of Member by BMI category
     * Current BMI, BMI category and bmi clasification(ideal/not ideal)
     * Member BMI is calculated using latest Assessment recorded
     * BMI is passed as parameter to determineBMICategory() method
     *
     * @param category String read in from switch statement, value derived from user input
     * @return Returns an ArrayList of Member by BMI category
     */
    public ArrayList<Member> listMembersBySpecificBMICategory(String category) {
        ArrayList<Member> listMembersByBMICategory = new ArrayList<Member>();
        if (members.size() > 0) {
            for (Member member : members) {
                Assessment assessment = member.latestAssessment();
                double calculateBMI = GymUtility.calculateBMI(member, assessment);
                String currentBmiCat = GymUtility.determineBMICategory(calculateBMI);
                if (currentBmiCat.toLowerCase().contains(category.toLowerCase())){
                    listMembersByBMICategory.add(member);
                }
            }
        }
        return listMembersByBMICategory;
    }


    /**
     * @return ArrayList of member objects, not untilised
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    /**
     * @return ArrayList of trainer objects
     */
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    /**
     * Add member method
     * adds new member to members ArrayList
     * Utilised in MenuController
     *
     * @param member an instance of Member
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Add trainer method
     * adds new trainer to trainers ArrayList
     * Utilised in MenuController
     *
     * @param trainer an instance of Trainer
     */
    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    /**
     * If members ArrayList is populated, return String of Name/Email for all members
     * else return "No members found"
     *
     * @return String containing Name and Email for each member in the members ArrayList
     */
    public String listMembers() {
        if (members.size() == 0) {
            return "No members found";
        } else {
            String memberList = "";
            int counter = 1;
            for (Member member : members) {
                memberList = memberList + counter + " : " + "Name: " + member.getName()
                        + "\t\tEmail: " + member.getEmail() + "\n";
                counter++;
            }
            return memberList;
        }
    }

    /**
     * If trainers ArrayList is populated, return String of Name/Email for all trainers
     * else return "No trainers found"
     *
     * @return String containing Name, Email and speciality for each trainer in the trainers ArrayList
     */
    public String listTrainers() {
        if (trainers.size() == 0) {
            return "No trainers found";
        } else {
            String trainerList = "";
            int counter = 1;
            for (Trainer trainer : trainers) {
                trainerList = trainerList + counter + " : " + "Email: " + trainer.getEmail()
                        + "\n\tName: " + trainer.getName()
                        + "\tSpeciality: " + trainer.getSpeciality() + "\n";
                counter++;
            }
            return trainerList;
        }
    }

    /**
     * Amount of Members stored in the members ArrayList
     *
     * @return members ArrayList size
     */
    public int numberOfMembers() {
        return members.size();
    }

    /**
     * Amount of Trainers stored in the trainers ArrayList
     *
     * @return trainers ArrayList size
     */
    public int numberOfTrainers() {
        return trainers.size();
    }

    /**
     * @param index int value
     * @return boolean returns true if index is less than size of members ArrayList
     */
    public boolean isValidMemberIndex(int index) {
        if (members.size() > 0) {
            if (index < members.size()) {
                return true;
            } else if (index > members.size()) {
                return false;
            }
        }
        return false;
    }

    /**
     * @param index int value
     * @return boolean returns true if index is less than size of trainers ArrayList
     */
    public boolean isValidTrainerIndex(int index) {
        if (trainers.size() > 0) {
            if (index < trainers.size()) {
                return true;
            } else if (index > trainers.size()) {
                return false;
            }
        }
        return false;
    }

    /**
     * Search members by email, return member object
     * if emailEntered matches email address stored for a member, that Member is returned
     *
     * @param emailEntered user input, represents email address
     * @return Member else null
     */
    public Member searchMembersByEmail(String emailEntered) {
        if (members.size() != 0) {
            Member memberSearch = null;
            for (Member member : members) {
                if (member.getEmail().equalsIgnoreCase(emailEntered)) {
                    memberSearch = member;
                    return memberSearch;
                }
            }
            return memberSearch;
        } else
            return null;
    }

    /**
     * Search trainers by name, return ArrayList of Strings containing trainer names if partial or complete match
     * if nameEntered matches name stored for a trainer, Trainer name is added to ArrayList of Strings
     *
     * @param nameEntered user input, represents Trainer name
     * @return ArrayList Strings containing Trainer names
     */
    public ArrayList<String> searchTrainersByName(String nameEntered) {
        ArrayList<String> trainerSearch = new ArrayList<String>();
        if (trainers.size() > 0) {
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getName().toLowerCase().contains((nameEntered.toLowerCase()))) {
                    trainerSearch.add(trainers.get(i).getName());
                }
            }
            return trainerSearch;
        } else {
            return trainerSearch;
        }
    }

    /**
     * Search trainers by name, return ArrayList of Strings containing trainer names if partial or complete match
     * if nameEntered matches name stored for a trainer, Trainer name and email are added to ArrayList of Strings
     *
     * @param nameEntered user input, represents Trainer name
     * @return ArrayList Strings containing Trainer names and emails
     */
    public ArrayList<String> searchTrainersListByName(String nameEntered) {
        ArrayList<String> trainerSearch = new ArrayList<String>();
        if (trainers.size() > 0) {
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getName().toLowerCase().contains((nameEntered.toLowerCase()))) {
                    trainerSearch.add(i, (i + 1) + " Name: " + trainers.get(i).getName() + "\tEmail: " + trainers.get(i).getEmail());
                }
            }
            return trainerSearch;
        } else {
            return trainerSearch;
        }
    }

    /**
     * Search members by name, return ArrayList of Strings containing members names if partial or complete match
     * if nameEntered matches name stored for a member, members name is added to ArrayList of Strings
     *
     * @param nameEntered user input, represents Member name
     * @return ArrayList Strings containing Member names
     */
    public ArrayList<String> searchMembersByName(String nameEntered) {
        ArrayList<String> memberSearch = new ArrayList<String>();
        if (members.size() > 0) {
            for (int i = 0; i < members.size(); i++) {
                if ((members.get(i).getName()).toLowerCase().contains((nameEntered.toLowerCase()))) {
                    memberSearch.add(members.get(i).getName());
                }
            }
            return memberSearch;
        } else {
            return memberSearch;
        }
    }

    /**
     * Search members by name, return ArrayList of Strings containing members names if partial or complete match
     * if nameEntered matches name stored for a member, email(ID) )is added to ArrayList of Strings
     *
     * @param nameEntered user input, represents Member name
     * @return ArrayList Strings containing Member emails
     */
    public ArrayList<String> searchMembersIDByName(String nameEntered) {
        ArrayList<String> memberSearch = new ArrayList<String>();
        if (members.size() > 0) {
            for (int i = 0; i < members.size(); i++) {
                if ((members.get(i).getName()).toLowerCase().contains((nameEntered.toLowerCase()))) {
                    memberSearch.add(members.get(i).getEmail());
                }
            }
            return memberSearch;
        } else {
            return memberSearch;
        }
    }

    /**
     * Search members by name, return ArrayList of Strings containing members names if partial or complete match
     * if nameEntered matches name stored for a member, members name and email are added to ArrayList of Strings
     *
     * @param nameEntered user input, represents Member name
     * @return ArrayList of formatted Strings containing Member names and emails
     */
    public ArrayList<String> searchMembersListByName(String nameEntered) {
        ArrayList<String> memberSearch = new ArrayList<String>();
        if (members.size() > 0) {
            for (int i = 0; i < members.size(); i++) {
                if ((members.get(i).getName()).toLowerCase().contains((nameEntered.toLowerCase()))) {
                    memberSearch.add("Name: " + members.get(i).getName() + "\tEmail: " + members.get(i).getEmail());
                }
            }
            return memberSearch;
        } else {
            memberSearch.add(0, "No members found");
            return memberSearch;
        }
    }

    /**
     * Search trainer by email, return trainer object
     * if emailEntered matches email address stored for a trainer, that trainer is returned
     *
     * @param emailEntered user input, represents email address
     * @return Trainer else null
     */
    public Trainer searchTrainersByEmail(String emailEntered) {
        if (trainers.size() != 0) {
            Trainer trainerSearch = null;
            for (Trainer trainer : trainers) {
                if (trainer.getEmail().equalsIgnoreCase(emailEntered)) {
                    trainerSearch = trainer;
                }
            }
            return trainerSearch;
        } else
            return null;
    }

    /**
     * @param member           currentMember being assessed
     * @param date             todays date*
     * @param weighRecord      weight recorded at time of assessment
     * @param thighMeasurement thigh measurement at time of assessment
     * @param waistMeasurement waist measurement at time of assessment
     * @param trainer          trainer performing assessment
     * @param comment          additional comments from Trainer
     */
    public void addMemberAssessment(Member member, String date, float weighRecord, float thighMeasurement, float waistMeasurement, String trainer, String comment) {
        member.addAssessment(date, weighRecord, thighMeasurement, waistMeasurement, trainer, comment);
    }

    /**
     * Method responsible for mashalling ArrayList of objects to XML
     * Warning supression code removed
     *
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void store() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream mem = xstream.createObjectOutputStream(new FileWriter("members.xml"));
        ObjectOutputStream trn = xstream.createObjectOutputStream(new FileWriter("trainers.xml"));
        mem.writeObject(members);
        trn.writeObject(trainers);
        mem.close();
        trn.close();
    }

    /**
     * Method responsible for unmashalling ArrayList of objects from XML
     * Warning supression code removed
     *
     * @throws Exception
     */
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream mem = xstream.createObjectInputStream(new FileReader("members.xml"));
        ObjectInputStream trn = xstream.createObjectInputStream(new FileReader("trainers.xml"));
        members = (ArrayList<Member>) mem.readObject();
        trainers = (ArrayList<Trainer>) trn.readObject();
        mem.close();
        trn.close();
    }
}
