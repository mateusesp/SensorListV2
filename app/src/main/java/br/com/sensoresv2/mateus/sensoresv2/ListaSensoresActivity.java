package br.com.sensoresv2.mateus.sensoresv2;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaSensoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sensores);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String[] sensorArray = new String[sensorList.size()];
        for (int i = 0; i < sensorList.size(); i++) {
            sensorArray[i] = sensorList.get(i).getName();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sensorArray);

        ListView ltvListaSensores = findViewById(R.id.ltvSensores);
        ltvListaSensores.setAdapter(arrayAdapter);
    }
}
