package nl.qien.WeekopdrachtKermis;

public abstract class RisicoRijkeAttracties extends Attractie {
    protected abstract void opstellingsKeuring();
    boolean getKeuringNodig() {
        return true;
    }
    public void setKeuring() {
    }
}