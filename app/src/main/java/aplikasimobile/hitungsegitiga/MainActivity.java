package aplikasimobile.hitungsegitiga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText a, b,c;
    Button btn_hitung;
    TextView text_hasils, texthasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_hitung = (Button)findViewById(R.id.btn_hitung);

        texthasil = (TextView)findViewById(R.id.text_hasil);
        text_hasils = (TextView)findViewById(R.id.text_hasils);
        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = (EditText) findViewById(R.id.a);
                b = (EditText) findViewById(R.id.b);
                c = (EditText) findViewById(R.id.c);


                if (a.length() == 0 && b.length() == 0 && c.length() == 0){
                    Toast.makeText(getApplication(),"Sisi a,b dan c tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if (a.length() == 0 && b.length() == 0 ){
                    Toast.makeText(getApplication(),"Sisi a dan b tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if (a.length() == 0 && c.length() == 0){
                    Toast.makeText(getApplication(),"Sisi a dan c tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if ( b.length() == 0 && c.length() == 0){
                    Toast.makeText(getApplication(),"Sisi b dan c tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else {
                    String sisia = a.getText().toString();
                    String sisib = b.getText().toString();
                    String sisic = c.getText().toString();

                    double a = Double.parseDouble(sisia);
                    double b = Double.parseDouble(sisib);
                    double c = Double.parseDouble(sisic);

                    double hs = S(a,b,c);
                    double th = LuasSegitiga(a,b,c,hs);
                    String output = String.valueOf(hs);
                    String output2 = String.valueOf(th);

                    text_hasils.setText(output.toString());
                    texthasil.setText(output2.toString());
                }
            }
        });
    }
    public double S  (double a, double b,double c ){
        return (a+b+c)/2;
    }
    public double LuasSegitiga (double a, double b, double c, double hs){
        return Math.sqrt(hs *(hs-a)*(hs-b)*(hs-c));
    }
}
