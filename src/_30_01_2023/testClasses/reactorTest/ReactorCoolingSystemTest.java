package _30_01_2023.testClasses.reactorTest;

import _30_01_2023.mockClasses.reactor.ReactorCoolingSystem;
import _30_01_2023.mockClasses.reactor.Thermometer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ReactorCoolingSystemTest {

    @InjectMocks
    ReactorCoolingSystem reactorCoolingSystem;

    @Mock
    Thermometer thermometer;

    @Test
    void testReactorCoolingSystemON() {
        Mockito.when(thermometer.getTemperature())
                .thenReturn(250D);
        reactorCoolingSystem.setTemperatureThreshold(240);
        reactorCoolingSystem.checkReactorCoolingSystem();
        Assertions.assertTrue(reactorCoolingSystem.isOn());
        Mockito.verify(thermometer, Mockito.times(1)).getTemperature();
    }

    @Test
    void testReactorCoolingSystemOFF() {
        Mockito.when(thermometer.getTemperature())
                .thenReturn(220D);
        reactorCoolingSystem.setTemperatureThreshold(240);
        reactorCoolingSystem.checkReactorCoolingSystem();
        Assertions.assertFalse(reactorCoolingSystem.isOn());
        Mockito.verify(thermometer, Mockito.times(1)).getTemperature();
    }
}