package com.project.scambiolavoro.fragments;


import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.project.scambiolavoro.R;
import com.project.scambiolavoro.widgets.DropDown;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);


        // Birthday
        final EditText birthDate = (EditText) view.findViewById(R.id.date);

        birthDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Calendar mcurrentDate = Calendar.getInstance();
                    int year = mcurrentDate.get(Calendar.YEAR);
                    int month = mcurrentDate.get(Calendar.MONTH);
                    int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog mDatePicker = new DatePickerDialog(Objects.requireNonNull(getContext()), new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
                            // TODO Auto-generated method stub
                            //*      Your code   to get workExp and time
                            Log.e("Date Selected", "Month: " + selectedMonth + 1 + " Day: " + selectedDay + " Year: " + selectedYear);
                            birthDate.setText(selectedDay + "/" + selectedMonth + 1 + "/" + selectedYear);
                        }
                    }, year, month, day);
                    mDatePicker.setTitle("Select workExp");
                    mDatePicker.show();
                }
            }
        });
        final EditText workExp = (EditText) view.findViewById(R.id.workExp);

        workExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        workExp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Calendar mcurrentDate = Calendar.getInstance();
                    int year = mcurrentDate.get(Calendar.YEAR);
                    int month = mcurrentDate.get(Calendar.MONTH);
                    int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog mDatePicker = new DatePickerDialog(Objects.requireNonNull(getContext()), new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
                            // TODO Auto-generated method stub
                            //*      Your code   to get workExp and time
                            Log.e("Date Selected", "Month: " + selectedMonth + 1 + " Day: " + selectedDay + " Year: " + selectedYear);
                            workExp.setText(selectedDay + "/" + selectedMonth + 1 + "/" + selectedYear);
                        }
                    }, year, month, day);
                    mDatePicker.setTitle("Select workExp");
                    mDatePicker.show();
                }
            }
        });



        // Work Experience
        final EditText name = (EditText) view.findViewById(R.id.et_name);

        // Dropdown arraylist. Two genders: male and female

        ArrayList<String> gender = new ArrayList<>();
        gender.add("Uomo");
        gender.add("Donna");

        // Dropdown widget
        ((DropDown) view.findViewById(R.id.dropdown)).setOptions(gender);

        final Button register = (Button) view.findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateBirthDate(birthDate);
            }
        });


        return view;
    }

    private void validateBirthDate(EditText birthDate) {
        String emailInput = birthDate.getText().toString().trim();

        if (emailInput.isEmpty()) {

            birthDate.setError("Inserire la Data di Nascita");

        } else {
            birthDate.setError(null);

        }
    }



}


