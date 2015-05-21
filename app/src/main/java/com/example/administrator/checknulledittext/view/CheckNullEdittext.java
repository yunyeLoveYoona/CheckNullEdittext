package com.example.administrator.checknulledittext.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.administrator.checknulledittext.R;

/**
 * Created by Administrator on 15-5-21.
 */
public class CheckNullEdittext extends EditText{
    private boolean isCheckNull=false;
    private Drawable right;
    public boolean checkNull() {
        if(getText().length()>0){
            return true;
        }else{
            if(!isCheckNull) {
                isCheckNull = true;
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (getText().length() < 1) {
                            setCompoundDrawables(getCompoundDrawables()[0],
                                    getCompoundDrawables()[1], right , getCompoundDrawables()[3]);
                        } else {
                            setCompoundDrawables(getCompoundDrawables()[0],
                                    getCompoundDrawables()[1], null , getCompoundDrawables()[3]);
                        }

                    }
                });
            }
            return false;
        }

    }
    public CheckNullEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        right= getResources().getDrawable(R.drawable.exclamation);
        right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());

    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(isCheckNull&&!focused&&getText().length()<1){

            setCompoundDrawables(getCompoundDrawables()[0],
                    getCompoundDrawables()[1], right , getCompoundDrawables()[3]);
        }
    }
}
