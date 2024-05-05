package com.example.permission_library;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.permissionlibrary.permissionManager;

public class MainActivity extends AppCompatActivity implements com.example.permissionlibrary.permissionManager.PermissionGrantCallback {
    private permissionManager permissionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        permissionManager = new permissionManager(getActivityResultRegistry());

        String[] permissions = {
                Manifest.permission.CAMERA,
        };

        permissionManager.askForPermissions(this, this, permissions,
                "We need camera permissions to enhance functionality",
                "Please enable camera permission");

    }

    @Override
    public void onPermissionGrant() {
        Toast.makeText(this, "All required permissions granted", Toast.LENGTH_SHORT).show();
    }
}
