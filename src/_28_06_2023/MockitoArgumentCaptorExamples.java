package _28_06_2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

//MockitoArgumentCaptor
//используется для захвата аргументов
//переданных в методы при вызове на мок объектах
public class MockitoArgumentCaptorExamples {

    @Captor
    ArgumentCaptor<Long> acLong;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test() {
        MathUtils mockMathUtils = Mockito.mock(MathUtils.class);
        Mockito.when(mockMathUtils.add(1, 1)).thenReturn(2);
        Mockito.when(mockMathUtils.isInteger(Mockito.anyString())).thenReturn(true);
        Mockito.when(mockMathUtils.squareLong(2l)).thenReturn(4l);

        ArgumentCaptor<Integer> acInteger = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> acString = ArgumentCaptor.forClass(String.class);

        Assertions.assertEquals(2, mockMathUtils.add(1, 1));
        Assertions.assertTrue(mockMathUtils.isInteger("1"));
        Assertions.assertTrue(mockMathUtils.isInteger("789"));
        Assertions.assertEquals(4l, mockMathUtils.squareLong(2l));

        Mockito.verify(mockMathUtils).add(acInteger.capture(), acInteger.capture());
        List<Integer> allValues = acInteger.getAllValues();
        Assertions.assertEquals(List.of(1, 1), allValues);

        Mockito.verify(mockMathUtils, Mockito.times(2)).isInteger(acString.capture());
        List<String> allStringValues = acString.getAllValues();
        Assertions.assertEquals(List.of("1", "789"), allStringValues);

        Mockito.verify(mockMathUtils).squareLong(acLong.capture());
        Assertions.assertEquals(2l, acLong.getValue());
    }
}

class MathUtils {
    public int add(int x, int y) {
        return x + y;
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public long squareLong(long l) {
        return l * l;
    }
}