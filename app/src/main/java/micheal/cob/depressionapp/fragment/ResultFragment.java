package micheal.cob.depressionapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import micheal.cob.depressionapp.HomeActivityFragment;
import micheal.cob.depressionapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {


    public ResultFragment() {
        // Required empty public constructor
    }

    TextView score, comment;
    HomeActivityFragment homeActivityFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        final int valueSum = getArguments().getInt("currentValueU");

        score = view.findViewById(R.id.score);
        comment = view.findViewById(R.id.comment);

        score.setText(String.valueOf(valueSum));

        if (valueSum>=0 || valueSum<=9){
            comment.setText("Normal");
        }else if(valueSum>=10 || valueSum<=15){
            comment.setText("Mild Depression");
        }else if (valueSum>=16 || valueSum<=19){
            comment.setText("Mild Moderate Depression");
        }else if (valueSum>=20 || valueSum<=29){
            comment.setText("Moderate Severe");
        }else if (valueSum>=30 || valueSum<=63){
            comment.setText("Severe Depression");
        }else{
            comment.setText("Bad Depression state");
        }

        TextView toHome = view.findViewById(R.id.transit);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivityFragment = new HomeActivityFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, homeActivityFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
