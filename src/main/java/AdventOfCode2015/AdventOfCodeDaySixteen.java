package AdventOfCode2015;

import java.util.ArrayList;

public class AdventOfCodeDaySixteen {

    private ArrayList<Aunt> aunts = new ArrayList<Aunt>();

    public void setup(String input) {
        int number = 0;
        for(String aunt : input.split("\n")) {
            int children = -1;
            int cats = -1;
            int samoyeds = -1;
            int pomeranians = -1;
            int akitas = -1;
            int vizslas = -1;
            int goldfish = -1;
            int trees = -1;
            int cars = -1;
            int perfumes = -1;
            aunt.replaceAll(",","");
            String[] giftValues = aunt.split(" ");

            if(giftValues[2].equals("cars:")) {
                cars = Integer.parseInt(giftValues[3].replace(",", ""));
            } else if(giftValues[2].equals("cats:")) {
                cats = Integer.parseInt(giftValues[3].replace(",", ""));
            } else if(giftValues[3].equals("samoyeds:")) {
                samoyeds = Integer.parseInt(giftValues[3].replace(",", ""));
            } else if(giftValues[2].equals("pomeranians:")) {
                pomeranians = Integer.parseInt(giftValues[3].replace(",", ""));
            } else if(giftValues[2].equals("akitas:")) {
                akitas = Integer.parseInt(giftValues[3].replace(",", ""));
            } else if(giftValues[2].equals("vizslas:")) {
                vizslas = Integer.parseInt(giftValues[3].replace(",", ""));
            } else if(giftValues[2].equals("goldfish:")) {
                goldfish = Integer.parseInt(giftValues[3].replace(",", ""));
            } else if(giftValues[2].equals("trees:")) {
                trees = Integer.parseInt(giftValues[3].replace(",", ""));
            } else if(giftValues[2].equals("perfumes:")) {
                perfumes = Integer.parseInt(giftValues[3].replace(",", ""));
            }

            if(giftValues[4].equals("cars:")) {
                cars = Integer.parseInt(giftValues[5].replace(",", ""));
            } else if(giftValues[4].equals("cats:")) {
                cats = Integer.parseInt(giftValues[5].replace(",", ""));
            } else if(giftValues[4].equals("samoyeds:")) {
                samoyeds = Integer.parseInt(giftValues[5].replace(",", ""));
            } else if(giftValues[4].equals("pomeranians:")) {
                pomeranians = Integer.parseInt(giftValues[5].replace(",", ""));
            } else if(giftValues[4].equals("akitas:")) {
                akitas = Integer.parseInt(giftValues[5].replace(",", ""));
            } else if(giftValues[4].equals("vizslas:")) {
                vizslas = Integer.parseInt(giftValues[5].replace(",", ""));
            } else if(giftValues[4].equals("goldfish:")) {
                goldfish = Integer.parseInt(giftValues[5].replace(",", ""));
            } else if(giftValues[4].equals("trees:")) {
                trees = Integer.parseInt(giftValues[5].replace(",", ""));
            } else if(giftValues[4].equals("perfumes:")) {
                perfumes = Integer.parseInt(giftValues[5].replace(",", ""));
            }

            if(giftValues[6].equals("cars:")) {
                cars = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("cats:")) {
                cats = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("samoyeds:")) {
                samoyeds = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("pomeranians:")) {
                pomeranians = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("akitas:")) {
                akitas = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("vizslas:")) {
                vizslas = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("goldfish:")) {
                goldfish = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("trees:")) {
                trees = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("perfumes:")) {
                perfumes = Integer.parseInt(giftValues[7].replace(",", ""));
            }




            else if(giftValues[6].equals("goldfish:")) {
                goldfish = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("trees:")) {
                trees = Integer.parseInt(giftValues[7].replace(",", ""));
            } else if(giftValues[6].equals("perfumes:")) {
                perfumes = Integer.parseInt(giftValues[7].replace(",", ""));
            }

            Aunt auntie = new Aunt(++number, children, cats, samoyeds, pomeranians, akitas, vizslas, goldfish, trees, cars, perfumes);
            aunts.add(auntie);
        }
    }

    public int getMatchingAuntie(int children, int cats, int samoyeds, int pomeranians, int akitas, int vizslas, int goldfish, int trees, int cars, int perfumes) {
        for(int i = 0; i < aunts.size(); i++) {
            if(aunts.get(i).match(children, cats, samoyeds, pomeranians, akitas, vizslas, goldfish, trees, cars, perfumes)) {
                System.out.println(++i);
                break;
            }
        }
        return -1;
    }

    public void getMatchingAuntiePartTwo(int children, int cats, int samoyeds, int pomeranians, int akitas, int vizslas, int goldfish, int trees, int cars, int perfumes) {
        for(int i = 0; i < aunts.size(); i++) {
            if(aunts.get(i).matchPartTwo(children, cats, samoyeds, pomeranians, akitas, vizslas, goldfish, trees, cars, perfumes)) {
                System.out.println(++i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AdventOfCodeDaySixteen adventOfCodeDaySixteen = new AdventOfCodeDaySixteen();
        adventOfCodeDaySixteen.setup(input);
        adventOfCodeDaySixteen.getMatchingAuntie(3, 7, 2, 3, 0, 0, 5, 3, 2, 1);
        adventOfCodeDaySixteen.getMatchingAuntiePartTwo(3, 7, 2, 3, 0, 0, 5, 3, 2, 1);
    }

    private class Aunt {
        private int number;
        private int children = -1;
        private int cats = -1;
        private int samoyeds = -1;
        private int pomeranians = -1;
        private int akitas = -1;
        int vizslas = -1;
        private int goldfish = -1;
        private int trees = -1;
        private int cars = -1;
        private int perfumes = -1;

        private Aunt(int number, int children, int cats, int samoyeds, int pomeranians, int akitas, int vizslas, int goldfish, int trees, int cars, int perfumes) {
            this.number = number;
            this.children = children;
            this.cats = cats;
            this.samoyeds = samoyeds;
            this.pomeranians = pomeranians;
            this.akitas = akitas;
            this.vizslas = vizslas;
            this.goldfish = goldfish;
            this.trees = trees;
            this.cars = cars;
            this.perfumes = perfumes;
        }

        public boolean match(int childrenCount, int catsCount, int samoyedsCount, int pomeraniansCount, int akitasCount, int vizslasCount, int goldfishCount, int treesCount, int carsCount, int perfumesCount) {
            int matchCount = 0;
            if (children == childrenCount && children != -1) {
                matchCount++;
            }
            if (cats == catsCount && cats != -1) {
                matchCount++;
            }
            if (samoyeds == samoyedsCount && samoyeds != -1) {
                matchCount++;
            }
            if (pomeranians == pomeraniansCount && pomeranians != -1) {
                matchCount++;
            }
            if (akitas == akitasCount && akitas != -1) {
                matchCount++;
            }
            if (vizslas == vizslasCount && vizslas != -1) {
                matchCount++;
            }

            if (goldfish == goldfishCount && goldfish != -1) {
                matchCount++;
            }
            if (trees == treesCount && trees != -1) {
                matchCount++;
            }
            if (cars == carsCount && cars != -1) {
                matchCount++;
            }
            if(perfumes == perfumesCount && perfumes != -1) {
                matchCount++;
            }
            if(matchCount == 3) {
                return true;
            }
            return false;
        }

        public boolean matchPartTwo(int childrenCount, int catsCount, int samoyedsCount, int pomeraniansCount, int akitasCount, int vizslasCount, int goldfishCount, int treesCount, int carsCount, int perfumesCount) {
            int matchCount = 0;
            if (children == childrenCount && children != -1) {
                matchCount++;
            }
            if (cats > catsCount && cats != -1) {
                matchCount++;
            }
            if (samoyeds == samoyedsCount && samoyeds != -1) {
                matchCount++;
            }
            if (pomeranians < pomeraniansCount && pomeranians != -1) {
                matchCount++;
            }
            if (akitas == akitasCount && akitas != -1) {

                matchCount++;
            }
            if (vizslas == vizslasCount && vizslas != -1) {
                matchCount++;
            }

            if (goldfish < goldfishCount && goldfish != -1) {
                matchCount++;
            }
            if (trees > treesCount && trees != -1) {
                matchCount++;
            }
            if (cars == carsCount && cars != -1) {
                matchCount++;
            }
            if(perfumes == perfumesCount && perfumes != -1) {
                matchCount++;
            }
            if(matchCount == 3) {
                System.out.println("match count: " + matchCount);
                System.out.println(toString());
                return true;
            }
            return false;
        }
    }

    private static final String input = "Sue 1: cars: 9, akitas: 3, goldfish: 0\n" +
                                        "Sue 2: akitas: 9, children: 3, samoyeds: 9\n" +
                                        "Sue 3: trees: 6, cars: 6, children: 4\n" +
                                        "Sue 4: trees: 4, vizslas: 4, goldfish: 9\n" +
                                        "Sue 5: akitas: 9, vizslas: 7, cars: 5\n" +
                                        "Sue 6: vizslas: 6, goldfish: 6, akitas: 3\n" +
                                        "Sue 7: pomeranians: 5, samoyeds: 0, perfumes: 10\n" +
                                        "Sue 8: cars: 10, pomeranians: 7, goldfish: 8\n" +
                                        "Sue 9: trees: 2, vizslas: 7, samoyeds: 6\n" +
                                        "Sue 10: perfumes: 5, pomeranians: 4, children: 9\n" +
                                        "Sue 11: vizslas: 5, perfumes: 8, cars: 10\n" +
                                        "Sue 12: children: 10, cars: 6, perfumes: 5\n" +
                                        "Sue 13: cats: 4, samoyeds: 7, pomeranians: 8\n" +
                                        "Sue 14: perfumes: 6, goldfish: 10, children: 7\n" +
                                        "Sue 15: perfumes: 4, pomeranians: 3, cars: 6\n" +
                                        "Sue 16: perfumes: 7, cars: 9, pomeranians: 6\n" +
                                        "Sue 17: goldfish: 3, cars: 6, vizslas: 7\n" +
                                        "Sue 18: perfumes: 6, cars: 7, goldfish: 3\n" +
                                        "Sue 19: trees: 0, akitas: 3, pomeranians: 8\n" +
                                        "Sue 20: goldfish: 6, trees: 2, akitas: 6\n" +
                                        "Sue 21: pomeranians: 9, akitas: 9, samoyeds: 9\n" +
                                        "Sue 22: vizslas: 2, cars: 9, perfumes: 5\n" +
                                        "Sue 23: goldfish: 10, samoyeds: 8, children: 9\n" +
                                        "Sue 24: akitas: 4, goldfish: 1, vizslas: 5\n" +
                                        "Sue 25: goldfish: 10, trees: 8, perfumes: 6\n" +
                                        "Sue 26: vizslas: 5, akitas: 8, trees: 1\n" +
                                        "Sue 27: trees: 3, cars: 6, perfumes: 2\n" +
                                        "Sue 28: goldfish: 8, trees: 7, akitas: 10\n" +
                                        "Sue 29: children: 5, trees: 1, goldfish: 10\n" +
                                        "Sue 30: vizslas: 3, perfumes: 8, akitas: 3\n" +
                                        "Sue 31: cars: 6, children: 10, perfumes: 7\n" +
                                        "Sue 32: cars: 10, perfumes: 3, goldfish: 10\n" +
                                        "Sue 33: perfumes: 9, vizslas: 3, akitas: 4\n" +
                                        "Sue 34: perfumes: 10, vizslas: 7, children: 8\n" +
                                        "Sue 35: cars: 5, perfumes: 5, vizslas: 9\n" +
                                        "Sue 36: trees: 9, cars: 9, akitas: 7\n" +
                                        "Sue 37: samoyeds: 9, perfumes: 2, cars: 10\n" +
                                        "Sue 38: akitas: 7, cars: 5, trees: 5\n" +
                                        "Sue 39: goldfish: 8, trees: 9, cars: 10\n" +
                                        "Sue 40: trees: 0, cats: 1, pomeranians: 1\n" +
                                        "Sue 41: pomeranians: 6, perfumes: 9, samoyeds: 1\n" +
                                        "Sue 42: vizslas: 6, akitas: 3, pomeranians: 1\n" +
                                        "Sue 43: vizslas: 2, perfumes: 3, pomeranians: 6\n" +
                                        "Sue 44: akitas: 5, pomeranians: 0, vizslas: 10\n" +
                                        "Sue 45: vizslas: 4, goldfish: 1, cars: 5\n" +
                                        "Sue 46: cars: 4, vizslas: 8, cats: 0\n" +
                                        "Sue 47: cats: 5, children: 8, pomeranians: 2\n" +
                                        "Sue 48: vizslas: 3, perfumes: 6, cats: 0\n" +
                                        "Sue 49: akitas: 7, perfumes: 0, trees: 7\n" +
                                        "Sue 50: trees: 4, akitas: 10, vizslas: 2\n" +
                                        "Sue 51: goldfish: 10, cars: 9, trees: 4\n" +
                                        "Sue 52: cars: 5, children: 9, perfumes: 0\n" +
                                        "Sue 53: vizslas: 5, cars: 3, cats: 8\n" +
                                        "Sue 54: cars: 5, akitas: 1, goldfish: 10\n" +
                                        "Sue 55: akitas: 10, vizslas: 2, cars: 6\n" +
                                        "Sue 56: cats: 6, trees: 0, cars: 4\n" +
                                        "Sue 57: vizslas: 1, akitas: 1, samoyeds: 7\n" +
                                        "Sue 58: samoyeds: 6, vizslas: 1, akitas: 7\n" +
                                        "Sue 59: akitas: 9, cars: 8, vizslas: 1\n" +
                                        "Sue 60: cars: 6, vizslas: 7, goldfish: 0\n" +
                                        "Sue 61: pomeranians: 5, akitas: 6, vizslas: 2\n" +
                                        "Sue 62: samoyeds: 2, cats: 8, goldfish: 7\n" +
                                        "Sue 63: vizslas: 10, goldfish: 7, samoyeds: 9\n" +
                                        "Sue 64: perfumes: 2, trees: 1, akitas: 6\n" +
                                        "Sue 65: cars: 8, perfumes: 10, vizslas: 9\n" +
                                        "Sue 66: akitas: 8, vizslas: 8, perfumes: 8\n" +
                                        "Sue 67: goldfish: 7, cars: 9, samoyeds: 9\n" +
                                        "Sue 68: perfumes: 2, children: 7, akitas: 1\n" +
                                        "Sue 69: perfumes: 7, vizslas: 9, akitas: 1\n" +
                                        "Sue 70: samoyeds: 3, vizslas: 1, trees: 1\n" +
                                        "Sue 71: vizslas: 8, goldfish: 7, trees: 9\n" +
                                        "Sue 72: goldfish: 8, cars: 6, trees: 9\n" +
                                        "Sue 73: perfumes: 5, cars: 10, samoyeds: 7\n" +
                                        "Sue 74: pomeranians: 4, perfumes: 3, cars: 5\n" +
                                        "Sue 75: samoyeds: 1, perfumes: 1, pomeranians: 1\n" +
                                        "Sue 76: goldfish: 4, cats: 6, akitas: 7\n" +
                                        "Sue 77: perfumes: 5, akitas: 4, vizslas: 8\n" +
                                        "Sue 78: perfumes: 4, cats: 3, children: 4\n" +
                                        "Sue 79: vizslas: 5, pomeranians: 9, samoyeds: 7\n" +
                                        "Sue 80: cars: 3, samoyeds: 5, pomeranians: 7\n" +
                                        "Sue 81: vizslas: 2, samoyeds: 4, perfumes: 2\n" +
                                        "Sue 82: trees: 1, akitas: 10, vizslas: 9\n" +
                                        "Sue 83: vizslas: 0, akitas: 2, samoyeds: 5\n" +
                                        "Sue 84: perfumes: 5, vizslas: 7, children: 8\n" +
                                        "Sue 85: cats: 3, children: 2, trees: 0\n" +
                                        "Sue 86: cars: 3, perfumes: 2, goldfish: 2\n" +
                                        "Sue 87: trees: 1, akitas: 7, vizslas: 0\n" +
                                        "Sue 88: trees: 1, akitas: 2, samoyeds: 1\n" +
                                        "Sue 89: cars: 4, vizslas: 8, akitas: 1\n" +
                                        "Sue 90: perfumes: 5, cats: 3, vizslas: 0\n" +
                                        "Sue 91: samoyeds: 7, cats: 6, goldfish: 8\n" +
                                        "Sue 92: samoyeds: 10, cats: 0, cars: 7\n" +
                                        "Sue 93: cars: 6, akitas: 7, samoyeds: 2\n" +
                                        "Sue 94: perfumes: 0, goldfish: 6, trees: 9\n" +
                                        "Sue 95: cars: 6, pomeranians: 2, samoyeds: 8\n" +
                                        "Sue 96: cars: 2, trees: 9, samoyeds: 4\n" +
                                        "Sue 97: goldfish: 5, trees: 1, children: 0\n" +
                                        "Sue 98: akitas: 9, goldfish: 7, children: 6\n" +
                                        "Sue 99: goldfish: 9, akitas: 0, pomeranians: 0\n" +
                                        "Sue 100: samoyeds: 6, children: 8, vizslas: 5\n" +
                                        "Sue 101: vizslas: 6, cars: 5, goldfish: 4\n" +
                                        "Sue 102: vizslas: 6, akitas: 2, perfumes: 6\n" +
                                        "Sue 103: samoyeds: 3, akitas: 7, children: 4\n" +
                                        "Sue 104: cars: 3, perfumes: 10, cats: 6\n" +
                                        "Sue 105: vizslas: 9, pomeranians: 0, cars: 1\n" +
                                        "Sue 106: cats: 6, samoyeds: 8, pomeranians: 5\n" +
                                        "Sue 107: cars: 7, trees: 4, akitas: 10\n" +
                                        "Sue 108: perfumes: 3, vizslas: 1, goldfish: 9\n" +
                                        "Sue 109: trees: 6, cars: 8, goldfish: 5\n" +
                                        "Sue 110: pomeranians: 2, children: 1, vizslas: 7\n" +
                                        "Sue 111: akitas: 0, vizslas: 8, cars: 0\n" +
                                        "Sue 112: goldfish: 3, vizslas: 6, akitas: 2\n" +
                                        "Sue 113: akitas: 10, pomeranians: 7, perfumes: 7\n" +
                                        "Sue 114: cars: 10, cats: 2, vizslas: 8\n" +
                                        "Sue 115: akitas: 8, trees: 1, vizslas: 2\n" +
                                        "Sue 116: vizslas: 2, akitas: 7, perfumes: 1\n" +
                                        "Sue 117: goldfish: 0, vizslas: 10, trees: 9\n" +
                                        "Sue 118: trees: 3, cars: 0, goldfish: 0\n" +
                                        "Sue 119: perfumes: 7, goldfish: 5, trees: 9\n" +
                                        "Sue 120: children: 9, vizslas: 3, trees: 5\n" +
                                        "Sue 121: vizslas: 1, goldfish: 7, akitas: 10\n" +
                                        "Sue 122: perfumes: 1, cars: 6, trees: 1\n" +
                                        "Sue 123: akitas: 2, vizslas: 0, goldfish: 7\n" +
                                        "Sue 124: vizslas: 10, pomeranians: 7, akitas: 0\n" +
                                        "Sue 125: perfumes: 4, cats: 5, vizslas: 2\n" +
                                        "Sue 126: cars: 6, samoyeds: 8, akitas: 3\n" +
                                        "Sue 127: trees: 9, goldfish: 7, akitas: 9\n" +
                                        "Sue 128: cars: 8, trees: 0, perfumes: 2\n" +
                                        "Sue 129: pomeranians: 7, vizslas: 2, perfumes: 6\n" +
                                        "Sue 130: vizslas: 9, pomeranians: 3, trees: 6\n" +
                                        "Sue 131: vizslas: 7, cars: 9, perfumes: 1\n" +
                                        "Sue 132: akitas: 2, pomeranians: 9, vizslas: 7\n" +
                                        "Sue 133: trees: 9, pomeranians: 10, samoyeds: 0\n" +
                                        "Sue 134: children: 4, akitas: 10, perfumes: 4\n" +
                                        "Sue 135: vizslas: 1, cats: 1, trees: 8\n" +
                                        "Sue 136: samoyeds: 7, cars: 8, goldfish: 5\n" +
                                        "Sue 137: perfumes: 0, children: 1, pomeranians: 10\n" +
                                        "Sue 138: vizslas: 4, perfumes: 5, cars: 5\n" +
                                        "Sue 139: trees: 2, perfumes: 8, goldfish: 0\n" +
                                        "Sue 140: cars: 10, akitas: 5, goldfish: 7\n" +
                                        "Sue 141: children: 4, trees: 3, goldfish: 8\n" +
                                        "Sue 142: cars: 8, perfumes: 6, trees: 7\n" +
                                        "Sue 143: akitas: 6, goldfish: 0, trees: 10\n" +
                                        "Sue 144: akitas: 7, pomeranians: 10, perfumes: 10\n" +
                                        "Sue 145: trees: 10, vizslas: 3, goldfish: 4\n" +
                                        "Sue 146: samoyeds: 4, akitas: 3, perfumes: 6\n" +
                                        "Sue 147: akitas: 8, perfumes: 2, pomeranians: 10\n" +
                                        "Sue 148: cars: 2, perfumes: 0, goldfish: 8\n" +
                                        "Sue 149: goldfish: 6, akitas: 7, perfumes: 6\n" +
                                        "Sue 150: cars: 2, pomeranians: 5, perfumes: 4\n" +
                                        "Sue 151: goldfish: 1, cars: 5, trees: 0\n" +
                                        "Sue 152: pomeranians: 4, cars: 7, children: 1\n" +
                                        "Sue 153: goldfish: 8, cars: 1, children: 10\n" +
                                        "Sue 154: cars: 6, perfumes: 8, trees: 1\n" +
                                        "Sue 155: akitas: 4, perfumes: 6, pomeranians: 2\n" +
                                        "Sue 156: pomeranians: 5, cars: 4, akitas: 1\n" +
                                        "Sue 157: cats: 5, cars: 9, goldfish: 8\n" +
                                        "Sue 158: vizslas: 5, samoyeds: 1, children: 7\n" +
                                        "Sue 159: vizslas: 1, perfumes: 3, akitas: 1\n" +
                                        "Sue 160: goldfish: 10, pomeranians: 9, perfumes: 5\n" +
                                        "Sue 161: samoyeds: 3, trees: 7, cars: 2\n" +
                                        "Sue 162: cars: 2, pomeranians: 1, vizslas: 6\n" +
                                        "Sue 163: vizslas: 3, perfumes: 5, akitas: 6\n" +
                                        "Sue 164: vizslas: 1, trees: 0, akitas: 5\n" +
                                        "Sue 165: vizslas: 5, cars: 6, pomeranians: 8\n" +
                                        "Sue 166: cars: 10, perfumes: 2, trees: 9\n" +
                                        "Sue 167: cars: 10, pomeranians: 6, perfumes: 4\n" +
                                        "Sue 168: akitas: 7, trees: 10, goldfish: 7\n" +
                                        "Sue 169: akitas: 1, perfumes: 10, cars: 10\n" +
                                        "Sue 170: akitas: 5, samoyeds: 8, vizslas: 6\n" +
                                        "Sue 171: children: 3, akitas: 2, vizslas: 3\n" +
                                        "Sue 172: goldfish: 5, vizslas: 5, perfumes: 9\n" +
                                        "Sue 173: perfumes: 5, goldfish: 10, trees: 5\n" +
                                        "Sue 174: akitas: 5, vizslas: 2, children: 7\n" +
                                        "Sue 175: perfumes: 5, cars: 7, samoyeds: 2\n" +
                                        "Sue 176: cars: 8, vizslas: 10, akitas: 7\n" +
                                        "Sue 177: perfumes: 7, children: 8, goldfish: 7\n" +
                                        "Sue 178: cars: 1, pomeranians: 9, samoyeds: 0\n" +
                                        "Sue 179: perfumes: 6, cars: 2, trees: 6\n" +
                                        "Sue 180: trees: 3, vizslas: 7, children: 3\n" +
                                        "Sue 181: vizslas: 8, samoyeds: 2, trees: 9\n" +
                                        "Sue 182: perfumes: 3, cats: 1, children: 5\n" +
                                        "Sue 183: akitas: 9, cats: 6, children: 3\n" +
                                        "Sue 184: pomeranians: 9, cars: 6, perfumes: 8\n" +
                                        "Sue 185: vizslas: 9, trees: 0, akitas: 9\n" +
                                        "Sue 186: perfumes: 6, cars: 5, goldfish: 5\n" +
                                        "Sue 187: perfumes: 4, cats: 7, vizslas: 2\n" +
                                        "Sue 188: akitas: 7, cars: 4, children: 10\n" +
                                        "Sue 189: akitas: 0, goldfish: 7, vizslas: 5\n" +
                                        "Sue 190: akitas: 5, cars: 5, cats: 6\n" +
                                        "Sue 191: cars: 6, children: 0, perfumes: 3\n" +
                                        "Sue 192: cats: 2, perfumes: 10, goldfish: 7\n" +
                                        "Sue 193: trees: 1, perfumes: 0, cars: 8\n" +
                                        "Sue 194: perfumes: 9, children: 4, cats: 6\n" +
                                        "Sue 195: akitas: 7, trees: 3, goldfish: 6\n" +
                                        "Sue 196: goldfish: 8, cars: 8, samoyeds: 0\n" +
                                        "Sue 197: cats: 0, akitas: 10, vizslas: 0\n" +
                                        "Sue 198: goldfish: 1, perfumes: 3, cars: 8\n" +
                                        "Sue 199: akitas: 10, vizslas: 5, samoyeds: 6\n" +
                                        "Sue 200: pomeranians: 9, goldfish: 9, samoyeds: 7\n" +
                                        "Sue 201: samoyeds: 0, goldfish: 7, akitas: 6\n" +
                                        "Sue 202: vizslas: 0, goldfish: 2, akitas: 1\n" +
                                        "Sue 203: goldfish: 3, children: 0, vizslas: 8\n" +
                                        "Sue 204: cars: 8, trees: 2, perfumes: 2\n" +
                                        "Sue 205: cars: 4, perfumes: 5, goldfish: 8\n" +
                                        "Sue 206: vizslas: 3, trees: 2, akitas: 1\n" +
                                        "Sue 207: cars: 7, goldfish: 5, trees: 1\n" +
                                        "Sue 208: goldfish: 1, cars: 6, vizslas: 8\n" +
                                        "Sue 209: cats: 4, trees: 1, children: 0\n" +
                                        "Sue 210: cats: 10, children: 0, perfumes: 0\n" +
                                        "Sue 211: cars: 4, pomeranians: 7, samoyeds: 5\n" +
                                        "Sue 212: cars: 2, pomeranians: 10, trees: 1\n" +
                                        "Sue 213: trees: 10, cats: 5, cars: 10\n" +
                                        "Sue 214: perfumes: 5, trees: 1, vizslas: 1\n" +
                                        "Sue 215: akitas: 10, vizslas: 8, samoyeds: 8\n" +
                                        "Sue 216: vizslas: 2, cats: 5, pomeranians: 3\n" +
                                        "Sue 217: akitas: 10, perfumes: 0, cats: 10\n" +
                                        "Sue 218: trees: 8, cats: 5, vizslas: 2\n" +
                                        "Sue 219: goldfish: 10, perfumes: 8, children: 2\n" +
                                        "Sue 220: samoyeds: 9, trees: 8, vizslas: 7\n" +
                                        "Sue 221: children: 7, trees: 6, cars: 6\n" +
                                        "Sue 222: cats: 4, akitas: 5, pomeranians: 0\n" +
                                        "Sue 223: trees: 8, goldfish: 2, perfumes: 8\n" +
                                        "Sue 224: pomeranians: 9, cars: 8, akitas: 5\n" +
                                        "Sue 225: akitas: 10, vizslas: 0, trees: 2\n" +
                                        "Sue 226: akitas: 8, cats: 6, cars: 7\n" +
                                        "Sue 227: trees: 1, akitas: 3, goldfish: 4\n" +
                                        "Sue 228: pomeranians: 6, cats: 3, goldfish: 3\n" +
                                        "Sue 229: trees: 10, perfumes: 3, vizslas: 7\n" +
                                        "Sue 230: perfumes: 8, cars: 7, akitas: 0\n" +
                                        "Sue 231: perfumes: 10, goldfish: 4, cars: 6\n" +
                                        "Sue 232: goldfish: 7, trees: 3, cats: 2\n" +
                                        "Sue 233: perfumes: 6, trees: 4, akitas: 4\n" +
                                        "Sue 234: goldfish: 9, cats: 4, cars: 7\n" +
                                        "Sue 235: pomeranians: 6, vizslas: 0, akitas: 6\n" +
                                        "Sue 236: samoyeds: 5, cars: 5, children: 4\n" +
                                        "Sue 237: vizslas: 10, cars: 4, goldfish: 4\n" +
                                        "Sue 238: goldfish: 3, samoyeds: 7, akitas: 2\n" +
                                        "Sue 239: cats: 8, children: 2, vizslas: 7\n" +
                                        "Sue 240: cars: 9, perfumes: 4, trees: 9\n" +
                                        "Sue 241: trees: 8, vizslas: 2, goldfish: 5\n" +
                                        "Sue 242: cars: 6, trees: 3, vizslas: 3\n" +
                                        "Sue 243: cats: 6, children: 7, cars: 4\n" +
                                        "Sue 244: cats: 10, perfumes: 2, goldfish: 7\n" +
                                        "Sue 245: akitas: 8, cats: 10, perfumes: 8\n" +
                                        "Sue 246: vizslas: 8, akitas: 5, perfumes: 10\n" +
                                        "Sue 247: goldfish: 2, vizslas: 5, akitas: 7\n" +
                                        "Sue 248: akitas: 3, perfumes: 0, trees: 10\n" +
                                        "Sue 249: cats: 4, vizslas: 5, pomeranians: 6\n" +
                                        "Sue 250: children: 3, vizslas: 7, perfumes: 2\n" +
                                        "Sue 251: cars: 0, pomeranians: 10, perfumes: 0\n" +
                                        "Sue 252: akitas: 0, goldfish: 9, cars: 6\n" +
                                        "Sue 253: perfumes: 7, cars: 4, samoyeds: 5\n" +
                                        "Sue 254: akitas: 9, trees: 10, cars: 4\n" +
                                        "Sue 255: samoyeds: 10, children: 6, akitas: 7\n" +
                                        "Sue 256: trees: 8, goldfish: 8, perfumes: 8\n" +
                                        "Sue 257: goldfish: 3, akitas: 2, perfumes: 6\n" +
                                        "Sue 258: cats: 7, trees: 0, vizslas: 1\n" +
                                        "Sue 259: perfumes: 7, cars: 7, akitas: 7\n" +
                                        "Sue 260: goldfish: 0, vizslas: 0, samoyeds: 2\n" +
                                        "Sue 261: vizslas: 2, children: 2, cats: 3\n" +
                                        "Sue 262: vizslas: 2, pomeranians: 9, samoyeds: 3\n" +
                                        "Sue 263: cats: 1, akitas: 3, vizslas: 1\n" +
                                        "Sue 264: pomeranians: 10, trees: 2, goldfish: 7\n" +
                                        "Sue 265: samoyeds: 5, trees: 7, perfumes: 4\n" +
                                        "Sue 266: perfumes: 10, cars: 1, pomeranians: 3\n" +
                                        "Sue 267: trees: 6, goldfish: 1, cars: 0\n" +
                                        "Sue 268: cars: 6, samoyeds: 4, pomeranians: 5\n" +
                                        "Sue 269: goldfish: 3, vizslas: 3, akitas: 3\n" +
                                        "Sue 270: children: 5, cats: 0, cars: 4\n" +
                                        "Sue 271: goldfish: 3, perfumes: 8, pomeranians: 7\n" +
                                        "Sue 272: samoyeds: 6, cars: 7, perfumes: 10\n" +
                                        "Sue 273: trees: 4, cars: 2, vizslas: 7\n" +
                                        "Sue 274: samoyeds: 10, perfumes: 9, goldfish: 6\n" +
                                        "Sue 275: cars: 4, trees: 2, perfumes: 7\n" +
                                        "Sue 276: akitas: 3, perfumes: 9, cars: 9\n" +
                                        "Sue 277: akitas: 8, vizslas: 2, cats: 6\n" +
                                        "Sue 278: trees: 5, goldfish: 7, akitas: 3\n" +
                                        "Sue 279: perfumes: 9, cars: 8, vizslas: 2\n" +
                                        "Sue 280: trees: 3, vizslas: 0, children: 0\n" +
                                        "Sue 281: cars: 7, trees: 2, cats: 5\n" +
                                        "Sue 282: vizslas: 4, cars: 10, cats: 3\n" +
                                        "Sue 283: akitas: 10, cats: 3, samoyeds: 9\n" +
                                        "Sue 284: trees: 7, children: 5, goldfish: 6\n" +
                                        "Sue 285: cars: 2, perfumes: 5, cats: 7\n" +
                                        "Sue 286: samoyeds: 5, trees: 10, goldfish: 6\n" +
                                        "Sue 287: goldfish: 10, perfumes: 4, trees: 7\n" +
                                        "Sue 288: vizslas: 9, trees: 9, perfumes: 0\n" +
                                        "Sue 289: trees: 4, goldfish: 9, vizslas: 8\n" +
                                        "Sue 290: vizslas: 3, cars: 3, trees: 2\n" +
                                        "Sue 291: goldfish: 2, akitas: 2, trees: 2\n" +
                                        "Sue 292: children: 1, cars: 0, vizslas: 5\n" +
                                        "Sue 293: trees: 5, akitas: 4, goldfish: 6\n" +
                                        "Sue 294: akitas: 3, vizslas: 7, pomeranians: 5\n" +
                                        "Sue 295: goldfish: 10, vizslas: 3, trees: 1\n" +
                                        "Sue 296: cars: 2, trees: 1, akitas: 0\n" +
                                        "Sue 297: akitas: 10, vizslas: 6, samoyeds: 2\n" +
                                        "Sue 298: children: 5, trees: 1, samoyeds: 9\n" +
                                        "Sue 299: perfumes: 9, trees: 6, vizslas: 1\n" +
                                        "Sue 300: akitas: 7, pomeranians: 6, vizslas: 6\n" +
                                        "Sue 301: cats: 7, children: 6, vizslas: 7\n" +
                                        "Sue 302: trees: 2, vizslas: 7, samoyeds: 4\n" +
                                        "Sue 303: goldfish: 0, samoyeds: 10, cars: 4\n" +
                                        "Sue 304: pomeranians: 9, children: 3, vizslas: 5\n" +
                                        "Sue 305: akitas: 8, vizslas: 4, cars: 5\n" +
                                        "Sue 306: akitas: 0, perfumes: 2, pomeranians: 10\n" +
                                        "Sue 307: akitas: 9, cars: 0, trees: 2\n" +
                                        "Sue 308: vizslas: 10, goldfish: 8, akitas: 6\n" +
                                        "Sue 309: trees: 0, cats: 6, perfumes: 2\n" +
                                        "Sue 310: vizslas: 10, cars: 1, trees: 4\n" +
                                        "Sue 311: goldfish: 8, perfumes: 6, cats: 3\n" +
                                        "Sue 312: goldfish: 0, children: 1, akitas: 2\n" +
                                        "Sue 313: pomeranians: 10, trees: 6, samoyeds: 6\n" +
                                        "Sue 314: vizslas: 5, akitas: 4, pomeranians: 2\n" +
                                        "Sue 315: goldfish: 7, trees: 0, akitas: 5\n" +
                                        "Sue 316: goldfish: 4, vizslas: 5, cars: 7\n" +
                                        "Sue 317: perfumes: 7, cats: 10, cars: 4\n" +
                                        "Sue 318: samoyeds: 10, cars: 9, trees: 7\n" +
                                        "Sue 319: pomeranians: 8, vizslas: 6, cars: 3\n" +
                                        "Sue 320: cars: 4, cats: 9, akitas: 4\n" +
                                        "Sue 321: cars: 6, trees: 2, perfumes: 6\n" +
                                        "Sue 322: goldfish: 1, cats: 2, perfumes: 4\n" +
                                        "Sue 323: akitas: 6, cats: 5, cars: 8\n" +
                                        "Sue 324: cats: 4, vizslas: 9, akitas: 0\n" +
                                        "Sue 325: children: 8, samoyeds: 9, trees: 4\n" +
                                        "Sue 326: vizslas: 2, samoyeds: 10, perfumes: 7\n" +
                                        "Sue 327: goldfish: 7, pomeranians: 4, akitas: 10\n" +
                                        "Sue 328: perfumes: 8, cats: 4, akitas: 10\n" +
                                        "Sue 329: trees: 0, cars: 9, goldfish: 3\n" +
                                        "Sue 330: trees: 5, samoyeds: 7, perfumes: 8\n" +
                                        "Sue 331: cars: 4, perfumes: 2, goldfish: 0\n" +
                                        "Sue 332: vizslas: 4, pomeranians: 7, akitas: 1\n" +
                                        "Sue 333: akitas: 4, goldfish: 3, perfumes: 0\n" +
                                        "Sue 334: samoyeds: 3, akitas: 10, vizslas: 0\n" +
                                        "Sue 335: goldfish: 1, akitas: 7, vizslas: 6\n" +
                                        "Sue 336: perfumes: 1, goldfish: 1, pomeranians: 8\n" +
                                        "Sue 337: children: 5, cars: 4, cats: 4\n" +
                                        "Sue 338: vizslas: 5, cars: 10, cats: 3\n" +
                                        "Sue 339: trees: 2, goldfish: 3, cars: 1\n" +
                                        "Sue 340: trees: 10, goldfish: 6, perfumes: 2\n" +
                                        "Sue 341: akitas: 5, trees: 6, cats: 3\n" +
                                        "Sue 342: cars: 10, children: 8, goldfish: 0\n" +
                                        "Sue 343: cats: 2, akitas: 0, pomeranians: 4\n" +
                                        "Sue 344: perfumes: 1, vizslas: 3, cars: 3\n" +
                                        "Sue 345: samoyeds: 8, cats: 5, perfumes: 8\n" +
                                        "Sue 346: cars: 5, akitas: 10, trees: 2\n" +
                                        "Sue 347: vizslas: 9, akitas: 9, cars: 3\n" +
                                        "Sue 348: cars: 3, perfumes: 1, pomeranians: 9\n" +
                                        "Sue 349: akitas: 1, cars: 4, perfumes: 0\n" +
                                        "Sue 350: perfumes: 8, vizslas: 2, trees: 6\n" +
                                        "Sue 351: pomeranians: 5, akitas: 9, cats: 8\n" +
                                        "Sue 352: pomeranians: 8, vizslas: 3, goldfish: 10\n" +
                                        "Sue 353: trees: 2, pomeranians: 0, goldfish: 6\n" +
                                        "Sue 354: cats: 5, akitas: 7, goldfish: 6\n" +
                                        "Sue 355: goldfish: 6, children: 4, trees: 10\n" +
                                        "Sue 356: children: 1, trees: 3, akitas: 7\n" +
                                        "Sue 357: trees: 2, samoyeds: 10, goldfish: 3\n" +
                                        "Sue 358: samoyeds: 10, cats: 0, goldfish: 0\n" +
                                        "Sue 359: perfumes: 3, children: 6, pomeranians: 1\n" +
                                        "Sue 360: cars: 10, pomeranians: 1, samoyeds: 5\n" +
                                        "Sue 361: samoyeds: 9, pomeranians: 7, perfumes: 6\n" +
                                        "Sue 362: goldfish: 6, trees: 8, perfumes: 9\n" +
                                        "Sue 363: samoyeds: 10, pomeranians: 9, children: 10\n" +
                                        "Sue 364: perfumes: 3, goldfish: 7, cars: 9\n" +
                                        "Sue 365: cats: 3, children: 4, samoyeds: 8\n" +
                                        "Sue 366: trees: 0, cars: 10, vizslas: 10\n" +
                                        "Sue 367: pomeranians: 10, children: 8, perfumes: 2\n" +
                                        "Sue 368: cars: 5, vizslas: 0, samoyeds: 3\n" +
                                        "Sue 369: trees: 1, goldfish: 8, cars: 8\n" +
                                        "Sue 370: vizslas: 0, cars: 2, perfumes: 5\n" +
                                        "Sue 371: trees: 2, cars: 3, vizslas: 8\n" +
                                        "Sue 372: trees: 10, children: 9, cats: 1\n" +
                                        "Sue 373: pomeranians: 3, perfumes: 1, vizslas: 0\n" +
                                        "Sue 374: vizslas: 0, perfumes: 6, trees: 0\n" +
                                        "Sue 375: vizslas: 7, pomeranians: 1, akitas: 10\n" +
                                        "Sue 376: vizslas: 8, trees: 2, cars: 10\n" +
                                        "Sue 377: perfumes: 9, cats: 5, goldfish: 5\n" +
                                        "Sue 378: cats: 0, akitas: 10, perfumes: 9\n" +
                                        "Sue 379: cars: 4, akitas: 1, trees: 1\n" +
                                        "Sue 380: cars: 4, perfumes: 5, trees: 3\n" +
                                        "Sue 381: goldfish: 3, akitas: 5, samoyeds: 9\n" +
                                        "Sue 382: goldfish: 7, perfumes: 5, trees: 5\n" +
                                        "Sue 383: akitas: 4, cats: 6, cars: 8\n" +
                                        "Sue 384: children: 6, goldfish: 10, akitas: 7\n" +
                                        "Sue 385: akitas: 7, vizslas: 5, perfumes: 10\n" +
                                        "Sue 386: children: 7, vizslas: 10, akitas: 10\n" +
                                        "Sue 387: goldfish: 6, akitas: 7, trees: 2\n" +
                                        "Sue 388: vizslas: 6, trees: 1, akitas: 2\n" +
                                        "Sue 389: cars: 5, vizslas: 3, akitas: 7\n" +
                                        "Sue 390: vizslas: 4, cats: 8, perfumes: 7\n" +
                                        "Sue 391: akitas: 3, trees: 0, children: 2\n" +
                                        "Sue 392: cats: 7, cars: 3, children: 9\n" +
                                        "Sue 393: trees: 10, vizslas: 3, goldfish: 7\n" +
                                        "Sue 394: perfumes: 0, goldfish: 7, akitas: 4\n" +
                                        "Sue 395: cats: 6, cars: 7, vizslas: 0\n" +
                                        "Sue 396: vizslas: 4, perfumes: 6, goldfish: 5\n" +
                                        "Sue 397: pomeranians: 8, trees: 1, akitas: 9\n" +
                                        "Sue 398: goldfish: 7, pomeranians: 6, samoyeds: 9\n" +
                                        "Sue 399: perfumes: 10, cars: 1, trees: 8\n" +
                                        "Sue 400: trees: 0, goldfish: 9, children: 6\n" +
                                        "Sue 401: trees: 1, cars: 6, pomeranians: 8\n" +
                                        "Sue 402: perfumes: 9, cars: 0, vizslas: 10\n" +
                                        "Sue 403: samoyeds: 4, akitas: 1, vizslas: 9\n" +
                                        "Sue 404: perfumes: 0, trees: 2, cars: 4\n" +
                                        "Sue 405: akitas: 0, perfumes: 5, samoyeds: 4\n" +
                                        "Sue 406: akitas: 8, vizslas: 6, children: 2\n" +
                                        "Sue 407: children: 1, trees: 8, goldfish: 10\n" +
                                        "Sue 408: pomeranians: 4, trees: 10, cars: 9\n" +
                                        "Sue 409: perfumes: 5, vizslas: 5, akitas: 4\n" +
                                        "Sue 410: trees: 1, akitas: 10, vizslas: 6\n" +
                                        "Sue 411: samoyeds: 0, goldfish: 9, perfumes: 7\n" +
                                        "Sue 412: goldfish: 7, samoyeds: 10, trees: 1\n" +
                                        "Sue 413: samoyeds: 0, pomeranians: 10, vizslas: 6\n" +
                                        "Sue 414: children: 2, cars: 10, samoyeds: 2\n" +
                                        "Sue 415: trees: 2, goldfish: 8, cars: 0\n" +
                                        "Sue 416: samoyeds: 4, goldfish: 9, trees: 2\n" +
                                        "Sue 417: trees: 8, akitas: 10, perfumes: 3\n" +
                                        "Sue 418: samoyeds: 9, goldfish: 2, cars: 1\n" +
                                        "Sue 419: akitas: 2, perfumes: 8, trees: 2\n" +
                                        "Sue 420: children: 3, goldfish: 6, perfumes: 5\n" +
                                        "Sue 421: akitas: 8, perfumes: 2, samoyeds: 6\n" +
                                        "Sue 422: vizslas: 10, akitas: 4, pomeranians: 3\n" +
                                        "Sue 423: cats: 8, perfumes: 3, trees: 4\n" +
                                        "Sue 424: cars: 2, children: 4, pomeranians: 8\n" +
                                        "Sue 425: pomeranians: 4, samoyeds: 2, goldfish: 4\n" +
                                        "Sue 426: perfumes: 6, cars: 4, goldfish: 4\n" +
                                        "Sue 427: akitas: 0, goldfish: 7, perfumes: 5\n" +
                                        "Sue 428: perfumes: 4, cars: 3, akitas: 5\n" +
                                        "Sue 429: trees: 0, vizslas: 0, goldfish: 1\n" +
                                        "Sue 430: perfumes: 4, vizslas: 2, cars: 7\n" +
                                        "Sue 431: goldfish: 7, pomeranians: 8, trees: 0\n" +
                                        "Sue 432: goldfish: 7, children: 9, trees: 3\n" +
                                        "Sue 433: akitas: 1, vizslas: 10, trees: 2\n" +
                                        "Sue 434: perfumes: 2, cars: 4, goldfish: 10\n" +
                                        "Sue 435: pomeranians: 6, vizslas: 9, trees: 1\n" +
                                        "Sue 436: cars: 9, trees: 0, goldfish: 0\n" +
                                        "Sue 437: trees: 1, goldfish: 1, vizslas: 8\n" +
                                        "Sue 438: goldfish: 7, samoyeds: 8, children: 2\n" +
                                        "Sue 439: children: 1, cats: 7, vizslas: 8\n" +
                                        "Sue 440: cats: 2, pomeranians: 6, goldfish: 4\n" +
                                        "Sue 441: perfumes: 7, cats: 3, vizslas: 6\n" +
                                        "Sue 442: akitas: 4, samoyeds: 5, cars: 2\n" +
                                        "Sue 443: akitas: 3, perfumes: 3, cats: 9\n" +
                                        "Sue 444: perfumes: 10, akitas: 6, trees: 0\n" +
                                        "Sue 445: cars: 5, children: 9, perfumes: 8\n" +
                                        "Sue 446: vizslas: 10, cars: 3, perfumes: 5\n" +
                                        "Sue 447: children: 9, perfumes: 1, cars: 10\n" +
                                        "Sue 448: akitas: 0, goldfish: 8, trees: 3\n" +
                                        "Sue 449: cars: 7, akitas: 8, children: 3\n" +
                                        "Sue 450: cars: 4, akitas: 9, cats: 0\n" +
                                        "Sue 451: perfumes: 4, samoyeds: 5, goldfish: 6\n" +
                                        "Sue 452: perfumes: 10, akitas: 1, cars: 7\n" +
                                        "Sue 453: trees: 1, goldfish: 3, vizslas: 6\n" +
                                        "Sue 454: goldfish: 8, pomeranians: 6, trees: 10\n" +
                                        "Sue 455: akitas: 5, vizslas: 8, goldfish: 10\n" +
                                        "Sue 456: cats: 5, trees: 4, samoyeds: 0\n" +
                                        "Sue 457: perfumes: 8, cars: 0, cats: 3\n" +
                                        "Sue 458: akitas: 1, trees: 10, vizslas: 2\n" +
                                        "Sue 459: vizslas: 6, akitas: 3, children: 10\n" +
                                        "Sue 460: perfumes: 7, trees: 9, goldfish: 8\n" +
                                        "Sue 461: children: 6, vizslas: 4, perfumes: 5\n" +
                                        "Sue 462: vizslas: 6, akitas: 8, perfumes: 9\n" +
                                        "Sue 463: goldfish: 8, cars: 4, trees: 10\n" +
                                        "Sue 464: pomeranians: 8, cars: 5, vizslas: 0\n" +
                                        "Sue 465: cats: 10, goldfish: 7, akitas: 1\n" +
                                        "Sue 466: cats: 2, children: 1, cars: 6\n" +
                                        "Sue 467: perfumes: 3, samoyeds: 6, cars: 0\n" +
                                        "Sue 468: samoyeds: 10, pomeranians: 6, trees: 2\n" +
                                        "Sue 469: children: 2, perfumes: 2, pomeranians: 4\n" +
                                        "Sue 470: cats: 1, perfumes: 5, vizslas: 9\n" +
                                        "Sue 471: vizslas: 5, perfumes: 2, akitas: 7\n" +
                                        "Sue 472: samoyeds: 8, goldfish: 6, cats: 1\n" +
                                        "Sue 473: goldfish: 10, perfumes: 9, cars: 4\n" +
                                        "Sue 474: samoyeds: 0, cars: 4, vizslas: 4\n" +
                                        "Sue 475: trees: 2, cars: 7, akitas: 8\n" +
                                        "Sue 476: vizslas: 3, perfumes: 5, goldfish: 1\n" +
                                        "Sue 477: cats: 7, cars: 4, trees: 1\n" +
                                        "Sue 478: vizslas: 8, akitas: 3, goldfish: 0\n" +
                                        "Sue 479: cars: 6, cats: 3, perfumes: 2\n" +
                                        "Sue 480: goldfish: 1, children: 9, vizslas: 3\n" +
                                        "Sue 481: pomeranians: 5, vizslas: 1, cars: 10\n" +
                                        "Sue 482: children: 5, perfumes: 5, cats: 1\n" +
                                        "Sue 483: perfumes: 2, goldfish: 7, trees: 6\n" +
                                        "Sue 484: akitas: 2, goldfish: 4, perfumes: 10\n" +
                                        "Sue 485: samoyeds: 3, goldfish: 0, akitas: 1\n" +
                                        "Sue 486: trees: 8, vizslas: 9, goldfish: 0\n" +
                                        "Sue 487: goldfish: 8, samoyeds: 0, trees: 0\n" +
                                        "Sue 488: perfumes: 7, cars: 5, trees: 0\n" +
                                        "Sue 489: vizslas: 3, pomeranians: 2, perfumes: 5\n" +
                                        "Sue 490: cars: 5, perfumes: 5, akitas: 5\n" +
                                        "Sue 491: children: 8, trees: 1, pomeranians: 4\n" +
                                        "Sue 492: pomeranians: 0, akitas: 1, vizslas: 8\n" +
                                        "Sue 493: akitas: 10, perfumes: 10, samoyeds: 8\n" +
                                        "Sue 494: perfumes: 6, vizslas: 4, cats: 6\n" +
                                        "Sue 495: children: 6, pomeranians: 5, samoyeds: 4\n" +
                                        "Sue 496: vizslas: 1, trees: 5, akitas: 1\n" +
                                        "Sue 497: vizslas: 10, perfumes: 10, pomeranians: 3\n" +
                                        "Sue 498: samoyeds: 3, trees: 2, cars: 5\n" +
                                        "Sue 499: cats: 6, children: 3, perfumes: 0\n" +
                                        "Sue 500: pomeranians: 10, cats: 3, vizslas: 5";
}
//
//children: 3
//        cats: 7
//        samoyeds: 2
//        pomeranians: 3
//        akitas: 0
//        vizslas: 0
//        goldfish: 5
//        trees: 3
//        cars: 2
//        perfumes: 1