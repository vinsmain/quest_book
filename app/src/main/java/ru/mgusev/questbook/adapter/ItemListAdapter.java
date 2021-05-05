package ru.mgusev.questbook.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mgusev.questbook.R;
import ru.mgusev.questbook.model.Item;
import ru.mgusev.questbook.model.UserItem;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder> {

        static class ItemListViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.item_name) TextView itemName;
            @BindView(R.id.item_count) TextView itemCount;

            ItemListViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

        private List<UserItem> userItems;
        private List<Item> itemNames;

    public ItemListAdapter() {
            this.userItems = new ArrayList<>();
            this.itemNames = new ArrayList<>();
        }

        public void setUserItems(List<UserItem> userItems, List<Item> itemNames) {
            notifyItemRangeRemoved(0, getItemCount());
            this.userItems = userItems;
            this.itemNames = itemNames;
            notifyItemRangeInserted(0, getItemCount());
        }

        @NonNull
        @Override
        public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ItemListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ItemListViewHolder holder, int position) {
            for (Item item : itemNames) {
                if (item.getId() == userItems.get(position).getItemId()) holder.itemName.setText(item.getName());
            }
            holder.itemCount.setText(String.valueOf(userItems.get(position).getCount()));
        }

        @Override
        public int getItemCount() {
            return userItems.size();
        }
}