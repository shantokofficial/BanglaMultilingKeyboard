package com.example.multilingbanglakeyboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        int pad = (int) (24 * getResources().getDisplayMetrics().density);
        layout.setPadding(pad, pad, pad, pad);

        TextView title = new TextView(this);
        title.setText("Bangla Multiling Keyboard");
        title.setTextSize(24);
        title.setPadding(0, 0, 0, pad / 2);
        layout.addView(title);

        TextView info = new TextView(this);
        info.setText("To use this keyboard, enable it in Android Settings, then select it from the keyboard picker.");
        info.setTextSize(16);
        info.setPadding(0, 0, 0, pad);
        layout.addView(info);

        Button settings = new Button(this);
        settings.setText("Enable keyboard");
        settings.setAllCaps(false);
        settings.setOnClickListener(v ->
                startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)));
        layout.addView(settings, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Button picker = new Button(this);
        picker.setText("Select keyboard");
        picker.setAllCaps(false);
        picker.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) imm.showInputMethodPicker();
        });
        LinearLayout.LayoutParams pickerParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerParams.topMargin = pad / 2;
        layout.addView(picker, pickerParams);

        setContentView(layout);
    }
}
