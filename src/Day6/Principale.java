package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principale
{
	public static void main(String[] args) throws FileNotFoundException
	{
		partOne();
		partTwo();
	}

	public static void partOne() throws FileNotFoundException
	{
		File fichier = new File("./src/Day6/data.txt");
		Scanner sc = new Scanner(fichier);

		String line = " ";
		String[] commande;

		int compteur = 0;

		boolean[][] grille = new boolean[1000][1000];
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				grille[i][j] = false;
			}
		}

		while (sc.hasNextLine())
		{
			line = sc.nextLine();
			commande = line.split(" ");
			if (commande.length == 5)
			{
				// Ce n'est pas du toogle
				if (commande[1].equals("on"))
				{
					turnOn(commande[2], commande[4], grille);
				} else
				{
					turnOff(commande[2], commande[4], grille);
				}
			} else
			{
				toggle(commande[1], commande[3], grille);
			}
		}

		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				if (grille[i][j])
				{
					compteur++;
				}
			}
		}

		System.out.println(compteur);
		sc.close();
	}

	public static void partTwo() throws FileNotFoundException
	{
		File fichier = new File("./src/Day6/data.txt");
		Scanner sc = new Scanner(fichier);

		String[] commande;
		int[][] grille = new int[1000][1000];

		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				grille[i][j] = 0;
			}
		}

		String line = "";

		int compteur = 0;

		while (sc.hasNextLine())
		{
			line = sc.nextLine();
			commande = line.split(" ");
			if (commande.length == 5)
			{
				// Ce n'est pas du toogle
				if (commande[1].equals("on"))
				{
					turnOnv2(commande[2], commande[4], grille);
				} else
				{
					turnOffv2(commande[2], commande[4], grille);
				}
			} else
			{
				togglev2(commande[1], commande[3], grille);
			}
		}
		sc.close();
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				compteur += grille[i][j];
			}
		}
		System.out.println(compteur);
	}

	public static void turnOn(String Coor1, String Coor2, boolean[][] grille)
	{
		String[] XY1 = Coor1.split(",");
		String[] XY2 = Coor2.split(",");

		int x1 = Integer.parseInt(XY1[0]);
		int y1 = Integer.parseInt(XY1[1]);

		int x2 = Integer.parseInt(XY2[0]);
		int y2 = Integer.parseInt(XY2[1]);

		for (int i = x1; i < x2 + 1; i++)
		{
			for (int j = y1; j < y2 + 1; j++)
			{
				grille[i][j] = true;
			}
		}
	}

	public static void turnOff(String Coor1, String Coor2, boolean[][] grille)
	{
		String[] XY1 = Coor1.split(",");
		String[] XY2 = Coor2.split(",");

		int x1 = Integer.parseInt(XY1[0]);
		int y1 = Integer.parseInt(XY1[1]);

		int x2 = Integer.parseInt(XY2[0]);
		int y2 = Integer.parseInt(XY2[1]);

		for (int i = x1; i < x2 + 1; i++)
		{
			for (int j = y1; j < y2 + 1; j++)
			{
				grille[i][j] = false;
			}
		}
	}

	public static void toggle(String Coor1, String Coor2, boolean[][] grille)
	{
		String[] XY1 = Coor1.split(",");
		String[] XY2 = Coor2.split(",");

		int x1 = Integer.parseInt(XY1[0]);
		int y1 = Integer.parseInt(XY1[1]);

		int x2 = Integer.parseInt(XY2[0]);
		int y2 = Integer.parseInt(XY2[1]);

		for (int i = x1; i < x2 + 1; i++)
		{
			for (int j = y1; j < y2 + 1; j++)
			{
				grille[i][j] = !grille[i][j];
			}
		}
	}

	public static void turnOnv2(String Coor1, String Coor2, int[][] grille)
	{
		String[] XY1 = Coor1.split(",");
		String[] XY2 = Coor2.split(",");

		int x1 = Integer.parseInt(XY1[0]);
		int y1 = Integer.parseInt(XY1[1]);

		int x2 = Integer.parseInt(XY2[0]);
		int y2 = Integer.parseInt(XY2[1]);

		for (int i = x1; i < x2 + 1; i++)
		{
			for (int j = y1; j < y2 + 1; j++)
			{
				grille[i][j]++;
			}
		}
	}

	public static void turnOffv2(String Coor1, String Coor2, int[][] grille)
	{
		String[] XY1 = Coor1.split(",");
		String[] XY2 = Coor2.split(",");

		int x1 = Integer.parseInt(XY1[0]);
		int y1 = Integer.parseInt(XY1[1]);

		int x2 = Integer.parseInt(XY2[0]);
		int y2 = Integer.parseInt(XY2[1]);

		for (int i = x1; i < x2 + 1; i++)
		{
			for (int j = y1; j < y2 + 1; j++)
			{
				if (grille[i][j] > 0)
				{
					grille[i][j]--;
				}
			}
		}
	}

	public static void togglev2(String Coor1, String Coor2, int[][] grille)
	{
		String[] XY1 = Coor1.split(",");
		String[] XY2 = Coor2.split(",");

		int x1 = Integer.parseInt(XY1[0]);
		int y1 = Integer.parseInt(XY1[1]);

		int x2 = Integer.parseInt(XY2[0]);
		int y2 = Integer.parseInt(XY2[1]);

		for (int i = x1; i < x2 + 1; i++)
		{
			for (int j = y1; j < y2 + 1; j++)
			{
				grille[i][j] += 2;
			}
		}
	}
}