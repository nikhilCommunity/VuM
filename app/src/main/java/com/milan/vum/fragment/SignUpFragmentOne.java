package com.milan.vum.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.milan.vum.R;
import com.milan.vum.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragmentOne extends Fragment implements View.OnClickListener{


    public SignUpFragmentOne() {
        // Required empty public constructor
    }

    private Button submitButton_signupfragmentone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View signupfragmentone= inflater.inflate(R.layout.fragment_sign_up_fragment_one, container, false);
            submitButton_signupfragmentone=signupfragmentone.findViewById(R.id.submit_button_sign_upfragment_one);
            submitButton_signupfragmentone.setOnClickListener(this);
        return signupfragmentone;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit_button_sign_upfragment_one:
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.callFragment(new SignUpFragmentTwo(),"SignUpFragmentTwo",null);
                break;
        }
    }
}
