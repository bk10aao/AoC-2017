package AdcentOfCode2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class AdventOfCodeDayEight {

    private HashMap<String, Integer> registerValues = new HashMap<String, Integer>();
    private ArrayList<Integer> allValues = new ArrayList<Integer>();

    public static void main(String[] args) {
        AdventOfCodeDayEight adventOfCodeDayEight = new AdventOfCodeDayEight();
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(input.split("\n")));
        adventOfCodeDayEight.getLargestValueInRegister(arrayList);
    }

    public int getLargestValueInRegister(ArrayList<String> instructions) {

        for(String s : instructions) {
            String[] steps = s.split(" ");
            String valueToBeModified = steps[0];
            String arithmeticFunction = steps[1];
            int arthmeticValue = Integer.parseInt(steps[2]);
            String comparatorKey = steps[4];
            String comparatorFunction = steps[5];
            int comparatorValue = Integer.parseInt(steps[6]);
            if(!registerValues.containsKey(valueToBeModified)) {
                registerValues.put(valueToBeModified, 0);
            }
            if(!registerValues.containsKey(comparatorKey)) {
                registerValues.put(comparatorKey, 0);
            }

            int checkValue = registerValues.get(comparatorKey);

            if(comparatorFunction.toString().equals(">")) {
                largerThanImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
            } else if(comparatorFunction.toString().equals("<")) {
                smallerThanImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
            } else if(comparatorFunction.toString().equals(">=")) {
                largerThanOrEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
            } else if(comparatorFunction.toString().equals("<=")) {
                smallerThanOrEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
            } else if(comparatorFunction.toString().equals("==")) {
                equalToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
            } else if(comparatorFunction.toString().equals("!=")) {
                notEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
            }
        }
        Collections.sort(allValues);
        Collections.reverse(allValues);
        System.out.println("largest ever value: " + allValues.get(0));
        return getLargestValue();
    }

    private void performAction(String valueToBeModified, String arithmeticFunction, int arthmeticValue) {
        int newValue = registerValues.get(valueToBeModified);

        if(arithmeticFunction.toString().equals("inc")) {
            registerValues.put(valueToBeModified, newValue + arthmeticValue);
            allValues.add(newValue + arthmeticValue);
        } else if(arithmeticFunction.toString().equals("dec")) {
            registerValues.put(valueToBeModified, newValue - arthmeticValue);
            allValues.add(newValue - arthmeticValue);
        }

    }

    private void largerThanImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue > comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private void smallerThanImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue < comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private void largerThanOrEqualToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue >= comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private void smallerThanOrEqualToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue <= comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private void equalToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue == comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private void notEqualToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue != comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private int getLargestValue() {
        int[] values = new int[registerValues.keySet().size()];
        int i = 0;
        for(String s : registerValues.keySet()) {
            values[i] = registerValues.get(s);
            i++;
        }
        Arrays.sort(values);
        System.out.println("largest value at end of instructions: " + values[values.length-1]);
        return values[values.length -1];
    }

    private static String input = "um inc -671 if lbf != 5\n" +
                                "j inc 236 if umr > -6\n" +
                                "fk inc -246 if j < 241\n" +
                                "uy dec -404 if mmw <= 2\n" +
                                "j inc 372 if gk >= -1\n" +
                                "uy inc -380 if umr > -4\n" +
                                "dy inc 257 if es > -9\n" +
                                "es dec 769 if es < 4\n" +
                                "t inc -429 if umr >= 0\n" +
                                "hg dec 13 if dy < 267\n" +
                                "is inc 66 if fk == -246\n" +
                                "fk inc -30 if es > -775\n" +
                                "ada inc 258 if umr > 3\n" +
                                "eri inc -950 if lx > -4\n" +
                                "umr dec -789 if x >= -4\n" +
                                "um inc -783 if aao > -7\n" +
                                "j inc -97 if ada != -1\n" +
                                "es inc 406 if fk != -283\n" +
                                "lx inc 43 if kg <= 7\n" +
                                "f inc 464 if lx <= 44\n" +
                                "kg inc 884 if t >= -435\n" +
                                "mmw inc 836 if gk > -3\n" +
                                "a dec 496 if um > -1447\n" +
                                "eri dec -617 if uy == 24\n" +
                                "j inc -858 if kg < 886\n" +
                                "hg dec -854 if umr == 789\n" +
                                "dy dec -246 if f >= 457\n" +
                                "lbf inc 122 if a != 10\n" +
                                "aao inc -408 if uy > 19\n" +
                                "f dec 908 if uy != 18\n" +
                                "t dec -775 if j >= -351\n" +
                                "t inc -594 if yk <= 3\n" +
                                "es inc 28 if gk == 0\n" +
                                "es inc -306 if kg >= 894\n" +
                                "mmw dec 154 if kg <= 885\n" +
                                "dy inc 832 if aao <= -402\n" +
                                "lx inc -426 if a >= -8\n" +
                                "umr dec -792 if eri > -341\n" +
                                "a inc -609 if gk <= -6\n" +
                                "j dec -970 if lx > -393\n" +
                                "uy dec -241 if yk > 0\n" +
                                "yk inc 411 if is > 61\n" +
                                "ada dec -253 if is == 66\n" +
                                "is dec -486 if aao > -413\n" +
                                "yk dec 561 if a == 0\n" +
                                "dy inc 976 if um == -1454\n" +
                                "dy inc 885 if eri < -331\n" +
                                "hg inc -5 if gk <= -9\n" +
                                "t dec 717 if f <= -443\n" +
                                "mmw inc -293 if lx <= -379\n" +
                                "t inc 77 if lx != -383\n" +
                                "uy dec -89 if ada <= 258\n" +
                                "fk inc -381 if fk < -272\n" +
                                "eri dec 711 if mmw < 398\n" +
                                "is dec -273 if gk != -3\n" +
                                "umr dec 384 if aao != -414\n" +
                                "is dec -36 if is != 825\n" +
                                "ada dec 422 if es < -326\n" +
                                "fk inc 207 if mmw < 389\n" +
                                "uy dec -357 if lx == -383\n" +
                                "es inc 829 if dy <= 3199\n" +
                                "aao dec -173 if gk == 0\n" +
                                "x dec 274 if is >= 824\n" +
                                "t dec -400 if is <= 833\n" +
                                "fk dec -677 if f == -444\n" +
                                "x inc -494 if j == 623\n" +
                                "t dec -406 if f < -443\n" +
                                "gk dec 704 if gk == 0\n" +
                                "x inc -637 if x < -758\n" +
                                "x dec 194 if gk != -710\n" +
                                "um inc 956 if fk > 26\n" +
                                "ada inc -527 if aao > -239\n" +
                                "j inc -774 if f <= -436\n" +
                                "es inc -121 if ada > -689\n" +
                                "hg dec -461 if gk < -698\n" +
                                "t inc 780 if is < 828\n" +
                                "yk inc -858 if es >= 504\n" +
                                "dy inc 145 if j > -159\n" +
                                "is inc 929 if f != -453\n" +
                                "mmw inc 702 if fk > 17\n" +
                                "lbf dec 123 if aao >= -240\n" +
                                "hg dec -543 if a == 0\n" +
                                "kg dec -610 if es > 488\n" +
                                "hg inc -726 if hg < 1854\n" +
                                "kg dec -410 if j <= -146\n" +
                                "dy inc -469 if gk <= -712\n" +
                                "a inc 252 if aao > -237\n" +
                                "dy dec 168 if uy <= 478\n" +
                                "gk inc -530 if a > 244\n" +
                                "gk dec -254 if uy == 479\n" +
                                "es inc -960 if j > -152\n" +
                                "umr dec 561 if hg != 1126\n" +
                                "uy inc 420 if j < -148\n" +
                                "mmw inc 976 if j < -142\n" +
                                "umr dec -852 if gk >= -1238\n" +
                                "aao dec 559 if eri >= -1042\n" +
                                "gk inc -745 if j <= -142\n" +
                                "t dec 183 if hg < 1112\n" +
                                "t inc 725 if yk == -150\n" +
                                "lbf dec -142 if kg < 1912\n" +
                                "mmw dec -908 if is <= 1758\n" +
                                "um inc 329 if f == -447\n" +
                                "x dec 543 if ada > -704\n" +
                                "gk inc 226 if eri <= -1041\n" +
                                "es dec -176 if mmw == 2975\n" +
                                "ada inc -156 if eri >= -1053\n" +
                                "ada inc -523 if t <= 1347\n" +
                                "aao inc -717 if x < -2145\n" +
                                "gk inc -236 if t >= 1354\n" +
                                "lx dec -266 if lx != -389\n" +
                                "hg dec -324 if dy >= 3169\n" +
                                "f dec 96 if x != -2143\n" +
                                "yk inc -270 if um != -1450\n" +
                                "aao inc -916 if lbf == 141\n" +
                                "es inc -943 if f == -540\n" +
                                "a dec 974 if lbf > 131\n" +
                                "dy dec -35 if yk == -413\n" +
                                "kg inc 112 if eri >= -1053\n" +
                                "mmw inc -30 if gk <= -1754\n" +
                                "um dec -288 if mmw < 2978\n" +
                                "es dec 774 if uy == 900\n" +
                                "t dec -60 if x > -2145\n" +
                                "j inc 1 if x > -2148\n" +
                                "dy inc 222 if es >= -1232\n" +
                                "is dec -221 if x != -2142\n" +
                                "hg dec -626 if uy > 887\n" +
                                "is dec -114 if t <= 1408\n" +
                                "j inc -564 if umr == 1488\n" +
                                "a inc -29 if f != -540\n" +
                                "umr dec 373 if fk != 17\n" +
                                "a dec -788 if fk >= 14\n" +
                                "ada inc 316 if aao >= -1153\n" +
                                "x dec 970 if lbf != 141\n" +
                                "x dec -209 if aao >= -1159\n" +
                                "uy dec 279 if lx != -117\n" +
                                "f dec 517 if hg >= 2065\n" +
                                "j dec 566 if a <= 75\n" +
                                "x dec -346 if a <= 59\n" +
                                "t inc 576 if lx > -118\n" +
                                "um dec 785 if es >= -1229\n" +
                                "a dec -949 if mmw > 2974\n" +
                                "j inc 915 if x <= -1929\n" +
                                "hg inc 177 if is < 1873\n" +
                                "is inc -678 if f >= -1052\n" +
                                "umr dec 254 if lx > -123\n" +
                                "x dec 754 if um < -1160\n" +
                                "aao dec 977 if uy <= 894\n" +
                                "yk inc -157 if aao <= -2124\n" +
                                "um inc 631 if is >= 1867\n" +
                                "lx inc -99 if ada <= -1058\n" +
                                "fk dec -834 if x < -2695\n" +
                                "is dec 105 if x != -2680\n" +
                                "a inc 462 if umr <= 864\n" +
                                "mmw inc 394 if lbf > 150\n" +
                                "gk inc -370 if lbf >= 146\n" +
                                "is inc 722 if yk > -586\n" +
                                "dy inc -882 if gk != -1753\n" +
                                "t inc 983 if gk == -1763\n" +
                                "fk dec 874 if fk > 14\n" +
                                "hg dec -949 if lbf < 142\n" +
                                "es dec -592 if uy == 891\n" +
                                "dy dec 823 if gk >= -1762\n" +
                                "mmw dec 137 if gk >= -1751\n" +
                                "hg dec 704 if dy >= 2343\n" +
                                "t dec -921 if j != -372\n" +
                                "x dec 95 if is >= 2485\n" +
                                "dy inc -117 if kg >= 2017\n" +
                                "gk dec 551 if um <= -545\n" +
                                "ada inc -161 if umr >= 856\n" +
                                "mmw inc 633 if umr != 862\n" +
                                "fk dec 38 if lbf >= 140\n" +
                                "kg dec -954 if x >= -2787\n" +
                                "um inc 325 if hg > 2481\n" +
                                "um dec -72 if j > -375\n" +
                                "umr dec 910 if gk <= -1756\n" +
                                "fk dec -628 if j != -356\n" +
                                "mmw dec 267 if aao != -2123\n" +
                                "eri inc -857 if um != -137\n" +
                                "um inc -651 if eri != -1896\n" +
                                "j dec -122 if a >= 1473\n" +
                                "umr dec 177 if gk == -1753\n" +
                                "mmw inc -16 if t > 2911\n" +
                                "eri dec 502 if um <= -785\n" +
                                "hg inc 134 if x != -2775\n" +
                                "lx dec 263 if kg <= 2978\n" +
                                "hg dec 83 if es != -1235\n" +
                                "mmw dec -837 if umr <= 693\n" +
                                "dy inc 148 if um < -792\n" +
                                "gk inc -13 if j > -247\n" +
                                "x dec 749 if yk >= -568\n" +
                                "lbf inc 606 if is != 2489\n" +
                                "x inc 588 if dy >= 2345\n" +
                                "dy dec 243 if yk <= -574\n" +
                                "umr dec 1 if es == -1233\n" +
                                "f dec 104 if t == 2903\n" +
                                "aao dec 32 if es != -1224\n" +
                                "x inc 882 if j < -245\n" +
                                "hg inc -998 if uy == 890\n" +
                                "dy dec -605 if dy <= 2115\n" +
                                "hg inc 45 if gk != -1769\n" +
                                "lbf inc -521 if t > 2894\n" +
                                "umr inc -115 if a != 1473\n" +
                                "lx dec -795 if x == -2194\n" +
                                "t inc 143 if f < -1154\n" +
                                "es dec 629 if is > 2494\n" +
                                "lbf inc 195 if fk <= -263\n" +
                                "fk inc 926 if aao <= -2153\n" +
                                "um inc 351 if es != -1230\n" +
                                "t dec -541 if lx != 316\n" +
                                "mmw inc -329 if mmw != 4178\n" +
                                "dy inc 708 if is > 2481\n" +
                                "j inc 386 if t != 3050\n" +
                                "hg dec 253 if umr == 568\n" +
                                "um inc 236 if mmw >= 4172\n" +
                                "fk inc -874 if hg != 1328\n" +
                                "lbf dec -499 if um != -202\n" +
                                "lbf dec 999 if gk > -1774\n" +
                                "gk dec 474 if fk > -219\n" +
                                "mmw dec -598 if yk > -585\n" +
                                "fk inc -508 if t == 3046\n" +
                                "mmw inc -638 if x == -2193\n" +
                                "f dec 756 if a == 1477\n" +
                                "mmw dec -339 if aao > -2161\n" +
                                "um inc 109 if lbf <= -578\n" +
                                "fk dec -421 if lx < 321\n" +
                                "is inc -725 if ada >= -1226\n" +
                                "fk dec -458 if ada >= -1226\n" +
                                "uy dec -588 if aao <= -2160\n" +
                                "ada inc 404 if dy != 3420\n" +
                                "x inc 788 if f <= -1910\n" +
                                "kg dec -520 if is == 1754\n" +
                                "es dec 895 if lbf < -568\n" +
                                "fk dec -999 if lbf == -578\n" +
                                "kg dec -38 if lbf != -574\n" +
                                "uy inc 343 if lbf != -579\n" +
                                "is dec -176 if es <= -2125\n" +
                                "lbf dec -680 if lbf < -573\n" +
                                "eri inc 562 if uy != 1823\n" +
                                "x inc 87 if fk >= 1158\n" +
                                "umr dec -850 if eri > -1843\n" +
                                "um inc -978 if eri <= -1849\n" +
                                "x dec 389 if gk < -2241\n" +
                                "f inc -288 if a != 1486\n" +
                                "kg dec -484 if uy < 1826\n" +
                                "lx dec -328 if lbf != 97\n" +
                                "um inc -998 if gk <= -2240\n" +
                                "yk inc 314 if mmw <= 5120\n" +
                                "t dec -884 if es == -2128\n" +
                                "uy dec 190 if f <= -2199\n" +
                                "lx dec 128 if umr > 1425\n" +
                                "eri inc 807 if a > 1485\n" +
                                "ada inc 272 if umr < 1422\n" +
                                "hg inc 630 if is == 1937\n" +
                                "um dec 143 if ada >= -949\n" +
                                "eri dec -334 if lx != 637\n" +
                                "fk dec 147 if umr < 1426\n" +
                                "gk dec 309 if uy == 1631\n" +
                                "aao dec 233 if hg == 1336\n" +
                                "is dec 825 if yk > -271\n" +
                                "lbf dec -498 if umr <= 1413\n" +
                                "kg dec 473 if es > -2131\n" +
                                "mmw dec -728 if hg != 1327\n" +
                                "dy dec 309 if hg <= 1341\n" +
                                "dy inc -863 if kg >= 3023\n" +
                                "x inc -465 if lx <= 647\n" +
                                "a inc 253 if x >= -1793\n" +
                                "kg inc -184 if eri < -1500\n" +
                                "um inc -527 if lx != 652\n" +
                                "j inc -455 if hg > 1328\n" +
                                "eri inc 866 if yk != -263\n" +
                                "aao inc -47 if gk > -2553\n" +
                                "gk inc 228 if gk < -2554\n" +
                                "gk inc -493 if fk <= 1006\n" +
                                "mmw inc 800 if x == -1784\n" +
                                "lbf inc -351 if umr < 1426\n" +
                                "a inc -903 if ada > -958\n" +
                                "umr inc 942 if es != -2128\n" +
                                "dy inc 600 if a < 830\n" +
                                "j dec -247 if lx < 646\n" +
                                "gk dec -922 if t >= 3930\n" +
                                "mmw inc -114 if lx != 654\n" +
                                "fk dec 415 if um > -1764\n" +
                                "t inc -763 if lbf < -246\n" +
                                "ada inc 818 if is > 1108\n" +
                                "uy inc -839 if t != 3171\n" +
                                "fk inc -335 if is > 1106\n" +
                                "fk dec -335 if yk == -263\n" +
                                "fk inc -291 if dy == 3711\n" +
                                "lx dec -665 if yk != -263\n" +
                                "es dec -772 if uy != 792\n" +
                                "umr dec -528 if um != -1764\n" +
                                "t dec -95 if es < -2137\n" +
                                "es inc -800 if yk >= -261\n" +
                                "kg inc 150 if j >= -70\n" +
                                "f dec -118 if mmw < 6536\n" +
                                "a inc 595 if uy > 794\n" +
                                "is inc 927 if lx > 636\n" +
                                "eri dec -61 if x != -1785\n" +
                                "hg inc -878 if yk != -260\n" +
                                "gk inc -727 if fk <= 305\n" +
                                "mmw dec -945 if a <= 833\n" +
                                "aao inc -101 if x >= -1792\n" +
                                "hg dec 567 if es > -2131\n" +
                                "gk inc -689 if mmw < 7484\n" +
                                "ada inc -644 if eri > -1452\n" +
                                "yk inc -810 if yk > -265\n" +
                                "um dec 655 if aao < -2533\n" +
                                "t dec 179 if umr != 1943\n" +
                                "gk inc 833 if hg >= -110\n" +
                                "fk dec 998 if fk < 315\n" +
                                "a dec -558 if aao > -2543\n" +
                                "x inc 426 if lbf == -249\n" +
                                "uy inc 892 if yk > -1075\n" +
                                "umr inc 250 if es <= -2127\n" +
                                "mmw inc -727 if umr >= 2193\n" +
                                "kg dec 111 if es == -2128\n" +
                                "dy dec 898 if fk != -693\n" +
                                "yk dec 168 if umr >= 2191\n" +
                                "uy dec 113 if dy <= 3711\n" +
                                "mmw inc -752 if yk == -1241\n" +
                                "yk inc -181 if t > 2989\n" +
                                "mmw dec -636 if t < 2995\n" +
                                "a inc -424 if hg == -109\n" +
                                "j dec -762 if ada > -780\n" +
                                "lx dec 565 if uy <= 1577\n" +
                                "aao dec 858 if j == 697\n" +
                                "fk inc -383 if a < 969\n" +
                                "eri inc -51 if lx <= 85\n" +
                                "aao inc 666 if j > 690\n" +
                                "t dec 234 if a == 964\n" +
                                "aao inc -69 if fk > -1085\n" +
                                "es inc -721 if gk >= -2215\n" +
                                "is inc -185 if lbf > -251\n" +
                                "mmw dec 411 if es == -2849\n" +
                                "f dec -214 if gk == -2210\n" +
                                "yk inc 904 if aao >= -2804\n" +
                                "es inc 883 if mmw != 6210\n" +
                                "x dec 6 if ada != -774\n" +
                                "aao inc -776 if um != -2419\n" +
                                "j inc -653 if yk == -344\n" +
                                "gk dec 338 if fk != -1072\n" +
                                "yk inc -13 if x >= -1360\n" +
                                "lbf inc 201 if dy < 3716\n" +
                                "yk dec -904 if aao != -3575\n" +
                                "f dec 922 if j == 697\n" +
                                "uy dec -562 if lbf != -53\n" +
                                "gk dec 50 if lbf <= -47\n" +
                                "t inc -670 if mmw > 6222\n" +
                                "lx inc 515 if uy == 2133\n" +
                                "yk inc 261 if dy > 3704\n" +
                                "x dec -854 if uy == 2133\n" +
                                "kg inc 66 if umr == 2196\n" +
                                "kg dec -83 if j != 706\n" +
                                "ada inc 739 if gk > -2590\n" +
                                "eri dec 379 if eri == -1497\n" +
                                "dy inc 638 if aao >= -3583\n" +
                                "a dec 130 if is > 1851\n" +
                                "mmw dec 399 if uy == 2133\n" +
                                "eri inc -195 if f > -2801\n" +
                                "j dec 885 if dy > 4339\n" +
                                "eri inc -544 if aao == -3587\n" +
                                "kg inc 895 if t != 2984\n" +
                                "yk inc 258 if dy <= 4350\n" +
                                "es dec 660 if dy == 4342\n" +
                                "umr inc -92 if gk < -2592\n" +
                                "eri inc 361 if x == -504\n" +
                                "um dec -298 if gk != -2588\n" +
                                "fk dec 532 if j < -184\n" +
                                "uy inc 31 if f < -2791\n" +
                                "aao dec 31 if j != -182\n" +
                                "ada inc 448 if um <= -2113\n" +
                                "fk inc -13 if eri <= -1703\n" +
                                "t inc -59 if es >= -1971\n" +
                                "gk dec -909 if x == -510\n" +
                                "es inc 805 if hg >= -112\n" +
                                "j dec 734 if kg >= 3919\n" +
                                "um inc 369 if aao != -3606\n" +
                                "yk inc -548 if dy > 4348\n" +
                                "gk inc 934 if j < -182\n" +
                                "x dec 346 if hg <= -107\n" +
                                "lbf dec -379 if eri != -1718\n" +
                                "lbf inc -921 if f >= -2802\n" +
                                "mmw inc -191 if eri <= -1703\n" +
                                "umr inc 252 if lx != 600\n" +
                                "mmw dec 410 if ada >= -330\n" +
                                "gk inc 558 if a != 828\n" +
                                "mmw dec 320 if um <= -1744\n" +
                                "ada dec 517 if t < 2933\n" +
                                "is dec -616 if ada > -835\n" +
                                "yk dec -406 if j <= -185\n" +
                                "yk inc -526 if lbf <= -586\n" +
                                "ada inc 368 if j == -188\n" +
                                "kg inc -89 if f <= -2791\n" +
                                "kg dec -531 if lbf == -590\n" +
                                "mmw inc -252 if f < -2787\n" +
                                "is inc 293 if eri > -1713\n" +
                                "lbf inc 509 if kg <= 4367\n" +
                                "eri inc 607 if fk > -1620\n" +
                                "f dec -313 if j > -194\n" +
                                "ada inc -582 if aao >= -3611\n" +
                                "a inc 373 if x == -850\n" +
                                "eri dec 668 if ada != -1057\n" +
                                "um dec 112 if lbf <= -72\n" +
                                "lx inc 91 if t > 2919\n" +
                                "a inc 157 if is > 2139\n" +
                                "fk inc -207 if a != 1371\n" +
                                "um inc 108 if t <= 2929\n" +
                                "aao inc 80 if lx >= 681\n" +
                                "fk inc 437 if lbf == -81\n" +
                                "umr inc 473 if lbf <= -75\n" +
                                "eri inc 509 if umr != 2822\n" +
                                "a dec -7 if is >= 2146\n" +
                                "fk inc -10 if t != 2920\n" +
                                "is dec 235 if a > 1358\n" +
                                "ada inc -655 if eri == -1201\n" +
                                "kg dec 983 if f >= -2486\n" +
                                "es dec 640 if t <= 2938\n" +
                                "eri dec -700 if is < 1919\n" +
                                "ada inc -213 if fk == -1401\n" +
                                "hg dec -846 if kg != 3381\n" +
                                "f dec 584 if a <= 1361\n" +
                                "aao inc 731 if gk != -1107\n" +
                                "t inc 823 if kg == 3377\n" +
                                "es dec 382 if j > -195\n" +
                                "fk inc -83 if ada < -1916\n" +
                                "umr inc 948 if eri > -511\n" +
                                "a inc -765 if eri == -501\n" +
                                "a inc 114 if f > -2478\n" +
                                "aao inc 343 if aao == -2798\n" +
                                "t inc -172 if eri < -498\n" +
                                "fk inc 905 if x < -840\n" +
                                "dy dec -731 if a > 597\n" +
                                "lx inc 410 if um <= -1744\n" +
                                "eri inc -859 if lbf <= -90\n" +
                                "fk dec 820 if ada < -1916\n" +
                                "yk dec 14 if dy != 5078\n" +
                                "aao inc -89 if lbf != -81\n" +
                                "umr dec 242 if aao > -2457\n" +
                                "f inc -563 if lx <= 1100\n" +
                                "uy dec 967 if uy <= 2166\n" +
                                "eri dec 984 if lx > 1086\n" +
                                "hg dec 816 if mmw <= 4653\n" +
                                "hg dec -413 if um == -1753\n" +
                                "dy dec -410 if mmw > 4643\n" +
                                "uy dec -298 if lx >= 1094\n" +
                                "mmw dec -611 if dy > 5483\n" +
                                "t dec 471 if is != 1915\n" +
                                "fk inc 505 if aao >= -2463\n" +
                                "gk dec -947 if fk == -894\n" +
                                "es inc -556 if umr >= 3532\n" +
                                "es inc 768 if x >= -853\n" +
                                "yk dec -865 if aao == -2455\n" +
                                "hg inc -481 if a != 609\n" +
                                "ada inc 904 if es == -1971\n" +
                                "hg dec -518 if um < -1750\n" +
                                "yk dec -744 if fk != -889\n" +
                                "a inc 410 if f > -3047\n" +
                                "dy inc 522 if is >= 1913\n" +
                                "um inc 882 if is < 1915\n" +
                                "es inc -950 if fk > -889\n" +
                                "is dec -211 if is == 1911\n" +
                                "kg inc -160 if um == -871\n" +
                                "a inc 315 if j == -188\n" +
                                "umr inc 840 if eri <= -1479\n" +
                                "kg inc -805 if ada <= -1013\n" +
                                "um inc 701 if x == -850\n" +
                                "a inc 735 if umr == 4375\n" +
                                "um inc -413 if lbf != -76\n" +
                                "dy inc 310 if mmw <= 5268\n" +
                                "lbf inc -210 if dy != 5800\n" +
                                "um dec -489 if lx == 1095\n" +
                                "fk dec -743 if mmw <= 5258\n" +
                                "lx inc 332 if mmw > 5249\n" +
                                "hg dec 396 if mmw >= 5251\n" +
                                "yk inc -672 if fk > -896\n" +
                                "a inc -872 if t >= 3114\n" +
                                "a inc 22 if umr >= 4370\n" +
                                "es inc 374 if um > -98\n" +
                                "uy inc 609 if lx <= 1434\n" +
                                "a dec 580 if is >= 2118\n" +
                                "hg dec -809 if lx >= 1424\n" +
                                "fk dec 451 if aao != -2446\n" +
                                "mmw dec -339 if gk < -156\n" +
                                "hg inc 566 if gk < -153\n" +
                                "hg inc -629 if uy >= 2100\n" +
                                "lx dec 314 if a > 1503\n" +
                                "lbf dec 173 if lx >= 1109\n" +
                                "t dec 107 if ada == -1021\n" +
                                "dy inc 421 if mmw <= 5607\n" +
                                "is dec 751 if hg != 731\n" +
                                "hg inc 844 if hg != 730\n" +
                                "eri inc -44 if a == 1505\n" +
                                "uy dec 230 if t <= 3002\n" +
                                "uy inc -450 if eri < -1521\n" +
                                "kg dec 353 if j == -188\n" +
                                "lbf inc -100 if mmw >= 5592\n" +
                                "umr dec -946 if f >= -3045\n" +
                                "t inc 893 if j == -188\n" +
                                "lbf dec -263 if hg <= 1572\n" +
                                "j inc 22 if umr == 5313\n" +
                                "eri dec 598 if aao >= -2463\n" +
                                "umr dec -591 if eri > -2130\n" +
                                "t dec 489 if dy <= 6230\n" +
                                "ada dec -547 if a != 1505\n" +
                                "eri dec -38 if dy > 6220\n" +
                                "ada inc 895 if is == 1371\n" +
                                "is inc -303 if mmw < 5599\n" +
                                "uy dec -217 if a <= 1513\n" +
                                "a dec -366 if x <= -851\n" +
                                "um dec 570 if t < 3411\n" +
                                "uy inc -560 if mmw <= 5599\n" +
                                "um dec -234 if gk != -152\n" +
                                "fk dec 305 if um == -430\n" +
                                "lx dec -553 if a > 1505\n" +
                                "yk dec -923 if yk < 1335\n" +
                                "yk dec 137 if es < -1590\n" +
                                "hg dec 737 if es > -1605\n" +
                                "yk dec 607 if eri < -2080\n" +
                                "um dec -588 if eri != -2097\n" +
                                "aao inc -230 if aao != -2455\n" +
                                "fk inc -654 if t >= 3398\n" +
                                "umr dec 525 if kg != 2064\n" +
                                "mmw inc -242 if lbf < -90\n" +
                                "lbf dec 682 if aao >= -2462\n" +
                                "yk inc -971 if t >= 3402\n" +
                                "t dec -403 if fk <= -2296\n" +
                                "ada dec 404 if kg == 2059\n" +
                                "dy inc 95 if yk < 542\n" +
                                "lbf inc 427 if j <= -182\n" +
                                "j inc 10 if j <= -179\n" +
                                "x dec 524 if f <= -3051\n" +
                                "lx dec 326 if gk != -163\n" +
                                "umr dec 176 if lx >= 789\n" +
                                "um dec 264 if eri == -2089\n" +
                                "t inc 197 if eri == -2084\n" +
                                "dy dec 574 if es > -1605\n" +
                                "lx inc -898 if um >= -110\n" +
                                "es dec -845 if um >= -113\n" +
                                "es inc -731 if yk < 537\n" +
                                "lx dec 424 if f >= -3053\n" +
                                "a inc 525 if lx != -535\n" +
                                "uy dec 692 if yk > 531\n" +
                                "a inc -591 if fk >= -2309\n" +
                                "fk dec -204 if aao != -2459\n" +
                                "mmw dec -420 if fk <= -2110\n" +
                                "yk inc 166 if j < -168\n" +
                                "umr inc 535 if gk < -158\n" +
                                "eri dec 417 if yk >= 695\n" +
                                "umr inc 230 if mmw != 5363\n" +
                                "umr inc -36 if lbf < -348\n" +
                                "f dec -763 if aao < -2450\n" +
                                "uy inc -841 if es >= -1490\n" +
                                "is dec -381 if gk >= -167\n" +
                                "x dec 981 if hg == 828\n" +
                                "f inc 682 if ada == -530\n" +
                                "fk inc 268 if uy != -450\n" +
                                "dy dec 891 if ada < -529\n" +
                                "uy dec 943 if hg != 828\n" +
                                "ada dec -496 if a < 907\n" +
                                "is dec 380 if gk == -159\n" +
                                "aao dec 772 if eri < -2505\n" +
                                "umr dec -646 if umr > 6151\n" +
                                "dy dec 978 if t == 3809\n" +
                                "kg inc -768 if fk > -1834\n" +
                                "lbf dec -107 if x <= -1828\n" +
                                "lx dec 822 if yk <= 709\n" +
                                "umr inc -504 if ada > -533\n" +
                                "aao dec -710 if es == -1483\n" +
                                "uy inc 17 if hg >= 838\n" +
                                "fk dec -48 if a == 914\n" +
                                "fk inc -80 if j >= -182\n" +
                                "gk inc 339 if um < -113\n" +
                                "lbf inc 224 if f != -1603\n" +
                                "lbf inc 553 if kg == 1291\n" +
                                "umr dec -384 if ada > -535\n" +
                                "lx dec -618 if t == 3809\n" +
                                "aao dec -291 if ada >= -534\n" +
                                "lx dec -385 if f <= -1591\n" +
                                "lbf inc -918 if is <= 1069\n" +
                                "kg inc 807 if dy != 3871\n" +
                                "a dec -120 if eri >= -2509\n" +
                                "fk dec 886 if uy == -452\n" +
                                "is inc 668 if f == -1600\n" +
                                "ada dec 281 if dy >= 3872\n" +
                                "aao inc 952 if j > -182\n" +
                                "eri inc -279 if kg >= 2098\n" +
                                "gk inc -357 if gk <= -153\n" +
                                "lbf inc -255 if um == -106\n" +
                                "es inc -509 if um < -105\n" +
                                "j dec 929 if umr < 6681\n" +
                                "is inc 906 if um != -114\n" +
                                "ada dec 951 if gk >= -523\n" +
                                "aao dec 80 if kg > 2089\n" +
                                "t inc 811 if hg < 832\n" +
                                "yk inc 303 if f > -1601\n" +
                                "gk inc 180 if mmw <= 5351\n" +
                                "is dec -639 if umr < 6672\n" +
                                "mmw dec -142 if kg <= 2103\n" +
                                "fk dec -275 if is != 2643\n" +
                                "ada inc 568 if x <= -1822\n" +
                                "a dec 677 if yk != 1005\n" +
                                "yk inc 111 if es <= -1990\n" +
                                "eri inc -17 if eri >= -2793\n" +
                                "lbf inc 974 if gk == -516\n" +
                                "hg inc -723 if lbf == 337\n" +
                                "mmw dec 408 if dy <= 3877\n" +
                                "t dec 142 if mmw < 5084\n" +
                                "gk dec 53 if yk != 1111\n" +
                                "lbf dec -434 if aao != -1344\n" +
                                "kg dec -837 if f >= -1593\n" +
                                "f inc 513 if eri <= -2804\n" +
                                "fk dec -925 if fk >= -2756\n" +
                                "t inc 280 if kg != 2100\n" +
                                "lx dec 328 if dy < 3880\n" +
                                "t inc -359 if j < -1103\n" +
                                "es inc 289 if ada < -1203\n" +
                                "x dec -414 if gk >= -574\n" +
                                "aao dec 710 if dy == 3873\n" +
                                "es dec -70 if ada <= -1187\n" +
                                "ada dec 883 if j == -1110\n" +
                                "is dec -635 if um != -105\n" +
                                "is inc 627 if a == 1034\n" +
                                "um inc -348 if ada > -1190\n" +
                                "mmw dec -270 if uy >= -454\n" +
                                "ada dec 362 if is > 3900\n" +
                                "eri dec -504 if t != 4541\n" +
                                "uy inc 910 if eri >= -2804\n" +
                                "es dec 261 if fk < -1821\n" +
                                "uy dec -430 if uy >= 456\n" +
                                "yk dec -841 if um >= -107\n" +
                                "j dec -287 if fk >= -1834\n" +
                                "a dec 90 if uy <= 897\n" +
                                "lx inc 867 if hg < 819\n" +
                                "yk dec 265 if fk >= -1820\n" +
                                "is inc -444 if umr >= 6676\n" +
                                "kg inc 586 if f == -1600\n" +
                                "es dec -298 if uy != 889\n" +
                                "mmw inc -896 if gk >= -576\n" +
                                "a dec -320 if t >= 4538\n" +
                                "t dec -722 if hg >= 819\n" +
                                "mmw inc -778 if ada < -1553\n" +
                                "um dec -914 if j != -826\n" +
                                "kg inc -964 if f < -1605\n" +
                                "yk inc -51 if umr >= 6670\n" +
                                "um dec 219 if j == -820\n" +
                                "dy inc 727 if a == 1264\n" +
                                "a dec -817 if kg <= 2692\n" +
                                "um dec 99 if fk == -1826\n" +
                                "kg dec 302 if uy != 892\n" +
                                "j dec -696 if lx <= -688\n" +
                                "uy inc -626 if t <= 5268\n" +
                                "a dec 961 if hg <= 837\n" +
                                "yk inc -803 if a != 1119\n" +
                                "mmw dec 678 if lx < -680\n" +
                                "lbf inc 862 if fk < -1825\n" +
                                "kg inc -786 if t <= 5259\n" +
                                "aao dec 91 if x == -1407\n" +
                                "uy dec -548 if t == 5263\n" +
                                "aao inc 638 if is != 3463\n" +
                                "hg dec 244 if uy > 807\n" +
                                "f inc 58 if lbf >= 765\n" +
                                "fk inc 581 if is != 3455\n" +
                                "hg dec -692 if fk >= -1247\n" +
                                "um inc -752 if aao < -1424\n" +
                                "lbf dec 14 if lbf != 783\n" +
                                "t dec 270 if f == -1542\n" +
                                "uy inc 70 if hg <= 1277\n" +
                                "is inc 676 if lx == -682\n" +
                                "is inc 230 if um >= -163\n" +
                                "gk dec 799 if yk > 1107\n" +
                                "ada dec -20 if eri != -2804\n" +
                                "lx dec -278 if umr == 6678\n" +
                                "gk inc 83 if umr <= 6686\n" +
                                "lbf inc 265 if a >= 1118\n" +
                                "is dec 476 if j != -820\n" +
                                "eri dec 509 if lx > -413\n" +
                                "is dec -486 if dy < 4606\n" +
                                "kg dec 989 if is > 4847\n" +
                                "lx inc 996 if dy >= 4591\n" +
                                "is inc -371 if eri > -3303\n" +
                                "kg dec 209 if f != -1542\n" +
                                "kg dec -21 if kg < 1394\n" +
                                "uy dec -34 if x == -1417\n" +
                                "mmw inc -753 if hg != 1285\n" +
                                "gk dec 862 if kg > 1408\n" +
                                "ada dec 346 if is < 4856\n" +
                                "umr inc 262 if es > -1888\n" +
                                "lx inc -842 if umr < 6948\n" +
                                "f inc 557 if yk != 1103\n" +
                                "dy inc -323 if lbf >= 1030\n" +
                                "kg dec 610 if ada >= -1883\n" +
                                "f dec 727 if f != -1544\n" +
                                "es dec -922 if aao > -1435\n" +
                                "kg inc -628 if f == -2269\n" +
                                "eri inc -762 if lx < -245\n" +
                                "a dec 246 if a <= 1118\n" +
                                "aao dec 51 if kg >= 181\n" +
                                "is dec 761 if x >= -1417\n" +
                                "j inc 359 if x == -1417\n" +
                                "mmw dec 562 if ada < -1880\n" +
                                "lbf dec 955 if aao != -1426\n" +
                                "umr dec -851 if x == -1417\n" +
                                "t dec -845 if is <= 4101\n" +
                                "lbf inc -666 if hg > 1272\n" +
                                "um dec -105 if f >= -2274\n" +
                                "gk inc 191 if umr != 7781\n" +
                                "dy dec -399 if eri <= -4072\n" +
                                "is inc 681 if t != 5835\n" +
                                "mmw inc -731 if ada > -1883\n" +
                                "x inc -603 if yk < 1111\n" +
                                "j inc 860 if fk <= -1239\n" +
                                "t dec -480 if kg > 175\n" +
                                "eri inc 308 if mmw > 957\n" +
                                "hg inc 37 if gk >= -1163\n" +
                                "eri inc 868 if kg >= 172\n" +
                                "gk inc 381 if f > -2276\n" +
                                "ada inc -231 if fk < -1234\n" +
                                "uy dec -404 if gk >= -781\n" +
                                "es inc -33 if yk != 1105\n" +
                                "j inc -210 if um != -66\n" +
                                "umr dec -783 if kg == 176\n" +
                                "a inc 287 if hg < 1322\n" +
                                "es inc 794 if f >= -2270\n" +
                                "f inc 816 if a < 1417\n" +
                                "eri inc -136 if fk <= -1235\n" +
                                "j dec 421 if lbf < 362\n" +
                                "kg dec -889 if fk > -1248\n" +
                                "um inc 701 if yk <= 1110\n" +
                                "x dec -487 if fk < -1243\n" +
                                "aao dec 623 if umr <= 8582\n" +
                                "mmw dec -307 if eri > -3038\n" +
                                "t inc 803 if f == -1453\n" +
                                "kg dec 980 if a < 1404\n" +
                                "dy inc -974 if gk < -772\n" +
                                "yk inc 221 if eri < -3040\n" +
                                "gk inc -421 if aao > -2059\n" +
                                "mmw dec -751 if f <= -1445\n" +
                                "kg dec 422 if lx <= -250\n" +
                                "dy dec 191 if x <= -1535\n" +
                                "um inc -318 if gk != -1195\n" +
                                "mmw inc 870 if kg != 651\n" +
                                "j dec -865 if t < 7131\n" +
                                "um dec 886 if t < 7124\n" +
                                "ada inc 171 if eri < -3030\n" +
                                "x dec -755 if es == -202\n" +
                                "fk inc -325 if hg >= 1313\n" +
                                "t dec 984 if t != 7130\n" +
                                "j dec 55 if aao == -2056\n" +
                                "fk dec 80 if x <= -773\n" +
                                "dy dec 852 if lx != -256\n" +
                                "is inc 295 if a >= 1408\n" +
                                "uy dec 733 if hg < 1318\n" +
                                "x inc 868 if um <= -560\n" +
                                "t dec -532 if t != 6128\n" +
                                "aao inc -530 if x == 90\n" +
                                "is dec 374 if lbf == 358\n" +
                                "aao inc 93 if t == 6673\n" +
                                "uy inc -657 if hg != 1317\n" +
                                "fk inc -670 if umr > 8568\n" +
                                "x inc 791 if j != 634\n" +
                                "mmw dec -872 if uy >= -73\n" +
                                "yk inc -771 if eri <= -3034\n" +
                                "umr dec -125 if kg < 645\n" +
                                "mmw inc -617 if aao > -2581\n" +
                                "mmw dec -90 if mmw != 3145\n" +
                                "es dec 182 if aao <= -2574\n" +
                                "kg dec 903 if ada >= -1934\n" +
                                "um inc 319 if lbf == 358\n" +
                                "uy inc -958 if f <= -1447\n" +
                                "ada dec -965 if eri == -3033\n" +
                                "fk dec 750 if es >= -393\n" +
                                "hg inc -488 if hg >= 1307\n" +
                                "lx inc 742 if umr != 8703\n" +
                                "uy inc 378 if kg != 643\n" +
                                "lx dec -584 if um != -233\n" +
                                "kg dec -654 if ada >= -986\n" +
                                "is dec 181 if f == -1453\n" +
                                "eri inc 302 if lx < 1080\n" +
                                "uy inc -907 if kg != 1289\n" +
                                "yk dec 652 if is < 4223\n" +
                                "lbf inc -147 if hg != 823\n" +
                                "fk dec -584 if kg < 1300\n" +
                                "fk dec -593 if f <= -1449\n" +
                                "dy dec -83 if gk < -1189\n" +
                                "a dec -568 if es <= -377\n" +
                                "aao inc -742 if gk <= -1193\n" +
                                "kg dec -560 if hg <= 831\n" +
                                "es dec -871 if fk > -1899\n" +
                                "lx inc 239 if kg != 1855\n" +
                                "uy dec 696 if ada >= -984\n" +
                                "kg dec -899 if yk >= 452\n" +
                                "x inc -303 if is <= 4223\n" +
                                "um inc -207 if lbf != 211\n" +
                                "eri dec 520 if eri >= -2731\n" +
                                "is dec -251 if t < 6675\n" +
                                "umr inc 19 if kg == 1857\n" +
                                "lbf dec -365 if uy != -2632\n" +
                                "yk dec 192 if fk < -1883\n" +
                                "dy dec 451 if hg > 820\n" +
                                "j dec -789 if lx <= 1320\n" +
                                "um dec -577 if lx > 1309\n" +
                                "es dec 954 if dy != 2800\n" +
                                "aao dec 798 if f <= -1446\n" +
                                "mmw dec -339 if mmw >= 3143\n" +
                                "j inc 126 if yk == 259\n" +
                                "ada inc -898 if umr != 8718\n" +
                                "kg inc -365 if eri == -3251\n" +
                                "aao dec 718 if lx > 1307\n" +
                                "x inc -872 if kg <= 1495\n" +
                                "j dec -862 if is != 4464\n" +
                                "mmw dec -785 if is == 4469\n" +
                                "t dec 355 if uy != -2627\n" +
                                "ada dec -528 if ada == -977\n" +
                                "yk dec -139 if hg >= 823\n" +
                                "mmw dec -97 if is == 4469\n" +
                                "j dec -454 if is == 4469\n" +
                                "yk dec -151 if kg < 1500\n" +
                                "lbf inc -19 if lbf != 576\n" +
                                "yk inc 281 if umr == 8718\n" +
                                "gk dec 59 if mmw <= 4374\n" +
                                "umr dec 266 if hg < 828\n" +
                                "fk inc -54 if is <= 4477\n" +
                                "is inc 468 if is >= 4477\n" +
                                "mmw inc -749 if ada != -442\n" +
                                "is inc 22 if mmw > 3608\n" +
                                "uy inc -436 if ada != -449\n" +
                                "umr dec -545 if gk == -1256\n" +
                                "mmw inc -716 if ada <= -447\n" +
                                "fk dec -470 if f >= -1450\n" +
                                "ada inc -429 if uy != -2633\n" +
                                "aao inc -28 if a < 1984\n" +
                                "umr inc -826 if aao >= -4867\n" +
                                "lbf dec 141 if kg < 1493\n" +
                                "lbf inc 307 if eri == -3251\n" +
                                "um dec -120 if um == 335\n" +
                                "j inc -674 if fk == -1956\n" +
                                "mmw inc -784 if lx == 1315\n" +
                                "x inc -524 if dy == 2805\n" +
                                "mmw dec 911 if kg == 1492\n" +
                                "gk inc 260 if mmw >= 1200\n" +
                                "es inc 638 if hg > 819\n" +
                                "mmw dec 276 if ada == -449\n" +
                                "eri dec -682 if kg != 1489\n" +
                                "um inc 790 if t > 6321\n" +
                                "a inc 288 if eri >= -2560\n" +
                                "eri dec -477 if lbf >= 747\n" +
                                "kg inc 922 if kg > 1489\n" +
                                "ada dec -65 if uy >= -2634\n" +
                                "ada dec -106 if umr >= 8170\n" +
                                "is dec -609 if aao >= -4866\n" +
                                "t dec -598 if mmw == 930\n" +
                                "gk dec 89 if t != 6912\n" +
                                "t dec -500 if f < -1456\n" +
                                "is dec -169 if es == 171\n" +
                                "f dec -633 if f <= -1453\n" +
                                "aao dec -191 if t > 6905\n" +
                                "a dec -772 if eri > -2574\n" +
                                "x inc -272 if x >= -818\n" +
                                "es dec 135 if j <= 2862\n" +
                                "uy inc 950 if aao == -4674\n" +
                                "ada dec 380 if aao != -4676\n" +
                                "aao inc 111 if kg < 2415\n" +
                                "lx inc -339 if umr == 8171\n" +
                                "yk dec 63 if ada <= -653\n" +
                                "yk inc -894 if j > 2863\n" +
                                "f dec -590 if eri != -2560\n" +
                                "hg inc -281 if gk == -996\n" +
                                "lx inc -529 if hg >= 539\n" +
                                "ada dec -133 if es != 163\n" +
                                "f dec -510 if t != 6912\n" +
                                "uy inc -761 if um != 465\n" +
                                "a inc -466 if um > 452\n" +
                                "f dec 811 if lbf <= 747\n" +
                                "umr dec 206 if umr >= 8170\n" +
                                "x dec -606 if dy <= 2814\n" +
                                "t dec 823 if hg <= 553\n" +
                                "yk inc 130 if um != 453\n" +
                                "aao inc 984 if fk > -1948\n" +
                                "x dec -152 if um > 447\n" +
                                "fk dec -958 if kg > 2418\n" +
                                "eri dec 996 if a < 2290\n" +
                                "aao inc 702 if x != -330\n" +
                                "lbf dec -8 if aao > -2872\n" +
                                "mmw inc 346 if hg != 554\n" +
                                "is dec -255 if fk == -1946\n" +
                                "gk dec -139 if x >= -335\n" +
                                "j dec -238 if x != -332\n" +
                                "lbf inc 649 if a < 2283\n" +
                                "lx inc 702 if es < 178\n" +
                                "fk dec -918 if j > 2858\n" +
                                "lbf inc 971 if hg == 544\n" +
                                "f dec -807 if a < 2283\n" +
                                "eri dec -263 if dy != 2814\n" +
                                "fk dec 128 if kg == 2414\n" +
                                "hg dec 541 if mmw > 1270\n" +
                                "uy inc -144 if um <= 458\n" +
                                "um dec 362 if mmw == 1276\n" +
                                "yk inc -346 if mmw == 1276\n" +
                                "mmw inc -543 if yk <= -340\n" +
                                "hg inc -358 if mmw == 733\n" +
                                "es dec -652 if f >= -232\n" +
                                "uy dec 401 if ada == -525\n" +
                                "x inc 736 if kg >= 2412\n" +
                                "uy inc -489 if mmw == 733\n" +
                                "yk inc 134 if is > 5522\n" +
                                "lbf dec 531 if uy != -3470\n" +
                                "f inc 472 if umr >= 7960\n" +
                                "f dec -410 if lbf >= 1836\n" +
                                "eri inc 522 if gk == -857\n" +
                                "um inc -672 if es != 178\n" +
                                "fk dec -774 if j <= 2871\n" +
                                "f inc 825 if kg != 2414\n" +
                                "j dec -713 if es <= 178\n" +
                                "um inc 769 if t <= 6079\n" +
                                "lx inc 995 if dy > 2797\n" +
                                "is dec 359 if es < 180\n" +
                                "a inc -680 if es < 177\n" +
                                "eri inc -102 if mmw < 736\n" +
                                "ada inc 39 if eri != -2889\n" +
                                "lx dec -935 if lx != 2145\n" +
                                "hg inc 741 if es >= 165\n" +
                                "kg dec -156 if lbf <= 1835\n" +
                                "f dec 376 if eri > -2892\n" +
                                "aao inc 570 if j == 3577\n" +
                                "dy inc 708 if is > 5162\n" +
                                "a dec 737 if aao == -2307\n" +
                                "x inc 936 if hg == 391\n" +
                                "aao inc -405 if j > 3576\n" +
                                "mmw inc -42 if kg > 2561\n" +
                                "j dec 295 if um != -588\n" +
                                "yk dec -641 if j <= 3282\n" +
                                "umr inc -633 if gk != -864\n" +
                                "dy inc -202 if gk < -858\n" +
                                "aao inc -244 if gk != -861\n" +
                                "uy inc -97 if kg == 2573\n" +
                                "mmw dec -889 if ada < -482\n" +
                                "es inc -166 if fk == -382\n" +
                                "eri dec -962 if eri >= -2889\n" +
                                "umr dec 201 if t >= 6086\n" +
                                "gk dec -700 if mmw == 1580\n" +
                                "ada inc -158 if gk < -159\n" +
                                "t inc 650 if es < -2\n" +
                                "lbf dec 870 if aao > -2966\n" +
                                "uy dec 727 if j <= 3289\n" +
                                "umr inc 483 if lbf < 971\n" +
                                "hg dec -283 if fk != -379\n" +
                                "kg dec 202 if t < 6090\n" +
                                "eri inc 607 if a >= 864\n" +
                                "lbf dec 282 if lx > 3074\n" +
                                "yk dec 490 if mmw >= 1573\n" +
                                "uy dec -536 if aao >= -2959\n" +
                                "uy dec -306 if lx > 3071\n" +
                                "fk dec 982 if lx == 3069\n" +
                                "aao dec 431 if aao < -2947\n" +
                                "mmw inc 145 if t < 6093\n" +
                                "is inc -222 if es <= 11\n" +
                                "mmw inc -953 if fk < -372\n" +
                                "a inc 588 if x != 406\n" +
                                "gk dec 464 if lx <= 3080\n" +
                                "mmw dec -655 if a > 1448\n" +
                                "mmw dec 251 if aao < -3394\n" +
                                "t inc 582 if dy < 3508\n" +
                                "lbf dec 816 if ada < -492\n" +
                                "uy inc 374 if a >= 1445\n" +
                                "f inc 98 if f >= -129\n" +
                                "gk dec -206 if gk == -621\n" +
                                "lbf dec -368 if fk != -382\n" +
                                "mmw dec -16 if um == -579\n" +
                                "dy dec 522 if umr == 7614\n" +
                                "fk inc -645 if dy != 2998\n" +
                                "hg dec 829 if lbf > 676\n" +
                                "aao dec 472 if t != 6098\n" +
                                "kg inc 926 if aao >= -3868\n" +
                                "x dec -485 if j <= 3284\n" +
                                "x dec 987 if mmw > 1433\n" +
                                "yk dec -933 if aao != -3859\n" +
                                "fk inc -446 if lx <= 3080\n" +
                                "kg dec 573 if f != -129\n" +
                                "hg dec 231 if dy <= 2992\n" +
                                "eri dec -162 if es < 14\n" +
                                "t dec 975 if lx > 3086\n" +
                                "dy dec -144 if f < -147\n" +
                                "lx dec 122 if lbf < 682\n" +
                                "mmw inc -438 if umr == 7614\n" +
                                "j inc 149 if mmw < 1009\n" +
                                "t inc 749 if lx > 2947\n" +
                                "um inc -970 if hg >= -400\n" +
                                "kg inc 368 if kg != 2721\n" +
                                "aao dec 845 if kg == 2721\n" +
                                "eri dec -521 if yk > -59\n" +
                                "gk dec -200 if ada >= -495\n" +
                                "hg inc 462 if um == -1549\n" +
                                "eri dec -54 if mmw >= 998\n" +
                                "hg dec -268 if a >= 1450\n" +
                                "j dec 86 if t != 6840\n" +
                                "a dec -394 if a == 1452\n" +
                                "aao inc 166 if kg >= 2720\n" +
                                "x inc -146 if is == 4943\n" +
                                "es inc 496 if kg < 2723\n" +
                                "t dec -949 if uy <= -2989";
}
