package app;

import appliances.Washer;
import clothes.Clothes;
import tools.Color;
import tools.temperature.IronTemperature;
import tools.temperature.WashingTemperature;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Washer load() {
        return new Washer(new Clothes(new WashingTemperature(40), new IronTemperature(70), Color.COLOR));
    }

    public static Washer load(int washingTemperature, int ironTemperature, Color color) {
        return new Washer(new Clothes(new WashingTemperature(washingTemperature)
                , new IronTemperature(ironTemperature)
                , color));
    }

    public static void main(String[] args) {
        try {
            Washer washer;
            System.out.println("Do you want custom options?");
            if (reader.readLine().equals("1")) {
                washer = App.load();
            } else {
                System.out.println("Enter washing temperature");
                int washingTemperature = Integer.parseInt(reader.readLine());
                System.out.println("Enter iron temperature");
                int ironTemperature = Integer.parseInt(reader.readLine());
                System.out.println("Choose DARK, LIGHT, COLOR");
                Color color;
                switch (reader.readLine().toLowerCase().trim()) {
                    case "dark":
                        color = Color.DARK;
                        break;

                    case "light":
                        color = Color.LIGHT;
                        break;

                    case "color":
                        color = Color.COLOR;
                        break;

                    default:
                        throw new RuntimeException("Error of cloth's type");
                }

                washer = App.load(washingTemperature, ironTemperature, color);

            }
            for (int i = 0; i < 3; i++) {
                System.out.print("Wahing ");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.write(13);
            }
            System.out.println(washer.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
