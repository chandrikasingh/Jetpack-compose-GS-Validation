# JetpackCompose App 
This application demonstrates the Global Setting write-value procedure through the user application.

1) If the Write Settings permission request fails due to custom settings, execute the below command:
   
    adb shell pm grant com.jsrvc.test android.permission.WRITE_SECURE_SETTINGS

   

3) Successful execution can be verified using the command line.
   
    adb shell settings get global EVENT_LOAD_INFO
