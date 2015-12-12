package edu.pdx.cs410J.jiancheng;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import java.util.ArrayList;

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
}
