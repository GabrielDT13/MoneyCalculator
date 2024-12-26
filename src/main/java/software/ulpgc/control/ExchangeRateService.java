package software.ulpgc.control;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.model.Currency;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRateService implements Loader{
    private static final String URL = "http://data.fixer.io/api/latest?access_key=0839e0419f3ed8dcba8cce7d0dd0d42a";

    @Override
    public List<Currency> load() {
        try {
            return toList(loadJson());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Currency> toList(String json) {
        List<Currency> currencies = new ArrayList<>();
        Map<String, JsonElement> symbols = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        for (String s : symbols.keySet()) {
            currencies.add(new Currency(s, symbols.get(s).getAsString()));
        }
        return currencies;
    }

    private String loadJson() throws IOException {
        URL url = new URL(URL);
        try (InputStream inputStream = url.openStream()) {
            return new String(inputStream.readAllBytes());
        }
    }
}
