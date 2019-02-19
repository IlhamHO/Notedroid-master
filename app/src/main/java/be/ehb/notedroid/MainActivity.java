package be.ehb.notedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.model.NoteDao;
import be.ehb.notedroid.recyclerutilities.NoteAdapter;

public class MainActivity extends AppCompatActivity {

        private RecyclerView rvNotes;
        private NoteAdapter adapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hoofd_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.mi_add){
Intent intent = new Intent(this,DetailActivity.class);
startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNotes = findViewById(R.id.rv_notes);
        adapter = new NoteAdapter(NoteDao.getInstance().getNoteLijst(), new NoteAdapter.OnItemClickListener() {

            @Override

            public void onItemClick(Note item) {

                Intent i = new Intent(getApplicationContext(), InfoActivity.class);

                i.putExtra("note", item);

                startActivity(i);

            }

        });
        rvNotes.setAdapter(adapter);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvNotes.setLayoutManager(layoutManager);


    }

    }


