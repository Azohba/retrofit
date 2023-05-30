package tests;

import common.Utilities;
import context.ContextStore;
import gitlab.Gitlab;
import gitlab.enums.Person;
import gitlab.enums.Project;
import models.commons.DateModel;
import models.gitlab.Issue;
import org.junit.Assert;
import utils.Printer;
import utils.StringUtilities;

import java.util.Calendar;
import java.util.List;

public class IssueTests extends Utilities {

    Printer log = new Printer(IssueTests.class);
    StringUtilities strUtils = new StringUtilities();
    Gitlab gitlab = new Gitlab();
    public void issueCreationTest(Project project){ // This method tests issue creation for a given project

        Calendar present = Calendar.getInstance(); // Acquire present date
        DateModel today = new DateModel(present); // Format date

        Person assignee = Person.UMUT;
        String title = strUtils.generateRandomString("Automated Issue #", 5,true, true);
        String description = "This is an automated issue";
        Boolean confidential = false;
        String dueDate = today.date();
        List<String> labels = List.of("TEST");

        //Let's create our test issue
        Issue issue = gitlab.createIssue(project.id(), title, assignee.id(), confidential, description, dueDate, labels);

        Assert.assertEquals("The Assignee ID's do not match!", assignee.id(), issue.assignee().id());
        Assert.assertEquals("The titles do not match!", title, issue.title());
        Assert.assertEquals("The descriptions do not match!", description, issue.description());
        Assert.assertEquals("The dueDates do not match!", dueDate, issue.due_date());
        Assert.assertEquals("The labels do not match!", labels, issue.labels());

        log.new Success("Issue creation verifications complete.");

        ContextStore.put("issueInContext", issue);
    }
}
