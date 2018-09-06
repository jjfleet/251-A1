package nz.ac.massey.cs;

import org.apache.wicket.Component;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.ResourceReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.io.*;

public class TasksPage extends WebPage {

	private static final long serialVersionUID = 1L;


	public TasksPage() {

        add(new EntryForm("entryForm"));

        Form listForm = new Form("listForm");

        add(listForm);

		Date now = new Date();
		Label dateTimeLabel = new Label("datetime", now.toString());
		add(dateTimeLabel);

		WicketApplication app = (WicketApplication) this.getApplication();
		TaskList collection = app.getTaskList();
		List<Task> tasks = collection.getTasks();
		List<Task> temp = new LinkedList<Task>();		//temp list for holding data that isn't being viewed.
		List<Task> deleted = new LinkedList<Task>();	//temp list for holding data to be deleted

		
		Label countLabel = new Label("hiCount", new PropertyModel(collection, "HighCount"));
		add(countLabel);
		
		Label countLabelLow = new Label("loCount", new PropertyModel(collection, "LowCount"));
		add(countLabelLow);
		
		Label countLabelActive = new Label("activeCount", new PropertyModel(collection, "ActiveCount"));
		add(countLabelActive);

		
		@SuppressWarnings("unchecked")
		PropertyListView taskListView =
				new PropertyListView("task_list", tasks) {
					private static final long serialVersionUID = 1L;

					@Override
					protected void populateItem(ListItem item) {
						
						item.add(new Label("project"));
						item.add(new Label("name"));
						item.add(new Label("dueDate"));
						item.add(new Label("priority"));

						item.add(new AjaxCheckBox("completed") {
							@Override
							protected void onUpdate(AjaxRequestTarget ajaxRequestTarget) {
							}
						});
					}
				};
		
		
		add(new Link<Void>("readInFile") {	
			@Override
			public void onClick() {
				File file = new File("../251-A1-Fleet-Josh/data/files/test.md");
				 
				BufferedReader br = null;
				String projectName = "";
				String taskName = "";
				String date = "";
				
				try {
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				String st;
				try {
					while ((st = br.readLine()) != null)
						if(st.contains("#")) {
							projectName = st.substring(2);
							System.out.println(projectName);
						}
						else if(st.contains("due")) {
							Integer thing = st.indexOf("due");
							date = st.substring(thing + 4);
							System.out.println(date);
							Integer item = st.indexOf("]");
							taskName = st.substring(item + 1, thing);
							System.out.println(taskName);
							if (st.charAt(item - 1) == 'X') {
								System.out.println(st.charAt(item - 1));
							}
							else {
								System.out.println("Active Task");
							}
						}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		add(new Link<Void>("selectAll") {	// selects / completes all tasks in the task list
			@Override
			public void onClick() {
				for(Task t: tasks) {		// for tasks in tasks list
					t.setComplete(true);	// set tasks to complete (true)
				}

			}
		});
		
		add(new Link<Void>("clearCompleted") {	// this code block clears all completed (checked) tasks
			@Override
			public void onClick() {
				for(Task t: temp) {			// for t in temp list
					if (t.isComplete())		// if task is set to complete
						deleted.add(t);		// add task to 'deleted' list
				}
				for(Task t: tasks) {		// for task in tasks list
					if (t.isComplete())		// if task is set to complete
						deleted.add(t);		// add task to 'deleted' list
				}
				tasks.removeAll(deleted);	// remove all tasks in deleted list from tasks list
				temp.removeAll(deleted);	// remove all tasks in deleted list from temp list
			}
		});
		
		add(new Link<Void>("isActive") {	// code block to show all active/unchecked tasks
			@Override
			public void onClick() {
				for(Task t: temp) {		// for all tasks in temp list
					tasks.add(t);		// add task t to 'tasks' list
				}
				temp.removeAll(temp);	// empties the temp list
				for(Task t: tasks) {	// for each task in tasks
					if (t.isComplete())	//if task is set to complete
						temp.add(t);	//add task to temp list
				}
				tasks.removeAll(temp);	//remove temp list items from tasks list
			}
		});
		
		add(new Link<Void>("isComplete") { // code block to show completed
			@Override
			public void onClick() {
				for(Task t: temp) {		// for t in temp
					tasks.add(t);		// add t to tasks
				}
				temp.removeAll(temp);	// empties the temp list
				for(Task t: tasks) {	// for t in tasks
					if (!t.isComplete())// if the task is NOT complete
						temp.add(t);	// add current iteration of t to temp list
				}
				tasks.removeAll(temp);	// remove all temp items from tasks list
			}
		});
		
		add(new Link<Void>("allTasks") {	// code block displays all tasks, active or completed
			@Override
			public void onClick() {
				for(Task t: temp) {		// for t in temp
					tasks.add(t);		// add current iteration of t to temp list
				}
				temp.removeAll(temp);	// remove all items in temp list
			}
		});

		listForm.add(taskListView);

	}
	
	// ois = new OOS(); ois,writeObject(collection)
}
