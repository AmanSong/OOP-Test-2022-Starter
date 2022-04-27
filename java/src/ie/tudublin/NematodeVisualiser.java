package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	//arraylist for nematodes
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	int choice = 0;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			choice -= 1;
			if(choice == -1)
			{
				choice = nematodes.size() - 1;
			}
			System.out.println(choice);
		}		
		if(keyCode == RIGHT)
		{
			choice = choice + 1;
			System.out.println(choice);
		}
		if(choice > nematodes.size()-1)
		{
			choice = 0;
		}
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();		
		loadNematodes();
		draw();		
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
		for(TableRow r:table.rows())
		{
			Nematode n = new Nematode(r);
			nematodes.add(n);
		}
	}

	public void draw()
	{	
		//send currently choses nematode to render
		nematodes.get(choice).render(this);
	}
}
