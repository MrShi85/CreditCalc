package com.shilkinsergey.android.creditcalc;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Sergey Shilkin on 08.07.2016.
 */
public class DialogClass extends DialogFragment {

    private ImageView mImageView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_date, null);

        mImageView = (ImageView) v.findViewById(R.id.imageView1);
        mImageView.setImageResource(R.drawable.img1);


        //mImageView.setImageResource(R.drawable.img3);

        return new AlertDialog.Builder(getActivity()).setView(v)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_button_ok,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create();
    }
}
