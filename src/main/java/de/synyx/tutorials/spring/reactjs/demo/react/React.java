package de.synyx.tutorials.spring.reactjs.demo.react;

import de.synyx.tutorials.spring.reactjs.demo.product.Product;
import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.util.Map;

@Component
public class React {

    public String renderProducts (List<Product> products, String sortBy) throws ScriptException {

        NashornScriptEngine nashornScriptEngine = getNashornScriptEngine ();

        try {
            Object                 html = nashornScriptEngine.invokeFunction ("renderServer", products, sortBy);
            return String.valueOf (html);
        }
        catch (Exception e) {
            throw new IllegalStateException ("failed to renderProducts react component", e);
        }
    }

    private NashornScriptEngine getNashornScriptEngine() throws ScriptException {

        NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName ("nashorn");
                            nashornScriptEngine.eval ("load ('src/main/resources/static/nashorn-polyfill.js')");
                            nashornScriptEngine.eval ("load ('src/main/resources/static/app.bundle.js')");

        return nashornScriptEngine;
    }
}
