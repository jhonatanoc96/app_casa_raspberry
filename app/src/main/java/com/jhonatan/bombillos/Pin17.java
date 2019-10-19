package com.jhonatan.bombillos;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;

import java.io.IOException;

public class Pin17  {
    //Clase con getter & setter para el pin 17. (Para obtener y cambiar su estado)

    private static Pin17 instance = null;
    private PeripheralManager pms;
    private Gpio pin17;

    public static Pin17 getInstance() {
        if (instance == null) {
            instance = new Pin17();
        }
        return instance;
    }

    private Pin17() {
        pms = PeripheralManager.getInstance();
        try {
            pin17 = pms.openGpio("BCM17");
            pin17.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setState(boolean state) {
        try {
            getInstance().pin17.setValue(state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean getState() {
        boolean value = false;
        try {
            value = getInstance().pin17.getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

}
