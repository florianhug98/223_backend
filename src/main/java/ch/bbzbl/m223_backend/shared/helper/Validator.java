package ch.bbzbl.m223_backend.shared.helper;

public class Validator {

    private Validator (){
    }

    public static boolean validateID(String id){
        String regex = "\\d+";
        return id != null
                && !"".equals(id)
                && id.matches(regex);
    }
}
