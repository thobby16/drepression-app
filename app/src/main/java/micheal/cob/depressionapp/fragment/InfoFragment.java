package micheal.cob.depressionapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import micheal.cob.depressionapp.R;
import micheal.cob.depressionapp.fragment.CausesFragment;
import micheal.cob.depressionapp.fragment.QuestionAFragment;
import micheal.cob.depressionapp.fragment.TypesFragment;
import micheal.cob.depressionapp.fragment.WhatFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {


    public InfoFragment() {
        // Required empty public constructor
    }

    WhatFragment whatFragment;
    CausesFragment causesFragment;
    TypesFragment typesFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        TextView what = view.findViewById(R.id.what);
        what.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whatFragment = new WhatFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, whatFragment);
                fragmentTransaction.commit();
            }
        });

        final TextView causes = view.findViewById(R.id.causes);
        causes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causesFragment = new CausesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, causesFragment);
                fragmentTransaction.commit();
            }
        });

        final TextView types = view.findViewById(R.id.types);
        types.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typesFragment = new TypesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, typesFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
