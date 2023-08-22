/**
 * Deadline encapsulates task that need to be done before a specific date or time
 */
public class Deadline extends Task {
    private String taskName;
    private String deadline;

    /**
     * Constructor for creating a task
     *
     * @param taskName name of task.
     */
    public Deadline(String taskName, String deadline) {
        super(taskName);
        this.taskName = taskName;
        this.deadline = deadline;
    }

    /**
     * Prints out a message that a deadline task has been added
     */
    @Override
    public void taskAdded(int noOfTask) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + this.toString());
        System.out.println("Now you have " + noOfTask + " tasks in the list.");
    }

    /**
     * taskValidator does nothing if there are no wrong inputs but throws a WrongInputException
     * if inputs are invalid
     * @param input the user's string input
     * @throws WrongInputTask which informs the user of the error and actions to take
     */
    public static void taskValidator(String input) throws WrongInputTask {
        String[] segementedString = input.split(" /by ");
        if (segementedString.length < 2) {
            throw new WrongInputTask("/by command is required",
                    "Use the /by command using 'deadline <name> /by <time>");
        } else {
            String deadline = segementedString[1];
            try {
                String taskNameDeadline = segementedString[0].substring(Duke.DEADLINEOFFSET);
            } catch (StringIndexOutOfBoundsException e) {
                throw new WrongInputTask("Task name cannot be blank",
                        "Enter a non-blank deadline task name");
            }

            String taskNameDeadline = segementedString[0].substring(Duke.DEADLINEOFFSET);
            if (taskNameDeadline.trim().isEmpty()) {
                throw new WrongInputTask("Task name cannot be blank",
                        "Enter a non-blank deadline task name");
            } else if (deadline.trim().isEmpty()) {
                throw new WrongInputTask("for /by <time>, time cannot be blank",
                        "Please input valid text that are not space");
            }
        }
    }

    @Override
    public String toString() {
        return "[D]" + "[" + this.getStatusIcon() + "] "
                + this.taskName + " (by: " + this.deadline + ")";
    }
}
