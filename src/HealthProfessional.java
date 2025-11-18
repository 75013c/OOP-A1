/**
 * Represents the abstract base class for all health professionals in the system.
 * This class establishes common properties and methods shared by all specialists
 * (e.g., General Practitioners, Cardiologists), enforcing a consistent structure
 * through inheritance and polymorphism.
 */
public abstract class HealthProfessional {
    // A unique identifier for the health professional. It's recommended to make this 'final'
    // to ensure the ID cannot be changed after the object is created (Encapsulation/Immutability).
    private  int id;
    private  String name;
    private int age;
    private  String profession;

    // --- Constructors ---

    /**
     * Default constructor. Initializes attributes with default/placeholder values.
     * Used when specific data is not immediately available.
     */
    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.age = 0;
        this.profession = "Unknown";
    }

    /**
     * Parameterized constructor. Used to initialize all instance variables upon creation.
     * This is the primary constructor used by subclasses when calling 'super()'.
     * * @param id The unique ID of the professional.
     * @param name The name of the professional.
     * @param age The age of the professional.
     * @param profession The job title/profession.
     */
    public HealthProfessional(int id, String name, int age, String profession) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    // --- Utility Method ---

    /**
     * Formats the base details (ID, Name, Age, Profession) into a fixed-width string.
     * This method is reusable by all subclasses to maintain consistent reporting format
     * for the common information.
     * * @return A formatted string containing the base professional details.
     */
    public String printBaseDetails() {
        // Defines the format string with fixed widths for each base field.
        final String BASE_INFO_FORMAT = "%-5d%-15s%-5d%-25s";
        return String.format(BASE_INFO_FORMAT,
                this.id,
                this.name,
                this.age,
                this.profession);
    }

    // --- Getters ---

    /**
     * Getter for the professional's ID.
     * @return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the professional's name.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the professional's age.
     * @return The age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for the professional's profession title.
     * @return The profession.
     */
    public String getProfession() {
        return  profession;
    }

    // --- Abstract Method ---

    /**
     * Abstract method that must be implemented (overridden) by every concrete subclass.
     * This method is responsible for printing the specialized details unique to each profession.
     * By being abstract, it enforces that all health professionals must define how their
     * specialized data is displayed.
     */
    public abstract void printProfessionalDetails();
}