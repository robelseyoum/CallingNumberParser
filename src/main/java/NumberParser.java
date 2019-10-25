import java.util.Map;
import java.util.Set;

public class NumberParser {

    private Map<String, Integer> callingCodes;
    private Map<String, String> prefixes;

    public NumberParser(Map<String, Integer> callingCodes, Map<String, String> prefixes) {
        this.callingCodes = callingCodes;
        this.prefixes = prefixes;
    }

    public String parse(String dialledNumber, String userNumber) {

        if (dialledNumber.isEmpty()) {
            return "Dialled number can not be empty";
        } else if (userNumber.isEmpty()) {
            return "User number can not be empty";
        }

        String firstDialledNumChar = dialledNumber.substring(0, 1);
        if ("+".equals(firstDialledNumChar)) {
            return dialledNumber;
        } else {
            String userCountryCode = getUserCountryCode(userNumber);
            if ("".equals(userCountryCode)) {
                return "Could not find country code of the user";
            }
            String prefix = getPrefix(dialledNumber);
            if ("".equals(prefix)) {
                return "Could not find prefix from the dialled number";
            }
            dialledNumber =
                    "+" + userCountryCode + dialledNumber.substring(prefix.length());
            return dialledNumber;

        }
    }

    private String getPrefix(String dialledNumber) {
        Set<String> prefixKeys = prefixes.keySet();
        String prefix = "";
        for (String key : prefixKeys) {
            if (dialledNumber.startsWith(prefixes.get(key))) {
                prefix = prefixes.get(key);
            }
        }
        return prefix;
    }

    private String getUserCountryCode(String userNumber) {
        String userCountryCode = "";
        Set<String> countryKeys = callingCodes.keySet();
        for (String key : countryKeys) {
            if (userNumber.substring(1).startsWith(String.valueOf(callingCodes.get(key)))) {
                userCountryCode = String.valueOf(callingCodes.get(key));
            }
        }
        return userCountryCode;

    }
}
