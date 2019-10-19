package com.jhonatan.bombillos;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.ext.nio.HttpServerHelper;
import org.restlet.routing.Router;

public class RESTfulService extends IntentService {
//El servidor HTTP correrá como servicio en segundo plano como un hilo separado de la actividad de la interfaz de usuario.
//Esto iniciará una instancia del servidor HTTP en el puerto 8080 para poder gestionar la solicitud que viene en dicho puerto.
//Este servicio proporciona acciones de intención que el "main activity" puede usar para iniciar y detener el servidor.


    private static final String ACTION_START = "com.jhonatan.bombillos.action.START";
    private static final String ACTION_STOP = "com.jhonatan.bombillos.action.STOP";

    private Component control;

    public RESTfulService() {
        super("RESTfulService");
        Engine.getInstance().getRegisteredServers().clear();
        Engine.getInstance().getRegisteredServers().add(new HttpServerHelper(null));
        control = new Component();
        control.getServers().add(Protocol.HTTP, 8080);
        Router routerPin2 = new Router(control.getContext().createChildContext());
        Router routerPin3 = new Router(control.getContext().createChildContext());
        Router routerPin4 = new Router(control.getContext().createChildContext());
        Router routerPin5 = new Router(control.getContext().createChildContext());
        Router routerPin6 = new Router(control.getContext().createChildContext());
        Router routerPin7 = new Router(control.getContext().createChildContext());
        Router routerPin8 = new Router(control.getContext().createChildContext());
        Router routerPin9 = new Router(control.getContext().createChildContext());
        Router routerPin10 = new Router(control.getContext().createChildContext());
        Router routerPin11 = new Router(control.getContext().createChildContext());
        Router routerPin12 = new Router(control.getContext().createChildContext());
        Router routerPin13 = new Router(control.getContext().createChildContext());
        Router routerPin14 = new Router(control.getContext().createChildContext());
        Router routerPin15 = new Router(control.getContext().createChildContext());
        Router routerPin16 = new Router(control.getContext().createChildContext());
        Router routerPin17 = new Router(control.getContext().createChildContext());
        Router routerPin18 = new Router(control.getContext().createChildContext());
        Router routerPin19 = new Router(control.getContext().createChildContext());
        Router routerPin20 = new Router(control.getContext().createChildContext());
        Router routerPin21 = new Router(control.getContext().createChildContext());
        Router routerPin22 = new Router(control.getContext().createChildContext());
        Router routerPin23 = new Router(control.getContext().createChildContext());
        Router routerPin24 = new Router(control.getContext().createChildContext());
        Router routerPin25 = new Router(control.getContext().createChildContext());
        Router routerPin26 = new Router(control.getContext().createChildContext());
        Router routerPin27 = new Router(control.getContext().createChildContext());

        routerPin6.attach("/pin6", Pin6Controller.class);
        routerPin17.attach("/pin17", Pin17Controller.class);
        routerPin22.attach("/pin22", Pin22Controller.class);

        control.getDefaultHost().attach("/restPin6", routerPin6);
        control.getDefaultHost().attach("/restPin17", routerPin17);
        control.getDefaultHost().attach("/restPin22", routerPin22);
    }

    public static void startServer(Context context) {
        Intent intent = new Intent(context, RESTfulService.class);
        intent.setAction(ACTION_START);
        context.startService(intent);
    }

    public static void stopServer(Context context) {
        Intent intent = new Intent(context, RESTfulService.class);
        intent.setAction(ACTION_STOP);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_START.equals(action)) {
                handleStart();
            } else if (ACTION_STOP.equals(action)) {
                handleStop();
            }
        }
    }

    private void handleStart() {
        try {
            control.start();
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), e.toString());
        }
    }

    private void handleStop() {
        try {
            control.stop();
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), e.toString());
        }
    }
}
