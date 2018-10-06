package com.milan.vum.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.milan.vum.R;
import com.milan.vum.adapter.RecyclerviewAdapter;
import com.milan.vum.utilities.ProjectConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareLogFragment extends Fragment implements View.OnClickListener{


    public ShareLogFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerview_sharelog;
    private TextView sharelog_text_onclick,favourites_text_onclick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sharelogfragment= inflater.inflate(R.layout.fragment_share_log, container, false);
            recyclerview_sharelog=sharelogfragment.findViewById(R.id.recyclerview_sharelog);
        sharelog_text_onclick=sharelogfragment.findViewById(R.id.sharelog_text_onclick);
        favourites_text_onclick=sharelogfragment.findViewById(R.id.favourites_text_onclick);
        sharelog_text_onclick.setOnClickListener(this);
        favourites_text_onclick.setOnClickListener(this);
            callRecyclerview();

        return sharelogfragment;
    }

    public void callRecyclerview(){

        // declare variable of recyclerviewadapter and call its constructor by passing arraylist and context
        RecyclerviewAdapter recyclerviewAdapter=new RecyclerviewAdapter(getActivity(), ProjectConstants.Fragment_ShareLog);

        // create linearlayoutmanager and set it to the recyclerview
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerview_sharelog.setLayoutManager(linearLayoutManager);

        // Now set the recyclerview adapter to recyclerview
        recyclerview_sharelog.setAdapter(recyclerviewAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.favourites_text_onclick:
                favourites_text_onclick.setTextColor(Color.WHITE);
                favourites_text_onclick.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.favouritesshape));
                sharelog_text_onclick.setBackground(null);
                sharelog_text_onclick.setTextColor(Color.BLACK);
                break;
            case R.id.sharelog_text_onclick:
                sharelog_text_onclick.setTextColor(Color.WHITE);
                sharelog_text_onclick.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.sharelogshape));
                favourites_text_onclick.setBackground(null);
                favourites_text_onclick.setTextColor(Color.BLACK);
                break;
        }
    }
}
