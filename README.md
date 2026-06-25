# JetpackCompose App 
This application demonstrates the Global Setting write-value procedure through the user application.

1) Write-Settings permission request if fails due custom settings then perform below command:
   
    adb shell pm grant <app-package> android.permission.WRITE_SECURE_SETTINGS

3) Successful execution can be verified using the command line.
   
    adb shell settings get global EVENT_LOAD_INFO
