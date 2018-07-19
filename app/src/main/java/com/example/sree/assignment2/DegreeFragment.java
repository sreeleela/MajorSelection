package com.example.sree.assignment2;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;


public class DegreeFragment extends ListFragment  implements
        AdapterView.OnItemClickListener {
    String[] degreeData;
    DegreeSelectionListener degreeSelectionListener;
    Button back;
    BackFromDegree backFromDegree;
    View inflatedView = null;

    public DegreeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflatedView = inflater.inflate(R.layout.fragment_degree, container, false);
        back = (Button) inflatedView.findViewById(R.id.degreeBackBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backFromDegree = (BackFromDegree) getActivity();
                backFromDegree.backFromDegree(view);
            }
        });
        // Inflate the layout for this fragment
        return inflatedView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        String degree = parent.getItemAtPosition(position).toString();
        degreeSelectionListener = (DegreeSelectionListener) getActivity();
        degreeSelectionListener.getMajorForDegree(position,degree,view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, degreeData);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    public void setDegree(String[] degree){
        degreeData = degree;
    }
}

interface DegreeSelectionListener{
    public void getMajorForDegree(int position,String degree,View view);
}

interface BackFromDegree{
    public void backFromDegree(View view);
}