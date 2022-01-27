/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54931.humbug.mavenproject1;

import java.util.LinkedList;

/**
 *
 * @author @author Maciej Rolecki (g54931) <54931@etu.he2b.be>
 */
public class NewClass {

    public static LinkedList<Position> why(int[][] tableau, int nombreRecherche) {
        LinkedList<Position> retour = new LinkedList<>();
        LinkedList<Position> suiteH = new LinkedList<>();
        LinkedList<Position> suiteD1 = new LinkedList<>();
        LinkedList<Position> suiteD2 = new LinkedList<>();
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] == nombreRecherche) {
                    suiteH.add(0, new Position(i, j));
                    suiteD1.add(0, new Position(i, j));
                    suiteD2.add(0, new Position(i, j));
                    int k = i, l = i;
                    int m = j, n = j;
                    while (true) {
                        while (true) {
                            if (tableau[k - 1][m] == nombreRecherche) {
                                suiteH.add(0, new Position(k - 1, m));
                                k--;
                            } else {
                                k = i;
                                break;
                            }
                        }
                        while (true) {
                            if (tableau[k + 1][m] == nombreRecherche) {
                                suiteH.add(suiteH.indexOf(suiteH.getLast()) + 1, new Position(k + 1, m));
                                k++;
                            } else {
                                k = i;
                                break;
                            }
                        }
                        if (!retour.contains(suiteH.getFirst())) {
                            if (suiteH.indexOf(suiteH.getLast()) >= 3) {
                                retour.add(suiteH.getFirst());
                            }
                            suiteH.clear();
                            break;
                        }
                    }
                    while (true) {
                        while (true) {
                            if (tableau[l - 1][n - 1] == nombreRecherche) {
                                suiteD1.add(0, new Position(l - 1, n - 1));
                                l--;
                                n--;
                            } else {
                                l = i;
                                n = j;
                                break;
                            }
                        }
                        while (true) {
                            if (tableau[l + 1][n + 1] == nombreRecherche) {
                                suiteD1.add(suiteD1.indexOf(suiteD1.getLast()) + 1, new Position(l + 1, n + 1));
                                l++;
                                n++;
                            } else {
                                l = i;
                                n = j;
                                break;
                            }
                        }
                        if (!retour.contains(suiteD1.getFirst())) {
                            if (suiteD1.indexOf(suiteD1.getLast()) >= 3) {
                                retour.add(suiteD1.getFirst());
                            }

                            suiteD1.clear();
                            break;
                        }
                    }
                    while (true) {
                        while (true) {
                            if (tableau[l - 1][n + 1] == nombreRecherche) {
                                suiteD2.add(0, new Position(l - 1, n + 1));
                                l--;
                                n++;
                            } else {
                                l = i;
                                n = j;
                                break;
                            }
                        }
                        while (true) {
                            if (tableau[l + 1][n - 1] == nombreRecherche) {
                                suiteD1.add(suiteD2.indexOf(suiteD2.getLast()) + 1, new Position(l + 1, n - 1));
                                l++;
                                n--;
                            } else {
                                l = i;
                                n = j;
                                break;
                            }
                        }
                        if (!retour.contains(suiteD2.getFirst())) {
                            if (suiteD2.indexOf(suiteD2.getLast()) >= 3) {
                                retour.add(suiteD2.getFirst());
                            }
                            suiteD2.clear();
                            break;
                        }
                    }
                }
            }
        }
        return retour;
    }
}
