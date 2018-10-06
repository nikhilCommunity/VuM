package com.milan.vum.fragment;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;

import com.milan.vum.R;
import com.milan.vum.javafiles.CircleImageView;
import com.milan.vum.utilities.ProjectConstants;

import static com.milan.vum.activity.HomeActivity.decodeBase64;

/**
 * A simple {@link Fragment} subclass.
 */
public class BioDialogFragment extends DialogFragment {


    public BioDialogFragment() {
        // Required empty public constructor
    }

    Dialog d=null;
    CircleImageView fragment_bio_dialog_circleimage;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Declare and Initialize alert dialog
        AlertDialog.Builder ab=new AlertDialog.Builder(getActivity());

        View v=getActivity().getLayoutInflater().inflate(R.layout.fragment_bio_dialog,null);
        fragment_bio_dialog_circleimage=v.findViewById(R.id.fragment_bio_dialog_circleimage);

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences(ProjectConstants.MyPREFERENCES, Context.MODE_PRIVATE);
        Bitmap bitmap=decodeBase64(sharedPreferences.getString("imagePreference",null));
        if(bitmap!=null)
        fragment_bio_dialog_circleimage.setImageBitmap(bitmap);

        // set view to the alert dialog object reference variable
        ab.setView(v);


        ab.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if ((i ==  android.view.KeyEvent.KEYCODE_BACK))
                {
                    /*//This is the filter
                    if (keyEvent.getAction()!=KeyEvent.ACTION_DOWN)
                        return true;
                    else
                    {
                        //Hide your keyboard here!!!!!!
                        return true; // pretend we've processed it
                    }*/
                    final View decorView = getDialog()
                            .getWindow()
                            .getDecorView();

                    ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(decorView,
                            PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f),
                            PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f),
                            PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));

                    scaleDown.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            dismiss();
                        }
                    });
                    scaleDown.setDuration(2000);
                    scaleDown.start();
                    return true;
                }
                else
                    return false;
            }
        });

        // create dialog
        d=ab.create();

/*
        // create window manager object to edit default layout of the dialog window appear on the screen
        WindowManager.LayoutParams params = d.getWindow().getAttributes();
        params.gravity =  Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM;// set the dialog where ever you want to see
        d.getWindow().setAttributes(params);// At end set param attribute

*/

        return d;
    }

    @Override
    public void onStart() {
        super.onStart();

       // AlertDialog dialog = (AlertDialog)getDialog();

        final View decorView = getDialog()
                .getWindow()
                .getDecorView();

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(decorView,
                PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
                PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f),
                PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        scaleDown.setDuration(2000);
        scaleDown.start();

    }
}
