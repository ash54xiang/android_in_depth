package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IniToJson {

    private Pattern _section = Pattern.compile("\\s*\\[([^]]*)\\]\\s*");
    private Pattern _keyValue = Pattern.compile("\\s*([^=]*)=(.*)");
    public static Map<String, Map<String, String>> _entries = new HashMap<>();

    public IniToJson(String path) throws IOException {
        load(path);
    }

    public void load(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            String section = null;
            while ((line = br.readLine()) != null) {
                Matcher m = _section.matcher(line);
                if (m.matches()) {
                    section = m.group(1).trim();
                } else if (section != null) {
                    m = _keyValue.matcher(line);
                    if (m.matches()) {
                        String key = m.group(1).trim();
                        String value = m.group(2).trim();
                        Map<String, String> kv = _entries.get(section);
                        if (kv == null) {
                            _entries.put(section, kv = new HashMap<>());
                        }
                        kv.put(key, value);
                    }
                }
            }
        }
        System.out.println("Map: " + _entries);
    }

    public JSONObject convertToJson() {
        return new JSONObject(_entries);
    }

    // public String getString(String section, String key, String defaultvalue) {
    // Map<String, String> kv = _entries.get(section);
    // if (kv == null) {
    // return defaultvalue;
    // }
    // return kv.get(key);
    // }

    // public int getInt(String section, String key, int defaultvalue) {
    // Map<String, String> kv = _entries.get(section);
    // if (kv == null) {
    // return defaultvalue;
    // }
    // return Integer.parseInt(kv.get(key));
    // }

    // public float getFloat(String section, String key, float defaultvalue) {
    // Map<String, String> kv = _entries.get(section);
    // if (kv == null) {
    // return defaultvalue;
    // }
    // return Float.parseFloat(kv.get(key));
    // }

    // public double getDouble(String section, String key, double defaultvalue) {
    // Map<String, String> kv = _entries.get(section);
    // if (kv == null) {
    // return defaultvalue;
    // }
    // return Double.parseDouble(kv.get(key));
    // }

    public static void main(String[] agrs) throws IOException {
        System.out.println("In Main: -----------------");
        IniToJson iniToJson = new IniToJson("C:\\src\\projects\\android_in_depth\\config.properties");
        System.out.println("End" + iniToJson);
        System.out.println("Convert map to json: ------------");
        JSONObject _json = iniToJson.convertToJson();
        System.out.println("JSON Object: " + _json);
    }
}
