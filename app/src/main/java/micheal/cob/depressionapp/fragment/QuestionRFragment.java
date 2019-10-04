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
public class QuestionRFragment extends Fragment {


    public QuestionRFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4;
    int valueR;
    QuestionSFragment questionSFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_r, container, false);
        option1 = view.findViewById(R.id.option_r1);
        option2 = view.findViewById(R.id.option_r2);
        option3 = view.findViewById(R.id.option_r3);
        option4 = view.findViewById(R.id.option_r4);

        if(option1.isChecked()){
            valueR= 0;
        }else if (option2.isChecked()){
            valueR=1;
        }else if (option3.isChecked()){
            valueR = 2;
        }else if (option4.isChecked()){
            valueR = 3;
        }else{
            valueR =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueQ = getArguments().getInt("currentValueQ");

        TextView next = view.findViewById(R.id.next_r);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionSFragment = new QuestionSFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionSFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueR = valueR+ valueQ;
                bundle.putInt("currentValueR", valueR);
                questionSFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
