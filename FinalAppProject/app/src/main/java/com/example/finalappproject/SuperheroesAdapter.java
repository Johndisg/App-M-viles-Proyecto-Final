package com.example.finalappproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SuperheroesAdapter extends RecyclerView.Adapter<SuperheroesAdapter.SuperheroeViewHolder> {

    private List<Superheroe> superheroeList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Superheroe superheroe);
    }

    public SuperheroesAdapter(List<Superheroe> superheroeList, OnItemClickListener listener) {
        this.superheroeList = superheroeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SuperheroeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_superheroe, parent, false);
        return new SuperheroeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperheroeViewHolder holder, int position) {
        Superheroe superheroe = superheroeList.get(position);
        holder.txtNombre.setText(superheroe.getNombre());
        holder.txtDescripcion.setText(superheroe.getDescripcion());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(superheroe);
            }
        });
    }

    @Override
    public int getItemCount() {
        return superheroeList.size();
    }

    public class SuperheroeViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre, txtDescripcion;

        public SuperheroeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
        }
    }
}

