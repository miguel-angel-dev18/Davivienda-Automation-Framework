package co.com.davivienda.automation.models;

public class ProfileData
{
    private final String profileName;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String employeeId;

    public ProfileData(String profileName,String firstName, String middleName, String lastName,String employeeId)
    {
        this.profileName=profileName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName= lastName;
        this.employeeId=employeeId;
    }

    // Getters
    public String getProfileName() { return profileName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getEmployeeId() { return employeeId; }
}