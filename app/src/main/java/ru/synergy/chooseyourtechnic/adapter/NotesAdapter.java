package ru.synergy.chooseyourtechnic.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.synergy.chooseyourtechnic.R;
import ru.synergy.chooseyourtechnic.notedb.model.Note;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.BeanHolder> {

    private List<Note> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnNoteItemClick onNoteItemClick;

    public NotesAdapter(List<Note> list, Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
        this.onNoteItemClick = (OnNoteItemClick) context;
    }


    @Override
    public BeanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.note_list_item, parent, false);
        return new BeanHolder(view);
    }

    @Override
    public void onBindViewHolder(BeanHolder holder, int position) {
        Log.e("bind", "onBindViewHolder: " + list.get(position));
        holder.textViewPower.setText(list.get(position).getPower());
        holder.textViewVoltage.setText(list.get(position).getVoltage());
        holder.textViewPhase.setText(list.get(position).getPhase());
        holder.textViewCosFi.setText(list.get(position).getCosFi());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BeanHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewPower;
        TextView textViewVoltage;
        TextView textViewPhase;
        TextView textViewCosFi;

        public BeanHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewPower = itemView.findViewById(R.id.tv_power);
            textViewVoltage = itemView.findViewById(R.id.tv_voltage);
            textViewPhase = itemView.findViewById(R.id.tv_phase);
            textViewCosFi = itemView.findViewById(R.id.tv_cosFi);
        }

        @Override
        public void onClick(View view) {
            onNoteItemClick.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteItemClick {
        void onNoteClick(int pos);
    }
}
