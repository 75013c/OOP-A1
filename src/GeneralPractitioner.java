/**
 * This class extends HealthProfessional, inheriting common attributes
 * and adding specialized properties and behaviors specific to a General Practitioner.
 */
public class GeneralPractitioner extends HealthProfessional {

    // --- Instance Variables ---

    // The maximum length (in minutes) allowed for a consultation.
    private int maxConsultationTime;
    // Flag indicating whether the GP offers bulk billing services.
    private boolean bulkBilling;

    // --- Constructors ---

    /**
     * Default constructor. Calls the default constructor of the superclass
     * and initializes GP-specific variables to default values.
     */
    public GeneralPractitioner() {
        super(); // Call default constructor of HealthProfessional
        this.maxConsultationTime = 0;
        this.bulkBilling = true;
    }

    /**
     * Parameterized constructor to initialize all instance variables.
     * Delegates base property initialization to the superclass constructor.
     * * @param id The unique ID of the professional.
     * @param name The name of the professional.
     * @param age The age of the professional.
     * @param profession The job title/profession (passed to super).
     * @param maxConsultationTime The maximum time for a consultation (in minutes).
     * @param bulkBilling Flag indicating bulk billing availability.
     */
    public GeneralPractitioner(int id, String name, int age, String profession, int maxConsultationTime, boolean bulkBilling) {
        super(id, name, age, profession); // Call parameterized constructor of HealthProfessional
        this.maxConsultationTime = maxConsultationTime;
        this.bulkBilling = bulkBilling;
    }

    // --- Methods ---

    /**
     * Implements the abstract method from HealthProfessional.
     * Prints the complete details of the General Practitioner:
     * Base details from superclass followed by GP-specific details.
     */
    @Override
    public void printProfessionalDetails() {
        // Get the formatted base information string from the superclass.
        String baseDetails = super.printBaseDetails();

        // Define the format for the GP-specific fields.
        // This format aligns with the GP_HEADER_FORMAT in the main class.
        final String GP_INFO_FORMAT = "%-25d%-5s%n";

        // Format the specific fields (Max Consult Time and Bulk Billing status).
        // Uses a ternary operator to convert the boolean 'bulkBilling' to "Yes" or "No".
        String gpDetails = String.format(GP_INFO_FORMAT,
                this.maxConsultationTime,
                this.bulkBilling ? "Yes" : "No");

        System.out.print(baseDetails + gpDetails);
    }

    // --- Getters (Encapsulation) ---

    /**
     * Getter for the maximum consultation time.
     * @return The maximum consultation time in minutes.
     */
    public int getMaxConsultationTime() {
        return maxConsultationTime;
    }

    /**
     * Getter for the bulk billing status.
     * @return True if bulk billing is available, false otherwise.
     */
    public boolean isBulkBilling() {
        return bulkBilling;
    }
}
