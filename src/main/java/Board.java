

import java.util.Scanner;

public class Board {
    public static void main(String[] args) {
        System.out.println("Witaj w grze, podaj rozmiar planszy: ");
        int wymiar = new Scanner(System.in).nextInt();

        char obecnySymbol = 'X';

        char[][] plansza = new char[wymiar][wymiar];

        int licznikRuchow = 0;
        boolean czyKontynuaować = true;
        while (czyKontynuaować ) {
            Board.drukujPlansze(plansza);
            boolean ruchPoprawny = wykonajRuch(plansza, obecnySymbol);
            if (ruchPoprawny) {
                licznikRuchow++;
                boolean wygraneWiersze = sprawdzWiersze(plansza, obecnySymbol);
                boolean wygranaKolumny = sprawdzKolumny(plansza, obecnySymbol);
                boolean wygranaSkos1 = sprawdzSkos1(plansza, obecnySymbol);
                boolean wygranaSkok2 = sprawdzSkos2(plansza, obecnySymbol);
                if (wygranaKolumny || wygraneWiersze || wygranaSkos1 || wygranaSkok2) {
                    System.out.println("Koniec gry, wygrał " + obecnySymbol);
                    czyKontynuaować = false;
                } else if ((wygranaKolumny || wygraneWiersze || wygranaSkos1 || wygranaSkok2) != true && licznikRuchow == Math.pow(wymiar, 2.0)) {
                    System.out.println("Remis");
                    czyKontynuaować = false;
                }
            }
            obecnySymbol = obecnySymbol == 'X' ? 'O' : 'X';

            }
        }


    public static boolean sprawdzWiersze(char[][] plansza, char symbol) {
        int wymiar = plansza.length;
        for (int wiersz = 0; wiersz < wymiar; wiersz++) {
            boolean wygrana = true;
            for (int k = 0; k < wymiar; k++) {
                if (plansza[wiersz][k] != symbol) {
                    wygrana = false;
                    break;
                }
            }
            if (wygrana) {
                return true;
            }
        }
        return false;
    }

    public static boolean sprawdzKolumny(char[][] plansza, char symbol) {
        int wymiar = plansza.length;
        for (int kolumna = 0; kolumna < wymiar; kolumna++) {
            boolean wygrana = true;
            for (int wiersz = 0; wiersz < wymiar; wiersz++) {
                if (plansza[wiersz][kolumna] != symbol) {
                    wygrana = false;
                    break;
                }
            }

            if (wygrana) {
                return true;
            }
        }
        return false;
    }

    public static boolean sprawdzSkos1(char[][] plansza, char symbol) {
        int wymiar = plansza.length;
        for (int i = 0; i < wymiar; i++) {
            if (plansza[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    public static boolean sprawdzSkos2(char[][] plansza, char symbol) {
        int wymiar = plansza.length;
        for (int i = 0; i < wymiar; i++) {
            if (plansza[i][wymiar - 1 - i] != symbol) {
                return false;
            }
        }
        return true;
    }


    public static boolean wykonajRuch(char[][] plansza, char symbol) {
        System.out.println(symbol + " twój ruch: ");
        System.out.println("Podaj indeks wiersza:");
        int wiersz = new Scanner(System.in).nextInt();
        System.out.println("Podaj indeks kolumny:");
        int kolumna = new Scanner(System.in).nextInt();
        boolean ruchPoprawny = plansza[wiersz][kolumna] == 0;
        if (!ruchPoprawny) {
            System.out.println("Ruch jest niepoprawny");
            return false;
        }
        plansza[wiersz][kolumna] = symbol;
        return true;
    }

    public static void drukujPlansze(char[][] plansza) {
        int wymiar = plansza.length;
        System.out.print("\t");
        //petla drukujaca naglowki kolumn
        for (int i = 0; i < wymiar; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int wiersz = 0; wiersz < wymiar; wiersz++) {
            System.out.print(wiersz + ":\t");
            for (int kolumna = 0; kolumna < wymiar; kolumna++) {
                System.out.print(plansza[wiersz][kolumna] + "\t");
            }
            System.out.println();
        }
    }
}





