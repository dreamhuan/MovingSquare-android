package project.android.fkq.movingsquare.adapt;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;

import project.android.fkq.movingsquare.R;
import project.android.fkq.movingsquare.bean.PuzzleImg;
import project.android.fkq.movingsquare.view.IntroActivity;

public class PuzzleAdapter extends RecyclerView.Adapter<PuzzleAdapter.ViewHolder> {

    private Context mContext;
    private List<PuzzleImg> mPuzzleImgList;
    private Typeface tf;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView image;
        TextView imageName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            imageName = view.findViewById(R.id.image_name);
            image = view.findViewById(R.id.image);
        }
    }

    public PuzzleAdapter(List<PuzzleImg> puzzleImgList) {
        mPuzzleImgList = puzzleImgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();

            AssetManager assets = mContext.getAssets();//得到AssetManager
            tf = Typeface.createFromAsset(assets, "fonts/迷你简细行楷.TTF");//根据路径得到Typeface
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            PuzzleImg puzzleImg = mPuzzleImgList.get(position);
            Intent intent = new Intent(mContext, IntroActivity.class);
            intent.putExtra(IntroActivity.IMAGE_NAME, puzzleImg.getName());
            intent.putExtra(IntroActivity.IMAGE_ID, puzzleImg.getImageId());
            intent.putExtra(IntroActivity.IMAGE_INTRO, puzzleImg.getIntro());
            mContext.startActivity(intent);
        });
        holder.imageName.setTypeface(tf);//设置字体
        holder.imageName.getPaint().setFakeBoldText(true);//中文仿“粗体”--使用TextPaint的仿“粗体”设置setFakeBoldText为true。

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PuzzleImg puzzleImg = mPuzzleImgList.get(position);
        holder.imageName.setText(puzzleImg.getName());
        Glide.with(mContext).load(puzzleImg.getImageId()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mPuzzleImgList.size();
    }
}
