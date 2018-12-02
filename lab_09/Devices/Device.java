package Devices;

public class Device {
    public String string;
    public Device(Integer ver, Double vol) {
        if (ver!=null && vol != null) {
            string = "Version of the Devices.Device: " + ver + "\nVolume of rhe Devices.Device: " + vol + "\n";
        }
        else { string = null; }
    }
    /**
    * Returns version and volume of Devices.Device
    *
    * Method is executed in {@link #main(String[])}
    *
    * @param ver - version of Devices.Device
    * @param vol - Volume of Devices.Device
    * @return ver and vol of Devices.Device
    */
    public static String getInfo(String ver, Integer vol) {
        return "Version of the Devices.Device: " + ver + "\nVolume of rhe Devices.Device: " + vol;
    }

    public static void main(String[] args){
        String version = "1.2"; Integer volume = 255;
        System.out.print(getInfo(version, volume));
    }
}
/* copyright BuchEE */