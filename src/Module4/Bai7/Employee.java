package Module4.Bai7;

public abstract class Employee {
    protected String firstName;
    protected String lastName;
    protected int ssn;

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        if(firstName.length() == 0 || firstName.equals(""))
            firstName = "Chưa xác định";
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        if(lastName.length() == 0 || lastName.equals(""))
            lastName = "Chưa xác định" ;
        this.lastName = lastName;
    }

    /**
     * @return int return the ssn
     */
    public int getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(int ssn) {
        if(ssn < 0)
            ssn = 0;
        this.ssn = ssn;
    }

    /**
     * @param firstName
     * @param lastName
     * @param ssn
     */
    public Employee(String firstName, String lastName, int ssn) {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
    }

    public abstract double tinhLuong();

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-10d ", firstName, lastName, ssn);
    }
}
