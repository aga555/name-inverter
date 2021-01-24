package com.example.nameinverter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NameInverterTest {

    public static final String EMPTY_STRING = "";
    private NameInverter nameInverter;

    @BeforeEach
    void setUp() {
        nameInverter = new NameInverter();
    }

    @Test
    void shouldThrowExceptionWhenNullProvided() {
        Assertions.assertThrows(NullPointerException.class,
                () -> nameInverter.invert(null));
    }

    @Test
    void shouldReturnEmptyStringWhenEmptyStringGiven() {
        String inverted = nameInverter.invert("");
        assertThat(inverted).isEqualTo(EMPTY_STRING);
    }

    @Test
    void shouldReturnEmptySTringWhenSpacesGiven() {
        String inverted = nameInverter.invert("      ");
        assertThat(inverted).isEqualTo(EMPTY_STRING);
    }

    @Test
    void shouldReturnInvertedFirstAndLastName() {
        //given
        String inverted = nameInverter.invert("Jan Kowalski");
        //when
        assertThat(inverted).isEqualTo("Kowalski,Jan");
        //then
    }

    @Test
    void shouldRemoveHonorificsReturnInvertedFirstAndLastName() {
        //given
        String inverted = nameInverter.invert("Pan Gracjan Kowalski");
        //when
        assertThat(inverted).isEqualTo("Kowalski,Gracjan");
        //then
    }
}