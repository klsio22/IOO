package ExLista_IOO_02.Temperatura;

public class Temperatura {
    private double celsius, fahrenheit, kelvin;


    public void setCelsius(double celsius) {
        //°F = °C × 1, 8 + 32
        this.celsius = celsius;
        kelvin = celsius + 273.15;
        fahrenheit = celsius * 1.8 + 32;
    }

    public void setKelvin(double kelvin) {
        //K-273.15 = C
        this.kelvin = kelvin;
        fahrenheit = celsius * 1.8 + 32;
        celsius = kelvin - 273.15;
    }

    public void setFahrenheit(double fahrenheit) {
        //°C = (°F − 32) ÷ 1,8
        this.fahrenheit = fahrenheit;
        celsius = (fahrenheit - 32) / 1.8;
        kelvin = celsius + 273.15;
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
