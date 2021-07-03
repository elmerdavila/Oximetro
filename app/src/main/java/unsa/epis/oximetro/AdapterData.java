package unsa.epis.oximetro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolderData> {


    private ArrayList<Evaluation> listdata;

    public AdapterData(ArrayList<Evaluation> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        /*View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderData(view);*/
        return null;
    }

    @Override
    public void onBindViewHolder( ViewHolderData holder, int position) {
        holder.mapData(listdata.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        TextView dato;

        public ViewHolderData(View itemView) {
            super(itemView);
            //dato= (TextView) itemView.findViewById(R.id.dato);
        }

        public void mapData(Evaluation evaluation) {
            dato.setText(evaluation.getMedida());
        }
    }
}
