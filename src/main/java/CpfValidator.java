public class CpfValidator {

    public boolean validate(String cpf) {
        if(cpf == null || cpf.isBlank()) return false;

        cpf = cpf.replaceAll("[.\\\\-]", "");

        if(cpf.length() != 11) return false;
        if(!cpf.matches("\\d{11}")) return false;

        if(cpf.chars().distinct().count() == 1) return false;
        if(!DigitVerifier.check(cpf, 1)) return false;
        if (!DigitVerifier.check(cpf, 2))return false;
        return true;
    }
}
