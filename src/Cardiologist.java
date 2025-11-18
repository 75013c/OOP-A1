/**
 * This class extends HealthProfessional, inheriting common attributes
 * and adding specialized properties and behaviors specific to a Cardiology specialist.
 * This demonstrates the principle of Inheritance.
 */
public class Cardiologist extends HealthProfessional {
    // --- Instance Variables (Cardiologist Specific) ---

    // The specific area of focus within cardiology.
    private String subspecialty;
    // Flag indicating whether the cardiologist has access to a Cath Lab.
    private boolean hasCathLabAccess;

    /**
     * Default constructor. Calls the default constructor of the superclass
     * and initializes Cardiologist-specific variables to default values.
     */
    public Cardiologist() {
        super(); // Call default constructor of HealthProfessional
        this.subspecialty = "Unknown";
        this.hasCathLabAccess = true;
    }

    /**
     * Parameterized constructor to initialize all instance variables.
     * Delegates base property initialization to the superclass constructor.
     * @param id The unique ID of the professional.
     * @param name The name of the professional.
     * @param age The age of the professional.
     * @param profession The job title/profession (passed to super).
     * @param subspecialty The specific subspecialty area.
     * @param hasCathLabAccess Flag indicating Cath Lab access.
     */
    public Cardiologist(int id, String name, int age, String profession, String subspecialty, boolean hasCathLabAccess) {
        super(id, name, age, profession); // Call parameterized constructor of HealthProfessional
        this.subspecialty = subspecialty;
        this.hasCathLabAccess = hasCathLabAccess;
    }

    // --- Methods ---

    /**
     * Implements the abstract method from HealthProfessional.
     * Prints the complete details of the Cardiologist:
     * Base details from superclass followed by Cardiology-specific details.
     */
    @Override
    public void printProfessionalDetails() {
        // Retrieve the formatted base information string from the superclass.
        String baseDetails = super.printBaseDetails();

        // Define the format for the Cardiologist-specific fields.
        // This format aligns with the CD_HEADER_FORMAT in the main class.
        final String CD_INFO_FORMAT = "%-25s%-5s%n";

        // Format the specific fields (Subspecialty and Cath Lab Access status).
        // Uses a ternary operator to convert the boolean 'hasCathLabAccess' to "Yes" or "No".
        String cardioDetails = String.format(CD_INFO_FORMAT,
                this.subspecialty,
                this.hasCathLabAccess ? "Yes" : "No");

        System.out.print(baseDetails + cardioDetails);
    }

    // --- Getters (Encapsulation) ---

    /**
     * Getter for the cardiologist's subspecialty.
     * @return The subspecialty string.
     */
    public String getSubspecialty() {
        return subspecialty;
    }

    /**
     * Getter for the Cath Lab access status.
     * @return True if Cath Lab access is available, false otherwise.
     */
    public boolean hasCathLabAccess() {
        return hasCathLabAccess;
    }
}