package com.Utilites;

public class PinGenerator {

    String pin;

    public PinGenerator(){}

    public String generatePin(String userId, String requestId){
        int userIdLength = userId.length();
        pin = "";
        pin += userId.charAt(userIdLength-1);
        pin += userId.charAt(userIdLength-2);
        pin += requestId.charAt(3);
        pin += requestId.charAt(2);
        return Integer.toString(Integer.parseInt(this.pin));
    }

    public void clearPin(){
        pin = "";
    }

}
