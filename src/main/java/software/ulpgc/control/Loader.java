package software.ulpgc.control;
import software.ulpgc.model.Currency;
import java.util.List;

public interface Loader {
    List<Currency> load();
}
