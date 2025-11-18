/**
 * Represents a patient who schedules an appointment in the system.
 * This class primarily serves as a simple data holder.
 * The use of 'final' for instance variables ensures that Patient objects
 * are immutable after creation, enhancing data integrity.
 */
public class Patient {

    // --- Instance Variables (Attributes) ---

    // The patient's full name. Declared as final.
    private final String name;
    // The patient's mobile phone number, often used for identifying and cancelling appointments. Declared as final.
    private final String mobile;

    // --- Constructor ---

    /**
     * Parameterized constructor used to create and initialize a Patient object.
     * @param name The patient's name.
     * @param mobile The patient's mobile phone number.
     */
    public Patient(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    // --- Getters (Encapsulation) ---

    /**
     * Getter for the patient's name.
     * @return The patient's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the patient's mobile phone number.
     * This getter is crucial for methods like 'cancelBooking' in the main application.
     * @return The patient's mobile number.
     */
    public String getMobile() {
        return mobile;
    }
}