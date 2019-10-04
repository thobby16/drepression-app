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
public class QuestionSFragment extends Fragment {


    public QuestionSFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4;
    int valueS;
    QuestionTFragment questionTFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_s, container, false);
        option1 = view.findViewById(R.id.option_s1);
        option2 = view.findViewById(R.id.option_s2);
        option3 = view.findViewById(R.id.option_s3);
        option4 = view.findViewById(R.id.option_s4);

        if(option1.isChecked()){
            valueS= 0;
        }else if (option2.isChecked()){
            valueS=1;
        }else if (option3.isChecked()){
            valueS = 2;
        }else if (option4.isChecked()){
            valueS = 3;
        }else{
            valueS =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueR = getArguments().getInt("currentValueR");

        TextView next = view.findViewById(R.id.next_s);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionTFragment = new QuestionTFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionTFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueS = valueS+ valueR;
                bundle.putInt("currentValueS", valueS);
                questionTFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
