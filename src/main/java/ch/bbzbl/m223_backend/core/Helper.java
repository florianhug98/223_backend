package ch.bbzbl.m223_backend.core;

public class Helper {

    private Helper (){
    }

    public static boolean validateID(String id){
        String regex = "\\d+";
        return id != null
                && !"".equals(id)
                && id.matches(regex);
    }
}
