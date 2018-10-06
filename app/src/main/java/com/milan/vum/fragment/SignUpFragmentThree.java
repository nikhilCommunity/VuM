package com.milan.vum.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.milan.vum.R;
import com.milan.vum.activity.HomeActivity;
import com.milan.vum.javafiles.CircleImageView;
import com.milan.vum.utilities.ProjectConstants;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragmentThree extends Fragment implements View.OnClickListener{


    public SignUpFragmentThree() {
        // Required empty public constructor
    }

    Button forward_button_signupfragthree,submit_button_sign_upfragment_three;
    CircleImageView circleImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View signupfragmentthree= inflater.inflate(R.layout.fragment_sign_up_fragment_three, container, false);
        forward_button_signupfragthree=signupfragmentthree.findViewById(R.id.forward_button_signupfragthree);
        forward_button_signupfragthree.setOnClickListener(this);
        circleImageView =signupfragmentthree.findViewById(R.id.signupcircleimageview);
        circleImageView.setOnClickListener(this);
        submit_button_sign_upfragment_three=signupfragmentthree.findViewById(R.id.submit_button_sign_upfragment_three);
        submit_button_sign_upfragment_three.setOnClickListener(this);
        return signupfragmentthree;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.forward_button_signupfragthree:
                Intent intent=new Intent(getActivity(),HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.submit_button_sign_upfragment_three:
                dispatchTakePictureIntent();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ProjectConstants.REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            circleImageView.setImageBitmap(imageBitmap);
            String encodeimage = encodeTobase64(imageBitmap);
            SharedPreferences.Editor editor = getActivity().getSharedPreferences(ProjectConstants.MyPREFERENCES, Context.MODE_PRIVATE).edit();
            editor.putString("imagePreference", encodeimage);
            editor.commit();
        }
    }

    // method for bitmap to base64
    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }





    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, ProjectConstants.REQUEST_IMAGE_CAPTURE);
        }
    }
}
