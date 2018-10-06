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
public class SignUpFragmentTwo extends Fragment implements View.OnClickListener{


    public SignUpFragmentTwo() {
        // Required empty public constructor
    }

    private Button nextButton_signupfragmentwo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View signupfragmenttwo= inflater.inflate(R.layout.fragment_sign_up_fragment_two, container, false);
            nextButton_signupfragmentwo=signupfragmenttwo.findViewById(R.id.next_button_signupfragmenttwo);
            nextButton_signupfragmentwo.setOnClickListener(this);
        return signupfragmenttwo;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.next_button_signupfragmenttwo:
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.callFragment(new SignUpFragmentTwoB(),"SignUpFragmentTwoB",null);
                break;
        }
    }
}
