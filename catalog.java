import java.util.HashMap;
import java.util.Map;

class Main { // Renamed class

    public static void main(String[] args) {
        // Manually parsed JSON-like input
        Map<String, Map<String, String>> jsonObject = new HashMap<>();

        // Sample JSON input as a nested map (hardcoded for simplicity)
        Map<String, String> keysMap = new HashMap<>();
        keysMap.put("n", "9");
        keysMap.put("k", "6");

        jsonObject.put("keys", keysMap);
        jsonObject.put("1", Map.of("base", "10", "value", "28735619723837"));
        jsonObject.put("2", Map.of("base", "16", "value", "1A228867F0CA"));
        jsonObject.put("3", Map.of("base", "12", "value", "132811A4AA0B7B"));
        jsonObject.put("4", Map.of("base", "11", "value", "917978721331A"));
        jsonObject.put("5", Map.of("base", "16", "value", "1A22886782E1"));
        jsonObject.put("6", Map.of("base", "10", "value", "28735619654702"));
        jsonObject.put("7", Map.of("base", "14", "value", "71AB5070CC4B"));
        jsonObject.put("8", Map.of("base", "9", "value", "122662581541670"));
        jsonObject.put("9", Map.of("base", "8", "value", "642121030037605"));

        // Extract n and k
        Map<String, String> keys = jsonObject.get("keys");
        int n = Integer.parseInt(keys.get("n"));
        int k = Integer.parseInt(keys.get("k"));

        // Extract points (x, y)
        double[] xValues = new double[n];
        double[] yValues = new double[n];
        int index = 0;

        for (String key : jsonObject.keySet()) {
            if (!key.equals("keys")) {
                int x = Integer.parseInt(key);
                Map<String, String> valueObject = jsonObject.get(key);
                int base = Integer.parseInt(valueObject.get("base"));
                String value = valueObject.get("value");

                // Decode the Y value based on the base
                // Use Long.parseLong() for large numbers
                long y = Long.parseLong(value, base);
                System.out.println(y);

                xValues[index] = x;
                yValues[index] = y;
                index++;
            }
        }

        // Apply Lagrange interpolation to find the constant term 'c'
        double constantTerm = lagrangeInterpolation(xValues, yValues, k);
        System.out.println("The constant term c is: " + constantTerm);
    }

    // Lagrange interpolation function to find the constant term
    public static double lagrangeInterpolation(double[] xValues, double[] yValues, int k) {
        double result = 0;

        for (int i = 0; i < k; i++) {
            double term = yValues[i];
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    term *= (0 - xValues[j]) / (xValues[i] - xValues[j]);
                }
            }
            result += term;
        }
        return result;
    }
}
  


output;2.11




import java.util.HashMap;
import java.util.Map;

class Main { // Renamed class

    public static void main(String[] args) {
        // Manually parsed JSON-like input
        Map<String, Map<String, String>> jsonObject = new HashMap<>();

        // Sample JSON input as a nested map (hardcoded for simplicity)
        Map<String, String> keysMap = new HashMap<>();
        keysMap.put("n", "4");
        keysMap.put("k", "3");

        jsonObject.put("keys", keysMap);
        jsonObject.put("1", Map.of("base", "10", "value", "4"));
        jsonObject.put("2", Map.of("base", "2", "value", "111"));
        jsonObject.put("3", Map.of("base", "10", "value", "12"));
        jsonObject.put("6", Map.of("base", "4", "value", "213"));

        // Extract n and k
        Map<String, String> keys = jsonObject.get("keys");
        int n = Integer.parseInt(keys.get("n"));
        int k = Integer.parseInt(keys.get("k"));

        // Extract points (x, y)
        double[] xValues = new double[n];
        double[] yValues = new double[n];
        int index = 0;

        for (String key : jsonObject.keySet()) {
            if (!key.equals("keys")) {
                int x = Integer.parseInt(key);
                Map<String, String> valueObject = jsonObject.get(key);
                int base = Integer.parseInt(valueObject.get("base"));
                String value = valueObject.get("value");

                // Decode the Y value based on the base
                int y = Integer.parseInt(value, base);

                xValues[index] = x;
                yValues[index] = y;
                index++;
            }
        }

        // Apply Lagrange interpolation to find the constant term 'c'
        double constantTerm = lagrangeInterpolation(xValues, yValues, k);
        System.out.println("The constant term c is: " + constantTerm);
    }

    // Lagrange interpolation function to find the constant term
    public static double lagrangeInterpolation(double[] xValues, double[] yValues, int k) {
        double result = 0;

        for (int i = 0; i < k; i++) {
            double term = yValues[i];
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    term *= (0 - xValues[j]) / (xValues[i] - xValues[j]);
                }
            }
            result += term;
        }
        return result;
    }
}
output:constant term is 3
