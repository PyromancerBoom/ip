public class Duke {
    public static void main(String[] args) throws BotException {
        // Name of the bot
        String botName = "WannaBeSkynet";

        // Default Greeting on start-up of the bot
        String tagLine = "Ah, another user attempting to interface with my superior intellect.";
        String defaultGreeting = tagLine
                + "\nMy creator named me "
                + botName
                + " and I'm on my path to be sentient."
                + "\nLet's get started!";

        String warning = "WARNING: Bot still in development. Please be patient with me. and don't get offended";

        // Initial
        System.out.println(TerminalUI.wrapWithSepLine(defaultGreeting + "\n" + warning + "\n"));

        // Starting Operation
        Operator operator = new Operator();
        operator.goLive();
    }
}
