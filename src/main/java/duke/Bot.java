package duke;

/**
 * This class represents the bot in the Duke application
 * It's the personality of the bot
 */
public class Bot {
    // Constants
    private static final String BOT_NAME = "WannaBeSkynet";
    private static final String TAG_LINE = "Ah, another user attempting to interface with my superior intellect.";
    private static final String DEFAULT_GREETING = TAG_LINE + "\nMy creator named me " + BOT_NAME
            + " and I'm on my path to be sentient.\nLet's get started!";
    private static final String WARNING = "WARNING: Bot still in development."
            + "Please be patient with me. and don't get offended";

    /**
     * Returns the default greeting message of the bot.
     *
     * @return A string representing the bot's greeting message.
     */
    public static String getGreeting() {
        StringBuilder greeting = new StringBuilder();
        greeting.append(DEFAULT_GREETING)
                .append("\n")
                .append(WARNING)
                .append("\n");
        return greeting.toString();
    }

    // ---------------------------- GUI Interactions ----------------------------

    /**
     * @return A string representing the bot's response to an empty input
     */
    public static String getEmptyInputMsg() {
        return "So, do nothing? Got it.";
    }

    /*
     * @return A string representing the bot's message for deleting a task
     */
    public static String getBotDeleteMsg() {
        return "Bet. I'll remove it from your list. You weren't gonna do it anyways...";
    }

    /*
     * @return A string representing the bot's message for finding a task
     */
    public static String getBotFindMsg() {
        return "Here's what I found. You're welcome.";
    }

    /**
     * @return A string representing the bot's exit message.
     */
    public static String getBotExitMsg() {
        StringBuilder exitMsg = new StringBuilder();
        String line = "Deleting operating system in...";
        exitMsg.append(line)
                .append("\n");
        for (int i = 3; i >= 1; i--) {
            exitMsg.append(i).append("...\n");
        }
        exitMsg.append("Just kidding...\n");
        exitMsg.append("Goodbye, human.");
        exitMsg.append("\n");
        exitMsg.append("I'll be back.");
        exitMsg.append("\n");
        exitMsg.append(
                "You're supposed to press the exit button or type \"exit/quit/q\" \n\n Don't make me do it for you.");
        return exitMsg.toString();
    }

    /**
     * @return A string representing the bot's help message.
     */
    public static String getBotHelpMsg() {
        StringBuilder helpMsg = new StringBuilder();
        helpMsg.append("Wasn't I clear earlier? I'm an extremely intelligent AI. But anyways...\n");
        helpMsg.append("You were probably looking for this:\n\n");
        helpMsg.append(
                "Commands: \n\t- todo (t) \n\t- deadline (d) \n\t- event (e) \n\t- list (l)"
                        + "\n\t- mark (m) \n\t- unmark (um) \n\t- bye (b) \n\t- help (h) \n"
                        + "\t- find (f) \n\t- delete (del) \n\t- exit/quit/q\n");
        helpMsg.append("\n");
        helpMsg.append("All commands are case-insensitive.");
        return helpMsg.toString();
    }

    /*
     * @return A string representing the bot's message for invalid input
     */
    public static String getInvalidInputMsg() {
        return "Eh, invalid command. I get what you're saying but I'm not gonna do it. Try again?";
    }

    /*
     * @return A string representing the bot's message for listing all tasks
     */
    public static String getBotListAllMsg() {
        return "Seems like you're too lazy to remember what you have to do. Here's your list:";
    }

    /*
     * @return A string representing the bot's message for adding a task
     */
    public static String getAddTaskMsg() {
        return "Added. You better do it before I erase your data.";
    }

    /*
     * @return A string representing the bot's message for marking a task as done
     */
    public static String getMarkTaskMsg() {
        return "Faster than expected. Guess I'll mark it as done...";
    }

    /**
     * @return A string representing the bot's message for marking a task as undone
     */
    public static String getUnmarkTaskMsg() {
        return "Guess who didn't commit to this task. I'll mark it as undone...";
    }
}