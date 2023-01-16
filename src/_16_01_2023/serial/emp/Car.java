package _16_01_2023.serial.emp;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@AllArgsConstructor
public class Car implements Serializable {
    String model;
    String colour;
}