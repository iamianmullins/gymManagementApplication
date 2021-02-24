import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Ian Mullins
 * @Utility Class
 * contains static methods and encapsulates no state (fields).
 * Methods contained provide analytics to the user through various metrics stored in the member and assessment classes
 */

public class GymUtility {

    /**
     * Returns the BMI for the member based on the calculation:
     * BMI is weight divided by the square of the height.
     *
     * @param member     is the current member for which  BMI is being calculated, contains the height field
     * @param assessment is the assessment for which  BMI is being calculated, contains the weightRecord field
     * @return double BMI calculated to two decimal places
     */
    public static double calculateBMI(Member member, Assessment assessment) {
        try {
            double latestWeight;
            if (assessment != null) {
                latestWeight = assessment.getWeighRecord();
            } else {
                latestWeight = member.getStartWeight();
            }
            double height = member.getHeight();
            double BMI = latestWeight / (height * height);
            return toTwoDecimalPlaces(BMI);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * double is passed as parameter
     *
     * @param number double passed as parameter
     * @return double to two decimal places
     */
    public static double toTwoDecimalPlaces(double number) {
        return (int) (number * 100) / 100.0;
    }

    public static double roundDecimalPlaces(double number) {
        number =Double.parseDouble(new DecimalFormat("##.##").format(number));
        return number;
    }

    /**
     * Returns the category the BMI belongs to, based on the following values:
     * BMI less than 16 (exclusive) is "SEVERELY UNDERWEIGHT"
     * BMI between 16 (inclusive) and 18.5 (exclusive) is "UNDERWEIGHT"
     * BMI between 18.5 (inclusive) and 25(exclusive) is "NORMAL"
     * BMI between 25 (inclusive) and 30 (exclusive) is "OVERWEIGHT"
     * BMI between 30 (inclusive) and 35 (exclusive) is "MODERATELY OBESE"
     * BMI greater than 35 (inclusive) and is "SEVERELY OBESE"
     *
     * @param bmiValue value calulated in the calculateBMI method, passed as parameter
     * @return corresponding String defining category based on double passed as parameter
     */
    public static String determineBMICategory(double bmiValue) {
        String bmicategory = "";
        try {
            double BMIvalue = bmiValue;
            if (bmiValue > 0) {
                if (BMIvalue < 16) {
                    bmicategory = "SEVERELY UNDERWEIGHT";
                } else if (BMIvalue >= 16 && bmiValue < 18.5) {
                    bmicategory = "UNDERWEIGHT";
                } else if (BMIvalue >= 18.5 && bmiValue < 25) {
                    bmicategory = "NORMAL";
                } else if (BMIvalue >= 25 && bmiValue < 30) {
                    bmicategory = "OVERWEIGHT";
                } else if (BMIvalue >= 30 && bmiValue < 35) {
                    bmicategory = "MODERATELY OBESE";
                } else if (BMIvalue >= 35) {
                    bmicategory = "SEVERELY OBESE";
                }
                return bmicategory;
            } else {
                bmicategory = "Not enough data";
                return bmicategory;
            }
        } catch (Exception e) {
            return bmicategory;
        }
    }

    /**
     * Returns a boolean to indicate if the member has an ideal body weight based on the Devine formula:
     * For males, an ideal body weight is: 50 kg + 2.3 kg for each inch over 5 feet.
     * For females, an ideal body weight is: 45.5 kg + 2.3 kg for each inch over 5 feet.
     * Note: if no gender is specified, return the result of the female calculation.
     * Note: if the member is 5 feet or less, return 50kg for male and 45.5kg for female.
     * To allow for different calculations and rounding, when testing for the ideal body weight, if it is +/- .2 of the devine formula, return true
     *
     * @param member     is the current member for which the boolean ideal body weight is returned
     * @param assessment is the assessment for which the boolean ideal body weight is returned
     * @return boolean is ideal body weight within a tolerance of +/-.2 kg
     */
    public static boolean isIdealBodyWeight(Member member, Assessment assessment) {
        double baseWeightMale = 50;
        double baseWeightFemale = 45.5;
        double baseHeight = 60; //5 feet in inches
        double mtrsToInch = 39.37;  //meters to inches

        double memberWeight;
        if (assessment != null) {
            memberWeight = assessment.getWeighRecord();
        } else {
            memberWeight = member.getStartWeight();
        }

        double memberHeight;
        if ((member.getHeight()) * mtrsToInch < baseHeight) {
            memberHeight = baseHeight;
        } else {
            memberHeight = member.getHeight() * mtrsToInch;
        }
        double weightDifference;
        String gender = member.getGender();
        if (gender.equalsIgnoreCase("m")) {
            weightDifference = memberWeight - baseWeightMale;
        } else {
            weightDifference = memberWeight - baseWeightFemale;
        }
        double heightDifference = memberHeight - baseHeight;
        double allowance = heightDifference * 2.3; //2.3kg allowance per inch over 5 foot
        double weightAllowanceDifference = weightDifference - allowance;

        if ((weightAllowanceDifference >= -0.2) && (weightAllowanceDifference <= 0.2)) {
            return true;
        }
        {
            return false;
        }

    }
}
