package com.bci.peopledata.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import com.bci.peopledata.entitys.Peoples;

public class ValidateEmail {

    public static void main(String[] args) {
    	
    	ValidateEmail mValidarCorreo = new ValidateEmail();
        Peoples vEmail = new Peoples();
        
        if (mValidarCorreo.ValidarEmail(vEmail.getEmail())) {
        	
            JOptionPane.showMessageDialog(null, "Correcto");
            
        } else {
        	
            JOptionPane.showMessageDialog(null, "Incorrecto");
            
        }

    }
    
    
    public boolean ValidarEmail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
	
}
