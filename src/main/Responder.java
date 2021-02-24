import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Ian Mullins
 * @Responder class
 * Responsible generating workouts output to the user
 */
public class Responder {
    private Random randomGenerator = new Random();
    private ArrayList<String> exercises;
    private HashMap<String, String> responseMap;
    private HashSet<String> responseSet;

    /**
     * Responder constructor
     * takes no parameters, instantiates new ArrayList of exercises
     * instantiates new HashMap of responses
     * instantiates new HashSet of responses
     * populates ArrayList of Exercises and HashMap of workouts with hardcoded key words
     */
    public Responder() {
        exercises = new ArrayList<String>();
        responseMap = new HashMap<String, String>();
        responseSet = new HashSet<String>();
        fillExercises();
        fillResponseMap();
    }

    /**
     * randomGenerator instantiates new Random()
     * @return a String of random exercises
     */
    private String fillRandomResponses() {
        while (responseSet.size() < 3) {
            randomGenerator = new Random();
            int selector = randomGenerator.nextInt(exercises.size());
            String exercise = exercises.get(selector) + "\n";
            responseSet.add(exercise);
        }
        Iterator set = responseSet.iterator();
        String str = "";
        for (String String : responseSet) {
            while (set.hasNext()) {
                str = str + set.next();
            }
        }
        return str;
    }

    /**
     * populates HashMap of String pairs
     * keys are hardcoded to represent target muscle groups
     * values are populates with exercises from the ecercises arraylist using the .get method
     */
    private void fillResponseMap() {
        responseMap.put("chest", exercises.get(0) + "\n" + exercises.get(1) + "\n" + exercises.get(4));
        responseMap.put("triceps", exercises.get(5) + "\n" + exercises.get(7) + "\n" + exercises.get(8));
        responseMap.put("biceps", exercises.get(20) + "\n" + exercises.get(21) + "\n" + exercises.get(23));
        responseMap.put("arms", exercises.get(7) + "\n" + exercises.get(20) + "\n" + exercises.get(24));
        responseMap.put("back", exercises.get(18) + "\n" + exercises.get(19) + "\n" + exercises.get(26));
        responseMap.put("quads", exercises.get(9) + "\n" + exercises.get(12) + "\n" + exercises.get(14));
        responseMap.put("hamstrings", exercises.get(13) + "\n" + exercises.get(11) + "\n" + exercises.get(15));
        responseMap.put("legs", exercises.get(9) + "\n" + exercises.get(16) + "\n" + exercises.get(15));
        responseMap.put("body", exercises.get(27) + "\n" + exercises.get(0) + "\n" + exercises.get(10));
    }

    /**
     * @fillExercises Populates the exercises arrayList with exercises
     * calls repsGenerator, setsGenerator and intensityGenerator methods to populate exercise intensity metrics
     */
    private void fillExercises() {
        exercises.add(0, "Bench Press" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(1, "Inclined dumbbell flies" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(2, "Pushups" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(3, "Inclined Bench Press" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(4, "Dumbbell flies" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(5, "Pushups" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(6, "Cable Flies" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(7, "Skull Crusher" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(8, "Wide Pushups" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");

        exercises.add(9, "Squats" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(10, "Deadlifts" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(11, "Lunges" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(12, "Sumo Squats" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(13, "Straight Leg Deadlifts" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(14, "Leg Extension" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(15, "Leg Curl" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(16, "Calf Raise" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(17, "Lateral Lunge" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");

        exercises.add(18, "Bent Over Row" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(19, "Romanian Deadlift" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(20, "Bicep Curls" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(21, "Single Arm Row" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(22, "Cable Row" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(23, "Pull Ups" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(24, "Chin Ups" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(25, "Reverse Fly" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(26, "Good Mornings" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
        exercises.add(27, "Shoulder Press" + "\nReps: " + repsGenerator() + "\tSets: " + setsGenerator() + "\tRep Max: " + intensityGenerator() + "%");
    }

    /**
     * @return int of intensity
     * @intensityGenerator Generates random integer between 5 and 9 exclusive
     * multiplies random * 100 to return % rate of percieved exertion
     */
    private int intensityGenerator() {
        int intensity = 0;
        do {
            intensity = randomGenerator.nextInt(10);
        }
        while (intensity < 5 || intensity > 9);
        return intensity * 10;
    }

    /**
     * @return int number of reps
     * @repsGenerator Generates random integer between 5 and 15 inclusive
     */
    private int repsGenerator() {
        int reps = 0;
        do {
            reps = randomGenerator.nextInt(16);
        }
        while (reps < 5);
        return reps;
    }

    /**
     * @return int number of sets
     * @setsGenerator Generates random integer between 3 and 5 inclusive
     */
    private int setsGenerator() {
        int reps = 0;
        do {
            reps = randomGenerator.nextInt(6);
        }
        while (reps < 2);
        return reps;
    }


    /**
     * @param words represents  HashSet of Strings generated in the @InputReader class @getInput method
     * @return String of exercises. If user input matches key in responseMap, return workout targeting body part defined
     * by user, else return random workout
     */
    public String generateResponseSearch(HashSet<String> words) {
        Iterator<String> it = words.iterator();
        while (it.hasNext()) {
            String word = it.next();
            String response = responseMap.get(word);
            if (response != null) {
                return response;
            }
        }
        System.err.println("Suitable workout not found, maybe try this one?");
        return fillRandomResponses();
    }

    /**
     * returns random workout of 3 exercises to the user
     * @return String generated in private helper method fillRandomResponses
     */
    public String generateResponse() {
        return fillRandomResponses();
    }

    /**
     * outputs welcome message to the user
     */
    public void printWelcome() {
        System.out.println("\nWelcome to the gym Workout Wizard");
        System.out.println("=================================");
    }

    /**
     * outputs thank you message to the user
     */
    public void printGoodbye() {
        System.out.println("We hope you enjoy your workout!");
    }
}

