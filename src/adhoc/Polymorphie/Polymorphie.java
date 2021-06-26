package adhoc.Polymorphie;

public class Polymorphie {
    public static void main(String[] args) {
    }
}

interface Roboter {
}

interface Haustier {
}

interface Tier {
}

interface Hundeartig extends Tier {
}

interface Katzenartig extends Tier {
}

class RoboDog implements Roboter, Haustier {
}

class Katze implements Haustier, Katzenartig {
}

class Löwe implements Katzenartig {
}

class Leopard implements Katzenartig {
}

class Elefant implements Tier {
}

class Panda implements Hundeartig {
}

class Hund implements Hundeartig {
}