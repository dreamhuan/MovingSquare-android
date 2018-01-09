package project.android.fkq.movingsquare.view;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import project.android.fkq.movingsquare.R;

public class IntroActivity extends AppCompatActivity {
    private static final String TAG = "IntroActivity";

    public static final String IMAGE_NAME = "image_name";

    public static final String IMAGE_ID = "image_id";

    public static final String IMAGE_INTRO = "image_intro";

    private int type = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AssetManager assets = getAssets();//得到AssetManager
        Typeface tf = Typeface.createFromAsset(assets, "fonts/迷你简细行楷.TTF");//根据路径得到Typeface

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Intent intent = getIntent();
        String imageName = intent.getStringExtra(IMAGE_NAME);
        int imageId = intent.getIntExtra(IMAGE_ID, 0);
        String imageIntro = intent.getStringExtra(IMAGE_INTRO);

        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView imageView = findViewById(R.id.image_view);
        TextView imageContent = findViewById(R.id.image_content);
        RadioGroup radioGroup = findViewById(R.id.choose_hard);

        radioGroup.check(R.id.choose_hard_3);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.choose_hard_3:
                    type = 3;
                    break;
                case R.id.choose_hard_4:
                    type = 4;
                    break;
                case R.id.choose_hard_5:
                    type = 5;
                    break;
            }
        });

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collapsingToolbar.setTitle(imageName);
        Glide.with(this).load(imageId).into(imageView);
        imageContent.setTypeface(tf);//设置字体
        imageContent.getPaint().setFakeBoldText(true);//中文仿“粗体”--使用TextPaint的仿“粗体”设置setFakeBoldText为true。
        imageContent.setText(imageIntro);

        findViewById(R.id.btn_play_game).setOnClickListener(v -> {
            Intent intent1 = new Intent(IntroActivity.this, GameActivity.class);
            intent1.putExtra("picSelectedID", imageId);
            intent1.putExtra("type", type);
            startActivity(intent1);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
