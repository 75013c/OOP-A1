import java.util.ArrayList;
import java.util.Iterator;


/**
 * @class AssignmentOne
 * @brief The main execution class of the clinic appointment management system.
 * * This class handles the initialization of doctor data, storage of appointments,
 * and implements core business logic like printing doctor info, creating,
 * printing, and cancelling appointments. Note: All logic is static and
 * centralised here.
 */
public class AssignmentOne {
    // Create collection to store doctors information for easy lookup.
    private static ArrayList<HealthProfessional> doctorList = new ArrayList<>();
    // Create ArrayList to store Appointment objects
    private static ArrayList<Appointment> appointmentsList = new ArrayList<>();
    // Constant formats for printing table headers
    private static final String BASE_HEADER_FORMAT = "%-5s%-15s%-5s%-25s";
    private static final String GP_HEADER_FORMAT = "%-25s%-15s%n";
    private static final String CD_HEADER_FORMAT = "%-25s%-15s%n";


    /**
     * @brief Prints the detailed information of all health professionals stored
     * in the doctorList, categorised by their specific professional type.
     * * Uses polymorphism and specific header formats for General Practitioners (GP)
     * and Cardiologists (CD).
     */
    public static void printDoctorsInfo() {
        System.out.println("Show Information of All Health Professionals\n");

        // Prepare and print GP header
        String baseHeader = String.format(BASE_HEADER_FORMAT, "ID", "Name", "Age", "Profession");
        String gpHeader = String.format(GP_HEADER_FORMAT, "Max Consultation Time", "Bulk Billing Available");
        System.out.println("General Practitioners");
        System.out.print(baseHeader + gpHeader);

        // Iterate through the list and print details for General Practitioners
        for (HealthProfessional doctor : doctorList) {
            if (doctor instanceof GeneralPractitioner) {
                doctor.printProfessionalDetails();
            }
        }

        // Prepare and print Cardiologist header
        String cdHeader = String.format(CD_HEADER_FORMAT, "Subspecialty", "Cath Lab Access");
        System.out.println("\nCardiologist");
        System.out.print(baseHeader + cdHeader);

        // Iterate through the list and print details for Cardiologists
        for (HealthProfessional doctor : doctorList) {
            if (doctor instanceof Cardiologist) {
                doctor.printProfessionalDetails();
            }
        }
    }


    /**
     * @brief Creates a new Appointment object and adds it to the appointmentsList.
     * @param doctorId The ID of the selected doctor.
     * @param pName Patient's name.
     * @param pMobile Patient's mobile number.
     * @param time Preferred appointment time slot.
     */
    public static void createAppointment(int doctorId, String pName, String pMobile, String time) {

        HealthProfessional selectedDoctor = null;

        // Search for the doctor by ID
        for (HealthProfessional doctor : doctorList) {
            if (doctor.getId() == doctorId) {
                selectedDoctor = doctor;
                break;
            }
        }

        // Basic validation: Check if doctor was found
        if (selectedDoctor == null) {
            System.out.println("Appointment Failed: Invalid doctor ID");
            return;
        }

        // Basic validation: Check for null/empty patient name
        if (pName == null || pName.trim().isEmpty()) {
            System.out.println("Appointment Failed: Patient name cannot be empty");
            return;
        }

        // Basic validation: Check for null/empty patient phone number
        if (pMobile == null || pMobile.trim().isEmpty()) {
            System.out.println("Appointment Failed: Phone number cannot be empty");
            return;
        }

        // Basic validation: Check for null/empty appointment time
        if (time == null || time.trim().isEmpty()) {
            System.out.println("Appointment Failed: Appointment time cannot be empty");
            return;
        }

        // Create the patient and appointment objects
        Patient patient = new Patient(pName, pMobile);
        Appointment newAppointment = new Appointment(patient, time, selectedDoctor);
        appointmentsList.add(newAppointment);

        // Print success message
        System.out.println("Appointment Successfully Created!");
        System.out.println("Patient: " + pName + "  |  Doctor: " + selectedDoctor.getName() + "  |  Time: " + time + "\n");
    }


    /**
     * @brief Displays the details of all existing appointments in the list.
     */
    public static void printExistingAppointments() {
        if (appointmentsList.isEmpty()) {
            System.out.println("\nNo Available Appointment");
            return;
        }

        System.out.println("\nDisplay Appointment List ( Total " + appointmentsList.size() + " )");
        System.out.println("------------------------------------");

        // Iterate through the list using an index to display appointment number.
        for (int i = 0; i < appointmentsList.size(); i++) {
            System.out.println("Appointment #" + (i + 1) + "\n");

            // Delegates the printing of internal details to the Appointment object.
            appointmentsList.get(i).printAppointmentDetails();
            System.out.println("------------------------------------");
        }
    }


    /**
     * Cancels an appointment based on the patient's mobile number.
     * Uses an Iterator for safe removal while traversing the collection.
     * * @param mobileNumber The mobile number of the patient whose booking should be cancelled.
     */
    public static void cancelBooking(String mobileNumber) {

        // Basic validation: Check for empty mobile number input.
        if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
            System.out.println("ERROR: Phone number cannot be empty");
            return;
        }

        // Use Iterator for safe modification (removal) of the collection during traversal.
        Iterator<Appointment> iterator = appointmentsList.iterator();
        boolean foundAndCancelled = false;

        while (iterator.hasNext()) {
            Appointment appt = iterator.next();
            // Get phone number of the patient from Appointment object
            if (appt.getPatientMobile().equals(mobileNumber)) {
                // Safely removes the current element from the list.
                iterator.remove();
                foundAndCancelled = true;
                System.out.println("Successfully cancelled the appointment of patient with phone number " + mobileNumber);
                break;
            }
        }

        if (!foundAndCancelled) {
            System.out.println("ERROR: Phone number " + mobileNumber + " did not found in existing appointment");
        }
    }


    /**
     * Main method: The entry point of the program.
     * Responsible for data initialization and demonstrating core functionalities.
     */
    public static void main(String[] args) {

        // Part 3 – Using classes and objects
        // Initialization: Create and add Health Professionals to Array list
        doctorList.add(new GeneralPractitioner(1, "Alice Smith", 35, "General Practitioner", 15, true));
        doctorList.add(new GeneralPractitioner(2, "Bob Johnson", 47, "General Practitioner", 20, false));
        doctorList.add(new GeneralPractitioner(3, "Clara Lee", 25, "General Practitioner", 15, true));

        doctorList.add(new Cardiologist(4, "Carol Dan", 30, "Cardiologist", "Electrophysiology", true));
        doctorList.add(new Cardiologist(5, "Peter Quill", 55, "Cardiologist", "Vascular Medicine", true));

        // Demonstration of printing doctor information
        printDoctorsInfo();
        System.out.println("------------------------------");

        // Part 5 – Collection of appointments
        // Demonstration of creating appointments.
        createAppointment(2, "YuZt", "18466209754", "09:30");
        createAppointment(1, "DengSy", "12356786093", "14:20");

        createAppointment(4, "LiTz", "16587398765", "16:15");
        createAppointment(5, "LiuHy", "12409567734", "10:00");

        // Demonstration of printing existing appointments.
        printExistingAppointments();

        // Demonstration of cancelling an appointment.
        cancelBooking("18466209754");

        // Demonstration of printing the updated list after cancellation.
        printExistingAppointments();

        System.out.println("------------------------------");
    }
}