package model;

public class RepartizareSali {
    private int nr_sali;
    private int capacitate_sala;

    public RepartizareSali(int nr_sali, int capacitate_sala) {
        this.nr_sali = nr_sali;
        this.capacitate_sala = capacitate_sala;
    }

    public int[] repartizareCandidat(Candidat c){
        int index = 0;
        int v[] = new int[2]; // v[0] nr sall, v[1] numarul in sala
        v[1] = index % capacitate_sala;
        if (index % capacitate_sala == 0)
            v[0] = index / capacitate_sala;
        else
            v[0] = index / capacitate_sala + 1;
        System.out.println("Numarul salii: " + v[0] + "; Numarul locului in sala: " + v[1]);
        return v;
    }

    public int getNr_sali() {
        return nr_sali;
    }

    public void setNr_sali(int nr_sali) {
        this.nr_sali = nr_sali;
    }

    public int getCapacitate_sala() {
        return capacitate_sala;
    }

    public void setCapacitate_sala(int capacitate_sala) {
        this.capacitate_sala = capacitate_sala;
    }

    @Override
    public String toString() {
        return "RepartizareSali{" +
                "nr_sali=" + nr_sali +
                ", capacitate_sala=" + capacitate_sala +
                '}';
    }
}
