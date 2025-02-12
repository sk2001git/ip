package duke;

/**
 * Ui encapsulates the user interface of the chat bot
 */
public class Ui {
    /**
     * Shows the user the error message when invalid command is given
     * @return the welcome message
     */
    public String welcomeMessage() {
        String chatBotName = "Benedict Cucumber Badge";
        String welcomeMessage = "Hello! I'm " + chatBotName + "\n" + "What can I do for you?";
        return welcomeMessage;
    }

    /**
     * Shows the user the list of tasks
     */
    public void terminate() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Shows the user the list of tasks
     * @param taskList  the list of tasks
     */
    public void list(TaskList taskList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.length(); i++) {
            System.out.println(i + 1 + ". " + taskList.getTask(i));
        }
    }

    /**
     * Shows the user the list of tasks name and their tags
     * @param taskList  the list of tasks
     */
    public void showTags(TaskList taskList) {
        System.out.println("Here are the tags in your list:");
        for (int i = 0; i < taskList.length(); i++) {
            Task task = taskList.getTaskObject(i);
            String taskName = task.getTaskName();
            String taskType = task.getTaskType();
            String tags = task.saveTagFormat();
            System.out.println(i + 1 + ". " + "[" + taskType + "]" + "[" + task.getStatusIcon() + "] "
                    + taskName + " | tags:  " + tags);
        }
    }

    /**
     * Shows the user the error message when invalid command is given
     * @param input the user's input
     */
    public void showCommandError(String input) {
        System.out.println("You have entered a invalid command \n"
                + "' " + input + "' " + " is not a valid command");
        String message = "valid commands: ";
        for (int i = 0; i < Command.VALID_COMMANDS.length; i++) {
            if (i == 0) {
                message += (Command.VALID_COMMANDS[i]);
            } else {
                message += ("\n" + Command.VALID_COMMANDS[i]);
            }
        }
        System.out.println(message);
    }

    /**
     * Shows the user the result of the search
     * @param taskList  the list of tasks
     */
    public void showSearchResult(TaskList taskList) {
        if (taskList.length() < 1) {
            System.out.println("There are no matching tasks in your list");
            System.out.println("Remember it is space sensitive!");
            return;
        }
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < taskList.length(); i++) {
            System.out.println(i + 1 + ". " + taskList.getTask(i));
        }
    }

}
