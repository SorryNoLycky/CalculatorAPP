package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText Num1, Num2, Operation;
    TextView ResultText;
    Button button;

    Toast toastError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = findViewById(R.id.editText1);
        Num2 = findViewById(R.id.editText2);
        Operation = findViewById(R.id.editOperation);
        ResultText = findViewById(R.id.textResult);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
            float num1, num2, result = 0;
            boolean correctOperation = true;
            String operation = "";
            try {
                num1 = Float.parseFloat(Num1.getText().toString());
                num2 = Float.parseFloat(Num2.getText().toString());
                operation = Operation.getText().toString();

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if(num2 == 0) throw new ArithmeticException();
                        result = num1 / num2;
                        break;
                    default:
                        correctOperation = false;
                        break;
                }
            }catch (ArithmeticException e)
        {
            int duration = Toast.LENGTH_SHORT;
            if(toastError != null)
            {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.divide_zero, duration);
            toastError.show();
            return;
        }
        catch (NullPointerException e)
        {
            int duration = Toast.LENGTH_SHORT;
            if(toastError != null)
            {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.null_data, duration);
            toastError.show();
            return;
        }
        catch (NumberFormatException e)
        {
            int duration = Toast.LENGTH_SHORT;
            if(toastError != null)
            {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.wrong_format, duration);
            toastError.show();
            return;
        }

        if(correctOperation) {

            ResultText.setText(num1 + " " + operation + " " + num2 + " = " + result);
        }
        else{
            int duration = Toast.LENGTH_SHORT;
            if(toastError != null)
            {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.wrong_operation, duration);
            toastError.show();
            return;
        }
    }
}