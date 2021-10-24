package com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.Test;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("LocalDate")
public class LocalDateTimeTest {

    static Stream<Arguments> provideArgumentsIsParseToLocalDateTimeTest() {
        return Stream.of(
                Arguments.of("June 5, 2020 12:10:56", LocalDateTime.of(2020, 6, 5, 12, 10, 56)),
                Arguments.of("July 12, 1994 12:10:56", LocalDateTime.of(1994, 7, 12, 12, 10, 56))
                );
    }

    @MethodSource("provideArgumentsIsParseToLocalDateTimeTest")
    @ParameterizedTest()
    public void parseToLocalDateTimeTest(String dateAsString, LocalDateTime expected) {
        LocalDateTime actual = DateParsing.parseToLocalDateTime(dateAsString);
        assertEquals(expected, actual);
    }


    @Test(expected = Exception.class)
    public void parseToLocalDateExceptionTest() throws Exception {
        DateParsing.parseToLocalDateTime("-1");
    }
}
