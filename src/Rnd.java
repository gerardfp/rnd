import java.util.Random;

class Rnd {
    static Random random = new Random();
    static char[] vowels = "aeiou".toCharArray();
    static char[] consonants = "bcdfghjklmnpqrstvwxyz".toCharArray();

    static class MyString {
        StringBuilder value = new StringBuilder();

        public MyString() {
        }

        public MyString(MyString value) {
            this.value.append(value);
        }

        void append(char value) {
            this.value.append(value);
        }

        void append(MyString value) {
            this.value.append(value);
        }

        MyString add(MyString value) {
            if (this.value.isEmpty()) append(value);
            else this.value.append(" ").append(value);
            return this;
        }

        MyString add(int probability, int lowerBound, int upperBound) {
            if (randomLottery(probability)) {
                add(randomString(lowerBound, upperBound));
            }
            return this;
        }

        MyString capitalize() {
            if (!value.isEmpty()) {
                value.setCharAt(0, Character.toUpperCase(value.charAt(0)));
            }
            return this;
        }

        public String toString() {
            return value.toString();
        }
    }

    static boolean randomLottery(int size) {
        return random.nextInt(size) == 0;
    }

    static MyString randomString(int lowerBound, int upperBound) {
        return new MyString(randomString(random.nextInt(upperBound - lowerBound) + lowerBound));
    }

    static MyString randomString(int size) {
        MyString result = new MyString();
        for (int i = 0; i < size; i++) {
            result.append(i % 2 == 0 ? consonants[random.nextInt(consonants.length)] : vowels[random.nextInt(vowels.length)]);
        }
        return result.capitalize();
    }

    static String rndName() {
        return new MyString()
                .add(1, 4, 8)
                .add(4, 2, 4)
                .add(1, 6, 14)
                .toString();
    }

    static String rndCity() {
        return new MyString()
                .add(8, 2, 4)
                .add(1, 6, 10)
                .toString();
    }

    static String rndTitle() {
        return new MyString()
                .add(4, 2, 6)
                .add(6, 6, 8)
                .add(1, 6, 14)
                .add(3, 2, 8)
                .add(2, 1, 4)
                .add(3, 6, 8)
                .add(2, 3, 9)
                .add(3, 6, 8)
                .toString();
    }

    static int rndYear() {
        return random.nextInt(523) + 1500;
    }
}
