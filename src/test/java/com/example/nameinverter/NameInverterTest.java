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
    void shouldRemoveHonorificsReturnInvertedFirstAndLastNameMale() {
        //given
        String inverted = nameInverter.invert("Pan Gracjan Kowalski");
        //when
        assertThat(inverted).isEqualTo("Kowalski,Gracjan");
        //then
    }

    @Test
    void shouldRemoveHonorificsReturnInvertedFirstAndLastNameForFemale() {
        //given
        String inverted = nameInverter.invert("Pani Anna Kowalczyk");
        //when
        assertThat(inverted).isEqualTo("Kowalczyk,Anna");
        //then
    }

    @Test
    void shouldReturnInvertedFirstLastNameWithTitleWithoutFemaleHonorifics() {
        //given
        String inverted = nameInverter.invert("Pani Dr Anna Kowalczyk");
        //when
        assertThat(inverted).isEqualTo("Kowalczyk,Anna,Dr");
        //then
    }
    @Test
    void shouldReturnInvertedFirstLastNameWithTitles() {
        //given
        String inverted = nameInverter.invert("Pani mgr inż. Anna Kowalczyk");
        //when
        assertThat(inverted).isEqualTo("Kowalczyk,Anna,inż.,mgr");
        //then
    }
}