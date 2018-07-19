package com.example.sree.assignment2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;


public class MajorFragment extends ListFragment implements
        AdapterView.OnItemClickListener {

    MajorSelectionListener majorSelectionListener;
    String[] majorData;
    Button back;
    BackFromMajor backFromMajor;
    View inflatedView = null;

    public MajorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflatedView = inflater.inflate(R.layout.fragment_major, container, false);
        back = (Button) inflatedView.findViewById(R.id.majorBackBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backFromMajor = (BackFromMajor) getActivity();
                backFromMajor.backFromMajor(view);
            }
        });
        // Inflate the layout for this fragment
        return inflatedView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        String major = parent.getItemAtPosition(position).toString();
        majorSelectionListener = (MajorSelectionListener) getActivity();
        majorSelectionListener.getMajor(position,major,view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, majorData);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    public void setMajor(String[] major){
        majorData = major;
    }
}
interface MajorSelectionListener{
    public void getMajor(int position,String major,View view);
}
interface BackFromMajor{
    public void backFromMajor(View view);
}