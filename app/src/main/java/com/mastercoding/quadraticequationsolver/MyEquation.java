package com.mastercoding.quadraticequationsolver;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.mastercoding.quadraticequationsolver.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {
    //extending baseobservable includes the databinding notifications to automatically update UI
    String a, b, c;
    ActivityMainBinding binding;

    public MyEquation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public MyEquation() {
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void solveEquation(View view){
        //converting the string to int
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        // Calculating the Discriminant
        double discriminant = b*b - 4*a*c;

        // When D > 0, the quadratic equation has two real roots
        // when D < 0, the quadratic equation has no real roots
        // when D = 0, the quadratic equation has a repeated root.

        // Finding the soltuions (roots)
        double x1, x2;
        if (discriminant > 0) {
            // two real and distinct roots
            x1 = (-b + Math.sqrt(discriminant))/(2*a);
            x2 = (-b - Math.sqrt(discriminant))/(2*a);

            // Display the results in the textview
            binding.textView.setText("X1= "+x1+ " X2= "+x2);

        } else if (discriminant < 0) {
            binding.textView.setText("No real roots (complex roots)");
        } else {
            // discriminant = 0
            // one real solution (double root)
            x1 = -b / (2*a);
            binding.textView.setText("x1 = x2 = "+x1);
        }

    }
}
