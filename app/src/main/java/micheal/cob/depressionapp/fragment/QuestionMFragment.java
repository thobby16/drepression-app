package micheal.cob.depressionapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import micheal.cob.depressionapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionMFragment extends Fragment {


    public QuestionMFragment() {
        // Required empty public constructor
    }

    CheckBox option1,option2,option3,option4;
    int valueM;
    QuestionNFragment questionNFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_m, container, false);
        option1 = view.findViewById(R.id.option_m1);
        option2 = view.findViewById(R.id.option_m2);
        option3 = view.findViewById(R.id.option_m3);
        option4 = view.findViewById(R.id.option_m4);


        if(option1.isChecked()){
            valueM=0;
        }else if (option2.isChecked()){
            valueM=1;
        }else if (option3.isChecked()){
            valueM = 2;
        }else if (option4.isChecked()){
            valueM = 3;
        }else{
            valueM =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueL = getArguments().getInt("currentValueL");

        TextView next = view.findViewById(R.id.next_m);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionNFragment = new QuestionNFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionNFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueM = valueM+ valueL;
                bundle.putInt("currentValueM", valueM);
                questionNFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
