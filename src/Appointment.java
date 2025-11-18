/**
 * Represents a single appointment booking in the clinic system.
 * This class demonstrates Aggregation relationship by holding
 * references to a Patient object and a HealthProfessional object.
 */
public class Appointment {

    // --- Instance Variables (Attributes) ---

    // Reference to the Patient object involved in the appointment.
    private Patient patient;
    // The specific time slot reserved for the appointment.
    private String timeSlot;
    // Reference to the selected doctor. Stored as the abstract base class type.
    private HealthProfessional doctor;

    // --- Constructors ---

    /**
     * Default constructor. Initializes all fields to null or default values.
     */
    public Appointment() {
        this.patient = null;
        this.timeSlot = "00:00";
        this.doctor = null;
    }

    /**
     * Parameterized constructor used to initialize all instance variables upon creation.
     * @param patient The Patient object for the booking.
     * @param timeSlot The preferred appointment time.
     * @param doctor The HealthProfessional object associated with the booking.
     */
    public Appointment(Patient patient, String timeSlot, HealthProfessional doctor) {
        this.patient = patient;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    // --- Methods ---

    /**
     * Prints all detailed information related to this specific appointment.
     * It retrieves data from the aggregated Patient and Doctor objects.
     */
    public void printAppointmentDetails() {

        // 使用 Patient 对象获取信息
        String patientName = "N/A";
        String patientMobile = "N/A";
        String doctorType = "N/A";
        String doctorName = "N/A";

        // Check for null Patient object before accessing its getters.
        if (this.patient != null) {
            patientName = this.patient.getName();
            patientMobile = this.patient.getMobile();
        }

        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Phone Number: " + patientMobile);
        System.out.println("Appointment Time: " + this.timeSlot);

        // Check for null Doctor object.
        if (this.doctor != null) {
            //Obtain the doctor's name through the HealthProfessional interface.
            doctorName = this.doctor.getName();
            //Check if the Doctor object is an instance of GeneralPractitioner.
            if (this.doctor instanceof GeneralPractitioner) {
                doctorType = "General Practitioner";
                //Check if the Doctor object is an instance of Cardiologist.
            } else if (this.doctor instanceof Cardiologist) {
                doctorType = "Cardiologist";
            } else {
                doctorType = "Unknown Health Professional";
            }
        }

        System.out.println("Doctor Name: " + doctorName);
        System.out.println("Doctor Type: " + doctorType);
    }

    /**
     * Getter for the patient's mobile number.
     * This method is essential as it is used by the 'cancelBooking' logic in the main class.
     * It delegates the request to the aggregated Patient object (Encapsulation).
     * @return The patient's mobile number.
     */
    public String getPatientMobile() {
        return patient.getMobile();
    }

}