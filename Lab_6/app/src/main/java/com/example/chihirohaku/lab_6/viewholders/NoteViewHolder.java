package com.example.chihirohaku.lab_6.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.models.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chihirohaku on 12/20/2016.
 */
public class NoteViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_color)
    TextView tvColor;

    public NoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Note note) {
        tvTitle.setText(note.getTitle());
        tvContent.setText(note.getContent());
        tvColor.setText(note.getColor());
    }
}
