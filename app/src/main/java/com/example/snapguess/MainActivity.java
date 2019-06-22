package com.example.snapguess;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.core.controller.LoginStateController;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView label = (TextView) findViewById(R.id.helloworld);
        label.setText("SnapGuess");

        Button button = (Button) findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//                SnapLogin.getAuthTokenManager((Context)MainActivity.this).startTokenGrant();
                goToNextView();
            }
        });
    }

    private void goToNextView() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

//    final LoginStateController.OnLoginStateChangedListener mLoginStateChangedListener =
//            new LoginStateController.OnLoginStateChangedListener() {
//                @Override
//                public void onLoginSucceeded() {
//                    System.out.println("login successful");
//                }
//
//                @Override
//                public void onLoginFailed() {
//                    // Here you could update UI to show login failure
//                }
//
//                @Override
//                public void onLogout() {
//                    // Here you could update UI to reflect logged out state
//                }
//            };

}
