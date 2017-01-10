package com.example.chihirohaku.recycleviewintro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.recycleviewintro.IOnRecyclerListener;
import com.example.chihirohaku.recycleviewintro.R;
import com.example.chihirohaku.recycleviewintro.models.Contact;
import com.example.chihirohaku.recycleviewintro.viewholders.ContactViewHolder;

/**
 * Created by Chihirohaku on 12/13/2016.
 */

public class ContactAdaper extends RecyclerView.Adapter<ContactViewHolder> {

    private IOnRecyclerListener onRecyclerListener;

    public ContactAdaper(IOnRecyclerListener onRecyclerListener) {
        this.onRecyclerListener = onRecyclerListener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_contact, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, final int position) {
        // holder, position (data)
        // VH + DATA => data
        Contact contact = Contact.CONTACTS[position];
        holder.bind(contact);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRecyclerListener.onItemClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Contact.CONTACTS.length;
    }
}
