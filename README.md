# Permission_Library

A simple Android library that simplifies the process of requesting runtime permissions. This library utilizes the `ActivityResultRegistry` for modern permission handling, ensuring a smooth integration into your Android applications.

## Getting Started

### Prerequisites

Ensure your project is set up with the minimum Android SDK version required by the library (e.g., API level 23 or higher).

### Installation

1. **Add JitPack repository to your project:**

   Add the following code in your root `build.gradle` at the end of repositories:
   ```gradle
   allprojects {
       repositories {
           ...
           maven { url 'https://jitpack.io' }
       }
   }

Add the library dependency:Include the following in your app-level build.gradle file:

dependencies {
	        implementation 'com.github.Hadarki1997:Permissions-library:Tag'
	}
Usage
Basic Setup
Add required permissions in your AndroidManifest.xml:Specify each permission your app requires:
<uses-permission android:name="android.permission.XXX" />
Replace XXX with the name of the permission you need to request.
Create an instance of permissionManager:
permissionManager permissionManager = new permissionManager(getActivityResultRegistry());
Request permissions:Utilize the askForPermissions() method to request permissions:
permissionManager.askForPermissions(this, this, new String[]{Manifest.permission.CAMERA}, "We need permission to use the camera", "It's necessary for our app to work properly.");
Implement the PermissionGrantCallback interface to handle the permission result:
@Override
public void onPermissionGrant() {
    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
}
Example (Java)
Here's a complete example demonstrating how to request camera permission in an MainActivity:
public class MainActivity extends AppCompatActivity implements PermissionGrantCallback {

    private permissionManager permissionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionManager = new permissionManager(getActivityResultRegistry());

        String[] permissions = {Manifest.permission.CAMERA};
        permissionManager.askForPermissions(this, this, permissions, "We need permission to use the camera", "We need permission to take pictures");
    }

    @Override
    public void onPermissionGrant() {
        Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
    }
}

















 
