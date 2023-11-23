package com.Utilites;

public class PinGenerator {

    int pin;

    public PinGenerator(){}

    public String generatePin(){
        pin = 1000;
        return Integer.toString(this.pin);
    }


}
