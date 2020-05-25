package bridge.settings;

import java.util.HashMap;
import java.util.Map;

public class SettingsImplementation implements Settings{

	private Map<String, Object> parameters = new HashMap<String, Object>();

    public Object getParameter(String parameter) {
        return this.parameters.get(parameter);
    }

    public void addParameter(String parameter, Object value) {
        this.parameters.put(parameter, value);
    }

}
