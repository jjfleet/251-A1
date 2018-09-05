package nz.ac.massey.cs;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

// form with two fields for adding a task item

public class EntryForm extends Form<Void> {
	
	private RequiredTextField projectField;
    private RequiredTextField nameField;
    private RequiredTextField dueDateField;
    private RequiredTextField priorityField;


    public EntryForm(String id) {
        super(id);
        projectField = new RequiredTextField("project", Model.of(""));
        nameField = new RequiredTextField("name", Model.of(""));
        dueDateField = new RequiredTextField("dueDate", Model.of(""));
        priorityField = new RequiredTextField("priority", Model.of(""));
        
        add(projectField);
        add(priorityField);
        add(nameField);
        add(dueDateField);
    }

    // adds the task when the form is submitted (by clicking the Add button)
    protected void onSubmit() {
        super.onSubmit();
        String project = (String)projectField.getDefaultModelObject();
        String name = (String)nameField.getDefaultModelObject();
        String dueDate= (String)dueDateField.getDefaultModelObject();
        String priority = (String)priorityField.getDefaultModelObject();

        projectField.clearInput();
        projectField.setModelObject(null);
        nameField.clearInput();
        nameField.setModelObject(null);
        dueDateField.clearInput();
        dueDateField.setModelObject(null);
        priorityField.clearInput();
        priorityField.setModelObject(null);
        
        WicketApplication app = (WicketApplication) this.getApplication();
        TaskList collection = app.getTaskList();
        collection.addTask(new Task(name, priority, dueDate, project));

    }
}
