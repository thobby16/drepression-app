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
public class QuestionCFragment extends Fragment {


    public QuestionCFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4, option5;
    private static int valueC;
    QuestionDFragment questionDFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_c, container, false);

        option1 = view.findViewById(R.id.option_c1);
        option2 = view.findViewById(R.id.option_c2);
        option3 = view.findViewById(R.id.option_c3);
        option4 = view.findViewById(R.id.option_c4);
        option5 = view.findViewById(R.id.option_c5);

        if(option1.isChecked()){
            valueC=0;
        }else if (option2.isChecked()){
            valueC=1;
        }else if (option3.isChecked()){
            valueC = 2;
        }else if (option4.isChecked()){
            valueC = 3;
        }else if (option5.isChecked()){
            valueC = 4;
        }else{
            valueC =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueB = getArguments().getInt("currentValueB");


        TextView next = view.findViewById(R.id.next_c);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionDFragment = new QuestionDFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionDFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueC = valueC + valueB;
                bundle.putInt("currentValueC", valueB);
                questionDFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
