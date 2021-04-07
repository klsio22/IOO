package Temperatura;

public class Temperatura {
    private double celsius , fahrenheit , kelvin;


    public void setKelvin(double kelvin) {

        this.kelvin = kelvin;
    }

    public void setFahrenheit(double fahrenheit) {
        //°C = (°F − 32) ÷ 1, 8
        this.fahrenheit = fahrenheit;
    }

    public void setCelsius(double celsius) {
        //°F = °C × 1, 8 + 32
        this.celsius = celsius;
        kelvin = celsius + 273.15;
        fahrenheit = (celsius * 1.8) + 32.00;
    }

    public double getKelvin() {
        return kelvin;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public double getCelsius() {
        return celsius;
    }
}
