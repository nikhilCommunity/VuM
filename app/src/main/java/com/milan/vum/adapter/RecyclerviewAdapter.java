package com.milan.vum.adapter;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.milan.vum.R;
import com.milan.vum.utilities.ProjectConstants;
import com.milan.vum.viewholders.RecyclerViewHolder;

import java.util.ArrayList;


public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{



    private LayoutInflater mInflater;
    private String stringtag;
    private ArrayList arrayList;
    private Context context;
    private Bundle bundle;
    private Cursor cursor;

    public RecyclerviewAdapter(){}


    @Override
    public RecyclerViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        switch(stringtag){
            case ProjectConstants.Fragment_People:
                return new RecyclerViewHolder(mInflater.inflate(R.layout.people_row,parent,false),ProjectConstants.Fragment_People);
            case ProjectConstants.Fragment_ShareLog:
                return new RecyclerViewHolder(mInflater.inflate(R.layout.welcome_row,parent,false),ProjectConstants.Fragment_ShareLog);
            case ProjectConstants.Fragment_Welcome_One:
                return new RecyclerViewHolder(mInflater.inflate(R.layout.welcome_row,parent,false),ProjectConstants.Fragment_Welcome_One);
        }
        return null;

    }

    public RecyclerviewAdapter(Context context, String stringtag, ArrayList arrayList) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.stringtag=stringtag;
        this.arrayList=arrayList;
        this.context=context;
        bundle=new Bundle();
    }

    public RecyclerviewAdapter(Context context, String stringtag) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.stringtag=stringtag;
        this.context=context;
        bundle=new Bundle();
    }

    public RecyclerviewAdapter(Context context, String stringtag, Cursor cursor) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.stringtag=stringtag;
        this.cursor=cursor;
        this.context=context;
    }

    @Override
    public void onBindViewHolder( RecyclerViewHolder holder, int position) {
        switch (stringtag){
            case ProjectConstants.Fragment_People:
                break;
            case ProjectConstants.Fragment_Welcome_One:
                break;
            case ProjectConstants.Fragment_ShareLog:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }


}
