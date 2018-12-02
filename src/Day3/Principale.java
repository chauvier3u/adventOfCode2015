package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principale
{
	public static void main(String[] args) throws FileNotFoundException
	{
		partTwo();
	}

	public static void partTwo() throws FileNotFoundException
	{
		File fichier = new File("./src/Day3/data.txt");
		Scanner sc = new Scanner(fichier);

		String ligne = sc.nextLine();
		ArrayList<String> Maison = new ArrayList<String>();
		Maison.add("0,0"); // X, Y

		String[] temp;

		int x = 0;
		int y = 0;

		int xR = 0;
		int yR = 0;

		char current = ' ';

		for (int i = 0; i < ligne.length(); i++)
		{
			current = ligne.charAt(i);
			if (i % 2 == 0)
			{
				if (current == '^')
				{
					y++;
				} else if (current == '>')
				{
					x++;
				} else if (current == 'v')
				{
					y--;
				} else if (current == '<')
				{
					x--;
				}
			} else
			{
				if (current == '^')
				{
					yR++;
				} else if (current == '>')
				{
					xR++;
				} else if (current == 'v')
				{
					yR--;
				} else if (current == '<')
				{
					xR--;
				}
			}

			boolean dejaFait = false;
			boolean dejaFaitR = false;
			for (int j = 0; j < Maison.size(); j++)
			{
				temp = Maison.get(j).split(",");
				if (Integer.parseInt(temp[0]) == x && Integer.parseInt(temp[1]) == y)
				{
					dejaFait = true;
				}
				if (Integer.parseInt(temp[0]) == xR && Integer.parseInt(temp[1]) == yR)
				{
					dejaFaitR = true;
				}
			}

			if (!dejaFait)
			{
				Maison.add(x + "," + y);
			}
			if (!dejaFaitR)
			{
				Maison.add(xR + "," + yR);
			}
		}

		System.out.println(Maison.size());
		sc.close();
	}

	public static void partOne() throws FileNotFoundException
	{
		File fichier = new File("./src/Day3/data.txt");
		Scanner sc = new Scanner(fichier);

		String ligne = sc.nextLine();
		ArrayList<String> Maison = new ArrayList<String>();
		Maison.add("0,0"); // X, Y

		String[] temp;

		int x = 0;
		int y = 0;

		char current = ' ';

		for (int i = 0; i < ligne.length(); i++)
		{
			current = ligne.charAt(i);
			if (current == '^')
			{
				y++;
			} else if (current == '>')
			{
				x++;
			} else if (current == 'v')
			{
				y--;
			} else if (current == '<')
			{
				x--;
			}

			boolean dejaFait = false;
			for (int j = 0; j < Maison.size(); j++)
			{
				temp = Maison.get(j).split(",");
				if (Integer.parseInt(temp[0]) == x && Integer.parseInt(temp[1]) == y)
				{
					dejaFait = true;
				}
			}
			if (!dejaFait)
			{
				Maison.add(x + "," + y);
			}
		}

		System.out.println(Maison.size());

		sc.close();
	}
}