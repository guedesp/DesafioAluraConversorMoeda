package codigos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMoeda {
    public static double converter(String from, String to, double valor) throws Exception {
        String urlStr = "https://api.exchangerate.host/convert?from=" + from + "&to=" + to;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Erro: " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;
        StringBuilder response = new StringBuilder();
        while ((output = br.readLine()) != null) {
            response.append(output);
        }
        conn.disconnect();

        org.json.JSONObject jsonObject = new org.json.JSONObject(response.toString());
        double taxa = jsonObject.getDouble("result");

        return valor * taxa;
    }
}
