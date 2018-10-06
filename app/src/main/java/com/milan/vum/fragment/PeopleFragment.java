package com.milan.vum.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.milan.vum.R;
import com.milan.vum.adapter.RecyclerviewAdapter;
import com.milan.vum.utilities.ProjectConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {


    public PeopleFragment() {
        // Required empty public constructor
    }

    RecyclerView recycelrview_peoplefrag;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View people_fragment= inflater.inflate(R.layout.fragment_people, container, false);
        recycelrview_peoplefrag=people_fragment.findViewById(R.id.recyclerview_peopelFrag);

        callRecyclerview();

        return people_fragment;
    }

    public void callRecyclerview(){

        // declare variable of recyclerviewadapter and call its constructor by passing arraylist and context
        RecyclerviewAdapter recyclerviewAdapter=new RecyclerviewAdapter(getActivity(), ProjectConstants.Fragment_People);

        // create linearlayoutmanager and set it to the recyclerview
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recycelrview_peoplefrag.setLayoutManager(linearLayoutManager);

        // Now set the recyclerview adapter to recyclerview
        recycelrview_peoplefrag.setAdapter(recyclerviewAdapter);

    }

}
