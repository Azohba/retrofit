package models.gitlab;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Issue {
    String state;
    String description;
    Person author;
    Milestone milestone;
    Integer project_id;
    List<Person> assignees;
    Person assignee;
    String type;
    String updated_at;
    String closed_at;
    String closed_by;
    Integer id;
    String title;
    String created_at;
    String moved_to_id;
    Integer iid;
    List<String> labels;
    Integer upvotes;
    Integer downvotes;
    Integer merge_requests_count;
    Integer user_notes_count;
    String due_date;
    String web_url;
    References references;
    TimeStats time_stats;
    Boolean has_tasks;
    String task_status;
    Boolean confidential;
    Boolean discussion_locked;
    String issue_type;
    String severity;
    Links _links;
    TaskCompletionStatus task_completion_status;
    String service_desk_reply_to;


    public String state() {
        return state;
    }

    public String description() {
        return description;
    }

    public Person author() {
        return author;
    }

    public Milestone milestone() {
        return milestone;
    }

    public Integer project_id() {
        return project_id;
    }

    public List<Person> assignees() {
        return assignees;
    }

    public Person assignee() {
        return assignee;
    }

    public String type() {
        return type;
    }

    public String updated_at() {
        return updated_at;
    }

    public String closed_at() {
        return closed_at;
    }

    public String closed_by() {
        return closed_by;
    }

    public Integer id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String created_at() {
        return created_at;
    }

    public String moved_to_id() {
        return moved_to_id;
    }

    public Integer iid() {
        return iid;
    }

    public List<String> labels() {
        return labels;
    }

    public Integer upvotes() {
        return upvotes;
    }

    public Integer downvotes() {
        return downvotes;
    }

    public Integer merge_requests_count() {
        return merge_requests_count;
    }

    public Integer user_notes_count() {
        return user_notes_count;
    }

    public String due_date() {
        return due_date;
    }

    public String web_url() {
        return web_url;
    }

    public References references() {
        return references;
    }

    public TimeStats time_stats() {
        return time_stats;
    }

    public Boolean has_tasks() {
        return has_tasks;
    }

    public String task_status() {
        return task_status;
    }

    public Boolean confidential() {
        return confidential;
    }

    public Boolean discussion_locked() {
        return discussion_locked;
    }

    public String issue_type() {
        return issue_type;
    }

    public String severity() {
        return severity;
    }

    public Links _links() {
        return _links;
    }

    public TaskCompletionStatus task_completion_status() {
        return task_completion_status;
    }

    public static class Person {
        String state;
        Integer id;
        String web_url;
        String name;
        String avatar_url;
        String username;

        public String state() {
            return state;
        }

        public int id() {
            return id;
        }

        public String web_url() {
            return web_url;
        }

        public String name() {
            return name;
        }

        public String avatar_url() {
            return avatar_url;
        }

        public String username() {
            return username;
        }
    }

    public static class Milestone {
        Integer project_id;
        String description;
        String state;
        String due_date;
        Integer iid;
        String created_at;
        String title;
        Integer id;
        String updated_at;

        public Integer project_id() {
            return project_id;
        }

        public String description() {
            return description;
        }

        public String state() {
            return state;
        }

        public String due_date() {
            return due_date;
        }

        public Integer iid() {
            return iid;
        }

        public String created_at() {
            return created_at;
        }

        public String title() {
            return title;
        }

        public Integer id() {
            return id;
        }

        public String updated_at() {
            return updated_at;
        }
    }

    public static class References {

        @JsonProperty("short")
        String _short;
        String relative;
        String full;

        public String _short() {
            return _short;
        }

        public String relative() {
            return relative;
        }

        public String full() {
            return full;
        }
    }

    public static class TimeStats {
        Integer time_estimate;
        Integer total_time_spent;
        Integer human_time_estimate;
        Integer human_total_time_spent;

        public Integer time_estimate() {
            return time_estimate;
        }

        public Integer total_time_spent() {
            return total_time_spent;
        }

        public Integer human_time_estimate() {
            return human_time_estimate;
        }

        public Integer human_total_time_spent() {
            return human_total_time_spent;
        }
    }

    public static class Links {
        String self;
        String notes;
        String award_emoji;
        String project;
        String closed_as_duplicate_of;

        public String self() {
            return self;
        }

        public String notes() {
            return notes;
        }

        public String award_emoji() {
            return award_emoji;
        }

        public String project() {
            return project;
        }

        public String closed_as_duplicate_of() {
            return closed_as_duplicate_of;
        }
    }

    public static class TaskCompletionStatus {
        Integer count;
        Integer completed_count;

        public Integer count() {
            return count;
        }

        public Integer completed_count() {
            return completed_count;
        }
    }
}
