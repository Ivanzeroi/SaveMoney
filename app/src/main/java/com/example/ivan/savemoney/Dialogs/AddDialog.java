package com.example.ivan.savemoney.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.ivan.savemoney.R;

/**
 * Created by ivan on 11/07/18.
 */

@SuppressLint("ValidFragment")
public class AddDialog extends DialogFragment{
    Button btnAddMoney,btnCancel;

    public AddDialog(){
    }
    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add,null);
        builder.setView(view);
        inicializarCampos(view);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        btnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });



        final AlertDialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

    private void inicializarCampos(View view) {
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnAddMoney = (Button) view.findViewById(R.id.btnAddMoney);
    }
}
