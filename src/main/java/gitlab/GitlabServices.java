package gitlab;

import models.gitlab.Issue;
import retrofit2.http.*;
import retrofit2.Call;
import java.util.List;

interface GitlabServices {

    String BASE_URL = GitlabApi.BASE_URL;

    @POST(BASE_URL + GitlabApi.PROJECTS_SUFFIX)
    Call<Object> newProject( //TODO -> Model response object for this request
            @Query("name") String name,
            @Query("visibility") String visibility,
            @Query("initialize_with_readme") Boolean createReadme
    );

    @GET(BASE_URL + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getIssues();

    @GET(BASE_URL + GitlabApi.ISSUES_SUFFIX + GitlabApi.ID)
    Call<List<Issue>> getIssues(@Path("id") Integer projectId);

    @GET(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX + GitlabApi.ISSUE_IID)
    Call<Issue> getProjectIssue(@Path("id") Integer projectId, @Path("issue_iid") Integer issue_iid);

    @GET(BASE_URL + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getIssuesByAssignee(@Query("assignee_id") Integer assigneeId);

    @GET(BASE_URL + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getIssuesByAuthor(@Query("author_id") Integer authorId);

    @GET(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getProjectIssuesById(@Path("id") Integer projectId);

    @GET(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getProjectIssuesByAssignee(@Path("id") Integer projectId, @Query("assignee_id") Integer assigneeId);

    @GET(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getProjectIssuesByAuthor(@Path("id") Integer projectId, @Query("author_id") Integer authorId);

    @GET(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getProjectIssuesByLabels(@Path("id") Integer projectId, @Query("labels") List<String> labels);

    @GET(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getProjectIssuesByLabelsAndState(
            @Path("id") Integer projectId,
            @Query("labels") List<String> labels,
            @Query("state") String state
    );

    @GET(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getProjectIssuesByState(@Path("id") Integer projectId, @Query("state") String state);

    @GET(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<List<Issue>> getProjectIssuesByTitleOrDesc(@Path("id") Integer projectId, @Query("search") String keyword);


    @POST(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<Issue> newIssue(
            @Path("id") Integer projectId,
            @Query("title") String title
    );


    @POST(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<Issue> newIssue(
            @Path("id") Integer projectId,
            @Query("title") String title,
            @Query("description") String description
    );


    @POST(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<Issue> newIssue(
            @Path("id") Integer projectId,
            @Query("title") String title,
            @Query("description") String description,
            @Query("issue_type") String issue_type
    );

    @POST(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<Issue> newIssue(
            @Path("id") Integer projectId,
            @Query("title") String title,
            @Query("confidential") Boolean confidential,
            @Query("description") String description,
            @Query("labels") List<String> labels
    );

    @POST(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<Issue> newIssue(
            @Path("id") Integer projectId,
            @Query("title") String title,
            @Query("assignee_id") Integer assignee_id,
            @Query("confidential") Boolean confidential,
            @Query("description") String description,
            @Query("due_date") String due_date,
            @Query("labels") List<String> labels
    );


    @POST(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX)
    Call<Issue> newIssue(
            @Path("id") Integer projectId,
            @Query("assignee_id") Integer assignee_id,
            @Query("assignee_ids") Integer assignee_ids,
            @Query("confidential") Boolean confidential,
            @Query("created_at") String created_at,
            @Query("description") String description,
            @Query("discussion_to_resolve") String discussion_to_resolve,
            @Query("due_date") String due_date,
            @Query("epic_id") String epic_id,
            @Query("epic_iid") String epic_iid,
            @Query("iid") String iid,
            @Query("issue_type") String issue_type,
            @Query("labels") List<String> labels,
            @Query("merge_request_to_resolve_discussions_of") String merge_request_to_resolve_discussions_of,
            @Query("milestone_id") String milestone_id,
            @Query("weight") String weight
    );

    @PUT(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX + GitlabApi.ISSUE_IID)
    Call<List<Issue>> updateIssue(
            @Path("id") Integer projectId,
            @Path("issue_iid") Integer issue_iid,
            @Query("title") String title
    );

    @PUT(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX + GitlabApi.ISSUE_IID)
    Call<List<Issue>> updateIssue(
            @Path("id") Integer projectId,
            @Path("issue_iid") Integer issue_iid,
            @Query("title") String title,
            @Query("description") String description
    );

    @PUT(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX + GitlabApi.ISSUE_IID)
    Call<List<Issue>> updateIssue(
            @Path("id") Integer projectId,
            @Path("issue_iid") Integer issue_iid,
            @Query("title") String title,
            @Query("description") String description,
            @Query("confidential") Boolean confidential,
            @Query("issue_type") String issue_type
    );

    @PUT(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX + GitlabApi.ISSUE_IID)
    Call<List<Issue>> updateIssue(
            @Path("id") Integer projectId,
            @Path("issue_iid") Integer issue_iid,
            @Query("assignee_id") Integer assignee_id,
            @Query("confidential") Boolean confidential,
            @Query("description") String description,
            @Query("issue_type") String issue_type,
            @Query("due_date") String due_date,
            @Query("labels") String labels,
            @Query("title") String title
    );


    @PUT(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX + GitlabApi.ISSUE_IID)
    Call<List<Issue>> updateIssue(
            @Path("id") Integer projectId,
            @Path("issue_iid") Integer issue_iid,
            @Query("assignee_id") Integer assignee_id,
            @Query("confidential") Boolean confidential,
            @Query("created_at") String created_at,
            @Query("description") String description,
            @Query("discussion_to_resolve") String discussion_to_resolve,
            @Query("due_date") String due_date,
            @Query("epic_id") String epic_id,
            @Query("epic_iid") String epic_iid,
            @Query("iid") String iid,
            @Query("issue_type") String issue_type,
            @Query("labels") String labels,
            @Query("merge_request_to_resolve_discussions_of") String merge_request_to_resolve_discussions_of,
            @Query("milestone_id") String milestone_id,
            @Query("weight") String weight
    );

    @DELETE(BASE_URL + GitlabApi.PROJECTS_SUFFIX + GitlabApi.ID + GitlabApi.ISSUES_SUFFIX + GitlabApi.ISSUE_IID)
    Call<Object> deleteIssue(@Path("id") Integer projectId, @Path("issue_iid") Integer issue_iid);

    @POST(BASE_URL +
            GitlabApi.PROJECTS_SUFFIX +
            GitlabApi.ID +
            GitlabApi.ISSUES_SUFFIX +
            GitlabApi.ISSUE_IID +
            GitlabApi.CLONE_SUFFIX
    )
    Call<Object> cloneIssue(
            @Path("id") Integer projectId,
            @Path("issue_iid") Integer issue_iid,
            @Query("to_project_id") Integer to_project_id
    );
}
