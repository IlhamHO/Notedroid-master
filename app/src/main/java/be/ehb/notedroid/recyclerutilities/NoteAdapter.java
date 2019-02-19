package be.ehb.notedroid.recyclerutilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.notedroid.R;
import be.ehb.notedroid.model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{


    public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //verwijzingen naar elementen in layout
        public final TextView tvTitel;
        public final TextView tvDatum;
        public final Button btnDelete;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            tvTitel = itemView.findViewById(R.id.tv_titel);
            tvDatum = itemView.findViewById(R.id.tv_datum);
            btnDelete = itemView.findViewById(R.id.btn_delete);

            View.OnClickListener deleteListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(getAdapterPosition());
                }
            };
            btnDelete.setOnClickListener(deleteListener);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            int welkeRij = getAdapterPosition();
            Note n = items.get(welkeRij);
            noteItemClickListener.onItemClick(n);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Note item);
    }

    private ArrayList<Note> items;
    private final OnItemClickListener noteItemClickListener;

    public NoteAdapter(ArrayList<Note> items, OnItemClickListener noteItemClickListener) {
        this.items = items;
        this.noteItemClickListener = noteItemClickListener;

    }

    @NonNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();

        View cardRijView = LayoutInflater.from(context).inflate(R.layout.note_card, viewGroup, false);

        return new NoteViewHolder(cardRijView);

    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder noteViewHolder, int i) {
        Note noteVoorDeRij = items.get(i);

        noteViewHolder.tvTitel.setText(noteVoorDeRij.getTitel());
        noteViewHolder.tvDatum.setText(noteVoorDeRij.getAanmaakdatum().toString());


    }


    void deleteItem(int i) {
        items.remove(i);
        notifyItemRemoved(i);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}

