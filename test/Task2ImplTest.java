import org.junit.ComparisonFailure;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by btow on 13.01.2017.
 */
public class Task2ImplTest extends Task2Impl {
    @Test
    public void testAssignNumbers() throws Exception {

        List<IElement> expectedValue_IElement = new ArrayList<>();
        ElementExampleImpl.Context expectedContext = new ElementExampleImpl.Context();
        expectedValue_IElement.add(new ElementExampleImpl(expectedContext, 0));
        expectedValue_IElement.add(new ElementExampleImpl(expectedContext, 1));
        expectedValue_IElement.add(new ElementExampleImpl(expectedContext, 2));
        expectedValue_IElement.add(new ElementExampleImpl(expectedContext, 3));
        expectedValue_IElement.add(new ElementExampleImpl(expectedContext, 4));
        expectedValue_IElement.add(new ElementExampleImpl(expectedContext, 5));
        expectedValue_IElement.add(new ElementExampleImpl(expectedContext, 6));

        List<IElement> inputValue_IElement = new ArrayList<>();
        ElementExampleImpl.Context inputContext = new ElementExampleImpl.Context();
        inputValue_IElement.add(new ElementExampleImpl(inputContext, 0)); // element number 0
        inputValue_IElement.add(new ElementExampleImpl(inputContext, 6)); // element number 1
        inputValue_IElement.add(new ElementExampleImpl(inputContext, 2)); // element number 2
        inputValue_IElement.add(new ElementExampleImpl(inputContext, 1)); // element number 3
        inputValue_IElement.add(new ElementExampleImpl(inputContext, 5)); // element number 4
        inputValue_IElement.add(new ElementExampleImpl(inputContext, 4)); // element number 5
        inputValue_IElement.add(new ElementExampleImpl(inputContext, 3)); // element number 6

        assignNumbers(inputValue_IElement);

        assertEquals((String) null, expectedValue_IElement, inputValue_IElement);

    }

    public static void assertEquals(String message, List<IElement> expected, List<IElement> actual) throws ComparisonFailure {
        if (!(expected == null ? actual == null : equalsList(expected, actual))) {
            String cleanMessage = message == null ? "" : message;
            throw new ComparisonFailure(cleanMessage, expected.toString(), actual.toString());
        }
    }

    private static boolean equalsList(List<IElement> expected, List<IElement> actual) {

        if (expected == null & actual == null) {
            return true;
        } else if ((expected == null & actual != null) | (expected != null & actual == null)) {
            return false;
        }

        int expectedSizeList = expected.size(),
                actualSizeList = actual.size();

        if (expectedSizeList != actualSizeList) {
            return false;
        } else {
            for (int i = 0; i < expectedSizeList; i++) {
                if (expected.get(i).getNumber() != actual.get(i).getNumber()) {
                    return false;
                }
            }
        }

        return true;
    }

}