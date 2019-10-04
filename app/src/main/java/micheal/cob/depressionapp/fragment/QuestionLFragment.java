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
public class QuestionLFragment extends Fragment {


    public QuestionLFragment() {
        // Required empty public constructor
    }
    CheckBox option1, option2, option3, option4;
    int valueL;
    QuestionMFragment questionMFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_l, container, false);

        option1 = view.findViewById(R.id.option_l1);
        option2 = view.findViewById(R.id.option_l2);
        option3 = view.findViewById(R.id.option_l3);
        option4 = view.findViewById(R.id.option_l4);


        if(option1.isChecked()){
            valueL=0;
        }else if (option2.isChecked()){
            valueL=1;
        }else if (option3.isChecked()){
            valueL = 2;
        }else if (option4.isChecked()){
            valueL = 3;
        }else{
            valueL =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueK = getArguments().getInt("currentValueK");

        TextView next = view.findViewById(R.id.next_l);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionMFragment = new QuestionMFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionMFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueL = valueL+ valueK;
                bundle.putInt("currentValueL", valueL);
                questionMFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
