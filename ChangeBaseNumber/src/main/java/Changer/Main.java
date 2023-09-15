/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Changer;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    String binary = Validate.checkInputBinary();
                    Manager.convertFromBinary(binary);
                    break;
                case 2:
                    String decimal = Validate.checkInputDecimal();
                    Manager.convertFromDecimal(decimal);
                    break;
                case 3:
                    String hexa = Validate.checkInputHexaDecimal();
                    Manager.convertFromHexa(hexa);
                    break;
                case 4:
                    return;
            }
        }
    }
}
