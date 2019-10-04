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
public class QuestionTFragment extends Fragment {


    public QuestionTFragment() {
        // Required empty public constructor
    }
    CheckBox option1, option2, option3, option4;
    int valueT;
    QuestionUFragment questionUFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_t, container, false);
        option1 = view.findViewById(R.id.option_t1);
        option2 = view.findViewById(R.id.option_t2);
        option3 = view.findViewById(R.id.option_t3);
        option4 = view.findViewById(R.id.option_t4);

        if(option1.isChecked()){
            valueT= 0;
        }else if (option2.isChecked()){
            valueT=1;
        }else if (option3.isChecked()){
            valueT = 2;
        }else if (option4.isChecked()){
            valueT = 3;
        }else{
            valueT =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueS = getArguments().getInt("currentValueS");

        TextView next = view.findViewById(R.id.next_t);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionUFragment = new QuestionUFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionUFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueT = valueT+ valueS;
                bundle.putInt("currentValueT", valueT);
                questionUFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
