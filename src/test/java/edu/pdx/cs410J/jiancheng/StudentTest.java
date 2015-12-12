package edu.pdx.cs410J.jiancheng;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/**
 * JUnit tests for the Student class.  These tests extend <code>InvokeMainTestCase</code>
 * which allows them to easily invoke the <code>main</code> method of <code>Student</code>.
 * They also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>matchers
 * for more readable assertion statements.
 */
public class StudentTest extends InvokeMainTestCase
{

    @Test
    public void NoArgumentsHasExitCodeOf1() {
        MainMethodResult result = invokeMain(Student.class);
        assertThat(result.getExitCode(), equalTo(1));
    }

    @Test
    public void NoArgumentsPrintsMissingArgumentsToStandardError() {
        MainMethodResult result = invokeMain(Student.class);
        assertThat(result.getErr(), containsString("Missing command line arguments"));
    }

    @Test
    public void onlyOneArgumentPrintsMissingGenderToStandardErrot() {
        MainMethodResult result = invokeMain(Student.class, "Dave");
        assertThat(result.getErr(), containsString("Missing gender"));
        assertThat(result.getExitCode(), equalTo(1));

    }

    @Test
    public void allStudentsSayThisClassIsTooMuchWork() {
        Student student = new Student("name", new ArrayList(), 1.23, "male");
        assertThat(student.says(), equalTo("This class is too much work"));
    }

    @Test
    public void studentNamedDaveHasNameOfDave() {
        Student dave = getStudent("Dave");

        assertThat(dave.toString(), startsWith("Dave"));
    }

    @Test
    public void studentNamedFrankHasNameOfFrank() {
        Student frank = getStudent("Frank");

        assertThat(frank.toString(), startsWith("Frank"));
    }
    private Student getStudent(String name) {
        ArrayList classes = new ArrayList();
        classes.add("Algorithm");
        classes.add("Operating Systems");
        classes.add("Java");
        return new Student(name, classes, 3.64, "male");
    }


    @Ignore
    @Test
    public void studentToStringOfDavemale3_64AlgorithmsOperatingSystemsJava() {
        Student dave = getStudent("Dave");

        assertThat(dave.toString(), equalTo("Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating Systems, and Java.  He says \"This class is too much work\"."));
    }
}
