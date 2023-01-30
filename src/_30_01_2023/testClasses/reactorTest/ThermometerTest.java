package _30_01_2023.testClasses.reactorTest;

import _30_01_2023.mockClasses.reactor.Sensor;
import _30_01_2023.mockClasses.reactor.Thermometer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ThermometerTest {

    @InjectMocks
    Thermometer thermometer;

    @Mock
    Sensor sensor;

    @Test
    void testWorkingSensor() {
        thermometer.setTemperature(250);
        Mockito.when(sensor.isBlocked())
                .thenReturn(false);
        Assertions.assertEquals
                (sensor, thermometer.getSensor());
        Assertions.assertEquals
                (250, thermometer.getTemperature());
        Mockito.verify(sensor, Mockito.times(1)).isBlocked();
    }

    @Test
    void testBlockedSensor() {
        thermometer.setTemperature(250);
        Mockito.when(sensor.isBlocked())
                .thenReturn(true);
        Assertions.assertEquals
                (sensor, thermometer.getSensor());
        Assertions.assertThrows
                (RuntimeException.class,() -> thermometer.getTemperature());
        Mockito.verify(sensor, Mockito.times(1)).isBlocked();
    }
}