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
public class QuestionHFragment extends Fragment {


    public QuestionHFragment() {
        // Required empty public constructor
    }
    CheckBox option1,option2,option3,option4,option5;
    public static int valueH;
    QuestionIFragment questionIFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_question_h, container, false);

        option1 = view.findViewById(R.id.option_h1);
        option2 = view.findViewById(R.id.option_h2);
        option3 = view.findViewById(R.id.option_h3);
        option4 = view.findViewById(R.id.option_h4);
        option5 = view.findViewById(R.id.option_h5);

        if(option1.isChecked()){
            valueH=0;
        }else if (option2.isChecked()){
            valueH=1;
        }else if (option3.isChecked()){
            valueH = 2;
        }else if (option4.isChecked()){
            valueH = 3;
        }else if (option5.isChecked()){
            valueH = 4;
        }else{
            valueH =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueG = getArguments().getInt("currentValueG");

        TextView next = view.findViewById(R.id.next_h);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionIFragment = new QuestionIFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionIFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueH = valueH+ valueG;
                bundle.putInt("currentValueH", valueH);
                questionIFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
