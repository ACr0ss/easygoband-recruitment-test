package com.cross.easygoband_test;

import android.app.Activity;
import android.view.KeyEvent;
import android.widget.EditText;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    private Activity activity;
    private EditText id;

    @Test
    public void checkInput() {
        id = activity.findViewById(R.id.searchbar);
        assertEquals("1",id.getText().toString());
    }

}