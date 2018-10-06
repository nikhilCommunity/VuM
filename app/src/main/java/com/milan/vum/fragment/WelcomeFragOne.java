package com.milan.vum.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Space;

import com.milan.vum.R;
import com.milan.vum.activity.HomeActivity;
import com.milan.vum.adapter.RecyclerviewAdapter;
import com.milan.vum.javafiles.CircleImageView;
import com.milan.vum.utilities.ProjectConstants;

import static com.milan.vum.activity.HomeActivity.decodeBase64;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragOne extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener{


    public WelcomeFragOne() {
        // Required empty public constructor
    }


    private RecyclerView recyclerView_welcomefrag;
    //private TextView sharelogtext_welcomefrag,peopletext_welcomefrag;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RelativeLayout relativeLayout;
    private Space space,spacenew;
    private CircleImageView welcome_frag_circularimage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View welcomeFragOne= inflater.inflate(R.layout.fragment_welcome_frag_one, container, false);
        welcome_frag_circularimage=welcomeFragOne.findViewById(R.id.welcome_frag_circularimage);
        welcome_frag_circularimage.setOnClickListener(this);
        recyclerView_welcomefrag=welcomeFragOne.findViewById(R.id.recyclerview_welcomeFragOne);
       // swipeRefreshLayout=welcomeFragOne.findViewById(R.id.swiperefresh);
        //swipeRefreshLayout.setOnRefreshListener(this);
        relativeLayout=welcomeFragOne.findViewById(R.id.innerrelativelayout_welcomefragfment);
        //space=welcomeFragOne.findViewById(R.id.spaceview);

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences(ProjectConstants.MyPREFERENCES, Context.MODE_PRIVATE);
        Bitmap bitmap=decodeBase64(sharedPreferences.getString("imagePreference",null));
        if(bitmap!=null)
        welcome_frag_circularimage.setImageBitmap(bitmap);

        callRecyclerview();

        return welcomeFragOne;
    }


    public void callRecyclerview(){

        // declare variable of recyclerviewadapter and call its constructor by passing arraylist and context
        RecyclerviewAdapter recyclerviewAdapter=new RecyclerviewAdapter(getActivity(), ProjectConstants.Fragment_Welcome_One);

        // create linearlayoutmanager and set it to the recyclerview
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView_welcomefrag.setLayoutManager(linearLayoutManager);

        // Now set the recyclerview adapter to recyclerview
        recyclerView_welcomefrag.setAdapter(recyclerviewAdapter);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.welcome_frag_circularimage:
                HomeActivity homeActivity= (HomeActivity) getActivity();
                homeActivity.callDialogFragment(ProjectConstants.DialogFragment_Bio,null,getActivity());
        }

    }

    @Override
    public void onRefresh() {

    }
}
