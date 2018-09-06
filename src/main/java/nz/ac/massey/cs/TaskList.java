package nz.ac.massey.cs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

// list of tasks managed by the web application

public class TaskList implements Serializable {
    private List<Task> collection;

    public TaskList() {
        collection = new LinkedList<Task>();
    }

    public List<Task> getTasks() {
        return collection;
    }

    public void addTask(Task task) {
        collection.add(task);
    }

    public void removeTask(Task task) {
        collection.remove(task);
    }
    
    public long getActiveCount() {
    	return collection.stream().filter(task -> !task.isComplete()).count();
    }
    
    static String path = new String("../251-A1-Fleet-Josh/persistence.ser");
    
    public void saveTaskList() throws IOException {
    	ObjectOutputStream outputStream = null;
    	try {
    		outputStream = new ObjectOutputStream(new FileOutputStream(path));
    		outputStream.writeObject(collection);
    	}
    	catch(FileNotFoundException ex) {
    		ex.printStackTrace();
    	}
    	catch(IOException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		try {
    			if(outputStream != null) {
    				outputStream.flush();
    				outputStream.close();
    			}
    		}
    		catch(IOException ex) {
    			ex.printStackTrace();
    		}
    	}
    }
    
    public static TaskList loadTaskList() throws IOException, ClassNotFoundException {
    	try {
    		FileInputStream fileIn = new FileInputStream(path);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		return (TaskList) in.readObject();
    	}
    	catch(FileNotFoundException ex) {
    		ex.printStackTrace();
    	}
    	catch(IOException ex) {
    		ex.printStackTrace();
    	}
		return null;
    }
}
