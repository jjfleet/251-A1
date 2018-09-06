package nz.ac.massey.cs;

import java.io.Serializable;
import java.util.Date;

// This class models a Task item

public class Task implements Serializable {
	
	private String project;
    private String dueDate;
    private boolean completed;
    private String name;
    private Integer id;
    private Date date;

    private String priority;

    public Task(String name, String priority, String dueDate, String project) {
    	this.project = project;
        this.name = name;
        this.dueDate = dueDate;
        // completed originally set to 'false' - have changed it here for testing
        this.completed = false;
        this.priority = priority;
    }
    
    public boolean isComplete() {
        return completed;
    }
    
    public String getPriority() {
    	return priority;
    }
    
    public void setComplete(boolean complete) { 
    	completed = complete; 
	}
}
