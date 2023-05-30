package common;

import models.cucumber.CucumberReport;
import models.commons.Receivers;
import models.slack.SuccessfulMessage;
import slack.Slack;
import utils.Printer;
import utils.StringUtilities;

import java.util.List;

public class ShutdownSequence extends Utilities {
    static Printer log = new Printer(ShutdownSequence.class);
    static Slack slack = new Slack();
    StringUtilities strUtils = new StringUtilities();

    public void publishReports(String testName){ // This method is called upon after the tests are done running
        log.new Info("Performing final sequence for the test specification: " + strUtils.highlighted(StringUtilities.Color.PURPLE,testName));
        if (Boolean.parseBoolean(properties.getProperty("notify-slack"))) {
            try {
                String directory = properties.getProperty("report-directory");
                String channelId = properties.getProperty("slack-channel-id");
                List<CucumberReport> reports = getCucumberReport(directory);
                boolean testFailure = false;
                for (CucumberReport report: reports) {if (!report.testSuccessful()) testFailure = true;}
                SuccessfulMessage message = slack.postSimpleMessage(
                        "Results of the *" + testName +"* tests have been uploaded to the <"+ properties.getProperty("report-url") + "|Cucumber Profile>.",
                        channelId
                );
                if (testFailure){
                    log.new Warning("There are test failures!");
                    String ts = message.ts();
                    StringBuilder threadMessage = new StringBuilder("There are failed tests ");
                    for (Receivers.Receiver receiver:getReceivers()) {
                        threadMessage.append(", <@").append(receiver.userId()).append(">");
                    }
                    threadMessage.append("!");
                    slack.postThreadMessage(threadMessage.toString(), channelId, ts);
                    log.new Success("Reports are posted on slack.");
                }
            }
            catch (Exception exception) {log.new Warning(exception.getMessage());}
        }
        log.new Info("Final sequence completed.");
    }
}