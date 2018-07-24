package com.example.ivan.savemoney.Fuentes;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by ivan on 20/07/18.
 */

public class Fuentes {
    public static Typeface WelcomeActionComics(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/Action Comics.ttf");
    }

    public static Typeface WelcomeWarWound(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/WarWound.otf");
    }
}
