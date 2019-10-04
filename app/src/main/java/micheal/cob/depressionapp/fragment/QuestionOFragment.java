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
public class QuestionOFragment extends Fragment {


    public QuestionOFragment() {
        // Required empty public constructor
    }
    CheckBox option1, option2, option3, option4, option5;
    int valueO;
    QuestionPFragment questionPFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_o, container, false);

        option1 = view.findViewById(R.id.option_o1);
        option2 = view.findViewById(R.id.option_o2);
        option3 = view.findViewById(R.id.option_o3);
        option4 = view.findViewById(R.id.option_o4);
        option5 = view.findViewById(R.id.option_o5);

        if(option1.isChecked()){
            valueO=0;
        }else if (option2.isChecked()){
            valueO=1;
        }else if (option3.isChecked()){
            valueO = 2;
        }else if (option4.isChecked()){
            valueO = 3;
        }else if (option5.isChecked()){
            valueO = 4;
        }else{
            valueO =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }


        TextView next = view.findViewById(R.id.next_o);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionPFragment = new QuestionPFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionPFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                int valueN = bundle.getInt("currentValueN");
                valueO = valueO+ valueN;
                bundle.putInt("currentValueO", valueO);
                questionPFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
