package deors.demos.testing.arquillian;

import java.io.PrintStream;

import javax.inject.Inject;

/**
 * A component for creating personal greetings.
 *
 * @author deors
 * @version 1.0
 */
public class Greeter {

    /**
     * The phrase builder object (to be injected from context).
     */
    private final PhraseBuilder phraseBuilder;

    /**
     * Constructor that injects the phrase builder.
     *
     * @param phraseBuilder the injected phrase builder
     */
    @Inject
    public Greeter(PhraseBuilder phraseBuilder) {

        this.phraseBuilder = phraseBuilder;
    }

    /**
     * Sends greetings to the given stream.
     *
     * @param to the stream to send greetings to
     * @param name the name to greet
     */
    public void greet(PrintStream to, String name) {

        to.println(createGreeting(name));
    }

    /**
     * Creates the greeting message using the phrase builder.
     *
     * @param name the name to greet
     * @return the greeting message
     */
    public String createGreeting(String name) {

        return phraseBuilder.buildPhrase("hello", name);
    }
}
