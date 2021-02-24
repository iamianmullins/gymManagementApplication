/**
 * Assessment
 * Used to store weight, and body measurements as a metric for member progress
 * Multiple assessments can be stored for each member in the assessments TreeMap in the member class
 *
 * @author Ian Mullins
 */
public class Assessment {

    private float weighRecord;
    private float thighMeasurement;
    private float waistMeasurement;
    private String trainer;
    private String comment;

    /**
     * Assessment constructor containing weight recording, thigh measurement, waist measurement and trainer comment
     *
     * @param weighRecord      is the weight recorded for this assessment
     * @param thighMeasurement is the thigh measurement recorded for this assessment
     * @param waistMeasurement is the waist measurement recorded for this assessment
     * @param comment          is the Trainer comment recorded for this assessment
     */
    public Assessment(float weighRecord, float thighMeasurement, float waistMeasurement, String comment) {
        this.weighRecord = weighRecord;
        this.thighMeasurement = thighMeasurement;
        this.waistMeasurement = waistMeasurement;
        this.comment = comment;
    }

    /**
     * Overloaded assessment constructor, stores one additional field to hold trainer name
     *
     * @param weighRecord      is the weight recorded for this assessment
     * @param thighMeasurement is the thigh measurement recorded for this assessment
     * @param waistMeasurement is the waist measurement recorded for this assessment
     * @param comment          is the Trainer comment recorded for this assessment
     * @param trainer          is the name of the trainer who created the assessment
     */
    public Assessment(float weighRecord, float thighMeasurement, float waistMeasurement, String trainer, String comment) {
        this.weighRecord = weighRecord;
        this.thighMeasurement = thighMeasurement;
        this.waistMeasurement = waistMeasurement;
        this.comment = comment;
        this.trainer = trainer;
    }

    /**
     * weight recorded in this assessment
     * @return the weight recorded in this assessment
     */
    public float getWeighRecord() {
        return weighRecord;
    }

    /**
     * thigh measurement accessor
     * @return the thigh measurement for assessment
     */
    public float getThighMeasurement() {
        return thighMeasurement;
    }

    /**
     * waist Measurement accessor
     * @return the waist measurement for assessment
     */
    public float getWaistMeasurement() {
        return waistMeasurement;
    }

    /**
     * comment accessor for this assessment
     * @return the trainers comments on this assessment
     */
    public String getComment() {
        return comment;
    }

    /**
     * weight record mutator for this assessment
     * @param weighRecord
     */
    public void setWeight(float weighRecord) {
        this.weighRecord = weighRecord;
    }


    /**
     * thighMeasurement mutator for this assessment
     * @param thighMeasurement
     */
    public void setThighMeasurement(float thighMeasurement) {
        this.thighMeasurement = thighMeasurement;
    }

    /**
     * waistMeasurement mutator for this assessment
     * @param waistMeasurement
     */
    public void setWaistMeasurement(float waistMeasurement) {
        this.waistMeasurement = waistMeasurement;
    }

    /**
     * comment mutator for this assessment
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * The toString method
     * tostring contains Trainer creating assessment
     * weight recorded for assessment
     * thigh measurement for assessment
     * waist measurement for assessment
     *
     * @return String containing assessment data
     */
    public String toString() {
        return "Trainer: " + trainer + "\tComment: " + comment
                + "\n\tWeight Recording: " + weighRecord
                + "\tThigh Measurement: " + thighMeasurement
                + "\tWaist Measurement: " + waistMeasurement;
    }
}
