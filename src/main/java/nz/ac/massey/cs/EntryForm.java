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


    public EntryForm(String id) {
        super(id);
        projectField = new RequiredTextField("project", Model.of(""));
        nameField = new RequiredTextField("name", Model.of(""));
        dueDateField = new RequiredTextField("dueDate", Model.of(""));
        
        add(projectField);
        add(nameField);
        add(dueDateField);
    }

    // adds the task when the form is submitted (by clicking the Add button)
    protected void onSubmit() {
        super.onSubmit();
        String project = (String)projectField.getDefaultModelObject();
        String name = (String)nameField.getDefaultModelObject();
        String dueDate= (String)dueDateField.getDefaultModelObject();

        projectField.clearInput();
        projectField.setModelObject(null);
        nameField.clearInput();
        nameField.setModelObject(null);
        dueDateField.clearInput();
        dueDateField.setModelObject(null);
        
        WicketApplication app = (WicketApplication) this.getApplication();
        TaskList collection = app.getTaskList();
        collection.addTask(new Task(name, dueDate, project));

    }
}
