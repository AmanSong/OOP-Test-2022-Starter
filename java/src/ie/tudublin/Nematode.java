package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode 
{
    //fields
    private String name;
    private Integer length;
    private Integer limbs;
    private String gender;
    private Integer eyes;

    //toString method
    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    //TableRow constructor
    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"),
            tr.getInt("length"),
            tr.getInt("limbs"),
            tr.getString("gender"),
            tr.getInt("eyes")
        );
    }

    //constructor
    public Nematode(String name, Integer length, Integer limbs, String gender, Integer eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    //accessor 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLimbs() {
        return limbs;
    }

    public void setLimbs(Integer limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEyes() {
        return eyes;
    }

    public void setEyes(Integer eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser nv)
    {
        nv.background(0);


        //prints the name
        nv.textAlign(PApplet.CENTER);
        nv.textSize(25);
        nv.text(name, nv.width/2, nv.height/5);

        int segements = length;
        nv.noFill();

        for(int i = 0; i < segements; i++)
        {
            nv.pushMatrix();
            float color = 0;
            color = PApplet.map(i, 0, length, 0, 255);
            nv.stroke(color,255,255);


            nv.translate(nv.width/2, (nv.height/2 - (length/2 * 50)) + (50 * i));

            float y = PApplet.map(i, 0, length, 300, nv.height-250);

            nv.circle(0, 0, 50);

            if (i == 0 && eyes == 1)
            {
                //draw right eye stalk
                nv.line(
                    PApplet.sin(PApplet.radians(180-45)) * 50/2, 
                    PApplet.cos(PApplet.radians(180-45)) * 50/2, 
                    PApplet.sin(PApplet.radians(180-45)) * 50, 
                    PApplet.cos(PApplet.radians(180-45)) * 50
                );
                //draw left eye stalk
                nv.line(
                    PApplet.sin(PApplet.radians(180+45)) * 50/2, 
                    PApplet.cos(PApplet.radians(180+45)) * 50/2, 
                    PApplet.sin(PApplet.radians(180+45)) * 50, 
                    PApplet.cos(PApplet.radians(180+45)) * 50
                );
            }

            //draw limbs if they have it
            if(limbs == 1)
            {
                nv.line(50, 0, 27, 0);
                nv.line(-50, 0, -27, 0);

            }

            //some reason i cant do gender == "m"
            //so this was the only way i figured
            if (length - 1 == i)
            {
                switch (gender)
                {
                    case("m"):
                    {
                        nv.line(0, 25, 0, 50);
                        nv.circle(0, 55, 10);
                        break;
                    }
                    case "h":
                    {
                        nv.circle(0, 0, 25);
                        nv.line(0, 25, 0, 50);
                        nv.circle(0, 55, 10);
                        break;
                    }
                    case "f":
                    {
                        nv.circle(0, 0, 25);
                        break;
                    }
                }
            }
            nv.popMatrix();
        }


    }

}
