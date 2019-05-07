package Validator;

import Domain.Nota;
import Exceptions.ValidatorException;

public class NotaValidator implements IValidator<Nota> {

    public void validate(Nota n) throws ValidatorException {
        String errors="";
        if(n.getId()<=0 || n.getId() == null || !(isNumeric(n.getId().toString()))){
            errors+="Id invalid\n";
        }
        if(n.getStudentId().equals("") || n.getStudentId()==null || !(isNumeric(n.getStudentId()))){
            errors+="Id student invalid\n";
        }
        if(n.getTemaLabId()<=0 || n.getTemaLabId() == null || !(isNumeric(n.getTemaLabId().toString()))){
            errors+="Id tema invalid\n";
        }
        if(n.getValoare()<=0 || n.getValoare()>10 ){
            errors+="Valoare invalida\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}