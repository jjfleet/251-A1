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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

		Label countLabel = new Label("count", new PropertyModel(collection, "highCount"));
		add(countLabel);
		
		@SuppressWarnings("unchecked")
		PropertyListView taskListView =
				new PropertyListView("task_list", tasks) {
					private static final long serialVersionUID = 1L;

					@Override
					protected void populateItem(ListItem item) {

						item.add(new Label("name"));
						item.add(new Label("description"));
						item.add(new Label("priority"));

						item.add(new AjaxCheckBox("completed") {
							@Override
							protected void onUpdate(AjaxRequestTarget ajaxRequestTarget) {
							}
						});
					}
				};

		add(new Link<Void>("selectAll") {
			@Override
			public void onClick() {
				for(Task t: tasks) {
					t.setComplete(true);
				}

			}
		});
		
		add(new Link<Void>("showHigh") {
			@Override
			public void onClick() {
				List<Task> forRemoval = new ArrayList<Task>();
				for(Task t: tasks) {
					if (!t.getPriority().equals("High"))
						forRemoval.add(t);
				}
				tasks.removeAll(forRemoval);

			}
		});


		listForm.add(taskListView);

	}
}
