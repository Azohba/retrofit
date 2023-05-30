package steps;

import context.ContextStore;
import gitlab.Gitlab;
import gitlab.enums.Project;
import gitlab.enums.Visibility;
import io.cucumber.java.en.Given;
import models.gitlab.Issue;
import tests.IssueTests;
import utils.Printer;

public class IssuesSteps {

    Printer log = new Printer(IssuesSteps.class);
    IssueTests issueTests = new IssueTests();
    Gitlab gitlab = new Gitlab();

    @Given("Print all the issues")
    public void printIssues(){
        for (Issue issue:gitlab.getIssues()) {
            log.new Info("Reservation title: " + issue.title());
        }
    }

    @Given("Create issue for project {}")
    public void createIssue(Project project){
        gitlab.createIssue(project.id());
    }

    @Given("Print issue number {} in project {}")
    public void printProjectIssue(Integer issueId, Project project){
        gitlab.getProjectIssue(project, issueId);
    }

    @Given("Create new {} project named {} with readme")
    public void createProject(Visibility visibility, String projectName){
        gitlab.createProject(projectName, visibility, true);
    }

    @Given("Create new {} project named {} without readme")
    public void createProjectNoReadme(Visibility visibility, String projectName){
        gitlab.createProject(projectName, visibility, false);
    }

    @Given("Perform an issue creation test on project {}")
    public void issueCreationTest(Project project){
        issueTests.issueCreationTest(project);
    }

    @Given("Delete last issue created")
    public void deleteLastIssue(){
        Issue issue = (Issue) ContextStore.get("issueInContext");
        gitlab.deleteIssue(issue.project_id(), issue.iid());
    }
}
