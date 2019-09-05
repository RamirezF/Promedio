package app.android.frisco.promedio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2,lab1,lab2,lab3,lab4;
    Spinner sp1;
    TextView resultado,resu,prom1,prom2;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1=findViewById(R.id.sp1);

        t1=findViewById(R.id.teorico1);
        t2=findViewById(R.id.teorico2);

        lab1=findViewById(R.id.lab1);
        lab2=findViewById(R.id.lab2);
        lab3=findViewById(R.id.lab3);
        lab4=findViewById(R.id.lab4);

        resultado=findViewById(R.id.resultado);
        resu=findViewById(R.id.resu);
        calcular=findViewById(R.id.calcular);

        prom1=findViewById(R.id.promedio1);
        prom2=findViewById(R.id.promedio2);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mayor=0;
                double prom=0;
                double total=0;

                mayor=calcMay();
                prom=promLabs();
                total=calculototal(mayor, sp1,prom);

                resultado.setText(String.valueOf(total));
                prom1.setText(String.valueOf(mayor));
                prom2.setText(String.valueOf(prom));

                if(total>=13){
                    resu.setText("Aprobado");
                }else{
                    resu.setText("Desaprobado");
                }
            }

            private double calcMay() {
                int mayor;
                int teo1=Integer.parseInt(t1.getText().toString());
                int teo2=Integer.parseInt(t2.getText().toString());

                if(teo1>teo2){
                    mayor=teo1;
                }else if(teo1<teo2){
                    mayor=teo2;
                }else{
                    mayor=teo1;
                }
                return mayor;
            }

            private Double calculototal(double mayor, Spinner sp2, double prom) {
                double tot=0;
                int pos=sp2.getSelectedItemPosition();
                if(pos==0){
                    tot=mayor*0.3+prom*0.7;
                }else if(pos==1){
                    tot=mayor*0.4+prom*0.6;
                }else if(pos==2){
                    tot=mayor*0.2+prom*0.8;
                }
                return tot;
            }

            private Double promLabs(){
                double prom=0;
                int labo1=Integer.parseInt(lab1.getText().toString());
                int labo2=Integer.parseInt(lab2.getText().toString());
                int labo3=Integer.parseInt(lab3.getText().toString());
                int labo4=Integer.parseInt(lab4.getText().toString());

                prom=(labo1+labo2+labo3+labo4)/4;

                return prom;
            }
        });
    }



}
