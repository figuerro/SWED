public class Developer {
    private String name;
    private int employeeId;
    private String programmingLanguage;
    private int yearsOfExperience;
    private boolean isCertified;

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name darf nicht leer sein.");
        this.name = name;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId <= 0) throw new IllegalArgumentException("ID muss positiv sein.");
        this.employeeId = employeeId;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        if (programmingLanguage == null || programmingLanguage.isEmpty())
            throw new IllegalArgumentException("Programmiersprache darf nicht leer sein.");
        this.programmingLanguage = programmingLanguage;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) throw new IllegalArgumentException("Erfahrung darf nicht negativ sein.");
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setCertified(boolean isCertified) {
        this.isCertified = isCertified;
    }
}
