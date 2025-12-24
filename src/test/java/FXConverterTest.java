import org.example.FXConverter;
import org.example.RemoteFXRateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FXConverterTest {

    private RemoteFXRateService service = mock(RemoteFXRateService.class);

    private FXConverter converter = new FXConverter(service);

    @Test
    @DisplayName("Given 100.00 USD, when convert to USD, then return 100.00")
    void test1() {
        when(service.getRate("USD", "USD")).thenReturn("1.0000");
        BigDecimal result = converter.convert("USD", "USD", "100.00");
        assertEquals("100.00", result.toString());
    }

    @Test
    @DisplayName("Given 50.00 USD, when convert to RUB, then return 3929.00")
    void test2() {
        when(service.getRate("USD", "RUB")).thenReturn("78.58");
        BigDecimal result = converter.convert("USD", "RUB", "50.00");
        assertEquals("3929.00", result.toString());
    }

    @Test
    @DisplayName("Given 100.00 USD, when convert to EUR, then return 84.97")
    void test3() {
        when(service.getRate("USD", "EUR")).thenReturn("0.8497");

        BigDecimal result = converter.convert("USD", "EUR", "100.00");

        assertEquals("84.97", result.toString());
    }

    @Test
    @DisplayName("Given 80.00 USD, when convert to GBP, then return 58.13")
    void test4() {
        // 1st arg is "USD" and 2nd arg is any string that contains "coin"
        when(service.getRate(eq("USD"), contains("coin")))
                .thenReturn("0.0000");

        // both 1st arg and 2nd arg is any string
        when(service.getRate(anyString(), anyString())).thenReturn("42");

        // 1st arg is any string that starts with "US"
        // and 2nd arg is any string that ends with "BP"
        when(service.getRate(startsWith("US"), endsWith("BP")))
                .thenReturn("0.7266");
        BigDecimal result = converter.convert("USD", "GBP", "80.00");
        assertEquals("58.13", result.toString());
    }

    @Test
    @DisplayName("Given any args, when service throws exception, then return -1.00")
    void test5() {
        when(service.getRate(anyString(), anyString()))
                .thenThrow(new IllegalStateException());

        BigDecimal result =
                converter.convert("USD", "EUR", "100.00");

        assertEquals("-1.00", result.toString());
    }
}