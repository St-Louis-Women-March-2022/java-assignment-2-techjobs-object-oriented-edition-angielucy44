package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public String toString() {
       String blankName = "Data not available";
       String blankEmployer = "Data not available";
       String blankLocation = "Data not available";
       String blankPositionType = "Data not available";
       String blankCoreCompetency = "Data not available";

        if(name != null && !name.equals("")) {
             blankName = name;
        }
        if(employer.getValue() != null && !employer.getValue().equals("")) {
            blankEmployer = employer.getValue();
        }
        if(location.getValue() != null && !location.getValue().equals("")) {
            blankLocation = location.getValue();
        }
        if(positionType.getValue() != null && !positionType.getValue().equals("")) {
           blankPositionType = positionType.getValue();
        }
        if(coreCompetency.getValue() != null && !coreCompetency.getValue().equals("")) {
            blankCoreCompetency = coreCompetency.getValue();
        }
        return  '\n' +
                "ID: " + id + '\n' +
                "Name: " + blankName + '\n' +
                "Employer: " + blankEmployer + '\n' +
                "Location: " + blankLocation + '\n' +
                "Position Type: " + blankPositionType + '\n' +
                "Core Competency: " + blankCoreCompetency +
                '\n';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
