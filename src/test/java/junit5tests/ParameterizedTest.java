package junit5tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTest {

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @ValueSource (ints = {1, 2, 3, 4, 5, 6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @NullAndEmptySource
    @ValueSource (strings = {"first string", "second string"})
    void stringValues(String theParam){
        System.out.println("theParam = " + theParam);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @ValueSource (booleans = {true, false})
    void booleanValues(boolean theParam){
        System.out.println("theParam = " + theParam);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @CsvSource(value = {"Kwon,'G,D'", "Choi,Seung-hyun", "Dong,Yong Bae", "Kang,Daesung"})
    void csvSourceStringValues(String param1, String param2){
        Assumptions.assumeFalse(param1.equals("Kwon"), "The assumption failed for the " + "following param2: " + param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @CsvSource(value = {"Kwon,1,true", "Choi,2,false", "Dong,3,true", "Kang,4,true"})
    void csvSourceStringIntBooleanValues(String param1, int param2, boolean param3){
        Assumptions.assumingThat(param2 > 2, () -> System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 =" + param3);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @CsvSource(value = {"Kwon?Ji Yong", "Choi?Seung-hyun", "Dong?Yong Bae", "Kang?Daesung"}, delimiter = '?')
    void csvSourceStringWithDifferentDelimiterValues(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvSourceIntDoubleStringFromCsvFile(String name, double price, int quantity, String unitOfMeasure, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unitOfMeasure = " + unitOfMeasure+ ", provider = " + provider);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist3.csv"}, numLinesToSkip = 1, delimiterString = "___")
    void csvSourceWithDifferentDelimiterValues(String name, double price, int quantity, String unitOfMeasure, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unitOfMeasure = " + unitOfMeasure+ ", provider = " + provider);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @MethodSource(value = "sourceString")
    void methodSourceString(String param1){
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString(){
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @MethodSource(value = "sourceStringAsStream")
    void methodSourceStringAsStream(String param2){
        System.out.println("param2 = " + param2);
    }

    Stream<String> sourceStringAsStream(){
        return Stream.of("beetroot", "apple", "pear");
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @MethodSource(value = "sourceListStringDouble")
    void methodSourceListStringDouble(String param3, double param4){
        System.out.println("param3 = " + param3 + ", param4 = " + param4);
    }

    List<Arguments> sourceListStringDouble(){
        return Arrays.asList(arguments("tomato", 2.0), arguments("carrot", 4.5), arguments("cabbage", 7.8));
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @MethodSource(value = "sourceStreamStringDouble")
    void methodSourceStreamStringDouble(String param3, double param4){
        System.out.println("param3 = " + param3 + ", param4 = " + param4);
    }

    Stream<Arguments> sourceStreamStringDouble(){
        return Stream.of(arguments("tomato", 2.0), arguments("carrot", 4.5), arguments("cabbage", 7.8));
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @MethodSource(value = "junit5tests.ParamProvider#methodSourceFromDifferentclass")
    void methodSourceFromDifferentclass(String param5, double param6){
        System.out.println("param3 = " + param5 + ", param4 = " + param6);
    }
}
