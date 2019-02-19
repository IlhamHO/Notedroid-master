package be.ehb.notedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.model.NoteDao;

public class DetailActivity extends AppCompatActivity {

private EditText etTitel, etInhoud, etDatum;
private Button btnsave;


private View.OnClickListener saveListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            String titel = etTitel.getText().toString();
            String inhoud = etInhoud.getText().toString();

            String date = etDatum.getText().toString();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date aanmaakDatum = dateFormat.parse(date);


            Note nieuweNote = new Note(titel,inhoud,aanmaakDatum);
            NoteDao.getInstance().addNote(nieuweNote);

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        etTitel = findViewById(R.id.et_titel);
        etInhoud = findViewById(R.id.et_inhoud);
        etDatum = findViewById(R.id.et_datum);
        btnsave = findViewById(R.id.btn_save);


btnsave.setOnClickListener(saveListener);
    }
}
