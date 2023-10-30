package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConfirmationActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Intent intent = getIntent();
        Team team = (Team) getIntent().getSerializableExtra("teamInfo");

        TextView teamName = (TextView) findViewById(R.id.teamNameTextViewId);
        teamName.setText(team.getName());

        TextView teamPostalCode = (TextView)  findViewById(R.id.postalCodeTextViewId);
        teamPostalCode.setText(team.getPostalCode());

        ImageView logoImage = (ImageView) findViewById(R.id.teamLogoId);

        int resID = getResources().getIdentifier(team.getDrawableName(), "drawable", getPackageName());
        logoImage.setImageResource(resID);
    }

}
