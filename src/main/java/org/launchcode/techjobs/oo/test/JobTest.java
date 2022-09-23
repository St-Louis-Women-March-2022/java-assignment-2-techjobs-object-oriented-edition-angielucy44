package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)

public class JobTest {

    @Before
    public void createJobObjects() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();

        assertFalse(emptyJob1.equals(emptyJob2));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertEquals(testJob.getName(), "Product tester");

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().getValue(), "ACME");
//
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().getValue(), "Desert");
//
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
//
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job testJob3 = new Job("Product Tester", new Employer("Google"), new Location("Mountains"), new PositionType("Analyst"), new CoreCompetency("Ethics"));
        Job testJob4 = new Job("Product Tester", new Employer("Google"), new Location("Mountains"), new PositionType("Analyst"), new CoreCompetency("Ethics"));

        assertFalse(testJob3.equals(testJob4));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob3 = new Job("Product Tester", new Employer("Google"), new Location("Mountains"), new PositionType("Analyst"), new CoreCompetency("Ethics"));
        int lastIndex = (testJob3.toString().length() - 1);

        assertEquals('\n', (testJob3.toString().charAt(0)));
        assertEquals('\n', (testJob3.toString().charAt(lastIndex)));
//        assertEquals(testJob3.toString(),"LaunchCode");
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob3 = new Job("Product Tester",
                new Employer("Google"),
                new Location("Mountains"),
                new PositionType("Analyst"),
                new CoreCompetency("Ethics"));

        String[] lines = testJob3.toString().trim().split("\n");

        System.out.println(testJob3.toString());

        assertTrue(lines[0].startsWith("ID: "));
        assertTrue(lines[1].startsWith("Name: "));
        assertTrue(lines[2].startsWith("Employer: "));
        assertTrue(lines[3].startsWith("Location: "));
        assertTrue(lines[4].startsWith("Position Type: "));
        assertTrue(lines[5].startsWith("Core Competency: "));

        assertTrue(lines[0].endsWith(Integer.toString(testJob3.getId())));
        assertTrue(lines[1].endsWith(testJob3.getName()));
        assertTrue(lines[2].endsWith(testJob3.getEmployer().toString()));
        assertTrue(lines[3].endsWith(testJob3.getLocation().toString()));
        assertTrue(lines[4].endsWith(testJob3.getPositionType().toString()));
        assertTrue(lines[5].endsWith(testJob3.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob3 = new Job("Product Tester",
                new Employer(""),
                new Location("Mountains"),
                new PositionType("Analyst"),
                new CoreCompetency(""));

        assertEquals("\nID: " + testJob3.getId() + "\nName: Product Tester\nEmployer: Data Not Available\nLocation: Mountains\nPosition Type: Analyst\nCore Competency: Data Not Available\n", testJob3.toString());



    }
}
