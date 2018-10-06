package com.milan.vum.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.milan.vum.R;
import com.milan.vum.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragmentTwoB extends Fragment implements View.OnClickListener{


    public SignUpFragmentTwoB() {
        // Required empty public constructor
    }


    Button next_button_signupfragmenttwoB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View signupfragmenttwoB= inflater.inflate(R.layout.fragment_sign_up_fragment_two_b, container, false);
        next_button_signupfragmenttwoB=signupfragmenttwoB.findViewById(R.id.next_button_signupfragmenttwoB);
        next_button_signupfragmenttwoB.setOnClickListener(this);
        Log.d("nikhil", "onCreateView: ");
        return signupfragmenttwoB;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next_button_signupfragmenttwoB:
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.callFragment(new SignUpFragmentThree(),"SignUpFragmentThree",null);
                break;
        }
    }
}
