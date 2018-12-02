package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principale
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File fichier = new File("./src/Day2/data.txt");
		Scanner sc = new Scanner(fichier);

		int largeur = 0;
		int epaisseur = 0;
		int hauteur = 0;

		int surface = 0;
		int ruban = 0;

		String ligne = "";
		String[] dimension =
			{ "", "", "" };

		while (sc.hasNextLine())
		{
			ligne = sc.nextLine();
			dimension = ligne.split("x");

			largeur = Integer.parseInt(dimension[0]);
			epaisseur = Integer.parseInt(dimension[1]);
			hauteur = Integer.parseInt(dimension[2]);

			surface += 2 * (largeur * epaisseur + largeur * hauteur + epaisseur * hauteur);
			surface += Math.min(Math.min(largeur * epaisseur, largeur * hauteur), hauteur * epaisseur);

			ruban += largeur * hauteur * epaisseur;
			ruban += Math.min(Math.min(2 * (largeur + hauteur), 2 * (largeur + epaisseur)), 2 * (hauteur + epaisseur));

		}

		System.out.println("surface : " + surface);
		System.out.println("ruban : " + ruban);

		sc.close();
	}
}