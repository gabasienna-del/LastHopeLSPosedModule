package com.laibandis.gaba;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.Gravity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        TextView tv = new TextView(this);
        tv.setText("GABA LSPosed UI");
        tv.setTextSize(22);
        layout.addView(tv);
        setContentView(layout);
    }
}
