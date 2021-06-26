package exercises;

abstract class Animal {
    public abstract void move(String s);

    public void move(int x) {
        System.out.println("teleport to " + x);
    }
}

class Fish extends Animal {
    public void move(String dest) {
        System.out.println("swim to " + dest);
    }
}

class Bird extends Animal {
    public void move(String dest) {
        System.out.println("fly to " + dest);
    }

    public void move(int x, int y) {
        System.out.println("fly to " + x + y);
    }
}

class RoadRunner extends Bird {
    public void move(String dest) {
        System.out.println("run to " + dest);
    }

    public void move(int x) {
        System.out.println("run faster to " + x);
    }
}

class OOP {
    public static void main(String[] args) {
        /*
        Fish shark = new Fish();
        Bird bird = new RoadRunner();
        Animal animal = new Bird();
        animal.move("the left");

        shark.move(0);
        bird.move(0);
        animal.move("the right");


         */

        Animal shark = new Fish();
        //Animal gnu = new Animal();
        RoadRunner coyote = new RoadRunner();
        //Fish nemo = coyote;
    }
}