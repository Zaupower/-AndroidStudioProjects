package pt.ipp.estg.pool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//imports de MPAndroidChart
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

import com.github.mikephil.charting.data.Entry;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart chart = (LineChart) findViewById(R.id.chart);
        List<Entry> entries = new ArrayList<Entry>();
        for (int i =0; i <10; i++) {
            entries.add(new Entry(i, (float) Math.random() ) );
        }
        LineDataSet dataSet = new LineDataSet(entries,"");
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
    }
}
