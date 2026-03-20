public final class DigitVerifier {
    public static boolean check(String cpf, int digitVerifier) {
        if(cpf.length() != 11){
            throw new IllegalArgumentException("A CPF(Brazilian Taxpayer ID) must have 11 digits.");
        }

        if(digitVerifier != 1 && digitVerifier != 2){
            throw new IllegalArgumentException("Digit verifier must be 1 or 2.");
        }

        int j = digitVerifier == 1 ? 10 : 11;
        int sum = 0;
        for(int i = 0; i < j-1; i++){
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (j - i);
        }
        int numberChecked = (sum * 10) % 11;
        if(numberChecked == 10 || numberChecked == 11) numberChecked = 0;

        return numberChecked == Character.getNumericValue(cpf.charAt(j - 1));
    }

}