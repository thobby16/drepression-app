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
public class QuestionJFragment extends Fragment {


    public QuestionJFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4;
    private static int valueJ;
    QuestionKFragment questionKFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_j, container, false);
        option1 = view.findViewById(R.id.option_j1);
        option2 = view.findViewById(R.id.option_j2);
        option3 = view.findViewById(R.id.option_j3);
        option4 = view.findViewById(R.id.option_j4);


        if(option1.isChecked()){
            valueJ=0;
        }else if (option2.isChecked()){
            valueJ=1;
        }else if (option3.isChecked()){
            valueJ = 2;
        }else if (option4.isChecked()){
            valueJ = 3;
        }else{
            valueJ =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueI = getArguments().getInt("currentValueI");

        TextView next = view.findViewById(R.id.next_j);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionKFragment = new QuestionKFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionKFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueJ = valueJ+ valueI;
                bundle.putInt("currentValueJ", valueJ);
                questionKFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
