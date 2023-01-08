package ec.edu.epn;

public class Inventario {

    private float galonesSuper;
    private float galonesExtra;
    private float galonesDiesel;

    public void ingresarNivelTanques(float nivelSuper, float nivelExtra, float nivelDiesel){
        if ((double)nivelSuper <= 2.7) {
            this.galonesSuper = (float)(-761.4 * Math.pow((double)nivelSuper, 3.0) + (double)(3104.0F * nivelSuper * nivelSuper) + 2066.1 * (double)nivelSuper - 179.72);
        }
        if ((double)nivelExtra <= 2.7) {
            this.galonesExtra = (float)(-703.56 * Math.pow((double)nivelExtra, 3.0) + 2868.1 * (double)(nivelExtra * nivelExtra) + 1908.5 * (double)nivelExtra - 166.02);
        }
        if ((double)nivelDiesel <= 2.7) {
            this.galonesDiesel = (float)(-596.37 * Math.pow((double)nivelDiesel, 3.0) + 2431.2 * (double)(nivelDiesel * nivelDiesel) + 1617.8 * (double)nivelDiesel - 140.79);
        }
        this.imprimirNivelTanques();
    }

    public void imprimirNivelTanques() {
        System.out.println("Nivel tanque Super: " + this.galonesSuper);
        System.out.println("Nivel tanque Extra: " + this.galonesExtra);
        System.out.println("Nivel tanque Diesel: " + this.galonesDiesel);
    }

    public float getGalonesSuper() {
        return galonesSuper;
    }

    public float getGalonesExtra() {
        return galonesExtra;
    }

    public float getGalonesDiesel() {
        return galonesDiesel;
    }
}
