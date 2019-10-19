package com.jhonatan.bombillos;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;

import java.io.IOException;

public class Pin22 {
    //Clase con getter & setter para el pin 22. (Para obtener y cambiar su estado)

    private static Pin22 instance = null;
    private PeripheralManager pms;
    private Gpio pin22;

    public static Pin22 getInstance() {
        if (instance == null) {
            instance = new Pin22();
        }
        return instance;
    }

    private Pin22() {
        pms = PeripheralManager.getInstance();
        try {
            pin22 = pms.openGpio("BCM22");
            pin22.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setState(boolean state) {
        try {
            getInstance().pin22.setValue(state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean getState() {
        boolean value = false;
        try {
            value = getInstance().pin22.getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
