package com.example.upiview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class CustomUpiPinEditText  extends FrameLayout {


    private EditText edtOne;
    private EditText edtTwo;
    private EditText edtThree;
    private EditText edtFour;
    private EditText edtFive;

    private ImageView ivEdtOne;
    private ImageView ivEdtTwo;


    private LinearLayout showHideLayout;
    private ImageView ivEye;
    private TextView tvHideShow;




    public CustomUpiPinEditText(@NonNull Context context) {
        super(context);
        initialzeCustomViewAndroid();

    }

    public CustomUpiPinEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialzeCustomViewAndroid();
    }

    public CustomUpiPinEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialzeCustomViewAndroid();
    }

    public CustomUpiPinEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialzeCustomViewAndroid();
    }


    private void initialzeCustomViewAndroid(){
        // This method inflates our custom layout and also defines the value for different elements.

        inflate(getContext(),R.layout.custom_upi_pin_view,this);
        initFindViews();

        textChangeEvents();

        keyCodeEvents();


        initShowHideLayout();



    }

    private void initShowHideLayout() {
        showHideLayout.setOnClickListener(v->{
            if(tvHideShow.getText().equals("SHOW")){
                tvHideShow.setText("HIDE");
                ivEye.setImageDrawable(getContext().getDrawable(R.drawable.ic_eye_visible));

            }else{
                tvHideShow.setText("SHOW");
                ivEye.setImageDrawable(getContext().getDrawable(R.drawable.ic_eye_invisible));

            }



        });




    }

    private void keyCodeEvents() {
        edtTwo.setOnKeyListener((view, i, keyEvent) -> {
            if(KeyEvent.KEYCODE_DEL==keyEvent.getKeyCode()){
                edtOne.requestFocus();
            }

            return false;
        });
        edtThree.setOnKeyListener((view, i, keyEvent) -> {
            if(KeyEvent.KEYCODE_DEL==keyEvent.getKeyCode()){
                edtTwo.requestFocus();
            }

            return false;
        });
        edtFour.setOnKeyListener((view, i, keyEvent) -> {
            if(KeyEvent.KEYCODE_DEL==keyEvent.getKeyCode()){
                edtThree.requestFocus();
            }

            return false;
        });
        edtFive.setOnKeyListener((view, i, keyEvent) -> {
            if(KeyEvent.KEYCODE_DEL==keyEvent.getKeyCode()){
                edtFour.requestFocus();
            }

            return false;
        });



    }
    private void showToast(String message){
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();


    }

    private void textChangeEvents() {
        edtOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    edtOne.requestFocus();
                }else{
                    edtTwo.requestFocus();


                }
            }
        });

        edtTwo.addTextChangedListener(new TextWatcher() {

            String beforeTextChanged= edtTwo.getText().toString();
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                beforeTextChanged = charSequence.toString();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    edtOne.requestFocus();

                }else{
                    edtThree.requestFocus();
                }


            }
        });
        edtThree.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {


                if(editable.toString().isEmpty()){
                    edtTwo.requestFocus();


                }else{
                    edtFour.requestFocus();

                }
            }
        });
        edtFour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(editable.toString().isEmpty()){
                    edtThree.requestFocus();

                }else{
                    edtFive.requestFocus();
                }
            }
        });


        edtFive.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    edtFour.requestFocus();

                }

            }
        });



    }

    private void initFindViews() {
        edtOne = findViewById(R.id.edtOne);
        edtTwo = findViewById(R.id.edtTwo);
        edtThree = findViewById(R.id.edtThree);
        edtFour = findViewById(R.id.edtFour);
        edtFive = findViewById(R.id.edtFive);

        ivEye = findViewById(R.id.ivEye);

        tvHideShow = findViewById(R.id.tvShowHide);





    }
}
