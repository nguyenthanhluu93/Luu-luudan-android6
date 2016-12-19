package com.example.chihirohaku.recycleviewintro.viewholders;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chihirohaku.recycleviewintro.R;
import com.example.chihirohaku.recycleviewintro.models.Contact;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chihirohaku on 12/13/2016.
 */
public class ContactViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_contact)
    ImageView ivContact;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    public ContactViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Contact contact) {
        Picasso.with(this.itemView.getContext()).load(contact.getImageUrl()).into(ivContact);
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());
    }
}
