package com.example.calculator2;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private int valeur1=0;
    private int valeur2=0;
    private String operation="";
    private boolean isOp1=true;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.textV);
    }
public void reset(View view){
        text.setText("0");
        valeur1=0;
        valeur2=0;
      isOp1=true;
}
public void saisieNombre(View view){
int v=Integer.parseInt(((Button) view).getText().toString());
if(isOp1){
    valeur1=valeur1*10+v;
afficher();
}
else{
    valeur2=valeur2*10+v;
    afficher();
}
}
public void afficher(){
        if(!isOp1)
            text.setText(String.valueOf(valeur1)+""+operation+""+String.valueOf(valeur2));
        else
            text.setText(String.valueOf(valeur1));
    }
    public void setOperator(View view){

        if(view.getId()==R.id.plus)
            operation="+";
        if(view.getId()==R.id.moins)
            operation="-";
        if(view.getId()==R.id.fois)
            operation="*";
        if(view.getId()==R.id.div)
            operation="/";
        isOp1=false;
        afficher();
    }
    public void result(View view){
        if(!isOp1){
            if(operation=="+")
                valeur1=valeur1+valeur2;
            if(operation=="-")
                valeur1=valeur1-valeur2;
            if(operation=="*")
                valeur1=valeur1*valeur2;
            if(operation=="/"){
                if(valeur2==0){
                    Context context = getApplicationContext();
                    CharSequence text = "Division sur 0 !";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else
                valeur1=valeur1/valeur2;
            }
            valeur2=0;
            isOp1=true;
            afficher();
        }
    }

}