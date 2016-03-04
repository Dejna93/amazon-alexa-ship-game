package com.amazon.alexa;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Damian on 2016-03-04.
 */
public class AlexaSpeeachHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds = new HashSet<String>();

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds.add("amzn1.echo-sdk-ams.app.c75417a4-1431-4120-9148-0b7e9eda7263");
    }

    public AlexaSpeeachHandler() {
        super(new AlexaSpeechlet(), supportedApplicationIds);
    }


}
