package com.example.photoeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.photoeditor.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.image.setImageURI(getIntent().getData());

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
                Uri filepath = getIntent().getData();
                Intent dsPhotoEditorIntent = new Intent(ResultActivity.this, DsPhotoEditorActivity.class);
                dsPhotoEditorIntent.setData(filepath);
                dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "PhotoEditor");
                int[] toolsToHide = {DsPhotoEditorActivity.TOOL_FRAME, DsPhotoEditorActivity.TOOL_STICKER, DsPhotoEditorActivity.TOOL_PIXELATE};
                dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);
                startActivityForResult(dsPhotoEditorIntent, 3);
            }
        });
    }

    /*private void shareFileToInstagram(Uri uri, boolean isVideo, Post post) {
        Intent feedIntent = new Intent(Intent.ACTION_SEND);
        feedIntent.setType(isVideo ? "video/*" : "image/*");
        feedIntent.putExtra(Intent.EXTRA_STREAM, uri);
        feedIntent.setPackage(Constants.INSTAGRAM_PACKAGE_NAME);

        Intent storiesIntent = new Intent("com.instagram.share.ADD_TO_STORY");
        storiesIntent.setDataAndType(uri, isVideo ? "mp4" : "jpg");
        storiesIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        storiesIntent.setPackage(Constants.INSTAGRAM_PACKAGE_NAME);

        activity.grantUriPermission(
                "com.instagram.android", uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);

        Intent chooserIntent = Intent.createChooser(feedIntent, getString(R.string.social_instagram));
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {storiesIntent});
        startActivity(chooserIntent);
    }

     */
}