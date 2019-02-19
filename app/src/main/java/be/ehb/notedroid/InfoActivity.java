package be.ehb.notedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import be.ehb.notedroid.model.Note;

public class InfoActivity extends AppCompatActivity {

    private TextView tvTitel, tvInhoud, tvDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvTitel = findViewById(R.id.tv_titel);
        tvInhoud = findViewById(R.id.tv_inhoud);
        tvDatum = findViewById(R.id.tv_datum);

        Note n = (Note) getIntent().getSerializableExtra("note");

        tvTitel.setText(n.getTitel());
        tvInhoud.setText(n.getInhoud());
        tvDatum.setText(n.getAanmaakdatum().toString());

        
    }
}
