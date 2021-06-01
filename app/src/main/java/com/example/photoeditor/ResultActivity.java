package com.example.photoeditor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.photoeditor.databinding.ActivityResultBinding;

import java.io.File;
import java.io.FileOutputStream;

public class ResultActivity extends AppCompatActivity {

    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        Uri outputUri = intent.getData();

        binding.image.setImageURI(outputUri);

        String pathname = outputUri.toString() + ".jpg";
        binding.textFilePath.setText(pathname);

        binding.homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
        );

        binding.backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent dsPhotoEditorIntent = new Intent(ResultActivity.this, DsPhotoEditorActivity.class);
                dsPhotoEditorIntent.setData(outputUri);
                dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "PhotoEditor");
                int[] toolsToHide = {DsPhotoEditorActivity.TOOL_FRAME, DsPhotoEditorActivity.TOOL_STICKER, DsPhotoEditorActivity.TOOL_PIXELATE};
                dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);
                startActivityForResult(dsPhotoEditorIntent, 3);
            }
        });

        binding.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable=binding.image.getDrawable();
                Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();

                try {
                    String filename = pathname.substring(pathname.lastIndexOf("/")+1);
                    File file = new File(getApplicationContext().getExternalCacheDir(), File.separator + filename);
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID +".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/jpg");

                    startActivity(Intent.createChooser(intent, "Share image via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}