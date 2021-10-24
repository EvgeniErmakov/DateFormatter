package com;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.Test;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("LocalDate")
public class LocalDateTest {

    static Stream<Arguments> provideArgumentsIsParseToLocalDateTest() {
        return Stream.of(
                Arguments.of("5 June, 2020", LocalDate.of(2020, 6, 5)),
                Arguments.of("12 July, 1994", LocalDate.of(1994, 7, 12))
        );
    }

    @MethodSource("provideArgumentsIsParseToLocalDateTest")
    @ParameterizedTest()
    public void parseToLocalDateTest(String dateAsString, LocalDate expected) {
        LocalDate actual = DateParsing.parseToLocalDate(dateAsString);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void parseToLocalDateExceptionTest() throws Exception {
        DateParsing.parseToLocalDate("75 June, 2020");
    }
}


