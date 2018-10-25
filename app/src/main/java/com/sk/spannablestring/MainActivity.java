package com.sk.spannablestring;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sambhaji Karad on 25/10/18.
 */

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        SpannableString styledString
                = new SpannableString("Large\n\n"     // index 0 - 5
                + "Bold\n\n"          // index 7 - 11
                + "Underlined\n\n"    // index 13 - 23
                + "Italic\n\n"        // index 25 - 31
                + "Strikethrough\n\n" // index 33 - 46
                + "Colored\n\n"       // index 48 - 55
                + "Highlighted\n\n"   // index 57 - 68
                + "K Superscript\n\n" // "Superscript" index 72 - 83
                + "K Subscript\n\n"   // "Subscript" index 87 - 96
                + "Url\n\n"           //  index 98 - 101
                + "Clickable\n\n");   // index 103 - 112

        // make the text twice as large
        styledString.setSpan(new RelativeSizeSpan(2f), 0, 5, 0);

        // make text bold
        styledString.setSpan(new StyleSpan(Typeface.BOLD), 7, 11, 0);

        // underline text
        styledString.setSpan(new UnderlineSpan(), 13, 23, 0);

        // make text italic
        styledString.setSpan(new StyleSpan(Typeface.ITALIC), 25, 31, 0);

        styledString.setSpan(new StrikethroughSpan(), 33, 46, 0);

        // change text color
        styledString.setSpan(new ForegroundColorSpan(Color.MAGENTA), 48, 55, 0);

        // highlight text
        styledString.setSpan(new BackgroundColorSpan(Color.YELLOW), 57, 68, 0);

        // superscript
        styledString.setSpan(new SuperscriptSpan(), 72, 83, 0);
        // make the superscript text smaller
        styledString.setSpan(new RelativeSizeSpan(0.5f), 72, 83, 0);

        // subscript
        styledString.setSpan(new SubscriptSpan(), 87, 96, 0);
        // make the subscript text smaller
        styledString.setSpan(new RelativeSizeSpan(0.5f), 87, 96, 0);

        // url
        styledString.setSpan(new URLSpan("http://www.google.com"), 98, 101, 0);

        // clickable text
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(@NonNull View widget) {
                // We display a Toast. You could do anything you want here.
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        };

        styledString.setSpan(clickableSpan, 103, 112, 0);

        // this step is mandated for the url and clickable styles.
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        // make it neat
        textView.setText(styledString);
        textView.setTextSize(18);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
