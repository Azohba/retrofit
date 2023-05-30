package gitlab.enums;

public enum Project {

    GITLAB_ISSUES_DEMO(38971261),

    TEST_PROJECT_A1(38974508),

    ISSUES_API(38975978);

    final int projectId;

    Project(int projectId) {
        this.projectId = projectId;
    }

    public int id(){return projectId;}
}
