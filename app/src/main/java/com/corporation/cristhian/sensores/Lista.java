package com.corporation.cristhian.sensores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista extends AppCompatActivity {

    ListView listView;

    String[] valores =new String[]{"Proximidad","Acelerómetro","Sensor Magnetico","Giroscopio"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        /*optener el objeto lisview por id*/
        listView=(ListView) findViewById(R.id.lista);

        /*adaptador*/
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,valores);
        listView.setAdapter(adapter);

        /*evento para dar click en los paises*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(Lista.this,MainActivity.class);
                        startActivity(intent);
                    break;

                    case 1:
                        Intent intent1=new Intent(Lista.this,Acelerometro.class);
                        startActivity(intent1);
                }

                //Toast.makeText(getApplicationContext(),"posicion"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
