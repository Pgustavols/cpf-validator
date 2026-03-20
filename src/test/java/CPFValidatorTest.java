import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CpfValidatorTest {
    private CpfValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CpfValidator();
    }

    @Test
    void nullOrEmptyCpfShouldReturnFalse() {
        assertFalse(validator.validate(null));
        assertFalse(validator.validate(""));
        assertFalse(validator.validate("   "));
    }



    @Test
    void cpfWithInvalidCharactersShouldReturnFalse() {
        assertFalse(validator.validate("5299822472A"));
        assertFalse(validator.validate("529.982.247+25"));
    }

    @Test
    void cpfWithWrongLengthShouldReturnFalse() {
        assertFalse(validator.validate("1234567890"));    // 10 dígitos
        assertFalse(validator.validate("123456789012"));  // 12 dígitos
    }


    @Test
    void cpfWithAllSameDigitsShouldReturnFalse() {
        assertFalse(validator.validate("00000000000"));
        assertFalse(validator.validate("111.111.111-11"));
        assertFalse(validator.validate("99999999999"));
    }


    @Test
    void cpfWithInvalidFirstVerifierShouldReturnFalse() {
        assertFalse(validator.validate("12345678900")); // dígito 1 errado
    }

    @Test
    void cpfWithInvalidSecondVerifierShouldReturnFalse() {
        assertFalse(validator.validate("12345678908")); // dígito 2 errado
    }
    @Test
    void validCpfWithoutMaskShouldReturnTrue() {
        assertTrue(validator.validate("52998224725"));
        assertTrue(validator.validate("11144477735"));
    }
    @Test
    void validCpfWithMaskShouldReturnTrue() {
        assertTrue(validator.validate("529.982.247-25"));
        assertTrue(validator.validate("111.444.777-35"));
    }
}