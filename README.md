
# Permission_Library

A simple Android library that simplifies the process of requesting runtime permissions. This library utilizes the `ActivityResultRegistry` for modern permission handling, ensuring a smooth integration into your Android applications.

## Getting Started

### Prerequisites

Ensure your project is set up with the minimum Android SDK version required by the library (e.g., API level 23 or higher).

### Installation

**1. Add JitPack repository to your project:**

   Insert the following code in your root `build.gradle` at the end of the repositories block:

   ```gradle
   allprojects {
       repositories {
           ...
           maven { url 'https://jitpack.io' }
       }
   }
   ```

**2. Add the library dependency:**

   Add this line to your app-level `build.gradle` file:

   ```gradle
   dependencies {
       implementation 'com.github.Hadarki1997:Permissions-library:Tag'
   }
   ```

## Usage

### Basic Setup

**1. Add required permissions in your AndroidManifest.xml:**

   Specify each permission your app requires:

   ```xml
   <uses-permission android:name="android.permission.XXX" />
   ```

   Replace `XXX` with the name of the permission you need to request.

**2. Create an instance of `permissionManager`:**

   ```java
   permissionManager permissionManager = new permissionManager(getActivityResultRegistry());
   ```

**3. Request permissions:**

   Utilize the `askForPermissions()` method to request permissions:

   ```java
        permissionManager.askForPermissions(this, this, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, "We need permission to use Bluetooth", "It's necessary for our app to connect with other Bluetooth devices.");
   ```

   Implement the `PermissionGrantCallback` interface to handle the permission result:

   ```java
   @Override
   public void onPermissionGrant() {
       Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
   }
   ```

### Example (Java)

Here's a complete example demonstrating how to request Bluetooth permission in `MainActivity`:

```java
public class MainActivity extends AppCompatActivity implements PermissionGrantCallback {

    private permissionManager permissionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionManager = new permissionManager(getActivityResultRegistry());
        permissionManager.askForPermissions(this, this, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, "We need permission to use Bluetooth", "It's necessary for our app to connect with other Bluetooth devices.");
    }

    @Override
    public void onPermissionGrant() {
        Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
    }
}
```

---

This formatting includes clear section breaks, syntax highlighting for code, and organized instructions which should make the README more visually appealing and easier to follow.
