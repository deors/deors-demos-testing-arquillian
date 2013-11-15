package deors.demos.testing.arquillian;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

/**
 * The phrase builder bean.
 *
 * @author deors
 * @version 1.0
 */
public class PhraseBuilder {

    /**
     * Map of templates for building messages.
     */
    private Map<String, String> templates;

    /**
     * Default constructor.
     */
    public PhraseBuilder() {
        super();
    }

    /**
     * Builds a phrase using a given template.
     *
     * @param id the template id
     * @param args the arguments to be applied to the template
     * @return the composed phrase
     */
    public String buildPhrase(String id, Object... args) {

        return MessageFormat.format(templates.get(id), args);
    }

    /**
     * Initializes the bean adding a new template for greeting messages.
     */
    @PostConstruct
    public void initialize() {

        templates = new HashMap<String, String>();
        templates.put("hello", "Hello, {0}!");
    }
}
