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
public class QuestionGFragment extends Fragment {


    public QuestionGFragment() {
        // Required empty public constructor
    }
    CheckBox option1, option2, option3, option4, option5;
    public static int valueG;
    QuestionHFragment questionHFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_g, container, false);
        option1 = view.findViewById(R.id.option_g1);
        option2 = view.findViewById(R.id.option_g2);
        option3 = view.findViewById(R.id.option_g3);
        option4 = view.findViewById(R.id.option_g4);
        option5 = view.findViewById(R.id.option_g5);

        if(option1.isChecked()){
            valueG=0;
        }else if (option2.isChecked()){
            valueG=1;
        }else if (option3.isChecked()){
            valueG = 2;
        }else if (option4.isChecked()){
            valueG = 3;
        }else if (option5.isChecked()){
            valueG = 4;
        }else{
            valueG =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }


        final int valueF = getArguments().getInt("currentValueF");

        TextView next = view.findViewById(R.id.next_g);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionHFragment = new QuestionHFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionHFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueG = valueG + valueF;
                bundle.putInt("currentValueG", valueG);
                questionHFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
