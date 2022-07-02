package com.geektech.hv2_m2.ui.fragment.board.boardadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.geektech.hv2_m2.R;


public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private final int[] img = {
            R.raw.love1,
            R.raw.love2,
            R.raw.love3,
            R.raw.love4
    };

    private final  String[]  title = {
            "Have a good time",
            "Cherishing love",
            "Have a breakup?",
            ""
    };

    private final String[] desc = {
            "You should take the time to help those who need you",
            "It is now no longer possible for you to cherish love",
            "We have made the correction for you don't worry" +
                    " Maybe someone is waiting for you!",
            "It's Funs and Mary more"
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(img[position], title[position], desc[position]);
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title, desc;
        private final LottieAnimationView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            desc = itemView.findViewById(R.id.txt_description);
            img = itemView.findViewById(R.id.img_board);
        }

        public void onBind(int img, String title, String desc) {
            this.title.setText(title);
            this.desc.setText(desc);
            this.img.setAnimation(img);
        }
    }
}
