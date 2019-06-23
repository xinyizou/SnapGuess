package com.example.snapguess;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GameScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        final ImageView one=(ImageView) findViewById(R.id.one);
        final ImageView two=(ImageView) findViewById(R.id.two);
        final ImageView three=(ImageView) findViewById(R.id.three);
        final ImageView four=(ImageView) findViewById(R.id.four);
        final ImageView five=(ImageView) findViewById(R.id.five);
        final ImageView six=(ImageView) findViewById(R.id.six);
        final ImageView seven=(ImageView) findViewById(R.id.seven);
        final ImageView eight=(ImageView) findViewById(R.id.eight);
        final ImageView nine=(ImageView) findViewById(R.id.nine);
        final ImageView ten=(ImageView) findViewById(R.id.ten);
        final ImageView eleven=(ImageView) findViewById(R.id.eleven);
        final ImageView twelve=(ImageView) findViewById(R.id.twelve);
        final ImageView thirteen=(ImageView) findViewById(R.id.thirteen);
        final ImageView fourteen=(ImageView) findViewById(R.id.fourteen);
        final ImageView fifteen=(ImageView) findViewById(R.id.fifteen);
        final ImageView sixteen=(ImageView) findViewById(R.id.sixteen);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (one.getAlpha()!= 1.0f)
                {
                    one.setAlpha(1.0f);
                }
                else
                {
                    one.setAlpha(0.5f);
                }
            }

        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (two.getAlpha() != 1.0f)
                {
                    two.setAlpha(1.0f);
                }
                else
                {
                    two.setAlpha(0.5f);
                }
            }

        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (three.getAlpha() != 1.0f)
                {
                    three.setAlpha(1.0f);
                }
                else
                {
                    three.setAlpha(0.5f);
                }
            }

        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (four.getAlpha() != 1.0f)
                {
                    four.setAlpha(1.0f);
                }
                else
                {
                    four.setAlpha(0.5f);
                }
            }

        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (five.getAlpha() != 1.0f)
                {
                    five.setAlpha(1.0f);
                }
                else
                {
                    five.setAlpha(0.5f);
                }
            }

        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (six.getAlpha() != 1.0f)
                {
                    six.setAlpha(1.0f);
                }
                else
                {
                    six.setAlpha(0.5f);
                }
            }

        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (seven.getAlpha() != 1.0f)
                {
                    seven.setAlpha(1.0f);
                }
                else
                {
                    seven.setAlpha(0.5f);
                }
            }

        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (eight.getAlpha() != 1.0f)
                {
                    eight.setAlpha(1.0f);
                }
                else
                {
                    eight.setAlpha(0.5f);
                }
            }

        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (nine.getAlpha() != 1.0f)
                {
                    nine.setAlpha(1.0f);
                }
                else
                {
                    nine.setAlpha(0.5f);
                }
            }

        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (ten.getAlpha() != 1.0f)
                {
                    ten.setAlpha(1.0f);
                }
                else
                {
                    ten.setAlpha(0.5f);
                }
            }

        });

        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (eleven.getAlpha() != 1.0f)
                {
                    eleven.setAlpha(1.0f);
                }
                else
                {
                    eleven.setAlpha(0.5f);
                }
            }

        });

        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (twelve.getAlpha() != 1.0f)
                {
                    twelve.setAlpha(1.0f);
                }
                else
                {
                    twelve.setAlpha(0.5f);
                }
            }

        });

        thirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (thirteen.getAlpha() != 1.0f)
                {
                    thirteen.setAlpha(1.0f);
                }
                else
                {
                    thirteen.setAlpha(0.5f);
                }
            }

        });

        fourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (fourteen.getAlpha() != 1.0f)
                {
                    fourteen.setAlpha(1.0f);
                }
                else
                {
                    fourteen.setAlpha(0.5f);
                }
            }

        });

        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (fifteen.getAlpha() != 1.0f)
                {
                    fifteen.setAlpha(1.0f);
                }
                else
                {
                    fifteen.setAlpha(0.5f);
                }
            }

        });

        sixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (sixteen.getAlpha() != 1.0f)
                {
                    sixteen.setAlpha(1.0f);
                }
                else
                {
                    sixteen.setAlpha(0.5f);
                }
            }

        });
    }
}
