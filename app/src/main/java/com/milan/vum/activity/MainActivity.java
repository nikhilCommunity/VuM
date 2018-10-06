package com.milan.vum.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.milan.vum.R;
import com.milan.vum.fragment.SignUpFragmentOne;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            callFragment(new SignUpFragmentOne(),"Signupfrag1",null);
        }
    }

    public void callFragment(Fragment fragment, String stringtag, String addbacktostack) {

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,fragment,stringtag).addToBackStack(addbacktostack).commit();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
