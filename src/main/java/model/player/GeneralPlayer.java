package model.player;

public abstract class GeneralPlayer {
    private static int id = 0;
    private String name;

    public GeneralPlayer(String name) {
        id = ++id;
        this.name = name;
    }

    public abstract void doAction();
}

/*
1.
Imán - ESZEK BÉNÍTÓT
Balázs
Krisz
Robi
PHANTOM
off(Imán)
Balázs
Krisz
Robi
PHANTOM
off(Imán)
Balázs
Krisz
Robi
PHANTOM
Imán
Balázs
Krisz
Robi
PHANTOM
Imán
Balázs
Krisz
Robi

 */
