package duke;

import java.io.*;

/**
 * TaskRepository class to handle the storage of tasks
 */
public class TaskRepository {
    // Relative file path to store tasks
    private final String FILE_PATH = "./data/taskStorage.txt";
    private TaskList taskList;

    /**
     * Constructor for the TaskRepository class
     * It checks if a file at FILE_PATH exists, and if not, creates it
     * It also initializes an empty TaskList
     */
    public TaskRepository() {
        try {
            // Create the file if it does not exist
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            // Initialize an empty TaskList
            this.taskList = new TaskList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads tasks from a file into a TaskList and
     * populates the taskList with tasks from the file
     * Tasks are read line by line, with details split by '|'
     * Task type (T, D, E) determines how each task is added to the TaskList
     *
     * @return The populated TaskList object
     */
    public TaskList loadTasks() throws BotException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            assert reader != null : "Reader should be initialized";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] taskDetails = line.split("\\|");
                assert taskDetails.length >= 3 : "Task details are incomplete";
                String isDone = taskDetails[1].trim();
                Boolean isTaskDone = isDone.equals("X");
                String taskType = taskDetails[0].trim();
                String description = taskDetails[2].trim();
                switch (taskType) {
                    case "T":
                        taskList.addTodo(description);
                        if (isTaskDone) {
                            taskList.getTaskByNum(taskList.getTaskCount()).markAsDone();
                        }
                        break;
                    case "D":
                        assert taskDetails.length >= 4 : "Deadline task details are incomplete";
                        String dueDate = taskDetails[3].trim();
                        dueDate = dueDate.substring(3).trim();
                        taskList.addDeadline(description, dueDate);
                        if (isTaskDone) {
                            taskList.getTaskByNum(taskList.getTaskCount()).markAsDone();
                        }
                        break;
                    case "E":
                        assert taskDetails.length >= 4 : "Event task details are incomplete";
                        String timeBlock = taskDetails[3].trim();
                        String[] parts = timeBlock.split("to:");
                        assert parts.length == 2 : "Time block is incomplete";
                        String fromPart = parts[0];
                        String toPart = parts[1];
                        String startTime = fromPart.replace("from:", "").trim();
                        String endTime = toPart.trim();
                        taskList.addEvent(description, startTime, endTime);
                        if (isTaskDone) {
                            taskList.getTaskByNum(taskList.getTaskCount()).markAsDone();
                        }
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    /**
     * This method saves the tasks from the provided TaskList to a text file
     * It writes each task as a new line in the file
     * The task number is removed before writing to the file as it is not needed
     *
     * @param taskList The TaskList containing the tasks to be saved to the file
     *
     */
    public void saveTasksToFile(TaskList taskList) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            for (String task : taskList.listTasks()) {
                String taskWithoutNumber = task.substring(task.indexOf(" ") + 1);
                fileWriter.write(taskWithoutNumber + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}