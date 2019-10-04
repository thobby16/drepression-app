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
public class QuestionAFragment extends Fragment {

    public QuestionAFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4, option5;
    public static int value;
    QuestionBFragment questionBFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_question_a, container, false);
        option1 = view.findViewById(R.id.option_1);
        option2 = view.findViewById(R.id.option_2);
        option3 = view.findViewById(R.id.option_3);
        option4 = view.findViewById(R.id.option_4);
        option5 = view.findViewById(R.id.option_5);
        if(option1.isChecked()){
            value=0;
        }else if (option2.isChecked()){
            value=1;
        }else if (option3.isChecked()){
            value = 2;
        }else if (option4.isChecked()){
            value = 3;
        }else if (option5.isChecked()){
            value = 4;
        }else{
            value =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        TextView next = view.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionBFragment = new QuestionBFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionBFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                bundle.putInt("currentValueA", value);
                questionBFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
