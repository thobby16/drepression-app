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
public class QuestionNFragment extends Fragment {


    public QuestionNFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4;
    int valueN;
    QuestionOFragment questionOFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_n, container, false);
        option1 = view.findViewById(R.id.option_n1);
        option2 = view.findViewById(R.id.option_n2);
        option3 = view.findViewById(R.id.option_n3);
        option4 = view.findViewById(R.id.option_n4);


        if(option1.isChecked()){
            valueN=0;
        }else if (option2.isChecked()){
            valueN=1;
        }else if (option3.isChecked()){
            valueN = 2;
        }else if (option4.isChecked()){
            valueN = 3;
        }else{
            valueN =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueM = getArguments().getInt("currentValueM");

        TextView next = view.findViewById(R.id.next_n);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionOFragment = new QuestionOFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionOFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueN = valueN+ valueM;
                bundle.putInt("currentValueN", valueN);
                questionOFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
