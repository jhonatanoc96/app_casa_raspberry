package com.jhonatan.bombillos;

import java.io.IOException;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;

public class Pin6 {
//Clase con getter & setter para el pin 6. (Para obtener y cambiar su estado)

    private static Pin6 instance = null;
    private PeripheralManager pms;
    private Gpio pin6;

    public static Pin6 getInstance() {
        if (instance == null) {
            instance = new Pin6();
        }
        return instance;
    }

    private Pin6() {
        pms = PeripheralManager.getInstance();
        try {
            pin6 = pms.openGpio("BCM6");
            pin6.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setState(boolean state) {
        try {
            getInstance().pin6.setValue(state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean getState() {
        boolean value = false;
        try {
            value = getInstance().pin6.getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

}
