/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLogic;

import java.awt.TextField;
import javax.swing.JTextField;

/**
 *
 * @author danie
 */
public class Validator {
    public static boolean isValidName(JTextField letter) {
       for (int i = 0; i < letter.getText().length(); i++) {
            if (!Character.isLetter(letter.getText().charAt(i)))
                return false;
        }
        return true;
    }

    public boolean isValidNumber(TextField number) {
        for (int i = 0; i < number.getText().length(); i++) {
            if (!Character.isDigit(number.getText().charAt(i)))
                return false;
        }
        return true;
    }

}
