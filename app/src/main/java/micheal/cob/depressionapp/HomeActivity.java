package micheal.cob.depressionapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import micheal.cob.depressionapp.R;
import micheal.cob.depressionapp.fragment.QuestionAFragment;

public class HomeActivity extends AppCompatActivity {

    QuestionAFragment questionAFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.take_test);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionAFragment = new QuestionAFragment();
                //getActivity
                FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, questionAFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_left);
                fragmentTransaction.commit();

            }
        });
    }
}
