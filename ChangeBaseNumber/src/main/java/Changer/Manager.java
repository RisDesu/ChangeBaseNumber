/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Changer;

/**
 *
 * @author HP
 */
public class Manager {

    public static final char[] hexDigits = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    
    public static int menu(){
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 4);
        return choice;
    }

    public static int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = Validate.checkInputIntLimit(1, 2);
        return result;
    }

    public static void convertFromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: "
                        + convertBinaryToDecimal(binary)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertBinaryToHexa(binary));
                break;
        }
    }

    public static void convertFromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertDecimalToBinary(decimal)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertDecimalToHexa(decimal));
                break;
        }
    }

    public static void convertFromHexa(String hexa) {
        int choice = displayConvert("hexa", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertHexaToBinary(hexa)
                );
                break;
            case 2:
                System.out.println("Decimal: "
                        + convertHexaToDecimal(hexa));
                break;
        }
    }

    public static String convertBinaryToDecimal(String binary) {
        int decimalValue = 0;
        int base = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimalValue += base;
            }
            base *= 2;
        }
        return String.valueOf(decimalValue);
    }

    public static String convertBinaryToHexa(String binary) {
        String decimal = convertBinaryToDecimal(binary);
        return convertDecimalToHexa(decimal);
    }

    public static int convertHexaToDecimal(String hexadecimal) {
        int decimalValue = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            char c = hexadecimal.charAt(i);
            int digitValue;
            if (Character.isDigit(c)) {
                digitValue = c - '0';
            } else {
                digitValue = Character.toUpperCase(c) - 'A' + 10;
            }
            decimalValue = decimalValue * 16 + digitValue;
        }
        return decimalValue;
    }

    public static String convertHexaToBinary(String hexadecimal) {
        String binary = "";
        for (int i = 0; i < hexadecimal.length(); i++) {
            char c = hexadecimal.charAt(i);
            int digitValue;
            if (Character.isDigit(c)) {
                digitValue = c - '0';
            } else {
                digitValue = Character.toUpperCase(c) - 'A' + 10;
            }
            String binaryValue = Integer.toBinaryString(digitValue);
            while (binaryValue.length() < 4) {
                binaryValue = "0" + binaryValue;
            }
            binary += binaryValue;
        }
        return binary;
    }

    public static String convertDecimalToBinary(String decimal) {
        int decimalValue = Integer.parseInt(decimal);
        StringBuilder binary = new StringBuilder();
        while (decimalValue > 0) {
            binary.insert(0, decimalValue % 2);
            decimalValue /= 2;
        }
        return binary.toString();
    }

    public static String convertDecimalToHexa(String decimal) {
        int decimalValue = Integer.parseInt(decimal);
        StringBuilder hexa = new StringBuilder();
        while (decimalValue > 0) {
            hexa.insert(0, hexDigits[decimalValue % 16]);
            decimalValue /= 16;
        }
        return hexa.toString();
    }
}

