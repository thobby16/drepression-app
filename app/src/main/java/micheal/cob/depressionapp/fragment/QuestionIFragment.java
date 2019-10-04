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
public class QuestionIFragment extends Fragment {


    public QuestionIFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4,option5;
    private static int valueI;

    QuestionJFragment questionJFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_i, container, false);

        option1 = view.findViewById(R.id.option_i1);
        option2 = view.findViewById(R.id.option_i2);
        option3 = view.findViewById(R.id.option_i3);
        option4 = view.findViewById(R.id.option_i4);


        if(option1.isChecked()){
            valueI=0;
        }else if (option2.isChecked()){
            valueI=1;
        }else if (option3.isChecked()){
            valueI = 2;
        }else if (option4.isChecked()){
            valueI = 3;
        }else{
            valueI =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueH = getArguments().getInt("currentValueH");

        TextView next = view.findViewById(R.id.next_i);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionJFragment = new QuestionJFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionJFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueI = valueI+ valueH;
                bundle.putInt("currentValueI", valueI);
                questionJFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
