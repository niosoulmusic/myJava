package com.riccio.extendsImplements;

public class DeskPhone implements ITelephone {
    @Override
    public void powerOn() {

    }

    @Override
    public void Dial(int phoneNumber) {

    }

    @Override
    public void Answer() {

    }

    @Override
    public boolean CallPhone(int phoneNumber) {
        return false;
    }

    @Override
    public boolean isRinging() {
        return false;
    }
}
