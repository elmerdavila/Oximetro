package unsa.epis.oximetro;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

       // private Item[] localDataSet;
      private  List<Evaluation> localDataSet;

    public CustomAdapter(List<Evaluation> itemList) {
        this.localDataSet = itemList;
    }

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;
            private TextView textView2;
            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                textView = (TextView) view.findViewById(R.id.textView1);
                textView2 =(TextView) view.findViewById(R.id.textView2);
            }

            public TextView getTextView() {
                return textView;
            }
            public TextView getTextView2(){
                return textView2;
            }
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.text_row_item, viewGroup, false);

            return new ViewHolder(view);
        }


        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.getTextView().setText(localDataSet.get(position).getMedida()+" "+localDataSet.get(position).getFecha());
        }

        // Return the size of your dataset (invoked by the layout manager)s
        @Override
        public int getItemCount() {
            Log.d("testing","tamañoooooooooooooooo:"+localDataSet.size()+"---------------------------");
            return localDataSet.size();
        }

    }


