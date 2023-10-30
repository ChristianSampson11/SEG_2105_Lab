package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String drawableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setLogo(View view){
        Intent intent = new Intent(getApplicationContext(), LogoSelectorActivity.class);

        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView logoImage = (ImageView) findViewById(R.id.logoImage);

        drawableName = "ic_logo_00";
        int imageID = data.getIntExtra("imageID", R.id.teamid06);

        if (imageID == R.id.teamid01) {
            drawableName = "ic_logo_01";
        } else if (imageID == R.id.teamid02) {
            drawableName = "ic_logo_02";
        } else if (imageID == R.id.teamid03) {
            drawableName = "ic_logo_03";
        } else if (imageID == R.id.teamid04) {
            drawableName = "ic_logo_04";
        } else if (imageID == R.id.teamid05) {
            drawableName = "ic_logo_05";
        } else if (imageID == R.id.teamid06) {
            drawableName = "ic_logo_00";
        } else {
            drawableName = "ic_logo_00";
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());

        logoImage.setImageResource(resID);
    }

    public void openInGoogleMaps(View view){
        EditText teamPostalCode = (EditText) findViewById(R.id.postalCodeID);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamPostalCode.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void submit(View view){
        TextView teamNameView = (TextView) findViewById(R.id.teamNameViewID);
        TextView postalCodeView = (TextView) findViewById(R.id.postalCodeID);

        String teamName = teamNameView.getText().toString();
        String postalCode = postalCodeView.getText().toString();

        Team team = new Team(teamName, postalCode,drawableName);

        Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
        intent.putExtra("teamInfo", team);
        startActivity(intent);
    }
}