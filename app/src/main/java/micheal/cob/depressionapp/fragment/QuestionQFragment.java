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
public class QuestionQFragment extends Fragment {


    public QuestionQFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4;
    int valueQ;
    QuestionRFragment questionRFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_q, container, false);

        option1 = view.findViewById(R.id.option_q1);
        option2 = view.findViewById(R.id.option_q2);
        option3 = view.findViewById(R.id.option_q3);
        option4 = view.findViewById(R.id.option_q4);

        if(option1.isChecked()){
            valueQ= 0;
        }else if (option2.isChecked()){
            valueQ=1;
        }else if (option3.isChecked()){
            valueQ = 2;
        }else if (option4.isChecked()){
            valueQ = 3;
        }else{
            valueQ =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueP = getArguments().getInt("currentValueP");

        TextView next = view.findViewById(R.id.next_q);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionRFragment = new QuestionRFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionRFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueQ = valueQ+ valueP;
                bundle.putInt("currentValueQ", valueQ);
                questionRFragment.setArguments(bundle);
            }
        });


        return view;
    }

}
