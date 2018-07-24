package com.example.ivan.savemoney.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.ivan.savemoney.Fuentes.Fuentes;
import com.example.ivan.savemoney.R;

/**
 * Created by ivan on 19/07/18.
 */

@SuppressLint("ValidFragment")
public class WelcomeDialog extends DialogFragment{
    private TextView txtWelcom;
    private String usuario;

    public WelcomeDialog(String usuario){
       this.usuario = usuario;
    }

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_welcome,null);
        builder.setView(view);
        inicializarCampos(view);

        if(usuario.equals("ivan_96.05@hotmail.com")){
            txtWelcom.setText("Bienvenido SR.Ivan");
        }else {
            txtWelcom.setText("Bienvenido " + usuario);
        }

        final AlertDialog dialog = builder.create();
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (null != dialog && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        },5000);

        return dialog;
    }

    private void inicializarCampos(View view) {
        txtWelcom = (TextView) view.findViewById(R.id.txtWelcomeUser);
        txtWelcom.setTypeface(Fuentes.WelcomeWarWound(getActivity()));
    }

}
