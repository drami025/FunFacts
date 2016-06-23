package com.hccd.daniel.funfacts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class FunFactsActivity extends Activity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        // Declare our View variables and assign them the Views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                factLabel.setText(mFactBook.getFact());
                //Update the label with our dynamic fact


                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        };

        showFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Yay! Our activity was created!", Toast.LENGTH_LONG).show();
        Log.d(TAG, "We are logging from the onCreate method");
    }
}
