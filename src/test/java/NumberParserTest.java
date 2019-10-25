import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class NumberParserTest {

    @Test
    public void testNumberParser() {
        Map<String, Integer> countryCodes = new HashMap<>();
        Map<String, String> prefixes = new HashMap<>();
        prefixes.put("GB", "0");
        prefixes.put("US", "1");
        countryCodes.put("US", 1);
        countryCodes.put("GB", 44);
        NumberParser NumberParser = new NumberParser(countryCodes, prefixes);

        assertEquals("+447277822335", NumberParser.parse("07277822335", "+447866866886"));
        assertEquals("+17277822334", NumberParser.parse("+17277822334", "+447866866886"));

    }
}
