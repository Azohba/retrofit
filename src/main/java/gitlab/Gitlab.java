package gitlab;

import api_assured.*;
import gitlab.enums.Project;
import gitlab.enums.Visibility;
import models.gitlab.Issue;
import okhttp3.Headers;
import retrofit2.Call;
import java.util.List;

public class Gitlab extends ApiUtilities {

    GitlabServices gitlabServices = new ServiceGenerator(
            new Headers.Builder().add("PRIVATE-TOKEN", properties.getProperty("gitlab-token")).build()
    ).generate(GitlabServices.class);

    public List<Issue> getIssues(){
        Call<List<Issue>> issues = gitlabServices.getIssues();
        return perform(issues, true, true, "getIssues");
    }

    public List<Issue> getIssuesByAuthor(Integer authorId){
        Call<List<Issue>> issues = gitlabServices.getIssuesByAuthor(authorId);
        return perform(issues, true, true, "getIssuesByAuthor");
    }

    public List<Issue> getIssuesByAssignee(Integer assigneeId){
        Call<List<Issue>> issues = gitlabServices.getIssuesByAssignee(assigneeId);
        return perform(issues, true, true, "getIssuesByAssignee");
    }

    public Issue getProjectIssue(Project project, Integer issueId){
        Call<Issue> issue = gitlabServices.getProjectIssue(project.id(), issueId);
        return perform(issue, true, true, "getProjectIssue");
    }

    public List<Issue> getIssuesInProject(Project project){
        Call<List<Issue>> issue = gitlabServices.getIssues(project.id());
        return perform(issue, true, true, "getIssues");
    }

    public Issue createIssue(Integer projectId){
        Call<Issue> issues = gitlabServices.newIssue(projectId, "TestIssue-"+numUtils.randomNumber(0,10000));
        return perform(issues, true, true, "getIssues");
    }

    public Issue createIssue(
            Integer projectId,
            String title,
            Integer assignee_id,
            Boolean confidential,
            String description,
            String due_date,
            List<String> labels
    ){
        Call<Issue> issues = gitlabServices.newIssue(projectId, title, assignee_id, confidential, description, due_date, labels);
        return perform(issues, true, true, "getIssues");
    }

    public Object createProject(String projectName, Visibility visibility, Boolean hasReadme){
        projectName += strUtils.generateRandomString(projectName, 5, false, true);
        Call<Object> create = gitlabServices.newProject(projectName, visibility.name().toLowerCase(), hasReadme);
        return perform(create, true, true, "newProject");
    }


    public Object deleteIssue(Integer projectId, Integer issueIid){
        Call<Object> delete = gitlabServices.deleteIssue(projectId, issueIid);
        return perform(delete, true, true, "deleteIssue");
    }
}
