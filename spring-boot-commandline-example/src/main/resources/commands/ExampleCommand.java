package commands;

import org.crsh.cli.Command;
import org.crsh.cli.Named;
import org.crsh.cli.Option;
import org.crsh.cli.Usage;
import org.crsh.command.BaseCommand;
import org.crsh.command.RuntimeContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Peter Szanto on 7/14/2016.
 */
@Usage("Example command for demonstration purposes")
@Named("example")
public class ExampleCommand extends BaseCommand {

    private enum Components {
        SPRING, BOOT, ALL;
    }

    @Usage("print version of a component")
    @Command
    public Map<String, Object> version(@Usage("name of the component, valid values are : SPRING, BOOT, ALL") @Option(names = {"c", "component"})  Components component) {

        Objects.requireNonNull(component, "the component parameter must be specified");

        Map<String, Object> result = new HashMap<>();

        if (Components.SPRING.equals(component) || Components.ALL.equals(component)) {
            addVersion(result, context, "spring.version");
        }

        if (Components.BOOT.equals(component) || Components.ALL.equals(component)) {
            addVersion(result, context, "spring.boot.version");
        }

        return result;

    }

    private void addVersion(Map<String, Object> result, RuntimeContext context, String key) {
        result.put(key, context.getAttributes().get(key));
    }

    @Usage("displays the current thread")
    @Named("current-thread")
    @Command
    public Thread currentThread() {
        return Thread.currentThread();
    }

}
