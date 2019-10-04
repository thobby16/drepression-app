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
public class QuestionBFragment extends Fragment {


    public QuestionBFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4, option5;
    private static int valueB;
    QuestionCFragment questionCFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_b, container, false);
        option1 = view.findViewById(R.id.option_1);
        option2 = view.findViewById(R.id.option_2);
        option3 = view.findViewById(R.id.option_3);
        option4 = view.findViewById(R.id.option_4);
        option5 = view.findViewById(R.id.option_5);

        if(option1.isChecked()){
            valueB=0;
        }else if (option2.isChecked()){
            valueB=1;
        }else if (option3.isChecked()){
            valueB = 2;
        }else if (option4.isChecked()){
            valueB = 3;
        }else if (option5.isChecked()){
            valueB = 4;
        }else{
            valueB =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueA = getArguments().getInt("currentValueA");

        TextView next = view.findViewById(R.id.next_b);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionCFragment = new QuestionCFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionCFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueB = valueB + valueA;
                bundle.putInt("currentValueB", valueB);
                questionCFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
