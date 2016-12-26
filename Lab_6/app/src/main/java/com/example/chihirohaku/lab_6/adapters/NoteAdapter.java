package com.example.chihirohaku.lab_6.adapters;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.lab_6.fragments.CreateNoteFragment;
import com.example.chihirohaku.lab_6.fragments.EditNoteFragment;
import com.example.chihirohaku.lab_6.models.Note;
import com.example.chihirohaku.lab_6.viewholders.NoteViewHolder;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Chihirohaku on 12/20/2016.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_note, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(view);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(final NoteViewHolder holder, int position) {
        final Note note = Note.notes.get(position);
        holder.bind(note);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("oc", String.format("onClick"));
                EditNoteFragment editNoteFragment = new EditNoteFragment();
                editNoteFragment.setNote(note);
                OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(editNoteFragment, false);
                EventBus.getDefault().post(openFragmentEvent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Note.notes.size();
    }
}
