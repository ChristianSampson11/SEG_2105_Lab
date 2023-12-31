package com.example.lab4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String drawableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setLogo(View view) {
        Intent intent = new Intent(getApplicationContext(), LogoSelectorActivity.class);
        startActivityForResult(intent, 0);
    }

    public void submit(View view) {
        TextView teamNameView = (TextView) findViewById(R.id.teamNameId);
        TextView postalCodeView = (TextView) findViewById(R.id.postalCodeId);
        String teamName = teamNameView.getText().toString();
        String postalCode = postalCodeView.getText().toString();
        Team team = new Team(teamName, postalCode,drawableName);
        Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
        intent.putExtra("teamInfo", team);
        startActivity(intent);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView logoImage = (ImageView) findViewById(R.id.logoImage);

        drawableName = "ic_logo_00";
        int imageID = data.getIntExtra("imageID", R.id.teamid1);
        if (imageID == R.id.teamid1) {
            drawableName = "ic_logo_01";
        } else if (imageID == R.id.teamid2) {
            drawableName = "ic_logo_02";
        } else if (imageID == R.id.teamid3) {
            drawableName = "ic_logo_03";
        } else if (imageID == R.id.teamid4) {
            drawableName = "ic_logo_04";
        } else if (imageID == R.id.teamid5) {
            drawableName = "ic_logo_05";
        } else if (imageID == R.id.teamid6) {
            drawableName = "ic_logo_00";
        } else {
            drawableName = "ic_logo_00";
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        logoImage.setImageResource(resID);
    }

    public void openInGoogleMaps (View view) {
        TextView teamPostalCode = (TextView) findViewById(R.id.postalCodeId);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamPostalCode.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}