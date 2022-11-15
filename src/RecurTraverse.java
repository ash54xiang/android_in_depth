package src;

public class RecurTraverse {
    private static void recursiveTraverse(String previousKey, JSONObject curObj) throws JSONException {
        Log.d(null, "Current obj: " + curObj.toString());
        for (Iterator<String> it = curObj.keys(); it.hasNext();) {
            String curKey = it.next();
            Log.d(null, "Cur Key: " + curKey);
            String nextKey;
            if (previousKey == null || previousKey.isEmpty()) {
                nextKey = curKey;
            } else {
                nextKey = curKey;
            }
            // Log.d(null, "Next key: " + nextKey);
            Object value = curObj.get(curKey);

            if (value instanceof JSONObject) {
                recursiveTraverse(nextKey, (JSONObject) value);
            } else if (value instanceof JSONArray) {
                JSONArray jsArray = (JSONArray) value;

                for (int i = 0; i < jsArray.length(); i++) {
                    try {
                        JSONObject jsObject = (JSONObject) jsArray.get(i);
                        // recursiveTraverse(nextKey + "-" + i, jsObject);
                        recursiveTraverse(String.valueOf(i), jsObject);
                    } catch (ClassCastException e) {
                        // current member is Json Array
                        value = jsArray.get(i);
                        Log.d(null, nextKey + " : " + value);
                    }
                }
            } else {
                Log.d(null, nextKey + " : " + value);
            }
        }
    }
}
