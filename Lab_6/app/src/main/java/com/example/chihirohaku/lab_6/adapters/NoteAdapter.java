package com.example.chihirohaku.lab_6.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.lab_6.DBContext;
import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.lab_6.fragments.EditNoteFragment;
import com.example.chihirohaku.lab_6.models.Account;
import com.example.chihirohaku.lab_6.models.BodyResponse;
import com.example.chihirohaku.lab_6.models.Note;
import com.example.chihirohaku.lab_6.viewholders.NoteViewHolder;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Chihirohaku on 12/20/2016.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private static final String TAG = NoteAdapter.class.toString();
    Context context;

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_note, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(view);
        context = parent.getContext();
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
                OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(editNoteFragment, true);
                EventBus.getDefault().post(openFragmentEvent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences = view.getContext().getSharedPreferences(Account.DATA, Context.MODE_PRIVATE);
                final String token = sharedPreferences.getString(Account.TOKEN, "");
                final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Do you delete this note?");
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBContext.getNoteDelete(note.getId().getoId(), token).enqueue(new Callback<BodyResponse>() {
                            @Override
                            public void onResponse(Call<BodyResponse> call, Response<BodyResponse> response) {
                                Log.d(TAG, String.format("onResponse: %s", response.body().toString()));
                                if (response.code() == 200) {

                                }
                            }

                            @Override
                            public void onFailure(Call<BodyResponse> call, Throwable t) {

                            }
                        });
                    }
                });
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return Note.notes.size();
    }
}
